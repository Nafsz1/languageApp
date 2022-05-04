
package com.mycompany.languageappdatabase;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Nafees
 */
public class CreateTopicTable {
    
        public static void main(String[] args) {
        Connection Con = ConnectDatabase.GetConnection();
        Statement Stmt = null;
        String CreateTopic;
        CreateTopic ="""
                       CREATE TABLE if not exists Topic (
                                   Level     VARCHAR(2),
                                   Context  VARCHAR (200),
                                   SubContext  VARCHAR (200)
                       ) ;""";

        
        try {
            Stmt = Con.createStatement();
            Stmt.executeUpdate(CreateTopic);
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
