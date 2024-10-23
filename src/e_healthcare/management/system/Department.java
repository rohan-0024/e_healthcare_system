package e_healthcare.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame {

    Department(){

        JPanel panel= new JPanel();
        panel.setBounds(5,5,690,490);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(12,40,700,280);
        table.setBackground(new Color(90,156,163));
        panel.add(table);

        try{

            Conn c = new Conn();
            String q= "select * from department";
            ResultSet resultSet= c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label1= new JLabel("Department");
        label1.setBounds(12,15,130,15);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label1);

        JLabel label2= new JLabel("Phone No");
        label2.setBounds(362,15,80,15);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label2);

        JButton back = new JButton("Back");
        back.setBounds(274,320,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });




        setSize(715,500);
        setLayout(null);
        setLocation(300,200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Department();
    }
}
