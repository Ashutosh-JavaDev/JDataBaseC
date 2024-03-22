import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
class DBase{
    private static final String url="jdbc:mysql://localhost:3306/my_DB";
    private static final String username="root";
    private  static final String password="@Radhakrishna297";
    public void data(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
            return;
        }
        try{
            Connection connection=DriverManager.getConnection(url, username, password);
            Statement statement=connection.createStatement();
            String query=String.format("Insert into student(name,age,marks)values('%s',%o,'%s')","Ashutosh",21,89);
            int Affectedrow=statement.executeUpdate(query);
            if(Affectedrow>0){
                System.out.println("Data Inserted Succesfully");
            }
            else{
                System.out.println("Data NNot Inserted");
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
public class Insert {
    public static void main(String[] args) {
        DBase ob=new DBase();
        ob.data();
    }
}
