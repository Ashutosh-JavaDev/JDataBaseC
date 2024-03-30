import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.ResultSet;
import javax.naming.spi.DirStateFactory.Result;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import com.mysql.cj.jdbc.Driver;

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
                System.out.print("Department ID: ");
                int Dep = scanner.nextInt();
                System.out.print("Enter First name: ");
                String Fname = scanner.nextLine();
                System.out.println("Enter Last name");
                String Lname = scanner.nextLine();
                System.out.println("Enter Date of Birth 'YY-MM-DD'");
                String dobInput = scanner.nextLine(); // Read the input as a String
                // Define a DateTimeFormatter for parsing the input
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd");

                try {
                    LocalDate dob = LocalDate.parse(dobInput, formatter); // Parse the input into LocalDate
                    System.out.println("Date of Birth: " + dob);
                } catch (DateTimeParseException e) {
                    System.out.println("Invalid date format. Please enter the date in 'YY-MM-DD' format.");
                }
                System.out.print("Enter Gender ('M/F/T'): ");
                String gender = scanner.nextLine().toUpperCase();
                System.out.print("Email: ");
                String email = scanner.nextLine();
                System.out.print("Mobile Number: ");
                int phone = scanner.nextInt();
                System.out.print("City: ");
                String City = scanner.nextLine();
                System.out.print("Salary: ");
                int sal = scanner.nextInt();
                System.out.print("Designation: ");
                String Desi = scanner.nextLine();
                System.out.print("Employee Status\n('A'Active/'IN'InActive/'L'Leave): ");
                String Stat = scanner.nextLine().toUpperCase();
                String query = String.format(
                        "Insert into Employee(id,name,Degination) values(%d,%d,'%s','%s',yy-MM-dd,'%s','%s',%d,'%s','%s','%s','%s')",
                        id, Dep, Fname, Lname, dobInput, gender, email, phone, City, sal, Desi, Stat);
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

    public void Read() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement statement = conn.createStatement();
            String queue = "select*from Employee";
            ResultSet res = statement.executeQuery(queue);
            while (res.next()) {
                int id = res.getInt("id");
                String name = res.getString("name");
                String Desi = res.getString("Degination");
                System.out.print("|ID: " + id + " |Name: " + name + " |Degination: " + Desi + "|");
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Delete() {
        Scanner sc = new Scanner(System.in);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection connec = DriverManager.getConnection(url, username, password);
            Statement statement = connec.createStatement();
            System.out.println("Which Employee ID you want to Delete?");
            int empID = sc.nextInt();
            String Query = String.format("Delete from Employee where id=%o", empID);
            int AffectedRow = statement.executeUpdate(Query);
            if (AffectedRow > 0) {
                System.out.println("Data Deleted Succesfully");
            } else {
                System.out.println("Data Not Deleted");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Updateing() {
        Scanner sc = new Scanner(System.in);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            System.out.println("Press 1: To Update ID\nPress 2: To Update Name\nPress 3: To Update Designation");
            int press = sc.nextInt();
            switch (press) {
                case 1:
                    System.out.println("Which User Id, You want to Update?");
                    int oldId = sc.nextInt();
                    System.out.print("New ID Number: ");
                    int newID = sc.nextInt();
                    String query = String.format("Update Employee set id =%o where id=%o", newID, oldId);
                    int result = statement.executeUpdate(query);
                    if (result > 0) {
                        System.out.println("Data Updated Succesfully");
                    } else {
                        System.out.println("Data Not Inserted");
                    }
                    break;
                case 2:
                    System.out.println("Enter the User ID whose Name Want to Update");
                    int uID = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New Name: ");
                    String newName = sc.nextLine();
                    String level = String.format("Update Employee set name ='%s' where id=%o", newName, uID);
                    int affectedRow = statement.executeUpdate(level);
                    if (affectedRow > 0) {
                        System.out.println("Data Updated Succesfully");
                    } else {
                        System.out.println("Data Not Inserted");
                    }
                    break;
                case 3:
                    System.out.println("Enter the User ID whose Name Want to Update");
                    int usID = sc.nextInt();
                    sc.nextLine();

                    System.out.print("New Degination: ");
                    String newDesignation = sc.nextLine();
                    String low = String.format("Update Employee set Degination ='%s' where id=%o", newDesignation,
                            usID);
                    int Affected = statement.executeUpdate(low);
                    if (Affected > 0) {
                        System.out.println("Data Updated Succesfully");
                    } else {
                        System.out.println("Data Not Inserted");
                    }
                    break;
                default:
                    System.out.println("Invalid Press");
                    break;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void choose() {
        Scanner sc = new Scanner(System.in);
        Inserting();
        System.out.println("Press 1:To Read Data\nPress 2:To Update Data\nPress 3:To Delete Data");
        int press = sc.nextInt();
        switch (press) {
            case 1:
                Read();
                break;
            case 2:
                Updateing();
                break;
            case 3:
                Delete();
                break;
            default:
                System.out.println("Invaid Press");
                break;
        }
    }
}

public class CRUD {
    public static void main(String[] args) {
        crud ob = new crud();
        ob.choose();
    }
}
