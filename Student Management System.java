import java.io.*;
import java.sql.*;

class StudentManagementSystem
{
    public static void main(String args[]) throws IOException, SQLException
    {
        InputStreamReader inp = new InputStreamReader(System.in);
        BufferedReader b = new BufferedReader(inp);

        //Taking user input
        System.out.println("Press 1 to CREATE student");
        System.out.println("Press 2 to READ students");
        System.out.println("Press 3 to UPDATE student");
        System.out.println("Press 4 to DELETE student");
        System.out.print("Enter your choice : ");
        int ch = Integer.parseInt(b.readLine());
        System.out.println();

        //Connection
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "My Sql12";
        Connection con = DriverManager.getConnection(url, username, password);

        //Statement
        Statement st = con.createStatement();
        String query = "";

        switch (ch)
        {
            case 1:
                query = "INSERT INTO Students VALUE (102, 'Alex');";
                st.execute(query);
                System.out.println("Student added!");
                break;

            case 2:
                query = "SELECT * FROM Students;";
                ResultSet rs = st.executeQuery(query);
                System.out.println("All students :");
                while (rs.next())
                {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    System.out.println(id +" : "+ name);
                }
                break;

            case 3:
                query = "UPDATE Students SET name = 'NewAlex' WHERE id = 102";
                st.executeUpdate(query);
                System.out.println("Student updated!");
                break;

            case 4:
                query = "DELETE FROM Students WHERE id = 102";
                st.execute(query);
                System.out.println("Student deleted!");
                break;

            default:
                System.out.println("Invalid choice!");
                break;
        }

        //Closing connection
        con.close();
    }
}