/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author German
 */
import java.sql.*;

public class MainTask {
    public static void main(String[] args){
        
        DataExtractor dbTestItem = new DataExtractor();
        try{
            dbTestItem.loadDBConn("C:/Users/German/Documents/School/Fall 2016/CSCI-4391_SEN/Project/Database/Database1.accdb");
            dbTestItem.getDBValues();
            dbTestItem.executeDataEntry();
        }
        catch (SQLException e){
                e.printStackTrace();
         }
        
        System.out.println("Done");
        System.exit(0);
    }
    
}
