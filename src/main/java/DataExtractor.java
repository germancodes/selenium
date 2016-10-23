import java.sql.*;
import java.util.*;

public class DataExtractor { 
    private Connection conn;
    private String strSQL;
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
    
    public void executeDataEntry(String strURL) throws SQLException{
        int intArrySize, x;
        
        Statement stmt = conn.createStatement();
        ResultSet recordSet = stmt.executeQuery("SELECT * FROM tblValues");
        
        while(recordSet.next()){
            WebsiteFiller testItem = new WebsiteFiller();
            testItem.loadSite(strURL);
            intArrySize = webIDList.size();
            for (x = 0; x < intArrySize; x++){
                switch(elementTypeList.get(x)){
                    case "TB":
                        if(!empty(recordSet.getString(columNameList.get(x)))){
                            testItem.populateTextBox(webIDList.get(x), recordSet.getString(columNameList.get(x)));
                        }
                        break;
                    case "DD":
                        if(!empty(recordSet.getString(columNameList.get(x)))){
                            testItem.populateDropDown(webIDList.get(x), recordSet.getString(columNameList.get(x)));
                        }
                        break;
                    case "UP":
                        if(!empty(recordSet.getString(columNameList.get(x)))){
                            testItem.uploadFile(webIDList.get(x), recordSet.getString(columNameList.get(x)));
                        }
                        break;
                    case "RAD":
                        if("Y".equals(recordSet.getString(columNameList.get(x)))){
                            testItem.selectRadio(webIDList.get(x));
                        }
                        break;
                    case "BUTT":
                        if("Y".equals(recordSet.getString(columNameList.get(x)))){
                            testItem.clickButton(webIDList.get(x));
                        }
                        break;
                    case "xTB":
                        if(!empty(recordSet.getString(columNameList.get(x)))){
                            testItem.populateSpecialTextBox(webIDList.get(x), recordSet.getString(columNameList.get(x)));
                        }
                        break;
                    case "xBUTT":
                        if("Y".equals(recordSet.getString(columNameList.get(x)))){
                            testItem.SpecialClickButton(webIDList.get(x));
                        }
                        break;
                    default:
                        break;
                }
            }
            //testItem.closeSite();
            testItem = null;
        }
        
    }
    private static boolean empty( final String s ) {
        return s == null || s.trim().isEmpty();
      }

}
