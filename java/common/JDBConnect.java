package common;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletContext;
public class JDBConnect {

    public Connection con;
    public Statement stmt;
    public PreparedStatement psmt;
    public ResultSet rs;
    public JDBConnect(ServletContext application){
        try {
            //web.xml use <tag>
            String driver=application.getInitParameter("db.driver");
            Class.forName(driver);

            String url=application.getInitParameter("db.url");
            String id=application.getInitParameter("db.username");
            String pwd=application.getInitParameter("db.password");
            con=DriverManager.getConnection(url,id,pwd);

        } catch (java.lang.Exception e) {
//            throw new RuntimeException(e);
            e.printStackTrace();
        }
    }

    public void close(){
        try {
            if (rs != null) rs.close();
            if (stmt !=null) stmt.close();
            if (psmt !=null) psmt.close();
            if (con !=null) con.close();
            System.out.println("jdbc close");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}