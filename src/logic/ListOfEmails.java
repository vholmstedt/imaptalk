/*
 * ListOfEmails.java er en kildefil til boken "Objektorientert programmering med Java"
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

import java.util.ArrayList;

import javax.mail.Message;

public class ListOfEmails extends ArrayList<EmailInstance> {

	public void addEmail(Message message) {
		add(new EmailInstance(message));
	}

	public String getSomeInfo(int index) {
		return get(index).getSomeInfo();
	}

}
