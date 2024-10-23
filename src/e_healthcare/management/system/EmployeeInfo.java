package e_healthcare.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class EmployeeInfo extends JFrame {



    EmployeeInfo(){

        JPanel panel= new JPanel();
        panel.setBounds(5,5,990,590);
        panel.setBackground(new Color(109,164,170));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10,35,980,250);
        table.setBackground(new Color(109,164,170));
        panel.add(table);

        try{

            Conn c = new Conn();
            String q= "select * from emp_info";
            ResultSet resultSet= c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label1= new JLabel("Name");
        label1.setBounds(41,9,70,20);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label1);

        JLabel label2= new JLabel("Age");
        label2.setBounds(175,9,70,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label2);

        JLabel label3= new JLabel("Phone Number");
        label3.setBounds(340,9,130,20);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label3);

        JLabel label4= new JLabel("Salary");
        label4.setBounds(500,9,130,20);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label4);

        JLabel label5= new JLabel("Mail");
        label5.setBounds(700,9,130,20);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label5);

        JLabel label6= new JLabel("Aadhar No");
        label6.setBounds(835,9,130,20);
        label6.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label6);

        JButton button = new JButton("Back");
        button.setBounds(350,400,120,30);
        button.setBackground(Color.black);
        button.setForeground(Color.white);
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });



        setUndecorated(true);
        setSize(1000,600);
        setLocation(200,195);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
         new EmployeeInfo();
    }
}
