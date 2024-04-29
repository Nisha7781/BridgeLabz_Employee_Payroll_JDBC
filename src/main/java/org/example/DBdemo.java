package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public List<EmployeePayroll> getemployeeDetails(String url) throws Exception {
        List<EmployeePayroll> employeelist = new ArrayList<>();

        String username = "root";
        String password = "Mahi7781";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String query = "select * from employee_payroll";
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                int Emp_ID = rs.getInt(1);
                String Emp_Name = rs.getString(2);
                double BasicPay = rs.getDouble(7);
                Date Start_date = rs.getDate(8);
                char Gender = rs.getString(3).charAt(0);

                EmployeePayroll employeePayroll = new EmployeePayroll(Emp_ID, Emp_Name, BasicPay, Start_date, Gender);
                employeelist.add(employeePayroll);
            }
        } catch (SQLException e) {
            throw new Exception("Database is empty");
        }

        return employeelist;
    }

    public double updateSalary(String url, String username, String password) throws Exception {
        String query = "update employee_payroll set BasicPay = ? where Emp_ID = ?";
        int update = 0;

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setDouble(1, 50000);
            ps.setInt(2, 4);
            update = ps.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("Failed to update Basicpay...");
        }

        return update;
    }


}
