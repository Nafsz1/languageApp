package com.mycompany.languageappdatabase;


import com.mycompany.languageappdatabase.ConnectDatabase;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

/**
 *
 * @author natha
 */
public class CreateTeacherTable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection Con = ConnectDatabase.GetConnection();
        Statement Stmt = null;
        String CreateTeacher;
        CreateTeacher ="""
                       CREATE TABLE if not exists Teacher (
                                   TeacherUsername     VARCHAR      PRIMARY KEY,
                                   TeacherFullname  VARCHAR (30),
                                   TeacherEmail  VARCHAR (30),
                                   TeacherPassword   VARCHAR (20)
                       ) ;""";

        
        try {
            Stmt = Con.createStatement();
            Stmt.executeUpdate(CreateTeacher);
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
    }    }
