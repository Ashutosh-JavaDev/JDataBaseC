import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

class crud {
    private static final String url = "jdbc:mysql://localhost:3306/my_DB";
    private static final String username = "root";
    private static final String password = "@Radhakrishna297";

    public void Inserting() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            Scanner scanner = new Scanner(System.in);

           
            while (true) {
                System.out.println("Enter employee ID (or type 'stop' to stop): ");
                String idInput = scanner.nextLine().trim();
                if (idInput.equalsIgnoreCase("stop")) {
                    break;
                }
                int id = Integer.parseInt(idInput);

                System.out.print("Enter employee name: ");
                String name = scanner.nextLine();

                System.out.print("Enter employee designation: ");
                String designation = scanner.nextLine();

                String query = String.format("Insert into Employee(id,name,Degination) values (%d,'%s','%s')", id, name, designation);
                int result = statement.executeUpdate(query);
                if (result > 0) {
                    System.out.println("Data Inserted Successfully");
                } else {
                    System.out.println("Data Not Inserted");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

public class CRUD {
    public static void main(String[] args) {
        crud ob = new crud();
        ob.Inserting();
    }
}
