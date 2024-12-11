
package book.store;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class login_admin extends JFrame implements ActionListener {
   JPasswordField password;
   JTextField name_per;
   JButton signin;
   JButton back;

   public static void main(String[] args) {
      new login_admin();
   }

   public login_admin() {
      this.setSize(680, 400);
      this.setLocation(150, 20);
      this.setLayout((LayoutManager)null);
      this.setVisible(true);
      JLabel text = new JLabel(" Login ");
      this.add(text);
      text.setBounds(270, 30, 450, 70);
      text.setFont(new Font("Raleway", 1, 29));
      text.setForeground(Color.orange);
      ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("images/admin_3.jpg"));
      Image i5 = i4.getImage().getScaledInstance(150, 150, 1);
      ImageIcon i6 = new ImageIcon(i5);
      JLabel image1 = new JLabel(i6);
      image1.setBounds(30, 110, 150, 150);
      this.add(image1);
      JLabel ad = new JLabel(" Admin ");
      this.add(ad);
      ad.setBounds(70, 260, 80, 30);
      ad.setFont(new Font("Raleway", 1, 16));
      ad.setForeground(Color.DARK_GRAY);
      JLabel name = new JLabel(" Identity  : ");
      this.add(name);
      name.setBounds(220, 120, 150, 50);
      name.setFont(new Font("Raleway", 1, 18));
      name.setForeground(Color.gray);
      this.name_per = new JTextField();
      this.add(this.name_per);
      this.name_per.setBounds(400, 130, 200, 30);
      this.name_per.setFont(new Font("Arial", 0, 14));
      this.name_per.setForeground(Color.black);
      JLabel pass = new JLabel(" Password : ");
      this.add(pass);
      pass.setBounds(220, 160, 150, 50);
      pass.setFont(new Font("Raleway", 1, 18));
      pass.setForeground(Color.gray);
      this.password = new JPasswordField();
      this.add(this.password);
      this.password.setBounds(400, 170, 200, 30);
      this.password.setFont(new Font("Arial", 0, 14));
      this.password.setForeground(Color.black);
      this.signin = new JButton("Login");
      this.add(this.signin);
      this.signin.setBounds(235, 230, 140, 30);
      this.signin.setBackground(Color.GRAY);
      this.signin.addActionListener(this);
      this.back = new JButton("back");
      this.add(this.back);
      this.back.setBounds(435, 230, 140, 30);
      this.back.setBackground(Color.GRAY);
      this.back.addActionListener(this);
   }

   public void actionPerformed(ActionEvent ae) {
      if (ae.getSource() == this.back) {
         this.setVisible(false);
         (new Index_2()).setVisible(true);
      } else if (ae.getSource() == this.signin) {
         Conn c = new Conn();
         String name = this.name_per.getText();
         String pass = this.password.getText();
         String query = " select * from signup_admin where identification = '" + name + "' and pass = '" + pass + "'";

         try {
            ResultSet rs = c.s.executeQuery(query);
            if (rs.next()) {
               this.setVisible(false);
               (new Admin_Page(name)).setVisible(true);
            } else {
               JOptionPane.showMessageDialog((Component)null, " Incorrect ID or Password ");
            }
         } catch (Exception var7) {
            System.out.println(var7);
         }
      }

   }
}
    
