package org.example;

import java.sql.*;

public class DBdemo
{
    public static void main(String[] args)
    {
        String url = "jdbc:mysql://localhost:3306/payroll_service";
        String username = "root";
        String password = "Mahi7781";

        DBdemo d = new DBdemo();
        d.loadDriver(url,username,password);
        String result = d.connection(url,username,password);
        System.out.println(result);
    }

    public String loadDriver(String url, String username, String password)
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            return "Driver loaded successfully";
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
            return "Driver not found in classpath";
        }
    }

    public String connection(String url, String username, String password)
    {
        String query = "Select * from employee_payroll";
        try
        {
            Connection connection = DriverManager.getConnection(url,username,password);
            System.out.println("Database Connected Successfully.");
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            rs.close();
            connection.close();
            stmt.close();
            return "Connection closed successfully...!";
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
            return "Connection Failed..!";
        }
    }
}
