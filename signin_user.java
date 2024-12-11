
package book.store;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class signin_user extends JFrame implements ActionListener {
   JTextField name_per;
   JTextField email_id;
   JTextField res_add;
   JTextField phone_no;
   JTextField id;
   JDateChooser date;
   JButton signin;
   JButton back;
   JRadioButton male;
   JRadioButton female;
   JPasswordField password;
   String identification;

   public static void main(String[] args) {
      new signin_user();
   }

   public signin_user() {
      this.setSize(800, 600);
      this.setLocation(150, 20);
      this.setLayout((LayoutManager)null);
      this.setVisible(true);
      Font f2 = new Font("Arial", 0, 18);
      Font f3 = new Font("Arial", 2, 14);
      new Font("Arial", 0, 15);
      JLabel text = new JLabel(" Sign-Up ");
      this.add(text);
      text.setBounds(420, 30, 150, 70);
      text.setFont(new Font("Raleway", 1, 29));
      text.setForeground(Color.RED);
      ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("images/user_3.png"));
      Image i5 = i4.getImage().getScaledInstance(100, 80, 1);
      ImageIcon i6 = new ImageIcon(i5);
      JLabel image1 = new JLabel(i6);
      image1.setBounds(230, 10, 100, 80);
      this.add(image1);
      JLabel name = new JLabel(" Name  : ");
      this.add(name);
      name.setBounds(150, 120, 150, 50);
      name.setFont(f2);
      name.setForeground(new Color(120, 120, 120));
      this.name_per = new JTextField();
      this.add(this.name_per);
      this.name_per.setBounds(350, 120, 300, 30);
      this.name_per.setFont(new Font("Arial", 0, 14));
      this.name_per.setForeground(Color.black);
      JLabel dob = new JLabel(" Date Of Birth : ");
      this.add(dob);
      dob.setBounds(150, 160, 200, 40);
      dob.setFont(f2);
      dob.setForeground(new Color(120, 120, 120));
      this.date = new JDateChooser();
      this.date.setBounds(350, 160, 300, 25);
      this.add(this.date);
      this.date.setFont(f3);
      this.date.setForeground(Color.black);
      JLabel email = new JLabel(" Email Id : ");
      this.add(email);
      email.setBounds(150, 200, 200, 40);
      email.setFont(f2);
      email.setForeground(new Color(120, 120, 120));
      this.email_id = new JTextField();
      this.add(this.email_id);
      this.email_id.setBounds(350, 200, 300, 25);
      this.email_id.setFont(f3);
      this.email_id.setForeground(Color.black);
      JLabel gender = new JLabel(" Gender : ");
      this.add(gender);
      gender.setBounds(150, 240, 200, 40);
      gender.setFont(f2);
      gender.setForeground(new Color(120, 120, 120));
      this.male = new JRadioButton("Male");
      this.add(this.male);
      this.male.setFont(f3);
      this.male.setBounds(350, 240, 80, 40);
      this.female = new JRadioButton("Female");
      this.add(this.female);
      this.female.setFont(f3);
      this.female.setBounds(450, 240, 80, 40);
      ButtonGroup gender_grp = new ButtonGroup();
      gender_grp.add(this.male);
      gender_grp.add(this.female);
      JLabel address = new JLabel(" Residential Address : ");
      this.add(address);
      address.setBounds(150, 280, 200, 40);
      address.setFont(f2);
      address.setForeground(new Color(120, 120, 120));
      this.res_add = new JTextField();
      this.add(this.res_add);
      this.res_add.setBounds(350, 280, 300, 25);
      this.res_add.setFont(f3);
      this.res_add.setForeground(Color.black);
      JLabel phone = new JLabel(" Phone No : ");
      this.add(phone);
      phone.setBounds(150, 320, 200, 40);
      phone.setFont(f2);
      phone.setForeground(new Color(120, 120, 120));
      this.phone_no = new JTextField();
      this.add(this.phone_no);
      this.phone_no.setBounds(350, 320, 300, 25);
      this.phone_no.setFont(f3);
      this.phone_no.setForeground(Color.black);
      JLabel create_id = new JLabel(" Create an Id : ");
      this.add(create_id);
      create_id.setBounds(150, 360, 200, 40);
      create_id.setFont(f2);
      create_id.setForeground(new Color(120, 120, 120));
      this.id = new JTextField();
      this.add(this.id);
      this.id.setBounds(350, 360, 300, 30);
      this.id.setFont(new Font("Arial", 0, 14));
      this.id.setForeground(Color.black);
      JLabel note1 = new JLabel(" * An Id must contains at least 1 capital letter , small letter , number and special character");
      this.add(note1);
      note1.setBounds(150, 390, 500, 20);
      note1.setFont(new Font("Arial", 0, 12));
      note1.setForeground(Color.red);
      this.signin = new JButton("Sign in");
      this.add(this.signin);
      this.signin.setBounds(220, 490, 140, 30);
      this.signin.setBackground(Color.GRAY);
      this.signin.addActionListener(this);
      this.back = new JButton("back");
      this.add(this.back);
      this.back.setBounds(420, 490, 140, 30);
      this.back.setBackground(Color.GRAY);
      this.back.addActionListener(this);
      JLabel pass = new JLabel(" Generate Password : ");
      this.add(pass);
      pass.setBounds(150, 410, 200, 50);
      pass.setFont(f2);
      pass.setForeground(new Color(120, 120, 120));
      this.password = new JPasswordField();
      this.add(this.password);
      this.password.setBounds(350, 420, 300, 30);
      this.password.setFont(new Font("Arial", 0, 14));
      this.password.setForeground(Color.black);
      JLabel note2 = new JLabel(" * An password must contains at least 1 capital letter , small letter , number and special character");
      this.add(note2);
      note2.setBounds(150, 450, 500, 20);
      note2.setFont(new Font("Arial", 0, 12));
      note2.setForeground(Color.red);
   }

   public void actionPerformed(ActionEvent ae) {
      if (ae.getSource() == this.back) {
         this.setVisible(false);
         (new Index_2()).setVisible(true);
      }

      if (ae.getSource() == this.signin) {
         String name = this.name_per.getText();
         String email = this.email_id.getText();
         String address = this.res_add.getText();
         String phone = this.phone_no.getText();
         String iden = this.id.getText();
         String DOB = ((JTextField)this.date.getDateEditor().getUiComponent()).getText();
         String gen = null;
         if (this.male.isSelected()) {
            gen = "Male";
         } else if (this.female.isSelected()) {
            gen = "Female";
         }

         String pass = this.password.getText();

         try {
            if (iden.equals("")) {
               JOptionPane.showMessageDialog((Component)null, " Create an ID ");
            } else if (pass.equals("")) {
               JOptionPane.showMessageDialog((Component)null, " Create a Password ");
            } else {
               Conn c = new Conn();
               String query = "insert into signup_user values ('" + iden + "','" + pass + "','" + name + "','" + gen + "','" + DOB + "','" + address + "','" + email + "','" + phone + " ')";
               c.s.executeUpdate(query);
               this.setVisible(false);
               (new book_catalog(this.identification)).setVisible(true);
            }
         } catch (Exception var12) {
            System.out.println(var12);
         }
      }

   }
}
