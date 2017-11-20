/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

/**
 *
 * @author Jamil
 */
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
public class DataAccess{
    Connection conn;
    // JDBC driver name and database URL
    String JDBC_DRIVER;  
    String DB_URL;
    Statement stmt;
   //  Database credentials
    String USER;
    String PASS;
    ResultSet rs;
    public DataAccess(){
        JDBC_DRIVER = "com.mysql.jdbc.Driver";
        DB_URL = "jdbc:mysql://localhost:3306/hello2";
        //  Database credentials
        USER = "root";
        PASS = "";
        try{
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);
            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public void close()throws SQLException
    {
        if(rs!=null)rs.close();
        if(rs!=null)stmt.close();
        //conn.close();
    }
    public ResultSet getData(String query) {
        try{
            stmt = conn.createStatement();
            rs= stmt.executeQuery(query);
            System.out.println("Info from DB");
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return rs;
   }
    public int loadDB(String sql){
        int numOfRowsUpdated=0;
        try{
            stmt = conn.createStatement();
            numOfRowsUpdated=stmt.executeUpdate(sql);
            System.out.println(numOfRowsUpdated+" row(s) inserted");
            //stmt.close();
            //conn.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return numOfRowsUpdated;
    }
    public int updateDB(String sql){
        int numOfRowsUpdated=0;
        try{
            stmt = conn.createStatement(); 
            numOfRowsUpdated=stmt.executeUpdate(sql);
            System.out.println(numOfRowsUpdated+" row(s) updated");
            //stmt.close();
            //conn.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return numOfRowsUpdated;
    }
    
   
    
    
}//end main



//public class betaTest {
//    public static void main(String[] args)throws SQLException
//    {
//        // TODO code application logic here
//        DataAccess da=new DataAccess();
//        ResultSet rs=null;
//        
//        rs=da.getData("select * from student");
//        while(rs.next()){
//            int age = rs.getInt("sid");
//            String first = rs.getString("sname");
//            //String last = rs.getString("lastname");
//            System.out.println("id : "+age);
//        }
//        da.close();
//        
//        /*int c=da.loadDB("insert into student values('bob','alex','60')");
//        da.close();*/
//        
////        int c=da.updateDB("update student set firstname='bob2' where age=23");
////        da.close();
//        //System.out.println(rs.toString());
//    }
//}
