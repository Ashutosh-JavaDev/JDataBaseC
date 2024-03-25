import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
class crud{
    private static final String url="jdbc:mysql://localhost:3306/my_DB";
    private static final String username="root";
    private  static final String password="@Radhakrishna297";
    public void curding(){
        try{
            Class.forName("com.mysql.cj.DriveManger");
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
public class CRUD {
    
}
