/*
 * EmailInstance.java er en kildefil til boken "Objektorientert programmering med Java"
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

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.mail.Message;
import javax.mail.MessagingException;

public class EmailInstance {

	private int messageNumber;
	private Date receivedDate;
	private String subject;

	public EmailInstance(Message message) {		
		try {
			messageNumber = message.getMessageNumber();
			receivedDate = message.getReceivedDate();
			subject = message.getSubject();
		} catch (MessagingException e) {
			e.printStackTrace();
		}		
	}
	
	private SimpleDateFormat sdf = new SimpleDateFormat();
	
	public String getSomeInfo() {
			return sdf.format(receivedDate) + " " + 
					messageNumber + " " + 
					subject;
	}

}
