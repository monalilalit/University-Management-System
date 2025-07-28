package university_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateStudent extends JFrame implements ActionListener {

    JTextField tfcourse, tfaddress, tfphone, tfemail, tfbranch;
    JLabel labelrollno;
    JButton submit, cancel;
    Choice crollno;

    UpdateStudent() {
        setTitle("Add New Student");
        setSize(900, 650);
        setLocation(350, 50);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Update Student Details");
        heading.setBounds(50, 10, 500, 50);
        heading.setFont(new Font("Tahoma", Font.ITALIC, 35));
        add(heading);

        JLabel lblrollnumber = new JLabel("Select Roll Number");
        lblrollnumber.setBounds(30, 100, 220, 25);
        lblrollnumber.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblrollnumber);

        crollno = new Choice();
        crollno.setBounds(250, 100, 200, 25);
        add(crollno);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while (rs.next()) {
                crollno.add(rs.getString("rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 150, 100, 30);
        lblname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblname);

        JLabel labelname = new JLabel();
        labelname.setBounds(200, 150, 200, 18);
        labelname.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labelname);

        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(420, 150, 200, 30);
        lblfname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblfname);

        JLabel labelfname = new JLabel();
        labelfname.setBounds(600, 150, 200, 30);
        labelfname.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labelfname);

        JLabel lblrollno = new JLabel("Roll Number");
        lblrollno.setBounds(50, 200, 150, 30);
        lblrollno.setFont(new Font("serif", Font.BOLD, 20));
        add(lblrollno);

        labelrollno = new JLabel();
        labelrollno.setBounds(200, 200, 150, 30);
        labelrollno.setFont(new Font("serif", Font.BOLD, 20));
        add(labelrollno);

        JLabel lbldob = new JLabel("Date Of Birth");
        lbldob.setBounds(420, 200, 150, 30);
        lbldob.setFont(new Font("serif", Font.BOLD, 20));
        add(lbldob);

        JLabel labeldob = new JLabel();
        labeldob.setBounds(600, 200, 200, 30);
        labeldob.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labeldob);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50, 250, 150, 30);
        lbladdress.setFont(new Font("serif", Font.BOLD, 20));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 200, 30);
        add(tfaddress);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(420, 250, 100, 30);
        lblphone.setFont(new Font("serif", Font.BOLD, 20));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 200, 30);
        add(tfphone);

        JLabel lblemail = new JLabel("Email Id");
        lblemail.setBounds(50, 300, 150, 30);
        lblemail.setFont(new Font("serif", Font.BOLD, 20));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 200, 30);
        add(tfemail);

        JLabel lblx = new JLabel("Class X (%)");
        lblx.setBounds(420, 300, 150, 30);
        lblx.setFont(new Font("serif", Font.BOLD, 20));
        add(lblx);

        JLabel labelx = new JLabel();
        labelx.setBounds(600, 300, 200, 30);
        labelx.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labelx);

        JLabel lblxii = new JLabel("Class XII (%)");
        lblxii.setBounds(50, 350, 150, 30);
        lblxii.setFont(new Font("serif", Font.BOLD, 20));
        add(lblxii);

        JLabel labelxii = new JLabel();
        labelxii.setBounds(200, 350, 200, 30);
        labelxii.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labelxii);

        JLabel lblaadhar = new JLabel("Aadhar Number");
        lblaadhar.setBounds(420, 350, 150, 30);
        lblaadhar.setFont(new Font("serif", Font.BOLD, 20));
        add(lblaadhar);

        JLabel labelaadhar = new JLabel();
        labelaadhar.setBounds(600, 350, 200, 30);
        labelaadhar.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labelaadhar);

        JLabel lblcourse = new JLabel("Course");
        lblcourse.setBounds(50, 400, 200, 30);
        lblcourse.setFont(new Font("serif", Font.BOLD, 20));
        add(lblcourse);

        tfcourse = new JTextField();
        tfcourse.setBounds(200, 400, 200, 30);
        add(tfcourse);

        JLabel lblbranch = new JLabel("Branch");
        lblbranch.setBounds(420, 400, 150, 30);
        lblbranch.setFont(new Font("serif", Font.BOLD, 20));
        add(lblbranch);

        tfbranch = new JTextField();
        tfbranch.setBounds(600, 400, 200, 30);
        add(tfbranch);

        
               try {
                    Conn c = new Conn();
                    String query = "select * from student where rollno='" + crollno.getSelectedItem() + "'";
                    ResultSet rs = c.s.executeQuery(query);
                    if (rs.next()) {
                         labelname.setText(rs.getString("name"));
                        labelfname.setText(rs.getString("fname"));
                        labeldob.setText(rs.getString("dob"));
                        tfaddress.setText(rs.getString("address"));
                        tfphone.setText(rs.getString("phone"));
                        tfemail.setText(rs.getString("email"));
                        labelx.setText(rs.getString("class_x"));
                        labelxii.setText(rs.getString("class_xii"));
                        labelaadhar.setText(rs.getString("aadhar"));
                        labelrollno.setText(rs.getString("rollno"));
                        tfcourse.setText(rs.getString("course"));
                        tfbranch.setText(rs.getString("branch"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                crollno.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                  try {
                    Conn c = new Conn();
                    String query = "select * from student where rollno='" + crollno.getSelectedItem() + "'";
                    ResultSet rs = c.s.executeQuery(query);
                    if (rs.next()) {
                        labelname.setText(rs.getString("name"));
                        labelfname.setText(rs.getString("fname"));
                        labeldob.setText(rs.getString("dob"));
                        tfaddress.setText(rs.getString("address"));
                        tfphone.setText(rs.getString("phone"));
                        tfemail.setText(rs.getString("email"));
                        labelx.setText(rs.getString("class_x"));
                        labelxii.setText(rs.getString("class_xii"));
                        labelaadhar.setText(rs.getString("aadhar"));
                        labelrollno.setText(rs.getString("rollno"));
                        tfcourse.setText(rs.getString("course"));
                        tfbranch.setText(rs.getString("branch"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
            
        });

        submit = new JButton("Update");
        submit.setBounds(250, 500, 150, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450, 500, 150, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String rollno = labelrollno.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String course = tfcourse.getText();
            String branch = tfbranch.getText();

            try {
                String query = "update student set address='"+address+"',phone='"+phone+"',email='"+email+"',course='"+course+"',branch='"+branch+"'where rollno='"+rollno+"'";

                Conn con = new Conn();
                con.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Student Details Updated Successfully");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();

            }

        } else {
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new UpdateStudent();
    }
}
