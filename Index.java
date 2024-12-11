
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

public class Index extends JFrame implements ActionListener {
   JButton next;

   public static void main(String[] args) {
      new Index();
   }

   public Index() {
      this.setSize(750, 550);
      this.setLocation(150, 20);
      this.setLayout((LayoutManager)null);
      this.setVisible(true);
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/book img.jpg"));
      Image i2 = i1.getImage().getScaledInstance(750, 550, 1);
      ImageIcon i3 = new ImageIcon(i2);
      JLabel image = new JLabel(i3);
      image.setSize(750, 550);
      image.setLocation(0, 0);
      this.add(image);
      JLabel text = new JLabel(" Welcome to Online Book Store ");
      image.add(text);
      text.setBounds(190, 30, 450, 50);
      text.setFont(new Font("Raleway", 1, 25));
      text.setForeground(Color.GRAY);
      this.next = new JButton("Open the Door");
      image.add(this.next);
      this.next.setBounds(280, 470, 140, 30);
      this.next.setBackground(Color.LIGHT_GRAY);
      this.next.addActionListener(this);
   }

   public void actionPerformed(ActionEvent ae) {
      if (ae.getSource() == this.next) {
         this.setVisible(false);
         (new Index_2()).setVisible(true);
      }

   }
}
