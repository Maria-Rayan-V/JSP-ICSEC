package ivfrt.icsec.DB;

import ivfrt.icsec.constants.DBConfig;
import ivfrt.icsec.models.ECModel;



import ivfrt.icsec.utils.SharedStorage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;





public class ECDao {
	 static String DB_URL=DBConfig.OJDBC_URL;
	   static  String DB_USERNAME=DBConfig.DB_USERNAME;
	   static  String DB_PSWD=DBConfig.DB_PWD;
	   static Connection dbConnection = null;
	   static ResultSet rs = null;
	   static Statement stmt = null;
	   static int ecId = -1;
	public static String insECVals(ECModel objEC) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		
		PreparedStatement objPrepStmt = null;
		int RecAffc = 0;
		String ReplyString = "InsertInit";
        try
        {
        	dbConnection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PSWD);
            String sql = "INSERT INTO IO_EC_TRAN(BATCH_SHIFT_SR_NO, EC_PAX_NAME, EC_PAX_GENDER, EC_PAX_NALTY_CODE, EC_PAX_DOB, " +
                    "EC_PAX_BIRTH_PLACE, EC_PAX_PARENTAGE, EC_TYPE_CODE, EC_NUM, EC_ISSUE_PLACE, EC_ISSUE_DATE, EC_EXPRY_DATE, " +
                    "EC_VISA_NO, EC_VTYPE_SRNO, EC_VISA_ISSUE_PLACE, EC_VISA_ISSUE_DATE, EC_VISA_EXPRY_DATE, EC_VISA_ENTRIES, " +
                    "EC_OLD_PPT_NO, EC_OLD_PPT_ISSUE_PLACE, EC_OLD_PPT_ISSUE_DATE, EC_OLD_PPT_EXPRY_DATE, EC_PAX_ARVL_DATE, " +
                    "EC_PAX_ARVL_FLT_NO, EC_PAX_ARVD_FRM_CNTRY, EC_PAX_ARVD_FRM_PORT, EC_PAX_ABRD_ADDRS, EC_PAX_IND_ADDRS, " +
                    "EC_PAX_DEPRT_DATE, EC_PAX_DEPRT_PORT, EC_DPRT_RSN_ID, EC_DPRT_RSN_DESC, EC_PAX_ACTN_TAKN, " +
                    "EC_PAX_INTRGTD_BY, EC_PAX_IS_PRIDE_CHKD) " +
                    "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

       // Create prepared statement with ability to retrieve generated keys
       objPrepStmt = dbConnection.prepareStatement(sql, new String[] { "EC_ID" });
        	objPrepStmt.setString(1, objEC.getDutyBatch().trim());
        	objPrepStmt.setString(2, objEC.getPaxName().trim());
        	objPrepStmt.setString(3, objEC.getGender().trim());
        	objPrepStmt.setString(4, objEC.getNationality().trim());
//             objPrepStmt.set(5,objEC.getArrivalDate());
//             sysdate,'AIE161','AFG'
     	objPrepStmt.setDate(5,objEC.getDob());
       	objPrepStmt.setString(6, objEC.getPlaceOfBirth().trim());
      	objPrepStmt.setString(7, objEC.getParentage().trim());
    	objPrepStmt.setString(8, objEC.getEcType().trim());
        	objPrepStmt.setString(9, objEC.getEcNum().trim());
       	objPrepStmt.setString(10, objEC.getEcPlaceOfIssue().trim());
        	objPrepStmt.setDate(11, objEC.getEcIssueDate());
        	objPrepStmt.setDate(12, objEC.getEcExpiryDate());
        	objPrepStmt.setString(13, objEC.getVisaNum().trim());
        	objPrepStmt.setString(14, objEC.getVisatype().trim());
        	objPrepStmt.setString(15, objEC.getVisaPlace().trim());
        	objPrepStmt.setDate(16, objEC.getVisaIssueDate());
        	objPrepStmt.setDate(17, objEC.getVisaExpiryDate());
        	objPrepStmt.setString(18, objEC.getVisaEntries().trim());
        	objPrepStmt.setString(19, objEC.getOldPptNo().trim());
        	objPrepStmt.setString(20, objEC.getOldPptPlace().trim());
        	objPrepStmt.setDate(21, objEC.getOldPptIssueDate());
        	objPrepStmt.setDate(22, objEC.getOldPptExpiryDate());
        	objPrepStmt.setDate(23, objEC.getArrivalDate());
        	objPrepStmt.setString(24, objEC.getFlitSelectlist().trim());
//        	objPrepStmt.setString(25, objEC.getFlightNum().trim());
        	objPrepStmt.setString(25, objEC.getArrivalCtry().trim());
        	objPrepStmt.setString(26, objEC.getArrivalPort().trim());
        	objPrepStmt.setString(27, objEC.getAddrAbroad().trim());
        	objPrepStmt.setString(28, objEC.getAddrInd().trim());
        	objPrepStmt.setDate(29, objEC.getDeptDate());
        	objPrepStmt.setString(30, objEC.getDeptPort().trim());
        	objPrepStmt.setString(31, objEC.getReasonType().trim());
        	objPrepStmt.setString(32, objEC.getReasonDesc().trim());
        	objPrepStmt.setString(33, objEC.getAction().trim());
        	objPrepStmt.setString(34, objEC.getInterrogatedBy().trim());
        	objPrepStmt.setString(35, objEC.getPride().trim());
//        	
        	
        	RecAffc = objPrepStmt.executeUpdate();
        	 if (RecAffc > 0)
             {   	ReplyString = "EC Details Saved Successfully";
        		  rs = objPrepStmt.getGeneratedKeys();
                  if (rs.next()) {
                      ecId = rs.getInt(1);
                      SharedStorage.put("Ec_ID", ecId);
                      System.out.println("EC ID "+ SharedStorage.get("Ec_ID"));
                  }
             }
             else
             {
             	ReplyString = "Done";
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
       
		return ReplyString;
	}
	
	
}
