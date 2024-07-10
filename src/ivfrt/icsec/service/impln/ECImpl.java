package ivfrt.icsec.service.impln;


import ivfrt.icsec.DB.ECDao;
import ivfrt.icsec.models.ECModel;
import ivfrt.icsec.service.intface.EcInf;

public class ECImpl implements EcInf {

	@Override
	public String saveECDts(ECModel objEc) throws Exception {
		String strServReply = "INSERT_FAILED";
		try 
		{
			strServReply = ECDao.insECVals(objEc);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return strServReply;
	
	}

}
