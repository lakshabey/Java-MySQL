import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class connect {


    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String URL = "jdbc:mysql://localhost:3306/mtc?useTimezone=true&serverTimezone=UTC";

    public static Connection connectme(){
        Connection connec = null;
/**
 * How try and catch used here
 */
        try {
            connec = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Database Error");
        }

        return connec;
    }
}
