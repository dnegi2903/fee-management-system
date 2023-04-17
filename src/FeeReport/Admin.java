package FeeReport;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
public class Admin extends JFrame implements ActionListener {
    JLabel l1,l2,l3;
    JButton b1,b2;
    JPanel p1,p2;
    Font f,f1;
    JTextField tf;
    JPasswordField pf;
    Admin(){
        super("AdminLogin Page");
        setLocation(100,100);
        setSize(500,200);

        l1 = new JLabel("Admin Login");
        l2 = new JLabel("Username");
        l3 = new JLabel("Password");

        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setForeground(Color.BLUE);

        b1 = new JButton("Login");
        b2 = new JButton("Cancel");

        b1.addActionListener(this);
        b2.addActionListener(this);

        tf = new JTextField();
        pf = new JPasswordField();

        f = new Font("Arial",Font.BOLD,20);
        f1 = new Font("Arial",Font.BOLD,15);

        l1.setFont(f);
        l2.setFont(f1);
        l3.setFont(f1);
        b1.setFont(f1);
        b2.setFont(f1);
        tf.setFont(f1);
        pf.setFont(f1);

        p1 = new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);

        p2 = new JPanel();
        p2.setLayout(new GridLayout(3,2,10,10));
        p2.add(l2);
        p2.add(tf);
        p2.add(l3);
        p2.add(pf);
        p2.add(b1);
        p2.add(b2);

        setLayout(new BorderLayout(0,0));

        add(p1,"North");
        add(p2,"Center");

    }
    public void actionPerformed(ActionEvent event){
        String name = tf.getText();
        String pass = pf.getText();

        if (event.getSource()==b1){
            try {
                ConnectionClass connectionClass = new ConnectionClass();
                String q = "select * from admin where username='"+name+"' and password='"+pass+"'";
                ResultSet rest = connectionClass.stmt.executeQuery(q);
                    if (rest.next()){
                        System.out.println("hello");
                    new AdminSection().setVisible(true);
                    System.out.println("you are login");
                } else{
                    JOptionPane.showMessageDialog(null,"Oops! Username or Password is Wrong..");
                }
                this.setVisible(false);
            } catch (Exception ee){
                ee.printStackTrace();
            }
        }
        if (event.getSource()==b2){
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Index().setVisible(true);
    }
}
