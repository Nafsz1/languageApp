package com.mycompany.languageappdatabase;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

import java.sql.Connection;
import java.sql.DriverManager;


/**
 *
 * @author natha
 */

public class ConnectDatabase {
    
      public static Connection GetConnection() {

        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:LanguageAppDatabase.db";
            Connection con = DriverManager.getConnection(url);
            return con;
        } catch (Exception e) {
            return null;
        }
    }
     
    
}

