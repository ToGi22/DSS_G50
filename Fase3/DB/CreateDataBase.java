

import DataLayer.DAOconfig;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class CreateDataBase 
{
    public static void main(String[] args) throws ClassNotFoundException {
        try(Connection conn = DAOconfig.getConnectionNoDatabase();
            Statement stmt = conn.createStatement();) 
        {
            String sql = "CREATE DATABASE IF NOT EXISTS "+DAOconfig.getDatabaseName()+";";
            int result = stmt.executeUpdate(sql);
            if (result == 1) System.out.println("Database created successfully...");
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }
}
