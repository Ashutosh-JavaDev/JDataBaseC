import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

class DBase {
    private static final String url = "jdbc:mysql://localhost:3306/my_DB";
    private static final String username = "root";
    private static final String password = "@Radhakrishna297";

    public void data() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return; // Exit the method if driver is not found
        }

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {
            String query = "INSERT INTO Employee(id,username, Degination) VALUES " +
                    "(1,'Ashutosh','FrontEnd Developer'), " +
                    "(2,'Ayush', 'Backend Developer'), " +
                    "(3,'Sahay', 'Full Stack Developer')";
            int affectedRows = statement.executeUpdate(query);
            System.out.println(affectedRows + " rows inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

public class Insert {
    public static void main(String[] args) {
        DBase db = new DBase();
        db.data();
    }
}
