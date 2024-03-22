import java.sql.*;

class Dynamic_Insertion
{
    public static void main(String args[]) throws SQLException
    {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "My Sql12";

        String query = "INSERT INTO students VALUES(?, ?, ?);";

        /*-------------------------------------------------------------------------------*/

        //Establishing connection
        Connection con = DriverManager.getConnection(url, username, password);

        //Creating a statement
        Statement st = con.createStatement();

        //Adding dynamic values
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, 105);
        ps.setString(2, "Griffin");
        ps.setString(3, "CSE");

        //Executing the query
        ps.executeUpdate();
        System.out.println("Successful!");

        //Closing the connection
        con.close();
    }
}