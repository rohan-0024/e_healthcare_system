package e_healthcare.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JTextField textField;

    JPasswordField  jPasswordField;

    JButton b1,b2;
    Login(){

        JLabel namelabel = new JLabel("Username:");
        namelabel.setBounds(40,20,100,30);
        namelabel.setFont(new Font("Tahoma",Font.BOLD,16));
        namelabel.setForeground(Color.BLUE);
        add(namelabel);

        JLabel password = new JLabel("Password:");
        password.setBounds(40,70,100,30);
        password.setFont(new Font("Tahoma",Font.BOLD,16));
        password.setForeground(Color.blue);
        add(password);




        textField= new JTextField();
        textField.setBounds(150,20,150,30);
        textField.setFont(new Font("Aerial",Font.BOLD,15));
        textField.setBackground(new Color(255, 252, 247));
        add(textField);


        jPasswordField=new JPasswordField();
        jPasswordField.setBounds(150,70,150,30);
        jPasswordField.setFont(new Font("Aerial",Font.BOLD,15));
        jPasswordField.setBackground(new Color(255, 252, 247));
        add(jPasswordField);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/login3.JPG"));
        Image i1 = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(i1);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(320,0,400,300);
        add(label);

        b1=new JButton("Login");
        b1.setBounds(40,140,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Cancel");
        b2.setBounds(180,140,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.addActionListener(this);
        add(b2);







        getContentPane().setBackground(new Color(0, 220, 220));
        setSize(750,300);
        setLocation(270,220);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() ==  b1){
            try {

                Conn c = new Conn();
                String user = textField.getText();
                String Pass = jPasswordField.getText();

                String q = "select * from login where ID = '"+user+"' and pw = '"+Pass+"'";
                ResultSet resultSet = c.statement.executeQuery(q);

                if(resultSet.next()){
                    new Reception();
                    setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid credentials");
                }

            }catch (Exception E){
                E.printStackTrace();
            }
        }
        else{
            System.exit(20);
        }
    }


    public static void main(String[] args) {
        new Login();
    }


}
