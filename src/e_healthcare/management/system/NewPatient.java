package e_healthcare.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class NewPatient extends JFrame implements ActionListener {

    JComboBox comboBox;

    JTextField textFieldNumber, textname, textfieldDisease, textFieldDeposit;

    JRadioButton r1,r2,r3;

    Choice c1;

    JLabel date;

    JButton b1,b2;

    NewPatient(){
        JPanel panel= new JPanel();
        panel.setBounds(5,5,840,540);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/patient.png"));
        Image image = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(image);
        JLabel label = new JLabel(i2);
        label.setBounds(550,150,200,200);
        panel.add(label);

        JLabel labelname = new JLabel("NEW PATIENT FORM");
        labelname.setBounds(118,11,260,53);
        labelname.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(labelname);

        JLabel labelID = new JLabel("ID : ");
        labelID.setBounds(35,76,200,14);
        labelID.setFont(new Font("Tahoma",Font.BOLD,14));
        labelID.setForeground(Color.WHITE);
        panel.add(labelID);

        comboBox = new JComboBox(new String[] {"Aadhar Card","PAN Card","Driving License","Voter ID "});
        comboBox.setBounds(150,73,150,20);
        comboBox.setBackground(new Color(3,45,48));
        comboBox.setForeground(Color.white);
        panel.add(comboBox);

        JLabel labelNumber = new JLabel("Number : ");
        labelNumber.setBounds(35,111,200,14);
        labelNumber.setFont(new Font("Tahoma",Font.BOLD,14));
        labelNumber.setForeground(Color.WHITE);
        panel.add(labelNumber);

        textFieldNumber = new JTextField();
        textFieldNumber.setBounds(150,111,150,20);
        panel.add(textFieldNumber);

        JLabel labelName = new JLabel("Name : ");
        labelName.setBounds(35,151,200,14);
        labelName.setFont(new Font("Tahoma",Font.BOLD,14));
        labelName.setForeground(Color.WHITE);
        panel.add(labelName);

        textname = new JTextField();
        textname.setBounds(150,151,150,20);
        panel.add(textname);

        JLabel labelGender = new JLabel("Gender : ");
        labelGender.setBounds(35,191,200,14);
        labelGender.setFont(new Font("Tahoma",Font.BOLD,14));
        labelGender.setForeground(Color.WHITE);
        panel.add(labelGender);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Aerial",Font.BOLD,14));
        r1.setForeground(Color.white);
        r1.setBackground(new Color(109,164,170));
        r1.setBounds(150,195,80,12);
        panel.add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Aerial",Font.BOLD,14));
        r2.setForeground(Color.white);
        r2.setBackground(new Color(109,164,170));
        r2.setBounds(230,195,80,12);
        panel.add(r2);

        r3 = new JRadioButton("Other");
        r3.setFont(new Font("Aerial",Font.BOLD,14));
        r3.setForeground(Color.white);
        r3.setBackground(new Color(109,164,170));
        r3.setBounds(310,195,80,12);
        panel.add(r3);

        JLabel labelDisease = new JLabel("Disease : ");
        labelDisease.setBounds(35,231,200,14);
        labelDisease.setFont(new Font("Tahoma",Font.BOLD,14));
        labelDisease.setForeground(Color.WHITE);
        panel.add(labelDisease);

        textfieldDisease = new JTextField();
        textfieldDisease.setBounds(150,231,150,20);
        panel.add(textfieldDisease);

        JLabel labelRoom = new JLabel("Room : ");
        labelRoom.setBounds(35,274,200,14);
        labelRoom.setFont(new Font("Tahoma",Font.BOLD,14));
        labelRoom.setForeground(Color.WHITE);
        panel.add(labelRoom);


        c1 = new Choice();
        try{
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from room");
            while(resultSet.next()){

                c1.add(resultSet.getString("Room_No"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        c1.setBounds(250,274,160,20);
        c1.setFont(new Font("Tahoma",Font.BOLD,14));
        c1.setForeground(Color.white);
        c1.setBackground(new Color(3,45,48));
        panel.add(c1);


        JLabel labelDate = new JLabel("Date : ");
        labelDate.setBounds(35,316,200,14);
        labelDate.setFont(new Font("Tahoma",Font.BOLD,14));
        labelDate.setForeground(Color.WHITE);
        panel.add(labelDate);

        Date date1= new Date();

        date= new JLabel(""+date1);
        date.setBounds(150,316,250,14);
        date.setForeground(Color.WHITE);
        date.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(date);

        JLabel labelDeposit = new JLabel("Deposit : ");
        labelDeposit.setBounds(35,359,200,14);
        labelDeposit.setFont(new Font("Tahoma",Font.BOLD,14));
        labelDeposit.setForeground(Color.WHITE);
        panel.add(labelDeposit);

        textFieldDeposit = new JTextField();
        textFieldDeposit.setBounds(150,359,150,20);
        panel.add(textFieldDeposit);

        b1= new JButton("ADD");
        b1.setBounds(100,430,120,30);
        b1.setForeground(Color.white);
        b1.setBackground(Color.BLACK);
        b1.addActionListener(this);
        panel.add(b1);

        b2= new JButton("BACK");
        b2.setBounds( 260,430,120,30);
        b2.setForeground(Color.white);
        b2.setBackground(Color.BLACK);
        b2.addActionListener(this);
        panel.add(b2);




        setUndecorated(true);
        setSize(850,550);
        setLocation(233,200);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1){
            Conn c= new Conn();
            String radioBTN = null;
             if (r1.isSelected()){
                 radioBTN = "Male";
             }
             else if (r2.isSelected()){
                 radioBTN = "Female";
             } else if (r3.isSelected()) {
                 radioBTN="Other";

             }
            String s1= (String)comboBox.getSelectedItem();
             String s2= textFieldNumber.getText();
             String s3= textname.getText();
             String s4= radioBTN;
             String s5= textfieldDisease.getText();
             String s6= c1.getSelectedItem();
             String s7= date.getText();
             String s8= textFieldDeposit.getText();

             try{
                 String q= "insert into patient_info values ('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"')";
                 String q1= "update room set Availability = 'Occupied' where Room_No = "+s6;

                 c.statement.executeUpdate(q);
                 c.statement.executeUpdate(q1);

                 JOptionPane.showMessageDialog(null,"Added Successfully");
                 setVisible(false);
             } catch (Exception E) {
                 E.printStackTrace();
             }


        }
        else {
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new NewPatient();
    }


}
