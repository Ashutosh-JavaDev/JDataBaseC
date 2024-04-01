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
                    break; // Exit loop if user enters 'stop'
                }

                int id = Integer.parseInt(idInput);

                System.out.print("Department ID: ");
                int departmentId = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character after reading an integer

                System.out.print("Enter First name: ");
                String firstName = scanner.nextLine();

                try {
                    if (firstName.equals(" ")) {
                        System.out.println("Enter Valid Name");
                        firstName = scanner.nextLine();
                    } else {
                        System.out.println("First Name: " + firstName);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.print("Enter Last name: ");
                String lastName = scanner.nextLine();

                try {

                    if (lastName.equals(" ")) {
                        System.out.println("Enter Valid Name");
                        lastName = scanner.nextLine();
                    } else {
                        System.out.println("Last Name: " + lastName);

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                System.out.println("Enter Date of Birth 'YYYY-MM-DD'");
                String dobInput = scanner.nextLine(); // Read the input as a String

                // Define a DateTimeFormatter for parsing the input
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

                try {
                    LocalDate dob = LocalDate.parse(dobInput, formatter); // Parse the input into LocalDate
                    System.out.println("Date of Birth: " + dob);
                } catch (DateTimeParseException e) {
                    System.out.println("Invalid date format. Please enter the date in 'YYYY-MM-DD' format.");
                    continue; // Continue to the next iteration of the loop
                }

                System.out.print("Enter Gender ('M/F/T'): ");
                String gender = scanner.nextLine().toUpperCase();

                System.out.print("Email: ");
                String email = scanner.nextLine();

                System.out.print("Mobile Number: ");
                String phone = scanner.nextLine();

                System.out.print("City: ");
                String city = scanner.nextLine();

                System.out.print("Salary: ");
                String salary = scanner.nextLine();

                System.out.print("Designation: ");
                String designation = scanner.nextLine();

                System.out.print("Employee Status\n('A'Active/'IN'InActive/'L'Leave): ");
                String status = scanner.nextLine().toUpperCase();

                // Prepare the SQL query
                String query = String.format(
                        "INSERT INTO Employee(Emp_ID, First_Name, Last_Name, DOB, Gender, Email, Mob_Number, City, Dep_ID, Salary, Designation, Emp_Status) "
                                +
                                "VALUES(%d, '%s', '%s', '%s', '%s', '%s', '%s', '%s', %d, '%s', '%s', '%s')",
                        id, firstName, lastName, dobInput, gender, email, phone, city, departmentId, salary,
                        designation, status);

                // Execute the query
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
                int id = res.getInt("Emp_ID");
                int DepID = res.getInt("Dep_ID");
                String First_Name = res.getString("First_Name");
                String Last_Name = res.getString("Last_Name");
                String DOB = res.getString("DOB");
                String Gender = res.getString("Gender");
                String Mob = res.getString("Mob_Number");
                String City = res.getString("City");
                int sal = res.getInt("Salary");
                String Desi = res.getString("Designation");
                String status = res.getString("Emp_Status");
                System.out.print("ID: " + id + "\nDep ID: " + DepID + "\nFirst Name: " + First_Name + "\nLast Name: "
                        + Last_Name + "\nDOB:  " + DOB + "\nGender: " + Gender + "\nMob: " + Mob + "\nCity: " + City
                        + "\nSalary:  " + sal + "\nDesigniation:  " + Desi + "\nEmployee Status: " + status);
                System.out.println();
                System.out.println(
                        "\nNew Employee------------------------------------------------------------------------------------------------------------------------------------------------------------");
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
            String Query = String.format("Delete from Employee where Emp_ID=%d", empID);
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
            System.out.println(
                    "Press 1: To Update Emp ID\nPress 2: To Update First Name\nPress 3: To Update Last Name\nPress 4: To Update DOB\nPress 5: To Update Gender\nPress 6: To Update Email ID\nPress 7: To Update Mobile Number\nPress 8: To Update City\nPress 9: To Update Dep_ID\nPress 10: To Update Salary\nPress 11: To Update Designation\nPress 12: To Update Employee Status");
            int press = sc.nextInt();
            switch (press) {
                case 1:
                    System.out.println("Which EMployee ID, You want to Update?");
                    int oldId = sc.nextInt();
                    System.out.print("New ID Number: ");
                    int newID = sc.nextInt();
                    String query = String.format("Update Employee set Emp_ID =%d where Emp_ID=%d", newID, oldId);
                    int result = statement.executeUpdate(query);
                    if (result > 0) {
                        System.out.println("Data Updated Succesfully");
                    } else {
                        System.out.println("Data Not Inserted");
                    }
                    break;
                case 2:
                    System.out.println("Enter the Emp ID whose First Name Want to Update");
                    int uID = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New First Name: ");
                    String newName = sc.nextLine();
                    String level = String.format("Update Employee set First_Name='%s' where Emp_ID=%d", newName, uID);
                    int affectedRow = statement.executeUpdate(level);
                    if (affectedRow > 0) {
                        System.out.println("Data Updated Succesfully");
                    } else {
                        System.out.println("Data Not Inserted");
                    }
                    break;
                case 3:
                    System.out.println("Enter the Emp ID whose Last Name Want to Update");
                    int usID = sc.nextInt();
                    sc.nextLine();

                    System.out.print("New Last Name: ");
                    String newLast = sc.nextLine();
                    String low = String.format("Update Employee set Last_Name ='%s' where Emp_ID=%d", newLast,
                            usID);
                    int Affected = statement.executeUpdate(low);
                    if (Affected > 0) {
                        dataupdate();
                    } else {
                        dataNotUpdate();
                    }
                    break;
                case 4:
                    System.out.println("Enter the Emp ID to Update DOB");
                    int upDOB = sc.nextInt();
                    sc.nextLine(); // Consume the newline character

                    while (true) {
                        System.out.println("Enter New Date of Birth 'YYYY-MM-DD'");
                        String dobInput = sc.nextLine(); // Read the input as a String

                        // Define a DateTimeFormatter for parsing the input
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

                        try {
                            LocalDate dob = LocalDate.parse(dobInput, formatter); // Parse the input into LocalDate
                            System.out.println("Date of Birth: " + dob);
                            String dateofBirth = String.format("Update Employee set DOB='%s' where Emp_ID=%d", dob,
                                    upDOB);
                            int local = statement.executeUpdate(dateofBirth);
                            if (local > 0) {
                                dataupdate();
                            } else {
                                dataNotUpdate();
                            }
                            break;
                        } catch (DateTimeParseException e) {
                            System.out.println("Invalid date format. Please enter the date in 'YYYY-MM-DD' format.");
                            continue; // Continue to the next iteration of the loop
                        }

                    }
                    break;

                case 5:
                    System.out.print("Enter the Emp ID whose Gender wannt to Update: ");
                    int gender = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New gender: 'M'/'F'/'T': ");
                    String newGender = sc.nextLine().toUpperCase();
                    String gen = String.format("Update Employee set Gender='%s' where Emp_ID=%d", newGender, gender);
                    int gendernew = statement.executeUpdate(gen);
                    if (gendernew > 0) {
                        dataupdate();
                    } else {
                        dataNotUpdate();
                    }

                    break;
                case 6:
                    System.out.println("Enter the Emp ID whose Email want to Update");
                    int email = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New Email: ");
                    String newEmail = sc.nextLine();
                    String emailNew = String.format("Update Employee set Email='%s' where Emp_ID=%d", newEmail, email);
                    int emailId = statement.executeUpdate(emailNew);
                    if (emailId > 0) {
                        dataupdate();
                    } else {
                        dataNotUpdate();
                    }
                    break;
                    // 7
                    case 7:
                    System.out.println("Enter the Emp ID whose Mobile Number want to Update");
                    int mob = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New Mobile Number: ");
                    String Mobile = sc.nextLine();
                    String mobNew = String.format("Update Employee set Mob_Number='%s' where Emp_ID=%d", Mobile, mob);
                    int moblieNew = statement.executeUpdate(mobNew);
                    if (moblieNew > 0) {
                        dataupdate();
                    } else {
                        dataNotUpdate();
                    }
                    break;
                    // 8
                    case 8:
                    System.out.println("Enter the Emp ID whose City want to Update");
                    int city = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New City: ");
                    String newCity = sc.nextLine();
                    String cityNew = String.format("Update Employee set City='%s' where Emp_ID=%d", newCity, city);
                    int citynew = statement.executeUpdate(cityNew);
                    if (citynew > 0) {
                        dataupdate();
                    } else {
                        dataNotUpdate();
                    }
                    break;
                    // 9
                    case 9:
                    System.out.println("Enter the Emp ID whose Department ID want to Update");
                    int DepID = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New Email: ");
                    int Depid = sc.nextInt();
                    String depId = String.format("Update Employee set Dep_ID=%d where Emp_ID=%d", Depid, DepID);
                    int newDep = statement.executeUpdate(depId);
                    if (newDep > 0) {
                        dataupdate();
                    } else {
                        dataNotUpdate();
                    }
                    break;
                    // 10
                    case 10:
                    System.out.println("Enter the Emp ID whose Salary want to Update");
                    int sal = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New Salary: ");
                    int newSal = sc.nextInt();
                    String SalNew = String.format("Update Employee set Salary=%d where Emp_ID=%d", newSal, sal);
                    int salaryNew = statement.executeUpdate(SalNew);
                    if (salaryNew > 0) {
                        dataupdate();
                    } else {
                        dataNotUpdate();
                    }
                    break;
                    // 11
                    case 11:
                    System.out.println("Enter the Emp ID whose Designation want to Update");
                    int desi = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New Designation: ");
                    String newDesi = sc.nextLine();
                    String DesiNew = String.format("Update Employee set Designation='%s' where Emp_ID=%d", newDesi, desi);
                    int Desinew = statement.executeUpdate(DesiNew);
                    if (Desinew > 0) {
                        dataupdate();
                    } else {
                        dataNotUpdate();
                    }
                    break;
                    // 12
                    case 12:
                    System.out.println("Enter the Emp ID whose Status want to Update");
                    int Stat = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New Employee Status: ");
                    String newStatus = sc.nextLine();
                    String StatusNew = String.format("Update Employee set Emp_Status='%s' where Emp_ID=%d", newStatus, Stat);
                    int newStat = statement.executeUpdate(StatusNew);
                    if (newStat > 0) {
                        dataupdate();
                    } else {
                        dataNotUpdate();
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

    public void dataupdate() {
        System.out.println("Data Updated Succesfully");
    }

    public void dataNotUpdate() {
        System.out.println("Data Not Updated");
    }

    public void choose() {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("Choose the Command You want to excute");
        System.out.println(
                "Press 0: To Insert Data\nPress 1:To Read Data\nPress 2:To Update Data\nPress 3:To Delete Data");
        int press = sc.nextInt();
        switch (press) {
            case 0:
                Inserting();
                break;
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
