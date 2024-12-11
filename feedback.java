
package book.store;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class feedback extends JFrame implements ActionListener {
   JTextField name_per;
   JButton submit;
   JTextArea feedback;

   public static void main(String[] args) {
      new feedback();
   }

   public feedback() {
      this.setSize(780, 400);
      this.setLocation(150, 20);
      this.setLayout((LayoutManager)null);
      this.setVisible(true);
      JLabel text = new JLabel(" FeedBack Form ");
      this.add(text);
      text.setBounds(260, 30, 350, 70);
      text.setFont(new Font("Raleway", 1, 29));
      text.setForeground(Color.RED);
      JLabel name = new JLabel(" Name  : ");
      this.add(name);
      name.setBounds(150, 120, 150, 50);
      name.setFont(new Font("Raleway", 1, 18));
      name.setForeground(new Color(120, 120, 120));
      this.name_per = new JTextField();
      this.add(this.name_per);
      this.name_per.setBounds(320, 120, 300, 30);
      this.name_per.setFont(new Font("Arial", 0, 14));
      this.name_per.setForeground(Color.black);
      JLabel response = new JLabel(" Feedback  : ");
      this.add(response);
      response.setBounds(150, 160, 150, 50);
      response.setFont(new Font("Raleway", 1, 18));
      response.setForeground(new Color(120, 120, 120));
      this.feedback = new JTextArea();
      this.add(this.feedback);
      this.feedback.setBounds(320, 160, 300, 80);
      this.feedback.setFont(new Font("Arial", 0, 14));
      this.feedback.setForeground(Color.black);
      this.submit = new JButton("SUBMIT");
      this.add(this.submit);
      this.submit.setBounds(250, 260, 150, 30);
      this.submit.setBackground(Color.GRAY);
      this.submit.addActionListener(this);
   }

   public void actionPerformed(ActionEvent ae) {
      if (ae.getSource() == this.submit) {
         String name = this.name_per.getText();
         String feed = this.feedback.getText();

         try {
            if (name.equals("")) {
               JOptionPane.showMessageDialog((Component)null, " Please , Enter a Name ");
            } else {
               Conn c = new Conn();
               String query = "insert into feedback values ('" + name + "','" + feed + "')";
               c.s.executeUpdate(query);
            }
         } catch (Exception var6) {
            System.out.println(var6);
         }
      }

      this.setVisible(false);
   }
}