import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
class Displaying{
    private static final String url="jdbc:mysql://localhost:3306/my_DB";
    private static final String username="root";
    private static final String password="@Radhakrishna297";
    public void disp(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
            return;
        }
        try{
            Connection conn=DriverManager.getConnection(url, username, password);
            Statement state=conn.createStatement();
            String query="select*from Employee";
            ResultSet result=state.executeQuery(query);
            while(result.next()){
                int id=result.getInt("id");
                String name=result.getString("username");
                String Deg=result.getString("Degination");
                System.out.println("ID: "+id);
                System.out.println("Name: "+name);
                System.out.println("Degination: "+Deg);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
public class Read {
    
}
