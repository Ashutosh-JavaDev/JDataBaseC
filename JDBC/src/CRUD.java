import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

class crud {
    private static final String url = "jdbc:mysql://localhost:3306/my_DB";
    private static final String username = "root";
    private static final String password = "@Radhakrishna297";

    public void Inserting() {
        try {
            Class.forName("com.mysql.cj.DriveManger");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String query = "Insert into Employee(id,name,Degination)values" + ("4,Aman,IT") + ("5,Ritika,Web Designer")
                    + ("6,Akash,UI/UX") + ("7,Prachi,Software Developer");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

public class CRUD {

}
