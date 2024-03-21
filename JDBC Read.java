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

class JDBC_Read
{
    public static void main(String args[]) throws SQLException
    {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "My Sql12";

        String query = "SELECT * FROM students;";

        /*-------------------------------------------------------------------------------*/

        //Establishing connection
        Connection con = DriverManager.getConnection(url, username, password);

        //Creating a statement
        Statement st = con.createStatement();

        //Executing the query
        ResultSet rs = st.executeQuery(query);

        //Processing the result
        while (rs.next())
        {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String course = rs.getString("course");

            System.out.println(id +" : "+ name +" -> "+ course);
        }

        //Closing the connection
        con.close();
    }
}