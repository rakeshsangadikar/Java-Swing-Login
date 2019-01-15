package com.jframe.practice;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class AfterLogin {
	public void AfterLoginPage(String username) {
		//JOptionPane.showMessageDialog(LoginPage.jFrame, "Login Successful", "Message", 1);
	

		// add message after login
		JLabel msg = new JLabel("Welcome " + username);
		msg.setBounds(200, 200, 200, 30);
		msg.setFont(new Font("Times New Roman", 1, 20));
		msg.setForeground(Color.WHITE);

		// add button to frame
		JButton logout = new JButton("Logout");
		logout.setBounds(300, 300, 100, 40);
		logout.setFont(new Font("Times New Roman", 1, 20));
		logout.setBackground(Color.BLACK);
		logout.setForeground(Color.WHITE);
		
		logout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginPage.jFrame.getContentPane().removeAll();
				LoginPage home = new LoginPage();
				home.HomePage();
			}
		});
		LoginPage.jFrame.add(logout);
		LoginPage.jFrame.add(msg);
		LoginPage.jFrame.repaint();
	}
}
