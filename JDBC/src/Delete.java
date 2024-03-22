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
        }
        try{
            Connection connection=DriverManager.getConnection(url,username,password);
            
        }
    }
}
public class Delete {
    
}
