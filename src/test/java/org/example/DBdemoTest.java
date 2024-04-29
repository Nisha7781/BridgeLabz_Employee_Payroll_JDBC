package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.List;

class DBdemoTest
{
    String url = "jdbc:mysql://localhost:3306/payroll_service";
    String username = "root";
    String password = "Mahi7781";
    DBdemo d= new DBdemo();

    @Test
    public void loadDriver()
    {
        String result = d.loadDriver(url,username,password);
        Assertions.assertEquals("Driver loaded successfully", result);
    }


    @Test
    public void connection()
    {
        String result =  d.connection(url,username,password);
        Assertions.assertEquals("Connection closed successfully...!",result);
    }

    @Test
    public void getemployeeDetails() throws Exception {
        List<EmployeePayroll> employeePayrollList = d.getemployeeDetails(url);

        EmployeePayroll employeePayroll = employeePayrollList.get(0);

        Assertions.assertEquals(1, employeePayroll.getEmp_ID());
        Assertions.assertEquals("Nisha", employeePayroll.getEmp_Name());
        Assertions.assertEquals(35000.0, employeePayroll.getBasicPay());
        Assertions.assertEquals(Date.valueOf("2024-01-01"), employeePayroll.getStart_date());
        Assertions.assertEquals('F', employeePayroll.getGender());
    }

    @Test
    public void updateSalary() throws Exception
    {
        double salary = d.updateSalary(url,username,password);
        Assertions.assertEquals(1, salary);
    }

    @Test
    public void getemployees_JoinedWithinDate() throws Exception {
        List<EmployeePayroll> employeePayrollList = d.getemployees_JoinedWithinDate(url);

        Assertions.assertFalse(employeePayrollList.isEmpty());

        EmployeePayroll employeePayroll = employeePayrollList.get(0);
        Assertions.assertEquals("Sanika", employeePayroll.getEmp_Name());
        Assertions.assertEquals(25000.0, employeePayroll.getBasicPay());
        Assertions.assertEquals(Date.valueOf("2024-03-01"), employeePayroll.getStart_date());
        Assertions.assertEquals('F', employeePayroll.getGender());
    }

    @Test
    public void testAggregateOperations() throws Exception
    {
        double result = d.AggregateOperations(url, username, password);
        Assertions.assertEquals(135000.0, result,0.0);
    }
}