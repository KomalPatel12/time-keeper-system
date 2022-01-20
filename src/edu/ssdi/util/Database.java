/****************************Author : Akanksha Gupta ****************************************/
package edu.ssdi.util;
import java.sql.Connection;
import java.sql.DriverManager;
public class Database {
      public static Connection getConnection() {
          try  {
              Class.forName("com.mysql.jdbc.Driver");
              Connection con = DriverManager.getConnection
            		  /*Add databse connection user name and paasword for mysql */
                //      ("jdbc:mysql://localhost:3306/timekeepersystem", "admin","ssdi");
              ("jdbc:mysql://localhost:3306/timekeepersystem", "root","Welcome123");
              return con;
          }
          catch(Exception ex) {
              System.out.println("Database.getConnection() Error -->" + ex.getMessage());
              return null;
          }
      }
 
       public static void close(Connection con) {
          try  {
              con.close();
          }
          catch(Exception ex) {
          }
      }
}