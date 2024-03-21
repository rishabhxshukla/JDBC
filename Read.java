import java.sql.*;

class Read
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