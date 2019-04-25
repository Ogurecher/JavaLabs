import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTest {
    public static void main (String[] args) {
        Connection conn = null;

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/JavaTunesDB", "GUEST", "a");
            DatabaseMetaData dbmd = conn.getMetaData();
            System.out.println("Task 1:\n" + dbmd.getDriverName() + "\n" + dbmd.getUserName());
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
