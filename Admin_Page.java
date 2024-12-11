
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

public class Admin_Page extends JFrame implements ActionListener {
   private JTextField Bookname;
   private JTextField Bookid;
   private JTextField Bookauthor;
   private JTextField Bookprice;
   private JComboBox Category;
   private JTextField quantity;
   JButton add_book;
   JButton del_book;
   JButton back;
   JButton exit;
   String id;

   public static void main(String[] args) {
      new Admin_Page("");
   }

   public Admin_Page(String id) {
      this.setSize(680, 570);
      this.setLocation(150, 20);
      this.setLayout((LayoutManager)null);
      this.setVisible(true);
      JLabel text = new JLabel(" BOOKS DETAILS ");
      this.add(text);
      text.setBounds(215, 30, 450, 70);
      text.setFont(new Font("Raleway", 1, 29));
      text.setForeground(Color.orange);
      JLabel book_name = new JLabel(" Book Name  : ");
      this.add(book_name);
      book_name.setBounds(150, 120, 150, 40);
      book_name.setFont(new Font("Raleway", 1, 18));
      book_name.setForeground(Color.gray);
      this.Bookname = new JTextField();
      this.add(this.Bookname);
      this.Bookname.setBounds(300, 120, 200, 30);
      this.Bookname.setFont(new Font("Arial", 0, 14));
      this.Bookname.setForeground(Color.black);
      JLabel book_id = new JLabel(" Book ID : ");
      this.add(book_id);
      book_id.setBounds(150, 170, 150, 40);
      book_id.setFont(new Font("Raleway", 1, 18));
      book_id.setForeground(Color.gray);
      this.Bookid = new JTextField();
      this.add(this.Bookid);
      this.Bookid.setBounds(300, 170, 200, 30);
      this.Bookid.setFont(new Font("Arial", 0, 14));
      this.Bookid.setForeground(Color.black);
      JLabel book_author = new JLabel(" Book Author  : ");
      this.add(book_author);
      book_author.setBounds(150, 220, 150, 40);
      book_author.setFont(new Font("Raleway", 1, 18));
      book_author.setForeground(Color.gray);
      this.Bookauthor = new JTextField();
      this.add(this.Bookauthor);
      this.Bookauthor.setBounds(300, 220, 200, 30);
      this.Bookauthor.setFont(new Font("Arial", 0, 14));
      this.Bookauthor.setForeground(Color.black);
      JLabel book_price = new JLabel(" Book Price : ");
      this.add(book_price);
      book_price.setBounds(150, 270, 150, 40);
      book_price.setFont(new Font("Raleway", 1, 18));
      book_price.setForeground(Color.gray);
      this.Bookprice = new JTextField();
      this.add(this.Bookprice);
      this.Bookprice.setBounds(300, 270, 200, 30);
      this.Bookprice.setFont(new Font("Arial", 0, 14));
      this.Bookprice.setForeground(Color.black);
      JLabel category = new JLabel(" Category  : ");
      this.add(category);
      category.setBounds(150, 320, 150, 40);
      category.setFont(new Font("Raleway", 1, 18));
      category.setForeground(Color.gray);
      String[] rel_name = new String[]{"Motivational Book", "Horror Book", "Comic Book", "Love Book", "Educational Book", "Devotional Book", "Crime Book", "Inspirational Book"};
      this.Category = new JComboBox(rel_name);
      this.Category.setBounds(300, 320, 200, 30);
      this.Category.setFont(new Font("Arial", 0, 14));
      this.add(this.Category);
      this.Category.setBackground(Color.WHITE);
      this.Category.setForeground(Color.black);
      JLabel quan = new JLabel(" Quantity  : ");
      this.add(quan);
      quan.setBounds(150, 370, 150, 40);
      quan.setFont(new Font("Raleway", 1, 18));
      quan.setForeground(Color.gray);
      this.quantity = new JTextField();
      this.add(this.quantity);
      this.quantity.setBounds(300, 370, 200, 30);
      this.quantity.setFont(new Font("Arial", 0, 14));
      this.quantity.setForeground(Color.black);
      this.del_book = new JButton("DELETE BOOK");
      this.add(this.del_book);
      this.del_book.setBounds(350, 430, 150, 30);
      this.del_book.setBackground(Color.GRAY);
      this.del_book.addActionListener(this);
      this.add_book = new JButton("ADD BOOK");
      this.add(this.add_book);
      this.add_book.setBounds(150, 430, 150, 30);
      this.add_book.setBackground(Color.GRAY);
      this.add_book.addActionListener(this);
      this.back = new JButton("Back");
      this.add(this.back);
      this.back.setBounds(150, 480, 150, 30);
      this.back.setBackground(Color.GRAY);
      this.back.addActionListener(this);
      this.exit = new JButton("Exit");
      this.add(this.exit);
      this.exit.setBounds(350, 480, 150, 30);
      this.exit.setBackground(Color.GRAY);
      this.exit.addActionListener(this);
   }

   public void actionPerformed(ActionEvent ae) {
      String bookname = this.Bookname.getText();
      String book_id = this.Bookid.getText();
      String book_author = this.Bookauthor.getText();
      String book_price = this.Bookprice.getText();
      String category = (String)this.Category.getSelectedItem();
      String Quantity = this.quantity.getText();
      String seller = "";

      Conn c;
      try {
         c = new Conn();
         ResultSet rs = c.s.executeQuery("select * from signup_admin where name =  '" + bookname + "'");
         if (rs.next()) {
            seller = rs.getString("name");
         }

         String query = "insert into totalbooks values ('" + this.id + "','" + seller + "','" + book_price + "','" + bookname + "','" + Quantity + "','" + book_author + "','" + category + " ')";
         c.s.executeUpdate(query);
      } catch (Exception var13) {
         System.out.println(var13);
      }

      String query;
      if (ae.getSource() == this.del_book) {
         if (bookname.equals("")) {
            JOptionPane.showMessageDialog((Component)null, " ADD a Book ");
         } else {
            new Conn();
            query = " DELETE FROM books WHERE book_name = '" + bookname + " ' ";
            JOptionPane.showMessageDialog((Component)null, " Book Deleted ");
         }
      }

      if (ae.getSource() == this.add_book) {
         try {
            if (bookname.equals("")) {
               JOptionPane.showMessageDialog((Component)null, " ADD a Book ");
            } else if (book_price.equals("")) {
               JOptionPane.showMessageDialog((Component)null, " ADD Book Price ");
            } else {
               c = new Conn();
               query = "insert into books values ('" + bookname + "','" + book_id + "','" + book_author + "','" + book_price + "','" + category + "','" + Quantity + " ')";
               c.s.executeUpdate(query);
               JOptionPane.showMessageDialog((Component)null, " Book Added ");
            }
         } catch (Exception var12) {
            System.out.println(var12);
         }
      }

      if (ae.getSource() == this.exit) {
         this.setVisible(false);
      }

      if (ae.getSource() == this.back) {
         this.setVisible(false);
         (new Index_2()).setVisible(true);
      }

   }
}
