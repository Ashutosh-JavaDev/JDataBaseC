import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class CreateDB {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String databaseName = "my_DB";
            String username = "root";
            String password = "@Radhakrishna297";
            
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            
            String sql = "CREATE DATABASE IF NOT EXISTS " + databaseName;
            statement.executeUpdate(sql);
            
            JOptionPane.showMessageDialog(null, "Your Database created successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
