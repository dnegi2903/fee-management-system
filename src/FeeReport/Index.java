package FeeReport;
import java.awt.event.*;
import java.awt.*;
import javax.imageio.stream.ImageInputStream;
import java.sql.*;
import javax.swing.*;
public class Index extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4;
    JButton b1, b2;
    JPanel p1, p2, p3;
    Font f, f1;

    Index() {
        super("Home Page");
        setLocation(100, 100);
        setSize(500, 200);

        l1 = new JLabel("Welcome");
        l2 = new JLabel("Admin Login");
        l3 = new JLabel("Accountant Login");

        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setForeground(Color.BLUE);

        b1 = new JButton("Login");
        b2 = new JButton("Login");

        b1.addActionListener(this);
        b2.addActionListener(this);

        f = new Font("Arial", Font.BOLD, 20);
        f1 = new Font("Arial", Font.BOLD, 15);

        l1.setFont(f);
        l2.setFont(f1);
        l3.setFont(f1);
        b1.setFont(f1);
        b2.setFont(f1);

        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("FeeReport/icons/LoginImage1.png"));
        Image img = i.getImage().getScaledInstance(130, 100, Image.SCALE_DEFAULT);
        ImageIcon i1 = new ImageIcon(img);
        l4 = new JLabel(i1);

        p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 1, 10, 10));
        p1.add(l1);

        p2 = new JPanel();
        p2.setLayout(new GridLayout(2, 2, 10, 10));
        p2.add(l2);
        p2.add(b1);
        p2.add(l3);
        p2.add(b2);

        p3 = new JPanel();
        p3.setLayout(new GridLayout(1, 1, 10, 10));
        p3.add(l4);

        setLayout(new BorderLayout(0, 0));

        add(p1, "North");
        add(p2, "Center");
        add(p3, "West");

    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == b1) {
            new Admin().setVisible(true);
            this.setVisible(false);
        } if(event.getSource()==b2){
            new Accountant().setVisible(true);
            this.setVisible(false);
        }
        }
        public static void main(String[] args){
            new Index().setVisible(true);
        }
    }

