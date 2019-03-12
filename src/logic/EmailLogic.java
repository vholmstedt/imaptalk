/*
 * EmailLogic.java er en kildefil til boken "Objektorientert programmering med Java"
 * 
 * ****    Tredje opplag   ****
 * 
 * Boken er utgitt på http://www.fagbokforlaget.no
 * 
 * ISBN 978-82-7674-748-5
 * 
 * Viggo Holmstedt 2002 - 2019
 * -------------------------------------------
 * File location: kap_17/imap/logic/
 * Last modified: 2019-03-05 12:28
 * 

 */ 
package logic;

import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.swing.AbstractListModel;
import javax.swing.ListModel;

public class EmailLogic {

	private ListOfEmails listofEmails = new ListOfEmails();

	public EmailLogic() {
		initiate();
	}

	public void checkImaps(String host, String user, String password) {
		try {

			// create properties field
			Properties properties = new Properties();

			properties.put("mail.imap.host", host);
			properties.put("mail.imap.port", "995");
			properties.put("mail.imap.starttls.enable", "true");
			Session emailSession = Session.getDefaultInstance(properties);
			Store store = emailSession.getStore("imaps");
			store.connect(host, user, password);
			Folder emailFolder = store.getFolder("INBOX");
			emailFolder.open(Folder.READ_ONLY);
			Message[] messages = emailFolder.getMessages();
			for (int i = 0, n = messages.length; i < n; i++) {
				Message message = messages[i];
				listofEmails.addEmail(message);
			}
			emailFolder.close(false);
			store.close();

		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initiate() {
		String host = "imap.one.com";  // Or your host
		String username = "test@evalanche.me"; // Or your username
		String password = "xxxxxxxxxxxxxxxxxx";// Or your password
		checkImaps(host, username, password);
	}

	public ListModel<String> someInfoAsListModel() {

		AbstractListModel<String> a = new AbstractListModel<String>() {

			@Override
			public String getElementAt(int index) {
				return listofEmails.getSomeInfo(index);
			}

			@Override
			public int getSize() {
				return listofEmails.size();
			}
		};
		return a;
	}

}
