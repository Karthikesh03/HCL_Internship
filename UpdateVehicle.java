package org.example;

import com.toedter.calendar.JDateChooser;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateVehicle extends JFrame implements ActionListener{

    JTextField tffname, tfaddress, tfphone, tfaadhar, tfprice;
    JLabel lblempId;
    JButton add, back;
    JDateChooser dcdob;
    String empId;

    UpdateVehicle(String empId) {
        this.empId = empId;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Update Vehicle Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);

        JLabel labelregno = new JLabel("Vehicle Reg No");
        labelregno.setBounds(50, 150, 150, 30);
        labelregno.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelregno);
        tffname = new JTextField();
        tffname.setBounds(200, 150, 150, 30);
        add(tffname);

        JLabel labeldor = new JLabel("Date of Reg");
        labeldor.setBounds(50, 200, 150, 30);
        labeldor.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldor);
        dcdob = new JDateChooser();
        dcdob.setBounds(200, 200, 150, 30);
        add(dcdob);


        JLabel labelprice = new JLabel("Price");
        labelprice.setBounds(400, 200, 150, 30);
        labelprice.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelprice);

        tfprice = new JTextField();
        tfprice.setBounds(600, 200, 150, 30);
        add(tfprice);

        JLabel labeladdr = new JLabel("Owner's Address");
        labeladdr.setBounds(50, 250, 150, 30);
        labeladdr.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeladdr);


        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        add(tfaddress);

        JLabel labelphn = new JLabel("Phone");
        labelphn.setBounds(400, 250, 150, 30);
        labelphn.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelphn);

        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        add(tfphone);


        JLabel labelaadhar = new JLabel("Aadhar Number");
        labelaadhar.setBounds(400, 150, 150, 30);
        labelaadhar.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelaadhar);
        tfaadhar = new JTextField();
        tfaadhar.setBounds(600, 150, 150, 30);
        add(tfaadhar);

        JLabel lblvehicleregno = new JLabel();
        lblvehicleregno.setBounds(200, 400, 150, 30);
        lblvehicleregno.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblvehicleregno);

        try {
            Conn c = new Conn();
            String query = "select * from vehicle where vregno = '"+labelregno+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {

                tfaddress.setText(rs.getString("oaddr"));
                tfprice.setText(rs.getString("price"));
                tfphone.setText(rs.getString("ophno"));
                tfaadhar.setText(rs.getString("aadhar"));
                tffname.setText(rs.getString("vregno"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        add = new JButton("Update Details");
        add.setBounds(250, 350, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);

        back = new JButton("Back");
        back.setBounds(450, 350, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);

        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String vregno = tffname.getText();
            String price = tfprice.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String aadhar = tfaadhar.getText();
            String dor = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            //String email = tfemail.getText();
            // String designation = tfdesignation.getText();

            try {
                Conn conn = new Conn();
                String query = "update vehicle set dor = '"+dor+"', price = '"+price+"', oaddr = '"+address+"', ophno = '"+phone+"', aadhar = ' "+aadhar+"' where vregno = '"+vregno+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
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

    public static void main(String[] args) {
        new UpdateVehicle("");
    }
}