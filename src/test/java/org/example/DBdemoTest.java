package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DBdemoTest
{
    String url = "jdbc:mysql://localhost:3306/payroll_service";
    String username = "root";
    String password = "Mahi7781";
    DBdemo d= new DBdemo();

    @Test
    void loadDriver()
    {
        String result = d.loadDriver(url,username,password);
        System.out.println(result);
        Assertions.assertEquals("Driver loaded successfully", result);
    }


    @Test
    void connection()
    {
        String result =  d.connection(url,username,password);
        System.out.println(result);
        Assertions.assertEquals("Connection closed successfully...!",result);
    }
}