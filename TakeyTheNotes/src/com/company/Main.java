package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {


        // write your code here
        DataBuddy dB = new DataBuddy();
        Dog d = new Dog("Fido","Cavalier King Charles Spaniel", 13 );
        dB.JSONTest(d);
        System.out.println(dB.ConvertToJSON(d));
/**
        dB.Connect();
        //where calls to database occur
        dB.createTable("test",
        dB.Disconnect();
         **/
    }
}