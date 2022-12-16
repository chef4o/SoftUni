package jdbcDbAccess;

import dbConnection.DbConnection;

import java.io.*;
import java.sql.*;

public class partOne {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            Connection connection = new DbConnection("soft_uni").getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("select first_name, last_name " +
                                                                                    "from employees " +
                                                                                    "where salary > ?");
            System.out.println("Please enter a minimum salary for the employees of interest:");
            double salaryInput = Double.parseDouble(reader.readLine());
            preparedStatement.setDouble(1, salaryInput);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.printf("%s %s \n",
                                    resultSet.getString("first_name"),
                                    resultSet.getString("last_name"));
            }

        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
    }
}
