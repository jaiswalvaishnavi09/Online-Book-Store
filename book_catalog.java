
package book.store;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class book_catalog extends JFrame implements ActionListener {
   JButton ser;
   JButton buy;
   JButton logout;
   JButton feedback;
   JTextField search_book;
   JLabel Bookauthor;
   JLabel Bookprice;
   JLabel Category;
   JLabel Bookname;
   String id;
   String name_book;

   public static void main(String[] args) {
      new book_catalog("");
   }

   public book_catalog(String id) {
      this.id = id;
      this.setSize(680, 570);
      this.setLocation(150, 20);
      this.setLayout((LayoutManager)null);
      this.setVisible(true);
      JLabel text = new JLabel(" BOOKS DETAILS ");
      this.add(text);
      text.setBounds(215, 30, 450, 70);
      text.setFont(new Font("Raleway", 1, 29));
      text.setForeground(Color.orange);
      this.ser = new JButton("Search");
      this.add(this.ser);
      this.ser.setBounds(130, 120, 110, 30);
      this.ser.setBackground(Color.GRAY);
      this.ser.addActionListener(this);
      this.search_book = new JTextField();
      this.add(this.search_book);
      this.search_book.setBounds(280, 120, 240, 30);
      this.search_book.setFont(new Font("Arial", 0, 14));
      this.search_book.setForeground(Color.black);
      JLabel text1 = new JLabel(" DETAILS : ");
      this.add(text1);
      text1.setBounds(150, 160, 450, 50);
      text1.setFont(new Font("Raleway", 1, 23));
      text1.setForeground(Color.DARK_GRAY);
      JLabel book_name = new JLabel(" Book Name  : ");
      this.add(book_name);
      book_name.setBounds(150, 200, 150, 40);
      book_name.setFont(new Font("Raleway", 1, 18));
      book_name.setForeground(Color.gray);
      this.Bookname = new JLabel();
      this.add(this.Bookname);
      this.Bookname.setFont(new Font("Raleway", 2, 16));
      this.Bookname.setBounds(300, 200, 200, 30);
      this.Bookname.setForeground(Color.black);
      JLabel book_author = new JLabel(" Book Author  : ");
      this.add(book_author);
      book_author.setBounds(150, 240, 150, 40);
      book_author.setFont(new Font("Raleway", 1, 18));
      book_author.setForeground(Color.gray);
      this.Bookauthor = new JLabel();
      this.add(this.Bookauthor);
      this.Bookauthor.setFont(new Font("Raleway", 1, 16));
      this.Bookauthor.setBounds(300, 240, 200, 30);
      this.Bookauthor.setFont(new Font("Arial", 2, 14));
      this.Bookauthor.setForeground(Color.black);
      JLabel book_price = new JLabel(" Book Price : ");
      this.add(book_price);
      book_price.setBounds(150, 280, 150, 40);
      book_price.setFont(new Font("Raleway", 1, 18));
      book_price.setForeground(Color.gray);
      this.Bookprice = new JLabel();
      this.add(this.Bookprice);
      this.Bookprice.setBounds(300, 280, 200, 30);
      this.Bookprice.setFont(new Font("Raleway", 2, 16));
      this.Bookprice.setFont(new Font("Arial", 0, 14));
      this.Bookprice.setForeground(Color.black);
      JLabel category = new JLabel(" Category  : ");
      this.add(category);
      category.setBounds(150, 320, 150, 40);
      category.setFont(new Font("Raleway", 1, 18));
      category.setForeground(Color.gray);
      this.Category = new JLabel();
      this.add(this.Category);
      this.Category.setFont(new Font("Raleway", 2, 16));
      this.Category.setBounds(300, 320, 200, 30);
      this.Category.setFont(new Font("Arial", 0, 14));
      this.Category.setForeground(Color.black);
      this.buy = new JButton("Buy Now");
      this.add(this.buy);
      this.buy.setBounds(150, 370, 150, 30);
      this.buy.setBackground(Color.GRAY);
      this.buy.addActionListener(this);
      this.feedback = new JButton("FeedBack");
      this.add(this.feedback);
      this.feedback.setBounds(350, 370, 150, 30);
      this.feedback.setBackground(Color.GRAY);
      this.feedback.addActionListener(this);
      this.logout = new JButton("Log-Out");
      this.add(this.logout);
      this.logout.setBounds(250, 410, 150, 30);
      this.logout.setBackground(Color.GRAY);
      this.logout.addActionListener(this);
   }

   public void actionPerformed(ActionEvent ae) {
      String search = this.search_book.getText();
      String namebook = " ";
      String id = " ";
      if (ae.getSource() == this.ser) {
         if (search.equals("")) {
            JOptionPane.showMessageDialog((Component)null, " Search a Book First ...");
         } else {
            Conn c = new Conn();

            try {
               ResultSet rs = c.s.executeQuery("select * from books where bookname =  '" + search + "'");
               if (rs.next()) {
                  String authorbook = rs.getString("book_author");
                  String pricebook = rs.getString("book_price");
                  String categorybook = rs.getString("category");
                  namebook = rs.getString("bookname");
                  this.Bookname.setText(namebook);
                  this.Bookauthor.setText(authorbook);
                  this.Bookprice.setText(pricebook);
                  this.Category.setText(categorybook);
               } else {
                  JOptionPane.showMessageDialog((Component)null, " Book Not Available");
               }
            } catch (Exception var10) {
               System.out.println(var10);
            }
         }
      }

      if (ae.getSource() == this.buy) {
         //this.setVisible(false);
         (new payment(id, namebook)).setVisible(true);
      }

      if (ae.getSource() == this.logout) {
         this.setVisible(false);
         (new Index_2()).setVisible(true);
      }

      if (ae.getSource() == this.feedback) {
         (new feedback()).setVisible(true);
      }

   }

   void setVisible() {
      throw new UnsupportedOperationException("Not supported yet.");
   }
}
