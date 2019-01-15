package com.jframe.practice;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage {
	static Connection connection = DBUtil.getConnection();
	static JFrame jFrame = new JFrame("Login Page");

	public LoginPage() {
		// inserting frame
		jFrame.setSize(1000, 500);
		jFrame.setResizable(false);
		jFrame.getContentPane().setBackground(Color.GRAY);
		jFrame.setLayout(null);
	}

	public static void main(String[] args) {
		LoginPage login = new LoginPage();
		login.HomePage();
	}

	public void HomePage() {
		// adding login label in frame
		JLabel loginLable = new JLabel("Login");
		loginLable.setBounds(450, 10, 100, 50);
		loginLable.setFont(new Font("Times New Roman", 2, 40));
		loginLable.setForeground(Color.WHITE);
		jFrame.add(loginLable);

		// adding label before textbox
		JLabel userNameLable = new JLabel("Enter Username: ");
		userNameLable.setBounds(300, 100, 150, 30);
		userNameLable.setFont(new Font("Times New Roman", 1, 20));
		userNameLable.setForeground(Color.WHITE);
		jFrame.add(userNameLable);

		// adding textbox for username
		JTextField userNameTextField = new JTextField();
		userNameTextField.setBounds(460, 100, 250, 30);
		jFrame.add(userNameTextField);

		// adding label before password
		JLabel passwordLable = new JLabel("Enter Password: ");
		passwordLable.setBounds(300, 140, 150, 30);
		passwordLable.setFont(new Font("Times New Roman", 1, 20));
		passwordLable.setForeground(Color.WHITE);
		jFrame.add(passwordLable);

		// adding password box for password
		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(460, 140, 250, 30);
		jFrame.add(passwordField);

		// adding button for login
		JButton jButton = new JButton("Login");
		jButton.setBounds(450, 200, 100, 40);
		jButton.setFont(new Font("Times New Roman", 1, 20));
		jButton.setBackground(Color.BLACK);
		jButton.setForeground(Color.WHITE);
		jFrame.add(jButton);

		// login action listener
		jButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String username = userNameTextField.getText();
					String password = new String(passwordField.getPassword());
					String query = "select * from user_master where user_name='" + username + "' AND user_password='"
							+ password + "'";
					Statement st = connection.createStatement();
					ResultSet rs = st.executeQuery(query);
					if (rs.next()) {
						jFrame.getContentPane().removeAll();
						AfterLogin login = new AfterLogin();
						login.AfterLoginPage(username);
						jFrame.repaint();
					} else
						JOptionPane.showMessageDialog(jFrame, "Login Failed", "Message", 0);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		// set visibility of frame
		jFrame.setVisible(true);
	}
}
