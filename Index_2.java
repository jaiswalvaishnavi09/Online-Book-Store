/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.store;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Index_2 extends JFrame implements ActionListener {
   JButton log_ad;
   JButton log_user;
   JButton signin_ad;
   JButton signin_user;
   JButton exit;

   public static void main(String[] args) {
      new Index_2();
   }

   public Index_2() {
      this.setSize(750, 550);
      this.setLocation(150, 20);
      this.setLayout((LayoutManager)null);
      this.setVisible(true);
      JLabel text = new JLabel(" Register / Login into Your account ");
      this.add(text);
      text.setBounds(200, 30, 450, 50);
      text.setFont(new Font("Raleway", 1, 20));
      text.setForeground(Color.orange);
      JLabel text1 = new JLabel(" Admin ");
      this.add(text1);
      text1.setBounds(150, 100, 450, 50);
      text1.setFont(new Font("Raleway", 1, 20));
      text1.setForeground(Color.PINK);
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/admin_3.jpg"));
      Image i2 = i1.getImage().getScaledInstance(200, 100, 1);
      ImageIcon i3 = new ImageIcon(i2);
      JLabel image = new JLabel(i3);
      image.setBounds(100, 150, 200, 100);
      this.add(image);
      JLabel text2 = new JLabel(" User ");
      this.add(text2);
      text2.setBounds(450, 100, 450, 50);
      text2.setFont(new Font("Raleway", 1, 20));
      text2.setForeground(Color.pink);
      ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("images/user_1.jpg"));
      Image i5 = i4.getImage().getScaledInstance(200, 100, 1);
      ImageIcon i6 = new ImageIcon(i5);
      JLabel image1 = new JLabel(i6);
      image1.setBounds(400, 150, 200, 100);
      this.add(image1);
      this.log_ad = new JButton("Login");
      this.add(this.log_ad);
      this.log_ad.setBounds(130, 270, 140, 30);
      this.log_ad.setBackground(Color.GRAY);
      this.log_ad.addActionListener(this);
      this.log_user = new JButton("Login");
      this.add(this.log_user);
      this.log_user.setBounds(430, 270, 140, 30);
      this.log_user.setBackground(Color.GRAY);
      this.log_user.addActionListener(this);
      this.signin_ad = new JButton("Sign-Up");
      this.add(this.signin_ad);
      this.signin_ad.setBounds(130, 310, 140, 30);
      this.signin_ad.setBackground(Color.GRAY);
      this.signin_ad.addActionListener(this);
      this.signin_user = new JButton("Sign-Up");
      this.add(this.signin_user);
      this.signin_user.setBounds(430, 310, 140, 30);
      this.signin_user.setBackground(Color.GRAY);
      this.signin_user.addActionListener(this);
      this.exit = new JButton("Exit");
      this.add(this.exit);
      this.exit.setBounds(280, 350, 140, 30);
      this.exit.setBackground(Color.GRAY);
      this.exit.addActionListener(this);
   }

   public void actionPerformed(ActionEvent ae) {
      if (ae.getSource() == this.exit) {
         this.setVisible(false);
      }

      if (ae.getSource() == this.log_ad) {
         (new login_admin()).setVisible(true);
         this.setVisible(false);
      }

      if (ae.getSource() == this.log_user) {
         this.setVisible(false);
         (new login_user()).setVisible(true);
      }

      if (ae.getSource() == this.signin_ad) {
         this.setVisible(false);
         (new signin_admin()).setVisible(true);
      }

      if (ae.getSource() == this.signin_user) {
         this.setVisible(false);
         (new signin_user()).setVisible(true);
      }

   }
}
