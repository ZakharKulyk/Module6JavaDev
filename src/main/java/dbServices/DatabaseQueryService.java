package dbServices;


import database.Database;
import dbDto.*;


import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    Connection connection;

    public DatabaseQueryService() {
        try {
            connection = Database.getInstance().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<HighestPayedWorker> findMaxSalaryWorker() {
        List<HighestPayedWorker> result = new ArrayList<>();
        String q = processSQLFile("sql/find_max_salary_worker.sql");
        try {
            ResultSet resultSet = getConnection().prepareStatement(q).executeQuery();
            while (resultSet.next()) {
                HighestPayedWorker worker = new HighestPayedWorker();

                worker.setName(resultSet.getString("name"));
                worker.setSalary(resultSet.getInt("salary"));
                result.add(worker);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public List<MaxProjectCountClient> findMaxProjectCountClient() {
        List<MaxProjectCountClient> result = new ArrayList<>();
        String q = processSQLFile("sql/find_max_project_count_client.sql");

        try {
            ResultSet resultSet = getConnection().prepareStatement(q).executeQuery();
            while (resultSet.next()) {
                MaxProjectCountClient maxProjectCountClient = new MaxProjectCountClient();

                maxProjectCountClient.setProjectCount(resultSet.getInt("PROJECT_COUNT"));
                maxProjectCountClient.setName(resultSet.getString("name"));
                result.add(maxProjectCountClient);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public List<LongestProjectDuration> findLongestProject() {
        List<LongestProjectDuration> result = new ArrayList<>();
        String q = processSQLFile("sql/find_longest_project.sql");

        try {
            ResultSet resultSet = getConnection().prepareStatement(q).executeQuery();
            while (resultSet.next()) {
                LongestProjectDuration longestProjectDuration = new LongestProjectDuration();

                longestProjectDuration.setName(resultSet.getString("PROJECT_ID"));
                longestProjectDuration.setMonth(resultSet.getInt("MONTH_COUNT"));
                result.add(longestProjectDuration);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public List<YoungestAndEldestWorker> findYoungestAndOldestWorkers() {
        List<YoungestAndEldestWorker> result = new ArrayList<>();
        String s = processSQLFile("sql/find_youngest_oldest_worker.sql");

        try {
            ResultSet resultSet = getConnection().prepareStatement(s).executeQuery();
            while (resultSet.next()) {
                YoungestAndEldestWorker youngestAndEldestWorker = new YoungestAndEldestWorker();
                youngestAndEldestWorker.setName(resultSet.getString("NAME"));
                youngestAndEldestWorker.setType(resultSet.getString("TYPE"));
                youngestAndEldestWorker.setDateOfBirth(resultSet.getDate("BIRTHDAY"));

                result.add(youngestAndEldestWorker);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public List<AllProjectsCost> showProjectsCost() {
        List<AllProjectsCost> result = new ArrayList<>();
        String q = processSQLFile("sql/print_project_prices.sql");

        try {
            ResultSet resultSet = getConnection().prepareStatement(q).executeQuery();
            while (resultSet.next()){
               AllProjectsCost allProjectsCost = new AllProjectsCost();
               allProjectsCost.setProjectId(resultSet.getInt("PROJECT_ID"));
               allProjectsCost.setProjectCost(resultSet.getInt("PRICE"));

               result.add(allProjectsCost);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }


    private String processSQLFile(String filePath) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String s;
            StringBuilder stringBuilder = new StringBuilder();

            while ((s = bufferedReader.readLine()) != null) {
                stringBuilder.append(s);
                stringBuilder.append("\n");
                if (s.endsWith(";")) {
                    return stringBuilder.toString();
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return "failed to process";
    }


    public Connection getConnection() {
        return connection;
    }

}





