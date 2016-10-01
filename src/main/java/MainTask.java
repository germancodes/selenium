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
//        WebsiteFiller testItem = new WebsiteFiller();
//        testItem.loadSite("http://www.pvamu.edu/ece/students/current/prerequisite-override-request/");
//        testItem.populateDropDown("input_15_71", "Prerequisite Override");
//        testItem.populateTextBox("input_15_6_3", "German");
//        testItem.populateTextBox("input_15_6_6", "Candelaria");
//        testItem.populateTextBox("input_15_24", "(210)789-1974");
//        testItem.populateTextBox("input_15_39", "K00345943");
//        testItem.selectRadio("choice_15_43_0");
//        testItem.selectRadio("choice_15_48_3");
//        testItem.populateDropDown("input_15_42", "Dr. Attia");
//        testItem.populateSpecialTextBox("//*[@id=\"field_15_49\"]/div[2]/table/tbody/tr/td[1]/input", "CSCI-4344");
//        testItem.populateSpecialTextBox("//*[@id=\"field_15_49\"]/div[2]/table/tbody/tr/td[2]/input", "35478");
//        testItem.populateSpecialTextBox("//*[@id=\"field_15_49\"]/div[2]/table/tbody/tr/td[3]/input", "CSCI-1336");
//        testItem.SpecialClickButton("//*[@id=\"field_15_49\"]/div[2]/table/tbody/tr[1]/td[4]/img[1]");
//        testItem.populateSpecialTextBox("//*[@id=\"field_15_49\"]/div[2]/table/tbody/tr[2]/td[1]/input", "CSCI-4366");
//        testItem.populateSpecialTextBox("//*[@id=\"field_15_49\"]/div[2]/table/tbody/tr[2]/td[2]/input", "35470");
//        testItem.populateSpecialTextBox("//*[@id=\"field_15_49\"]/div[2]/table/tbody/tr[2]/td[3]/input", "CSCI-1337");
//        testItem.populateDropDown("input_15_46", "Yes");
//        testItem.selectRadio("label_15_45_0");
//        testItem.populateDropDown("input_15_60", "Yes");
//        testItem.uploadFile("input_15_59", "C:\\Users\\German\\Documents\\School\\Fall 2016\\CSCI-4366_THE\\Course Documents\\CSCI_4366_syllabus_FA16.pdf");
//        testItem.uploadFile("input_15_31", "C:\\Users\\German\\Documents\\School\\Fall 2016\\CSCI-4366_THE\\Course Documents\\CSCI_4366_syllabus_FA16.pdf");
        //testItem.clickButton("gform_submit_button_15");
        //testItem.closeSite();
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
    }
    
}
