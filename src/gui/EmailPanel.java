/*
 * EmailPanel.java er en kildefil til boken "Objektorientert programmering med Java"
 * 
 * ****    Tredje opplag   ****
 * 
 * Boken er utgitt på http://www.fagbokforlaget.no
 * 
 * ISBN 978-82-7674-748-5
 * 
 * Viggo Holmstedt 2002 - 2019
 * -------------------------------------------
 * File location: kap_17/imap/gui/
 * Last modified: 2019-03-05 12:28
 * 

 */ 
package gui;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

import logic.EmailLogic;

public class EmailPanel extends JPanel {

	public EmailPanel(EmailLogic emailLogic) {
		setLayout(new BorderLayout());
		add(new JScrollPane(new JList<String>(emailLogic.someInfoAsListModel() ) {
			{				
				setFont(new Font("monospace", Font.PLAIN, 14));
				
			}
		}) {
			{
				Border border = BorderFactory.createEmptyBorder();
				setBorder(border);
			}
		});		
	}

}
