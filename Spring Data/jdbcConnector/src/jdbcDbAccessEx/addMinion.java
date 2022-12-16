package jdbcDbAccessEx;

import dbConnection.DbConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class addMinion {
    public static Connection connection;
    static {
        try {
            connection = new DbConnection("minions_db").getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Deque<String> input = new ArrayDeque<>();
        try {
            do {
                input.add(reader.readLine());
            } while (!reader.readLine().isEmpty());
        } catch (IOException e) {
            e.printStackTrace();
        }

        String minion = "";
        List<String> parameters = new ArrayList<>();
        while (!(parameters = setInput(input.pollFirst())).isEmpty()) {

            String tableName = getTableName(parameters.get(0));
            if (tableName.equals("minions")) {
                minion = parameters.get(1);
            }

            if (tableName.equals("minions")
                    && !townIsAvailable(tableName,"town_id", parameters.get(3))) {
                String townName = parameters.get(3);
                insertTownData("towns", townName);
                System.out.printf("Town %s was added to the database.\n", townName);
            }

            String villainName = "";
            if (tableName.equals("villains")
                    && !villainIsAvailable("villains", parameters.get(1))) {
                villainName = parameters.get(1);
                insertVillainData("villains", villainName);
                System.out.printf("Villain %s was added to the database.\n", villainName);
            };

            PreparedStatement preparedStatement = generateQuery(tableName, parameters);
            preparedStatement.executeUpdate();

            if (tableName.equals("villains")) {
                setForeignRelations("minions_villains", "minions", minion, "villains", villainName);
                System.out.printf("Successfully added %s to be minion of %s.", minion, villainName);
            }
        }
    }

    private static void insertTownData(String table, String town) throws SQLException {
        String query = "insert into " + table + " () " +
                        "values (null, ? , null); ";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, town);
        ps.executeUpdate();
    }

    private static void insertVillainData(String table, String name) throws SQLException {
        String query = "insert into " + table + " () " +
                "values (null, ? , ?); ";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, name);
        ps.setString(2, "evil");
        ps.executeUpdate();
    }

    private static void setForeignRelations(String targetTable,
                                            String sourceTableOne, String relationNameOne,
                                            String sourceTableTwo, String relationNameTwo) throws SQLException {
        String query = "insert into " + targetTable + " () " +
                        " values (?, ?); \n";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, Integer.parseInt(getElementId(relationNameOne, sourceTableOne)));
        ps.setInt(2, Integer.parseInt(getElementId(relationNameTwo, sourceTableTwo)));
        ps.executeUpdate();
    }

    private static PreparedStatement generateQuery(String tableName, List<String> parameters) throws SQLException {

        if (tableName.equals("minions")) {
            String townName = parameters.get(3);
            parameters.set(3, getElementId(townName, tableName));
        }

        String query = "insert into " + tableName + " () " +
                        "values \n" +
                        "(null, " + setValuesCount(tableName) + " ;";
        PreparedStatement ps = connection.prepareStatement(query);
        for (int i = 1; i < parameters.size(); i++) {
            if (parameters.get(i).isEmpty()) {
                ps.setObject(i, null);
            } else if (parameters.get(i).matches("^\\d+$")) {
                ps.setInt(i, Integer.parseInt(parameters.get(i)));
            } else if (parameters.get(i).matches("^\\d+\\.\\d+$")) {
                ps.setDouble(i, Double.parseDouble(parameters.get(i)));
            } else {
                ps.setString(i, parameters.get(i));
            }
        }
        return ps;
    }

    private static int getColumnNumber(String tableName) throws SQLException {
        String query = "select * from " + tableName + " ;";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(query);
        ResultSetMetaData rsmd = rs.getMetaData();
        return rsmd.getColumnCount();
    }

    private static String setValuesCount (String tableName) throws SQLException {
        int columnCount = getColumnNumber(tableName);
        List<String> output = new ArrayList<>();
        for (int i = 0; i < columnCount; i++) {
            output.add("?");
        }
        return output.isEmpty()
                ? ""
                : output.toString().replaceAll("[\\[\\]]", "");
    }

    private static String getTableName(String input) {
        return input.toLowerCase().substring(0, input.length() - 1) + "s";
    }

    private static List<String> setInput (String input) {
    return Arrays.stream(input
                        .split("\\s+"))
                        .collect(Collectors.toList());
    }

    private static String getElementId(String element, String tableName) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("select t.id from " + tableName +
                                                                " where t.name = ?;\n");
        ps.setString(1, element);
        ResultSet rs = ps.executeQuery();
        rs.next();
        return String.valueOf(rs.getInt(1));
    }

    private static boolean townIsAvailable(String tableName, String column, String foreignKey) throws SQLException {
        String query = "select * from " + tableName + " where " + column + "= ?;\n";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, foreignKey);
        ResultSet rs = ps.executeQuery();
        return rs.next();
    }

    private static boolean villainIsAvailable(String database, String name) throws SQLException {
        String query = "select * from " + database + " where name = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, name);
        ResultSet rs = ps.executeQuery();
        return rs.next();
    }
}
