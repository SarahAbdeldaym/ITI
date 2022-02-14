import java.sql.*;
import java.util.*;


public class SqlApp{

       public static void main(String[] args) {
     
        new SqlApp();
    /*
        int choice;
     choice = new Scanner(System.in);
        System.out.println("please enter your choise:");
        System.out.println("1/insert student");
        System.out.println("2/view all students");
        System.out.println("3/delete student");
        System.out.println("4/update student");
     switch(choice){
         case 1:
         addquery(c);
         break;
         case2:
         selectquery(con);
         break;
         case 3:
         deleteQuery(con);
         break;
         case 4:
         updateQuery(con);
         break;

     }
     con.close();
    */}


     public SqlApp(){
       try {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/grades", "root", "root");
    
        con.setAutoCommit(false);
       
       //original data
        System.out.println("original data");
        selectquery(con);
        
        deleteQuery(con);
        System.out.println("\n data after deleting :");
        selectquery(con);

        addquery(con);
        System.out.println("\n data after adding :");
        selectquery(con);
        
        updateQuery(con);
        System.out.println("\n data after updating :");
        selectquery(con);
        con.close();
       } catch (Exception e) {
           e.printStackTrace();
       }

     }

    public static void addquery (Connection c){
        
    try {
        PreparedStatement pst = c.prepareStatement("insert into students (student_id, first_name, last_name) values(?,?,?)");
        pst.setInt(1,13);
        pst.setString(2,"sarah");
        pst.setString(3,"abdelDaym");
        pst.addBatch();
        pst.executeBatch();
        c.commit();
        pst.close();

        
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    }

    public static void selectquery (Connection con){
        //PreparedStatement pst = c.prepareStatement("select * from students");
        try {
        Statement stmt = con.createStatement() ;
        String queryString = new String("select * from students");
        ResultSet rs = stmt.executeQuery(queryString) ;
        while(rs.next())
        {
        System.out.println(rs.getString(1) + " "+rs.getString(2)+" "+rs.getString(3));
        }
        stmt.close();   
        }
     catch (SQLException ex) {
        ex.printStackTrace();
    }
            }

    public static void deleteQuery(Connection con){
        try {
            PreparedStatement pst = con.prepareStatement("DELETE FROM students WHERE student_id=?");
            pst.setInt(1, 13);
            
            int rowsDeleted = pst.executeUpdate();
                    if (rowsDeleted > 0) {
                        System.out.println("\n A user was deleted successfully!");
                    }
            con.commit();     
            pst.close(); 
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }

    public static void updateQuery (Connection con){
        try {
            PreparedStatement pst = con.prepareStatement("UPDATE students SET student_id=?, first_name =? WHERE student_id=?;");
            pst.setInt(1, 15);
            pst.setString(2, "youssef");
            pst.setInt(3, 14);
            
            int updateRows=pst.executeUpdate();
            if(updateRows>0){
                System.out.println("\n Updated well ");
            }
            con.commit();
            pst.close(); 
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
    }
}



