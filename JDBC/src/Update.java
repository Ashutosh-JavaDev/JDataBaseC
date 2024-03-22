import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
class Updating{
    private static final String url="jdbc:mysql://localhost:3306/my_DB";
    private static final String username="root";
    private static final String password="@Radhakrishna297"; 
    public void UpdatingData(){
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
            String query=String.format("Update Employee set username =Sanatani where id=3");
            int Affectedrow=statement.executeUpdate(query);
            if(Affectedrow>0){
                System.out.println("Data Updated Successfully!");
            }
            else{
                System.out.println("Data Not Updated!");
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
public class Update {
    
}
