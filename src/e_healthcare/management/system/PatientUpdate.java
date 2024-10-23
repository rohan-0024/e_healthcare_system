package e_healthcare.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class PatientUpdate extends JFrame {
    PatientUpdate(){


        JPanel panel =new JPanel();
        panel.setBounds(5,5,940,490);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/updated.png"));
        Image image = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500,60,300,300);
        panel.add(label);

        JLabel label1 = new JLabel("Update Patient Details");
        label1.setBounds(124,11,260,25);
        label1.setFont(new Font("Tahoma",Font.BOLD,20));
        label1.setForeground(Color.white);
        panel.add(label1);


        JLabel label2 = new JLabel("Name :");
        label2.setBounds(25,88,100,14);
        label2.setFont(new Font("Tahoma",Font.PLAIN,16));
        label2.setForeground(Color.white);
        panel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(245,85,100,25);
        panel.add(choice);

        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from patient_info");
            while(resultSet.next()){
                choice.add(resultSet.getString("Name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel label3 = new JLabel("Room Number");
        label3.setBounds(25,129,100,14);
        label3.setFont(new Font("Tahoma",Font.PLAIN,16));
        label3.setForeground(Color.white);
        panel.add(label3);

        JTextField jTextField = new JTextField();
        jTextField.setBounds(248,129,140,20);
        panel.add(jTextField);

        JLabel label4 = new JLabel("In Time :");
        label4.setBounds(25,174,100,14);
        label4.setFont(new Font("Tahoma",Font.PLAIN,16));
        label4.setForeground(Color.white);
        panel.add(label4);

        JTextField jTextFieldINTIME = new JTextField();
        jTextFieldINTIME.setBounds(248,174,140,20);
        panel.add(jTextFieldINTIME);

        JLabel label5 = new JLabel("Amounr Paid (INR) :");
        label5.setBounds(25,216,150,14);
        label5.setFont(new Font("Tahoma",Font.PLAIN,16));
        label5.setForeground(Color.white);
        panel.add(label5);

        JTextField jTextFieldAmount = new JTextField();
        jTextFieldAmount.setBounds(248,216,140,20);
        panel.add(jTextFieldAmount);

        JLabel label6 = new JLabel("Pending Amount (INR) :");
        label6.setBounds(25,261,200,14);
        label6.setFont(new Font("Tahoma",Font.PLAIN,16));
        label6.setForeground(Color.white);
        panel.add(label6);

        JTextField jTextFieldPending = new JTextField();
        jTextFieldPending.setBounds(248,261,140,20);
        panel.add(jTextFieldPending);

        JButton check = new JButton("CHECK");
        check.setBounds(281,378,89,23);
        check.setBackground(Color.black);
        check.setForeground(Color.white);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = choice.getSelectedItem();
                String q = "select * from patient_info where Name = '"+id+"'";
                try {
                    Conn c = new Conn();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    while (resultSet.next()){
                        jTextField.setText(resultSet.getString("Room_Number"));
                        jTextFieldINTIME.setText(resultSet.getString("Time"));
                        jTextFieldAmount.setText(resultSet.getString("Deposit"));
                    }


                    ResultSet resultSet1 = c.statement.executeQuery("select * from room where Room_No = '"+jTextField.getText()+"'");
                    while(resultSet1.next()){
                        String price = resultSet1.getString("Price");
                        int amountpaid= Integer.parseInt(price) - Integer.parseInt(jTextFieldAmount.getText());
                        jTextFieldPending.setText(""+amountpaid);


                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton update = new JButton("UPDATE");
        update.setBounds(56,378,89,23);
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                try {
                    Conn c = new Conn();
                    String q = choice.getSelectedItem();
                    String room = jTextField.getText();
                    String time = jTextFieldINTIME.getText();
                    String amount = jTextFieldAmount.getText();
                    c.statement.executeUpdate("update patient_info set Room_Number = '"+room+"', Time = '"+time+"', Deposit = '"+amount+"' where name = '"+q+"'");
                    JOptionPane.showMessageDialog(null,"Updated Succesfully");
                    setVisible(false);

                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton back = new JButton("BACK");

        back.setBounds(168,378,89,23);
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
        setSize(950,500);
        setLayout(null);
        setLocation(200,200);
        setVisible(true);


    }


    public static void main(String[] args) {
        new PatientUpdate();
    }
}
