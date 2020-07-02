package com.company;


import com.google.gson.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.json.simple.JSONValue;


public class DataBuddy {

    private Connection conn;

    public DataBuddy(){
        //constructor
        //connection is null. This is bad.
        Connection conn = null;
    }

    public boolean Connect(){

        try {
            // db parameters
            String url = "jdbc:mysql://database-1.ciqrtpfk6ufa.us-east-2.rds.amazonaws.com:3306/";
            String user = "admin";
            String password = "copperjohn";

            // create a connection to the database
            conn = DriverManager.getConnection(url, user, password);
            // more processing here
            // ...
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (conn != null) {
                System.out.println("Connection not null.");
                //conn.close();
            }
        }
        return true;
    }

    public boolean Disconnect() {
        try {
            conn.close();
        }catch (SQLException ex) {
            System.out.println((ex.getMessage()));
            return false;
        }

        return true;
    }

    public void createDataBase(String DBName){
        String DatabaseCreationStatement;
        DatabaseCreationStatement = "CREATE DATABASE IF NOT EXISTS " + DBName;
        sendSqlStatement(DatabaseCreationStatement);

    }

    private void sendSqlStatement(String sql){
        System.out.println("Creating statement...");
        //autogenerated try catch
        //TODO customise appropriately
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void createTable(String TableName){
        //takes tablename and arbitrary java object as arguments
        //creates table capable of storing java object
        System.out.println("Creating table...");

        String TableCreationStatement;
        TableCreationStatement = "CREATE TABLE " + TableName
                + " (ID VARCHAR(9999));" ;
        sendSqlStatement((TableCreationStatement));

    }


    public void JSONTest(Object o){
        System.out.println("I'm doing the thing");
        System.out.println(JSONValue.toJSONString(o));
    }

    public String ConvertToJSON(Object o){
        Gson gson = new Gson();
        return gson.toJson(o);
    }
}
