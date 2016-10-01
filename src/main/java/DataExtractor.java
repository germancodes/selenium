import java.sql.*;
import java.util.*;

public class DataExtractor { 
    private Connection conn;
    private String strSQL;
    private WebsiteFiller testItem = new WebsiteFiller();
    private final List<String> webIDList = new ArrayList<>();
    private final List<String> elementTypeList = new ArrayList<>();
    private final List<String> columNameList = new ArrayList<>();
    
    
    public void loadDBConn(String strDBPath) throws SQLException{
        conn = DriverManager.getConnection("jdbc:ucanaccess://" + strDBPath);
    }
    
    public void getDBValues() throws SQLException{
        int x = 0;
        Statement stmt = conn.createStatement();
        ResultSet recordSet = stmt.executeQuery("SELECT * FROM tblMappings ORDER BY executionOrder");
        //webIDList = (List<String>) recordSet.getArray("fieldID");
        while(recordSet.next()){
            webIDList.add(recordSet.getString("fieldID"));
            elementTypeList.add(recordSet.getString("elementType"));
            columNameList.add(recordSet.getString("columnName"));
            System.out.println(webIDList.get(x) + " - " + elementTypeList.get(x) + " - " + columNameList.get(x));
            x++;
        }
        recordSet.close();
        stmt.close();
    }
    
    public void executeDataEntry() throws SQLException{
        int intArrySize, x;
        
        Statement stmt = conn.createStatement();
        ResultSet recordSet = stmt.executeQuery("SELECT * FROM tblValues");
        
        while(recordSet.next()){
            testItem.loadSite("http://www.pvamu.edu/ece/students/current/prerequisite-override-request/");
            intArrySize = webIDList.size();
            for (x = 0; x < intArrySize; x++){
                switch(elementTypeList.get(x)){
                    case "TB":
                        testItem.populateTextBox(webIDList.get(x), recordSet.getString(columNameList.get(x)));
                        break;
                    case "DD":
                        testItem.populateDropDown(webIDList.get(x), recordSet.getString(columNameList.get(x)));
                        break;
                }
            }
        }
        
    }

}
