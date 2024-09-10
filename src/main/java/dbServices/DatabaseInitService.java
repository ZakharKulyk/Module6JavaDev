package dbServices;


import database.Database;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseInitService {

    public static void main(String[] args) {
        List<String> queryList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("sql/init_db.sql"))) {
            String line;
            Connection connection = Database.getInstance().getConnection();
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = bufferedReader.readLine())!=null) {
                stringBuilder.append(line.trim());
                if(line.endsWith(";")){
                    connection.createStatement().executeUpdate(stringBuilder.toString());
                    stringBuilder.setLength(0);
                }

            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
