package fr.epita.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDBConnection {

     public static void test() throws SQLException {
         System.out.println("TestDBConnection");
         Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/EPITAexamdb", "postgres","03545259");

         String createTableQuery = "CREATE TABLE IF NOT EXISTS STUDENTS( id varchar(30), name varchar(255))";

         connection.prepareStatement(createTableQuery).execute();

         String insertQuery = "INSERT INTO STUDENTS(id, name) values ('Charbel Tabet', '001')";

         connection.prepareStatement(insertQuery).execute();
         connection.close();
     }

}
