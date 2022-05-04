package com.mycompany.languageappdatabase;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

import com.mycompany.languageappdatabase.ConnectDatabase;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author natha
 */
public class CreateStudentTable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection Con = ConnectDatabase.GetConnection();
        Statement Stmt = null;
        String CreateStudent;
        CreateStudent ="""
                       CREATE TABLE if not exists Student (
                                   StudentUsername     VARCHAR      PRIMARY KEY,
                                   StudentFullname  VARCHAR (30),
                                   StudentEmail  VARCHAR (30),
                                   StudentPassword   VARCHAR (20)
                       ) ;""";

        
        try {
            Stmt = Con.createStatement();
            Stmt.executeUpdate(CreateStudent);
            Con.commit();
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        } finally {
            if (Stmt != null) {
                try {
                    Stmt.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
            if (Con != null) {
                try {
                    Con.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
        }
    }    
}
