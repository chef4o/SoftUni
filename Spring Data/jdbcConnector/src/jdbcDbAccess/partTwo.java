package jdbcDbAccess;

import dbConnection.DbConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

import static java.lang.System.in;

public class partTwo {
    public static Connection connection;
    static {
        try {
            connection = new DbConnection("minions_db").getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void main(String[] args) throws NullPointerException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        DbConnection dbConnection = new DbConnection("diablo");

        try {

            PreparedStatement ps = connection.prepareStatement("select u.user_name,\n" +
                                                                    "       concat_ws(' ', u.first_name, u.last_name) as full_name,\n" +
                                                                    "       count(*) as number_of_games\n" +
                                                                    "from users_games ug\n" +
                                                                    "inner join users u on ug.user_id = u.id\n" +
                                                                    "where u.user_name = ?");
            System.out.println("Please nickname:");
            String input = reader.readLine();
            ps.setString(1, input);

            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getString("user_name") != null)
                System.out.printf("User: %s \n%s has played %d games",
                        resultSet.getString("user_name"),
                        resultSet.getString("full_name"),
                        resultSet.getInt("number_of_games"));
                else {
                    System.out.println("No such user exists");
                }
            }
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
    }
}
