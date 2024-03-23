import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
class Deleting{
    private static final String url="jdbc:mysql://localhost:3306/my_DB";
    private static final String username="root";
    private  static final String password="@Radhakrishna297";
    public void deletingData(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
            return;
        }
        try{
            Connection connection=DriverManager.getConnection(url,username,password);
            Statement statement=connection.createStatement();
            String query="Delete from Employee where id>=1";
            int Affected=statement.executeUpdate(query);
            if(Affected>0){
                System.out.println("Data Deleted Succesfully");
            }
            else{
                System.out.println("Data Not Deleted!");
            }

        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
public class Delete {
    public static void main(String[] args) {
        Deleting ob=new Deleting();
        ob.deletingData();
    }
}
