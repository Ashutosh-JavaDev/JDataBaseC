import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLDataException;
class DBase{
    private static final String url="jdbc:mysql://localhost:3306/?user=root";
    private static final String username="root";
    private  static final String password="@Radhakrishna297";
    public static void data(){
        try{
            class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
public class Insert {
    
}
