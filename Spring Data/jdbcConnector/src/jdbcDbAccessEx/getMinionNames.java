package jdbcDbAccessEx;

import dbConnection.DbConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

import static java.lang.System.in;

public class getMinionNames {

    public static Connection connection;
    static {
        try {
            connection = new DbConnection("minions_db").getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        DbConnection dbConnection = new DbConnection("minions_db");

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select m.name,\n" +
                                            "       m.age\n" +
                                            "from minions_villains mv\n" +
                                            "left join minions m on m.id = mv.minion_id\n" +
                                            "left join villains v on mv.villain_id = v.id\n" +
                                            "where v.id = ?;");
            System.out.println("Please input a villain id:");
            int villainId = Integer.parseInt(reader.readLine());
            preparedStatement.setInt(1, villainId);
            System.out.println(getNameById("villains", villainId));

            ResultSet resultSet = preparedStatement.executeQuery();
            int col = 1;
            while (resultSet.next()) {
                System.out.printf("%d %s %d\n",
                        col++,
                        resultSet.getString("name"),
                        resultSet.getInt("age"));
            }
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
    }

    private static String getNameById(String tableName, int entryId) throws SQLException {
        String query = "SELECT name FROM " + tableName + " WHERE id = ?; ";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, entryId);
        ResultSet rs = ps.executeQuery();
        return rs.next()
                ? String.format("Villain: %s", rs.getString(1))
                : String.format("No villain with ID %d exists in the database.", entryId);
    }
}
