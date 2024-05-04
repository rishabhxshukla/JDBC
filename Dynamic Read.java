import java.sql.*;

class DynamicRead
{
    public static void main(String args[]) throws SQLException
    {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "My Sql12";

        String query = "SELECT * FROM Students WHERE id = ?;";

        /*-------------------------------------------------------------------------------*/

        //Establishing connection
        Connection con = DriverManager.getConnection(url, username, password);

        //Creating a statement
        PreparedStatement ps = con.prepareStatement(query);

        //Adding dynamic values
        ps.setInt(1, 101);

        //Executing the query
        ResultSet rs = ps.executeQuery();

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