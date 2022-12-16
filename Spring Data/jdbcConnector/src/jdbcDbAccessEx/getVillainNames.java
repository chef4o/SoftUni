package jdbcDbAccessEx;

import dbConnection.DbConnection;

import java.io.*;
import java.sql.*;

import static java.lang.System.in;

public class getVillainNames {

    public static Connection connection;
    static {
        try {
            connection = new DbConnection("minions_db").getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        try {
            PreparedStatement prepareStatement = connection
                    .prepareStatement("select v.name,\n" +
                                    "       count(distinct minion_id) as `count`\n" +
                                    "from minions_villains mv\n" +
                                    "join villains v on mv.villain_id = v.id\n" +
                                    "group by name\n" +
                                    "having count > ?\n" +
                                    "order by count desc;");

            prepareStatement.setInt(1, 15);
            ResultSet resultSet = prepareStatement.executeQuery();

            while (resultSet.next()) {
                System.out.printf("%s %d\n",
                        resultSet.getString(1),
                        resultSet.getInt(2));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
