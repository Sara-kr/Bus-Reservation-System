import java.sql.*;

public class DBconnection {
    private static final String url = "jdbc:mysql://localhost:3306/busresv";
    private static final String userName = "root";
    private static final String passWord = "2003";

   public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,userName,passWord);
    }
}
