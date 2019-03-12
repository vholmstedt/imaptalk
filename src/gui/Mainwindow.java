/*
 * Mainwindow.java er en kildefil til boken "Objektorientert programmering med Java"
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

import javax.swing.JFrame;
import javax.swing.JPanel;

import logic.EmailLogic;

public class Mainwindow extends JFrame {
	
	private EmailLogic emailLogic = null; 
	
	public Mainwindow() {		
		setTitle("email experiments");
		add(new JPanel(),BorderLayout.WEST);
		add(new JPanel(),BorderLayout.EAST);
		setSize(1100,400);
		add(new EmailPanel(emailLogic = new EmailLogic()));
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(Mainwindow.EXIT_ON_CLOSE);
	}

}
