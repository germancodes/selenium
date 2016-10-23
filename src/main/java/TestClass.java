/*
Student: German M. Candelaria
Date: 10/23/2016
Class: CSCI-4316
QUIZ 3
*/
import java.sql.SQLException;

public class TestClass {
    public static void main(String[] args){
        WebsiteFiller webTestItem = new WebsiteFiller();
        //Testing site loader functionality
        webTestItem.loadSite("http://www.pvamu.edu/ece/students/current/prerequisite-override-request/");
        //Testing drop down filler functionality
        webTestItem.populateDropDown("input_15_71", "Prerequisite Override");
        //Testing text box filler functionality
        webTestItem.populateTextBox("input_15_6_3", "German");
        System.out.println("Done");
        System.exit(0);
    }
}
