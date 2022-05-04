
package com.mycompany.languageappdatabase;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.sql.PreparedStatement;
import java.io.FileReader;


/**
 *
 * @author Nafees
 */
public class ReadCSVData {
    
    public static void main(String[] args) {
        Connection Con = ConnectDatabase.GetConnection();
        String filePath = "./topic.csv";
        
        //https://github.com/youtube-arjun-codes/CsvToDatabaseJava/blob/master/src/main/java/CSVConsume.java
        //I used this website to help me read the CSV file and update the database 
                try{

                    String sql="insert into Topic(Level, Context, SubContext) values(?,?,?)";

                    PreparedStatement statement=Con.prepareStatement(sql);

                    BufferedReader lineReader=new BufferedReader(new FileReader(filePath));

                    String lineText=null;
                    int count=0;

                    lineReader.readLine();
                    while ((lineText=lineReader.readLine())!=null){
                        String[] data=lineText.split(",");


                        String Level=data[0];
                        String Context=data[1];
                        String SubContext=data[2];

                        statement.setString(1,Level);
                        statement.setString(2,Context);
                        statement.setString(3,SubContext);
                        statement.addBatch();
                        int batchSize = 500;
                        if(count%batchSize==0){
                            statement.executeBatch();
                        }
                    }
                    lineReader.close();
                    statement.executeBatch();
                    Con.close();
                    System.out.println("Data has been inserted successfully.");

        }
        catch (Exception exception){
            exception.printStackTrace();
        }
        
    }
}
       