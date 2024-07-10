package ivfrt.icsec.facade;

import ivfrt.icsec.masters.IcsMasters;
import ivfrt.icsec.models.CountryModel;
import ivfrt.icsec.models.DutyBatchModel;
import ivfrt.icsec.models.ECType;
import ivfrt.icsec.models.FlightNumModel;
import ivfrt.icsec.models.ReasonTypeModel;
import ivfrt.icsec.models.VisatypeModel;

import java.util.ArrayList;

public class IcsMastersFac {
	public ArrayList<CountryModel> getListOfAllCountries()
	{
		ArrayList<CountryModel> ListOfCoun = null;
		ListOfCoun = new ArrayList<CountryModel>();
		try 
		{
			ListOfCoun = IcsMasters.getCountries();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return ListOfCoun;
	}
	public ArrayList<ECType> getListOfAllECTypes()
	{
		ArrayList<ECType> ListOfECType = null;
		ListOfECType = new ArrayList<ECType>();
		try 
		{
			ListOfECType = IcsMasters.getEcType();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return ListOfECType;
	}
	public ArrayList<FlightNumModel> getListOfAllFlights()
	{
		ArrayList<FlightNumModel> ListOfFlights = null;
		ListOfFlights = new ArrayList<FlightNumModel>();
		try 
		{
			ListOfFlights = IcsMasters.getFlightNo();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return ListOfFlights;
	}
	public ArrayList<VisatypeModel> getListOfAllVisatypes()
	{
		ArrayList<VisatypeModel> ListOfVisatypes = null;
		ListOfVisatypes = new ArrayList<VisatypeModel>();
		try 
		{
			ListOfVisatypes = IcsMasters.getVisatypes();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return ListOfVisatypes;
	}
	public ArrayList<ReasonTypeModel> getListOfAllRsntypes()
	{
		ArrayList<ReasonTypeModel> ListOfRsntypes = null;
		ListOfRsntypes = new ArrayList<ReasonTypeModel>();
		try 
		{
			ListOfRsntypes = IcsMasters.getReasontypes();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return ListOfRsntypes;
	}
	public ArrayList<DutyBatchModel> getListOfAllBatch()
	{
		ArrayList<DutyBatchModel> ListOfDutyBatch = null;
		ListOfDutyBatch = new ArrayList<DutyBatchModel>();
		try 
		{	ListOfDutyBatch = IcsMasters.getBatchType();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return ListOfDutyBatch;
	}
}
