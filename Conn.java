
package book.store;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
   Connection c;
   Statement s;

   public Conn() {
      try {
         this.c = DriverManager.getConnection("jdbc:mysql:///Book_Store", "root", "V@ishnavi09");
         this.s = this.c.createStatement();
      } catch (Exception var2) {
         System.out.println(var2);
      }

   }
}
    
