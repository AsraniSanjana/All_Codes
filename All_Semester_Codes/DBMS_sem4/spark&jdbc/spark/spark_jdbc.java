package spark;

import java.sql.*;

public class spark_jdbc{
    public static void main(String[] args) {
        Connection con = null;
        int result;
        ResultSet rs = null;
        Statement stat = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel_ms", "root", "");
            stat = con.createStatement();
            result = stat.executeUpdate("INSERT INTO visitor"
                    + "(visit_no, VISITOR_ID, VISITOR_NAME, IN_TIME, OUT_TIME, VISIT_DATE, CUR_TIME, CUR_DATE, VISITING_STUD_ID)"
                    + "VALUES (3, V002, 'Ajinkya Phadtare', '09:00AM', '12:00PM', '2024-03-29', '09:30:00', '2024-03-29 23:34:30', HS02)");
            System.out.println("Values inserted in table");
            // rs = stat.executeQuery("Select * from banktable");
            // while(rs.next()){
            // System.out.println("AccountNo: "+rs.getInt(1));
            // System.out.println("Balance: "+rs.getString(2));
            // System.out.println("CustomerName: "+rs.getString(3));
            // System.out.println("Phone: "+rs.getString(4));
            // System.out.println("Address: "+rs.getString(5));
            // System.out.println();
            // }
            rs = null;
            /*
             * result = stat.executeUpdate("DELETE FROM banktable WHERE AccountNo=88");
             * System.out.println("Values deleted from table!");
             * result =
             * stat.executeUpdate("UPDATE banktable set AccountNo=100 WHERE AccountNo=55");
             * System.out.
             * println("Values updated from table and updated record is as follows....!");
             * rs = stat.executeQuery("SELECT * from banktable ");
             * while (rs.next()) {
             * System.out.println("AccountNo: " + rs.getInt(1));
             * System.out.println("Balance: " + rs.getString(2));
             * System.out.println("CustomerName: " + rs.getString(3));
             * System.out.println("Phone: " + rs.getString(4));
             * System.out.println("Address: " + rs.getString(5));
             * System.out.println();
             * }
             */
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}