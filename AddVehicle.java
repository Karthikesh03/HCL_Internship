package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.toedter.calendar.JDateChooser;

public class AddVehicle extends JFrame implements ActionListener{

    JTextField vnam1, vaddr, vphno, vaadhar, vprice;
    JDateChooser dcdob;
    JComboBox cbeducation;
    JLabel lblempId;
    JButton add, back;

    AddVehicle(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Add Vehicle Details");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font(" ",Font.BOLD,20));
        add(heading);

        JLabel labelname = new JLabel("Vehicle Reg no.");
        labelname.setBounds(50,150,150,30);
        labelname.setFont(new Font(" ",Font.PLAIN,15));
        add(labelname);
        vnam1 = new JTextField();
        vnam1.setBounds(200,150,150,30);
        add(vnam1);

        JLabel labeldob = new JLabel("Date of Registration");
        labeldob.setBounds(50,200,150,30);
        labeldob.setFont(new Font(" ",Font.PLAIN,15));
        add(labeldob);
        dcdob = new JDateChooser();
        dcdob.setBounds(200, 200, 150, 30);
        add(dcdob);

        JLabel labelsalary = new JLabel("Price");
        labelsalary.setBounds(400,150,150,30);
        labelsalary.setFont(new Font(" ",Font.PLAIN,15));
        add(labelsalary);
        vprice = new JTextField();
        vprice.setBounds(600,150,150,30);
        add(vprice);

        JLabel labeladdress = new JLabel("Owner's Address");
        labeladdress.setBounds(50,250,150,30);
        labeladdress.setFont(new Font(" ",Font.PLAIN,15));
        add(labeladdress);
        vaddr = new JTextField();
        vaddr.setBounds(200,250,150,30);
        add(vaddr);

        JLabel labelphone = new JLabel("Owner's contact no.");
        labelphone.setBounds(400,250,150,30);
        labelphone.setFont(new Font(" ",Font.PLAIN,15));
        add(labelphone);
        vphno = new JTextField();
        vphno.setBounds(600,250,150,30);
        add(vphno);


        JLabel labelaadhar = new JLabel("Aadhar Number");
        labelaadhar.setBounds(400, 200, 150, 30);
        labelaadhar.setFont(new Font("serif", Font.PLAIN, 15));
        add(labelaadhar);

        vaadhar = new JTextField();
        vaadhar.setBounds(600, 200, 150, 30);
        add(vaadhar);


        add = new JButton("Add Details");
        add.setBounds(250, 400, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);

        back = new JButton("Back");
        back.setBounds(450, 400, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);

        setSize(800,600);
        setLocation(300,50);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == add) {
            String vregno = vnam1.getText();
            String dor = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String price = vprice.getText();
            String oaddr = vaddr.getText();
            String ophno = vphno.getText();
            String aadhar = vaadhar.getText();
            try {
                Conn conn = new Conn();
                String query = "insert into vehicle values('"+vregno+"', '"+dor+"', '"+price+"', '"+oaddr+"', '"+ophno+"', '"+aadhar+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[]args){
        new AddVehicle();
    }
}