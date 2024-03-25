import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.ResultSet;
import javax.naming.spi.DirStateFactory.Result;

import com.mysql.cj.jdbc.Driver;

class crud {
    private static final String url = "jdbc:mysql://localhost:3306/my_DB";
    private static final String username = "root";
    private static final String password = "@Radhakrishna297";

    // public void Inserting() {
    // try {
    // Class.forName("com.mysql.cj.jdbc.Driver");
    // } catch (ClassNotFoundException e) {
    // e.printStackTrace();
    // }
    // try {
    // Connection connection = DriverManager.getConnection(url, username, password);
    // Statement statement = connection.createStatement();
    // Scanner scanner = new Scanner(System.in);

    // while (true) {
    // System.out.println("Enter employee ID (or type 'stop' to stop): ");
    // String idInput = scanner.nextLine().trim();
    // if (idInput.equalsIgnoreCase("stop")) {
    // break;
    // }
    // int id = Integer.parseInt(idInput);

    // System.out.print("Enter employee name: ");
    // String name = scanner.nextLine();

    // System.out.print("Enter employee designation: ");
    // String designation = scanner.nextLine();

    // String query = String.format("Insert into Employee(id,name,Degination) values
    // (%d,'%s','%s')", id, name,
    // designation);
    // int result = statement.executeUpdate(query);
    // if (result > 0) {
    // System.out.println("Data Inserted Successfully");
    // } else {
    // System.out.println("Data Not Inserted");
    // }
    // }

    // } catch (SQLException e) {
    // e.printStackTrace();
    // }
    // }
    public void excep() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try{
            Connection conn=DriverManager.getConnection(url, username, password);
            Statement statement=conn.createStatement();
            String queue="select*from Employee";
            ResultSet res=statement.executeQuery(queue);
            while(res.next()){
                int id=res.getInt("id");
                String name=res.getString("name");
                String Desi=res.getString("Degination");
                System.out.print("|ID: "+id+" |Name: "+name+" |Degination: "+Desi+"|");
                System.out.println();
            }
        }
        catch(SQLException e){
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

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

public class CRUD {
    public static void main(String[] args) {
        crud ob = new crud();
        ob.Updateing();
    }
}
