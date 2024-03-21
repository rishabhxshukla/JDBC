/*
1. Import
2. Load driver (Optional)
3. Establish connection
4. Create statement
5. Execute query
6. Process result
7. Close connection
*/

import java.sql.*;

class JDBC_Manipulate
{
    public static void main(String args[]) throws SQLException
    {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "My Sql12";

        String query = "INSERT INTO students VALUES(104, 'Jon Smith', 'Web Development');";
        //query = "UPDATE students SET name = 'Peter Smith' WHERE id = 104;";
        //query = "DELETE FROM students WHERE id = 104;";

        /*-------------------------------------------------------------------------------*/

        //Establishing connection
        Connection con = DriverManager.getConnection(url, username, password);

        //Creating a statement
        Statement st = con.createStatement();

        //Executing the query
        st.execute(query);
        System.out.println("Successful!");

        //Closing the connection
        con.close();
    }
}