package e_healthcare.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRoom extends JFrame {
    SearchRoom(){


        JPanel panel =new JPanel();
        panel.setBounds(5,5,690,490);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);



        JLabel forRoom = new JLabel("Search for Room");
        forRoom.setBounds(250,11,186,31);
        forRoom.setForeground(Color.yellow);
        forRoom.setFont(new Font("Tahome",Font.BOLD,20));
        panel.add(forRoom);

        JLabel status = new JLabel("Status :");
        status.setBounds(70,72,80,20);
        status.setForeground(Color.yellow);
        status.setFont(new Font("Tahome",Font.BOLD,16));
        panel.add(status);

        Choice choice = new Choice();
        choice.setBounds(170,73,120,20);
        choice.add("Available");
        choice.add("Occupied");
        panel.add(choice);

        JTable table = new JTable();
        table.setBounds(0,187,700,210);
        table.setBackground(new Color(90,156,163));
        table.setForeground(Color.white);
        panel.add(table);

        try {
            Conn c = new Conn();
            String q = "select * from room";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel roomno = new JLabel("Room Number :");
        roomno.setBounds(18,162,150,20);
        roomno.setForeground(Color.yellow);
        roomno.setFont(new Font("Tahome",Font.BOLD,16));
        panel.add(roomno);

        JLabel available = new JLabel("Availability");
        available.setBounds(172,162,150,20);
        available.setForeground(Color.yellow);
        available.setFont(new Font("Tahome",Font.BOLD,16));
        panel.add(available);

        JLabel Price = new JLabel("Price");
        Price.setBounds(350,162,150,20);
        Price.setForeground(Color.yellow);
        Price.setFont(new Font("Tahome",Font.BOLD,16));
        panel.add(Price);

        JLabel Bed = new JLabel("Bed Type");
        Bed.setBounds(520,162,150,20);
        Bed.setForeground(Color.yellow);
        Bed.setFont(new Font("Tahome",Font.BOLD,16));
        panel.add(Bed);


        JButton search = new JButton("Search");
        search.setBounds(200,420,120,25);
        search.setBackground(Color.black);
        search.setForeground(Color.white);
        panel.add(search);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String q = "select * from Room where Availability = '"+choice.getSelectedItem()+"'";
                try {
                    Conn c = new Conn();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(380,420,120,25);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });




        setUndecorated(true);
        setSize(700,500);
        setLayout(null);
        setLocation(275,180);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SearchRoom();
    }
}
