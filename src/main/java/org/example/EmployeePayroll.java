package org.example;

import java.util.Date;

public class EmployeePayroll
{
    private int Emp_ID;
    private String Emp_Name;
    private double BasicPay;
    private Date Start_date;
    private char Gender;

    public EmployeePayroll(int Emp_ID,String Emp_Name,  double BasicPay, Date Start_date, char Gender)
    {
        this.Emp_ID = Emp_ID;
        this.Emp_Name = Emp_Name;
        this.BasicPay = BasicPay;
        this.Start_date = Start_date;
        this.Gender = Gender;
    }

    public int getEmp_ID() {
        return Emp_ID;
    }

    public String getEmp_Name() {
        return Emp_Name;
    }

    public double getBasicPay() {
        return BasicPay;
    }

    public Date getStart_date() {
        return Start_date;
    }

    public char getGender() {
        return Gender;
    }
}
