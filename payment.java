
package book.store;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class payment extends JFrame implements ActionListener {
   JButton buy;
   JButton enter;
   JButton exit ;
   JTextField Bookname;
   JLabel Bookprice;
   JComboBox Category;
   String id;
   String name_book;

   public static void main(String[] args) {
      new payment("", "");
   }

   public payment(String id, String name_book) {
      this.setSize(680, 400);
      this.setLocation(150, 20);
      this.setLayout((LayoutManager)null);
      this.setVisible(true);
      JLabel text = new JLabel(" PAYMENT DETAILS ");
      this.add(text);
      text.setBounds(200, 30, 450, 70);
      text.setFont(new Font("Raleway", 1, 29));
      text.setForeground(Color.orange);
      JLabel book_name = new JLabel(" Purchased Book : ");
      this.add(book_name);
      book_name.setBounds(120, 120, 220, 40);
      book_name.setFont(new Font("Raleway", 1, 18));
      book_name.setForeground(Color.gray);
      this.Bookname = new JTextField();
      this.add(this.Bookname);
      this.Bookname.setBounds(340, 120, 200, 30);
      this.Bookname.setFont(new Font("Arial", 0, 14));
      this.Bookname.setForeground(Color.black);
      this.enter = new JButton("Enter");
      this.add(this.enter);
      this.enter.setBounds(250, 160, 150, 30);
      this.enter.setBackground(Color.GRAY);
      this.enter.addActionListener(this);
      JLabel book_price = new JLabel(" Purchased Book Price : ");
      this.add(book_price);
      book_price.setBounds(120, 200, 220, 40);
      book_price.setFont(new Font("Raleway", 1, 18));
      book_price.setForeground(Color.gray);
      this.Bookprice = new JLabel();
      this.add(this.Bookprice);
      this.Bookprice.setBounds(340, 210, 200, 30);
      this.Bookprice.setFont(new Font("Arial", 0, 18));
      this.Bookprice.setForeground(Color.GRAY);
      JLabel category = new JLabel(" Mode of Payment : ");
      this.add(category);
      category.setBounds(120, 240, 220, 40);
      category.setFont(new Font("Raleway", 1, 18));
      category.setForeground(Color.gray);
      String[] rel_name = new String[]{"Cash", "Check", "Paytm", "G Pay", "Phone pay", "Internet Banking"};
      this.Category = new JComboBox(rel_name);
      this.Category.setBounds(340, 240, 200, 30);
      this.Category.setFont(new Font("Arial", 0, 14));
      this.add(this.Category);
      this.Category.setBackground(Color.white);
      this.Category.setForeground(Color.black);
      this.buy = new JButton("Pay");
      this.add(this.buy);
      this.buy.setBounds(150, 300, 150, 30);
      this.buy.setBackground(Color.GRAY);
      this.buy.addActionListener(this);
       this.exit = new JButton("Exit");
      this.add(this.exit);
      this.exit.setBounds(350, 300, 140, 30);
      this.exit.setBackground(Color.GRAY);
      this.exit.addActionListener(this);

   }

   public void actionPerformed(ActionEvent ae) {
      String nameofbook;
      String bookprice;
      
       if (ae.getSource() == this.exit) {
         this.setVisible(false);
      }
       
      if (ae.getSource() == this.buy) {
         nameofbook = this.Bookname.getText();
         bookprice = "0";
         String mode = (String)this.Category.getSelectedItem();
         String user_name = "";
         String seller = "";

         Conn c;
         try {
            c = new Conn();

            for(ResultSet rs = c.s.executeQuery("select * from books where bookname =  '" + nameofbook + "'"); rs.next(); bookprice = rs.getString("book_price")) {
            }
         } catch (Exception var14) {
            System.out.println(var14);
         }

         if (nameofbook.equals("")) {
            JOptionPane.showMessageDialog((Component)null, "Sorry ! You have not added any book , Add a Book");
         } else {
            JOptionPane.showMessageDialog((Component)null, "Congratulations !! You have purchased (" + nameofbook + ") book of price (" + bookprice + ") via (" + mode + ") mode");
         }

         c = new Conn();
         boolean var17 = false;

         try {
            ResultSet rs = c.s.executeQuery("select * from signup_admin where name =  '" + nameofbook + "'");
            if (rs.next()) {
               seller = rs.getString("name");
            }

            ResultSet rs1 = c.s.executeQuery("select * from signup_user where identification =  '" + this.id + "'");
            if (rs1.next()) {
               user_name = rs1.getString("name");
            }

            String query = "insert into book_sold values ('" + nameofbook + "','" + bookprice + "','" + mode + "','" + seller + "','" + this.id + "','" + user_name + " ')";
            c.s.executeUpdate(query);
         } catch (Exception var12) {
            System.out.println(var12);
         }
      }

      if (ae.getSource() == this.enter) {
         nameofbook = this.Bookname.getText();
         bookprice = "0";

         try {
            Conn c = new Conn();

            for(ResultSet rs = c.s.executeQuery("select * from books where bookname =  '" + nameofbook + "'"); rs.next(); bookprice = rs.getString("book_price")) {
            }

            this.Bookprice.setText(bookprice);
         } catch (Exception var13) {
            System.out.println(var13);
         }
      }

   }
}
