import java.io.File;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.*;

public class CreateUser {
    public static void main(String[] args) {
        for (String mydata : args) {
            Pattern fnPattern = Pattern.compile("-fn='(.*?)'");
            Pattern lnPattern = Pattern.compile("-ln='(.*?)'");
            Pattern unPattern = Pattern.compile("-un='(.*?)'");

            Matcher fnMatcher = fnPattern.matcher(mydata);
            Matcher lnMatcher = lnPattern.matcher(mydata);
            Matcher unMatcher = unPattern.matcher(mydata);

            if (fnMatcher.find() && lnMatcher.find() && unMatcher.find()) {
                String firstname = fnMatcher.group(1);
                String lastname = lnMatcher.group(1);
                String username = unMatcher.group(1);

                static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
                static final String DB_URL = "jdbc:mysql://localhost/jdbc";

                //  Database credentials
                static final String USER = "root";
                static final String PASS = "1234";

                public static void main(String[] args) {
                    Connection conn = null;
                    Statement stmt = null;
                    try {

                        Class.forName("com.mysql.jdbc.Driver");

                        System.out.println("Connecting to a selected database...");
                        conn = DriverManager.getConnection(DB_URL, USER, PASS);
                        System.out.println("Connected database successfully...");

                        //STEP 4: Execute a query
                        System.out.println("Creating statement...");
                        stmt = conn.createStatement();

                        String sql = "insert into jdbc.users (fn, ln, un) values (%s, %s, %s)", firstname, lastname, username;
                        ResultSet rs = stmt.executeQuery(sql);


                        rs.close();
                    }catch(SQLException se){
                        //Handle errors for JDBC
                        se.printStackTrace();
                    }catch(Exception e){
                        //Handle errors for Class.forName
                        e.printStackTrace();
                    }finally{
                        //finally block used to close resources
                        try{
                            if(stmt!=null)
                                conn.close();
                        }catch(SQLException se){
                        }// do nothing
                        try{
                            if(conn!=null)
                                conn.close();
                        }catch(SQLException se){
                            se.printStackTrace();
                        }//end finally try
                    }//end try
                    System.out.println("Goodbye!");
            }

            } catch (Exception ignored) {
            }
        }
    }
}
//insert into users (id, fn, ln, un) values (1, 'Alex', 'Filippov', 'alexfilippov')