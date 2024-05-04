import java.sql.*;

class DynamicInsertion
{
    public static void main(String args[]) throws SQLException
    {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "My Sql12";

        String query = "INSERT INTO Students VALUE (?, ?, ?);";
        //query = "UPDATE Students SET name = ? WHERE id = ?;";
        //query = "DELETE FROM Students WHERE id = ?;";

        /*-------------------------------------------------------------------------------*/

        //Establishing connection
        Connection con = DriverManager.getConnection(url, username, password);

        //Creating a statement
        PreparedStatement ps = con.prepareStatement(query);

        //Adding dynamic values
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