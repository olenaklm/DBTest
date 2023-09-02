package lesson32;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        String select_sql = "SELECT * FROM PERSONS";

        // This will load the Postgres driver, each DB has its own driver
//        Class.forName("com.mysql.jdbc.Driver");
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "docker");
        Statement statement = connection.createStatement();


        int[] array = new int[2];
        int i = 0;
        ResultSet rs = statement.executeQuery(select_sql);
        while (rs.next()){
            System.out.println(rs.getString("PersonId") + " " + rs.getString(2) + " " + rs.getString(3)
                    + " " + rs.getString(4) + " " + rs.getString(5));
            int a = rs.getInt("PersonId");
            array[i++] = a;
        }

        connection.close();
    }

}
