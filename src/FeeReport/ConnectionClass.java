package FeeReport;

import java.sql.*;

public class ConnectionClass {
    Connection conn;
    PreparedStatement stmt;
    ConnectionClass() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
              conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fee", "root", "root");
            stmt = conn.prepareStatement("select * from admin");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
//                System.out.println( rs.getString(1) + "," + rs.getString(2));
                System.out.println();
            }


        } catch (Exception e) {
            System.out.println(e);

        }
    }


        public static void main (String[]args){
            new ConnectionClass();
        }
    }

