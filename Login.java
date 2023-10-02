package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JTextField tusrname, tpswd;
    Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lblusrnam = new JLabel("Username");
        lblusrnam.setBounds(200,120,100,30);
        add(lblusrnam);
        tusrname = new JTextField();
        tusrname.setBounds(400,120,150,30);
        add(tusrname);

        JLabel lblpswd = new JLabel("Password");
        lblpswd.setBounds(200,180,100,30);
        add(lblpswd);
        tpswd = new JTextField();
        tpswd.setBounds(400,180,150,30);
        add(tpswd);

        JButton login = new JButton("Login");
        login.setBounds(300,250,150,70);
        add(login);
        login.addActionListener(this);

        setSize(800,500);
        setVisible(true);
        setLocation(450,200);
    }
    public void actionPerformed(ActionEvent ae){
        try{
            String username = tusrname.getText();
            String password = tpswd.getText();

            Conn c = new Conn();
            String query = "select * from login where username = '"+username+"' and pwd = '"+password+"'";

            ResultSet rs = c.s.executeQuery(query);
            if (rs.next()){
                setVisible(false);
                new Home();
            }
            else {
                JOptionPane.showMessageDialog(null,"Invalid Username or Password.");
                setVisible(true);
                tusrname.setText("");
                tpswd.setText("");
                tusrname.requestFocus();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[]args){
        new Login();
    }
}