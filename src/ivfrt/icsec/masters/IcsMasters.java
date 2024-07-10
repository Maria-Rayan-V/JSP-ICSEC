package ivfrt.icsec.masters;
import ivfrt.icsec.constants.DBConfig;
import ivfrt.icsec.models.CountryModel;
import ivfrt.icsec.models.DutyBatchModel;
import ivfrt.icsec.models.ECType;
import ivfrt.icsec.models.FlightNumModel;
import ivfrt.icsec.models.ReasonTypeModel;
import ivfrt.icsec.models.VisatypeModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class IcsMasters {
	 static String DB_URL=DBConfig.OJDBC_URL;
   static  String DB_USERNAME=DBConfig.DB_USERNAME;
   static  String DB_PSWD=DBConfig.DB_PWD;
   static Connection dbConnection = null;

	public static ArrayList<CountryModel> getCountries() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		
		PreparedStatement objPrepStmt = null;
		ArrayList<CountryModel> ListOfCountries = null;
       
        try
        {
        	dbConnection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PSWD);
        	objPrepStmt = dbConnection.prepareStatement("select COUNTRY_CODE, COUNTRY_DESC from IM_COUNTRY where ACTIVE_RECORD='Y' order by COUNTRY_DESC asc");
        	ResultSet objResultSet = objPrepStmt.executeQuery();
        	if(objResultSet.isBeforeFirst())
        	{
        		ListOfCountries = new ArrayList<CountryModel>();
        		  while (objResultSet.next()) {
                      String countryCode = objResultSet.getString("COUNTRY_CODE");
                      String countryDesc = objResultSet.getString("COUNTRY_DESC");
                      CountryModel country = new CountryModel(countryCode, countryDesc);
                     
                      ListOfCountries.add(country);
//                      System.out.println("Countries"+ListOfCountries);
                  }
        	}
        	objPrepStmt.clearParameters();
        	objPrepStmt.close();
        } 
        catch (SQLException e)
        {
                e.printStackTrace();
        }
        finally
        {
        	dbConnection.close();
        }
        return ListOfCountries;
	}
	
	public static ArrayList<ECType> getEcType() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		
		ArrayList<ECType> ListOfECtype = null;
		PreparedStatement objPrepStmt = null;
        try
        {
        	dbConnection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PSWD);
        	objPrepStmt = dbConnection.prepareStatement("select EC_TYPE_CODE,EC_TYPE_DESC from IO_EC_TYPE_M where IS_ROW_ACTIVE='Y'");
        	ResultSet objResultSet = objPrepStmt.executeQuery();
        	if(objResultSet.isBeforeFirst())
        	{
        		ListOfECtype = new ArrayList<ECType>();
        		  while (objResultSet.next()) {
                      String ecTypeCode = objResultSet.getString("EC_TYPE_CODE");
                      String ecTypeDesc = objResultSet.getString("EC_TYPE_DESC");
                      ECType ecTypeObj = new ECType(ecTypeCode, ecTypeDesc);
                     
                      ListOfECtype.add(ecTypeObj);
                  
                  }
        	}
        	objPrepStmt.clearParameters();
        	objPrepStmt.close();
        } 
        catch (SQLException e)
        {
                e.printStackTrace();
        }
        finally
        {
        	dbConnection.close();
        }
        return ListOfECtype;
	}
	public static ArrayList<FlightNumModel> getFlightNo() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		
		ArrayList<FlightNumModel> ListOfFlightNo = null;
		PreparedStatement objPrepStmt = null;
        try
        {
        	dbConnection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PSWD);
        	objPrepStmt = dbConnection.prepareStatement("select FLIGHT_NO,FLIGHT_DESC from IM_FLIGHT_TRANS where ICP_SRNO='004'");
        	ResultSet objResultSet = objPrepStmt.executeQuery();
        	if(objResultSet.isBeforeFirst())
        	{
        		ListOfFlightNo = new ArrayList<FlightNumModel>();
        		  while (objResultSet.next()) {
                      String flightCode = objResultSet.getString("FLIGHT_NO");
                      String flightDesc = objResultSet.getString("FLIGHT_DESC");
                      FlightNumModel flightNoObj = new FlightNumModel(flightCode, flightDesc);
                     
                      ListOfFlightNo.add(flightNoObj);
                  
                  }
        	}
        	objPrepStmt.clearParameters();
        	objPrepStmt.close();
        } 
        catch (SQLException e)
        {
                e.printStackTrace();
        }
        finally
        {
        	dbConnection.close();
        }
        return ListOfFlightNo;
	}
	public static ArrayList<VisatypeModel> getVisatypes() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		
		ArrayList<VisatypeModel> ListOfVisatypes = null;
		PreparedStatement objPrepStmt = null;
        try
        {
        	dbConnection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PSWD);
        	objPrepStmt = dbConnection.prepareStatement("select VTYPE_SRNO,VTYPE_DESC from IM_VISA_TYPE");
        	ResultSet objResultSet = objPrepStmt.executeQuery();
        	if(objResultSet.isBeforeFirst())
        	{
        		ListOfVisatypes = new ArrayList<VisatypeModel>();
        		  while (objResultSet.next()) {
                      String visatypeCode = objResultSet.getString("VTYPE_SRNO");
                      String visatypeDesc = objResultSet.getString("VTYPE_DESC");
                      VisatypeModel visatypeObj = new VisatypeModel(visatypeCode, visatypeDesc);
                     
                      ListOfVisatypes.add(visatypeObj);
                  
                  }
        	}
        	objPrepStmt.clearParameters();
        	objPrepStmt.close();
        } 
        catch (SQLException e)
        {
                e.printStackTrace();
        }
        finally
        {
        	dbConnection.close();
        }
        return ListOfVisatypes;
	}
	public static ArrayList<ReasonTypeModel> getReasontypes() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		
		ArrayList<ReasonTypeModel> ListOfReasontypes = null;
		PreparedStatement objPrepStmt = null;
        try
        {
        	dbConnection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PSWD);
        	objPrepStmt = dbConnection.prepareStatement("select EC_DPRT_RSN_ID,EC_DPRT_RSN_DESC from IO_EC_DPRT_RSN_M where  IS_ROW_ACTIVE='Y'");
        	ResultSet objResultSet = objPrepStmt.executeQuery();
        	if(objResultSet.isBeforeFirst())
        	{
        		ListOfReasontypes = new ArrayList<ReasonTypeModel>();
        		  while (objResultSet.next()) {
                      String rsntypeCode = objResultSet.getString("EC_DPRT_RSN_ID");
                      String rsntypeDesc = objResultSet.getString("EC_DPRT_RSN_DESC");
                      ReasonTypeModel reasontypeObj = new ReasonTypeModel(rsntypeCode, rsntypeDesc);
                     
                      ListOfReasontypes.add(reasontypeObj);
                  
                  }
        	}
        	objPrepStmt.clearParameters();
        	objPrepStmt.close();
        } 
        catch (SQLException e)
        {
                e.printStackTrace();
        }
        finally
        {
        	dbConnection.close();
        }
        return ListOfReasontypes;
	}
	public static ArrayList<DutyBatchModel> getBatchType() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		
		ArrayList<DutyBatchModel> ListOfBatchTypes = null;
		PreparedStatement objPrepStmt = null;
        try
        {
        	dbConnection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PSWD);
        	objPrepStmt = dbConnection.prepareStatement("select BATCH_SHIFT_SR_NO,ICP_BATCH_SHIFT_DESC from IO_BATCH_SHIFT_R where ICP_SRNO='004'");
        	ResultSet objResultSet = objPrepStmt.executeQuery();
        	if(objResultSet.isBeforeFirst())
        	{
        		ListOfBatchTypes = new ArrayList<DutyBatchModel>();
        		  while (objResultSet.next()) {
                      String batchCode = objResultSet.getString("BATCH_SHIFT_SR_NO");
                      String batchDesc = objResultSet.getString("ICP_BATCH_SHIFT_DESC");
                      DutyBatchModel batchObj = new DutyBatchModel(batchCode, batchDesc);
                     
                      ListOfBatchTypes.add(batchObj);
                  
                  }
        	}
        	objPrepStmt.clearParameters();
        	objPrepStmt.close();
        } 
        catch (SQLException e)
        {
                e.printStackTrace();
        }
        finally
        {
        	dbConnection.close();
        }
        return ListOfBatchTypes;
	}
}
