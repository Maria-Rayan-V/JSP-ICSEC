package ivfrt.icsec.servlets.ec;

import ivfrt.icsec.models.ECModel;
import ivfrt.icsec.models.VisatypeModel;
import ivfrt.icsec.service.impln.ECImpl;

import ivfrt.icsec.utils.DateUtils;
import ivfrt.icsec.utils.ValidationUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ecDts extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String servMsg;

	public ecDts() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<String> errors = new ArrayList<String>();

		String paxName = request.getParameter("txt_paxName");
		try {
			ValidationUtils.validateField(paxName, "Pax Name", errors, 100, "text", true);
		} catch (java.text.ParseException e1) {
			e1.printStackTrace();
		}

		String dutyBatch = request.getParameter("ddl_dutyBatch");
		try {
			ValidationUtils.validateField(dutyBatch, "Duty Batch", errors, 2, "select", true);
		} catch (java.text.ParseException e1) {
			e1.printStackTrace();
		}

		String nationality = request.getParameter("ddl_nationality");
		try {
			ValidationUtils.validateField(nationality, "Nationality", errors, 3, "select", true);
		} catch (java.text.ParseException e1) {
			e1.printStackTrace();
		}

		String flightNum = request.getParameter("ddl_flitSelectlist");
		try {
			ValidationUtils.validateField(flightNum, "Flight Number", errors, 10, "select", true);
		} catch (java.text.ParseException e1) {
			e1.printStackTrace();
		}

		String arriCountry = request.getParameter("ddl_arriCtry");
		try {
			ValidationUtils.validateField(arriCountry, "Arrival Country", errors, 3, "select", true);
		} catch (java.text.ParseException e1) {
			e1.printStackTrace();
		}
		String arriDate = request.getParameter("date_arrival");
		try {
			ValidationUtils.validateField(arriDate, "Arrival Date", errors, 10, "date", true);
		} catch (java.text.ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String genderStr = request.getParameter("ddl_gender");
		try {
			ValidationUtils.validateField(genderStr, "Gender", errors, 1, "text", false);
		} catch (java.text.ParseException e1) {
			e1.printStackTrace();
		}

		String dobStr = request.getParameter("date_dob");
		System.out.println("Date Of Birth" + dobStr);
		try {
			ValidationUtils.validateField(dobStr, "Date Of Birth", errors, 10, "date", false);
		} catch (java.text.ParseException e1) {
			e1.printStackTrace();
		}

		String birthPlace = request.getParameter("txt_placeOfBirth");
		try {
			ValidationUtils.validateField(birthPlace, "Place Of Birth", errors, 100, "text", false);
		} catch (java.text.ParseException e1) {
			e1.printStackTrace();
		}

		String parentageStr = request.getParameter("txt_parentage");
		try {
			ValidationUtils.validateField(parentageStr, "Parentage", errors, 40, "text", false);
		} catch (java.text.ParseException e1) {
			e1.printStackTrace();
		}

		String ecTypeStr = request.getParameter("ddl_ECType");
		try {
			ValidationUtils.validateField(ecTypeStr, "EC Type", errors, 3, "text", false);
		} catch (java.text.ParseException e1) {
			e1.printStackTrace();
		}

		String ecNumStr = request.getParameter("txt_ECno");
		try {
			ValidationUtils.validateField(ecNumStr, "EC Number", errors, 20, "text", false);
		} catch (java.text.ParseException e1) {
			e1.printStackTrace();
		}

		String ecPlaceStr = request.getParameter("txt_ECPlaceOfIss");
		try {
			ValidationUtils.validateField(ecPlaceStr, "EC Issue Place", errors, 30, "text", false);
		} catch (java.text.ParseException e1) {
			e1.printStackTrace();
		}

		String ecIssuStr = request.getParameter("date_ECIssue");
		try {
			ValidationUtils.validateField(ecIssuStr, "EC Issue Date", errors, 10, "date", false);
		} catch (java.text.ParseException e1) {
			e1.printStackTrace();
		}

		String ecExpirStr = request.getParameter("date_ECExpiry");
		try {
			ValidationUtils.validateField(ecExpirStr, "EC Expiry Date", errors, 10, "date", false);
		} catch (java.text.ParseException e1) {
			e1.printStackTrace();
		}

		String ecVisanoStr = request.getParameter("txt_visaNo");
		try {
			ValidationUtils.validateField(ecVisanoStr, "Visa Number", errors, 20, "text", false);
		} catch (java.text.ParseException e1) {
			e1.printStackTrace();
		}
		String ecVisatypeStr = request.getParameter("ddl_visatype");
		try {
			ValidationUtils.validateField(ecVisatypeStr, "Visatype", errors, 2, "number", false);
		} catch (java.text.ParseException e1) {
			e1.printStackTrace();
		}

		String visaPlaceStr = request.getParameter("txt_visaPlace");
		try {
			ValidationUtils.validateField(visaPlaceStr, "Visa Issue Place", errors, 100, "text", false);
		} catch (java.text.ParseException e1) {
			e1.printStackTrace();
		}

		String visaIssueStr = request.getParameter("date_visaIssue");
		try {
			ValidationUtils.validateField(visaIssueStr, "Visa Issue Date", errors, 10, "date", false);
		} catch (java.text.ParseException e1) {
			e1.printStackTrace();
		}
		String visaExpiryStr = request.getParameter("date_visaExpiry");
		try {
			ValidationUtils.validateField(visaExpiryStr, "Visa Expiry Date", errors, 10, "date", false);
		} catch (java.text.ParseException e1) {
			e1.printStackTrace();
		}

		String visaEntryStr = request.getParameter("txt_visaEntries");
		try {
			ValidationUtils.validateField(visaEntryStr, "Visa Entries", errors, 500, "text", false);
		} catch (java.text.ParseException e1) {
			e1.printStackTrace();
		}

		String oldPptNoStr = request.getParameter("txt_oldPptNo");
		try {
			ValidationUtils.validateField(oldPptNoStr, "Old Passport Number", errors, 20, "text", false);
		} catch (java.text.ParseException e1) {
			e1.printStackTrace();
		}

		String oldPptPlaceStr = request.getParameter("txt_oldPptPlace");
		try {
			ValidationUtils.validateField(oldPptPlaceStr, "Old Passport Issue Place", errors, 100, "text", false);
		} catch (java.text.ParseException e1) {
			e1.printStackTrace();
		}

		String oldPptIssStr = request.getParameter("date_oldPptIssue");
		try {
			ValidationUtils.validateField(oldPptIssStr, "Old Passport Issue Date", errors, 10, "date", false);
		} catch (java.text.ParseException e1) {
			e1.printStackTrace();
		}

		String oldPptExpStr = request.getParameter("date_oldPptExpiry");
		try {
			ValidationUtils.validateField(oldPptExpStr, "Old Passport Expiry Date", errors, 10, "date", false);
		} catch (java.text.ParseException e1) {
			e1.printStackTrace();
		}

		String arriPortStr = request.getParameter("txt_arriPort");
		try {
			ValidationUtils.validateField(arriPortStr, "Arrival Port", errors, 100, "text", false);
		} catch (java.text.ParseException e1) {
			e1.printStackTrace();
		}
		String addrAbrStr = request.getParameter("txtArea_addrAbroad");
		try {
			ValidationUtils.validateField(addrAbrStr, "Address Abroad", errors, 1000, "text", false);
		} catch (java.text.ParseException e1) {
			e1.printStackTrace();
		}

		String addrIndStr = request.getParameter("txtArea_addrIndia");
		try {
			ValidationUtils.validateField(addrIndStr, "Address India", errors, 1000, "text", false);
		} catch (java.text.ParseException e1) {
			e1.printStackTrace();
		}

		String deptDate = request.getParameter("date_dept");
		try {
			ValidationUtils.validateField(deptDate, "Departure Date", errors, 10, "date", false);
		} catch (java.text.ParseException e1) {
			e1.printStackTrace();
		}

		String deptPort = request.getParameter("txt_deptPort");
		try {
			ValidationUtils.validateField(deptPort, "Departure Port", errors, 100, "text", false);
		} catch (java.text.ParseException e1) {
			e1.printStackTrace();
		}

		String deptRsn = request.getParameter("ddl_reasonType");
		try {
			ValidationUtils.validateField(deptRsn, "Departure Reason", errors, 2, "number", false);
		} catch (java.text.ParseException e1) {
			e1.printStackTrace();
		}

		String deptRsnDesc = request.getParameter("txtArea_reasonDesc");
		try {
			ValidationUtils.validateField(deptRsnDesc, "Departure Reason Description", errors, 500, "text", false);
		} catch (java.text.ParseException e1) {
			e1.printStackTrace();
		}

		String actionTkn = request.getParameter("txt_action");
		try {
			ValidationUtils.validateField(actionTkn, "Action", errors, 300, "text", false);
		} catch (java.text.ParseException e1) {
			e1.printStackTrace();
		}

		String intBy = request.getParameter("txt_interrogatedBy");
		try {
			ValidationUtils.validateField(intBy, "Interrogated By", errors, 100, "text", false);
		} catch (java.text.ParseException e1) {
			e1.printStackTrace();
		}

		String pride = request.getParameter("txt_pride");
		try {
			ValidationUtils.validateField(pride, "Pride", errors, 1, "text", false);
		} catch (java.text.ParseException e1) {
			e1.printStackTrace();
		}

		if (!errors.isEmpty()) {
			request.setAttribute("errors", errors);
			RequestDispatcher objReqDisptcher = request.getRequestDispatcher("index.jsp");
			objReqDisptcher.forward(request, response);
			return;
		}
		ECModel ecDtsObj = null;
		ecDtsObj = new ECModel();

		ecDtsObj.setPaxName(paxName);
		ecDtsObj.setDutyBatch(dutyBatch);
		ecDtsObj.setGender(genderStr);
		ecDtsObj.setNationality(nationality);
		String dobString = (request.getParameter("date_dob"));
		System.out.println("Date bef" + request.getParameter("date_dob"));
		java.sql.Date dobDate = DateUtils.convertStringToSqlDate(dobString);

		System.out.println("Date aft" + dobDate);
		ecDtsObj.setDob(dobDate);
		ecDtsObj.setPlaceOfBirth(birthPlace);
		ecDtsObj.setParentage(parentageStr);
		ecDtsObj.setEcType(ecTypeStr);
		ecDtsObj.setEcNum(ecNumStr);
		ecDtsObj.setEcPlaceOfIssue(ecPlaceStr);
		// ecDtsObj.setEcIssueDate(request.getParameter("date_ECIssue"));
		String ecIssuString = (request.getParameter("date_ECIssue"));

		java.sql.Date ecIssueDate = DateUtils.convertStringToSqlDate(ecIssuString);

		ecDtsObj.setEcIssueDate(ecIssueDate);

		String ecExpStr = (request.getParameter("date_ECExpiry"));

		java.sql.Date ecExpiryDate = DateUtils.convertStringToSqlDate(ecExpStr);

		ecDtsObj.setEcExpiryDate(ecExpiryDate);
		ecDtsObj.setVisaNum(ecVisanoStr);
		ecDtsObj.setVisatype(ecVisatypeStr);
		ecDtsObj.setVisaPlace(visaPlaceStr);
		//
		String visaIssueString = (request.getParameter("date_visaIssue"));

		java.sql.Date visaIssueDate = DateUtils.convertStringToSqlDate(visaIssueString);

		ecDtsObj.setVisaIssueDate(visaIssueDate);

		String visaExpiryString = (request.getParameter("date_visaExpiry"));

		java.sql.Date visaExpiryDate = DateUtils.convertStringToSqlDate(visaExpiryString);

		ecDtsObj.setVisaExpiryDate(visaExpiryDate);
		ecDtsObj.setVisaEntries(visaEntryStr);
		ecDtsObj.setOldPptNo(oldPptNoStr);
		ecDtsObj.setOldPptPlace(oldPptPlaceStr);

		String oldPptIssString = (request.getParameter("date_oldPptIssue"));

		java.sql.Date oldPptIssDate = DateUtils.convertStringToSqlDate(oldPptIssString);

		ecDtsObj.setOldPptIssueDate(oldPptIssDate);

		String oldPptExpString = (request.getParameter("date_oldPptExpiry"));

		java.sql.Date oldPptExpDate = DateUtils.convertStringToSqlDate(oldPptExpString);

		ecDtsObj.setOldPptExpiryDate(oldPptExpDate);
		//
		String arriStr = (request.getParameter("date_arrival"));

		java.sql.Date arrivalDate = DateUtils.convertStringToSqlDate(arriStr);

		ecDtsObj.setArrivalDate(arrivalDate);
		ecDtsObj.setFlitSelectlist(flightNum);
		//// ecDtsObj.setFlightNum(request.getParameter("txt_flitNo"));
		ecDtsObj.setArrivalCtry(arriCountry);
		ecDtsObj.setArrivalPort(arriPortStr);
		ecDtsObj.setAddrAbroad(addrAbrStr);
		ecDtsObj.setAddrInd(addrIndStr);

		String deptDtStr = (request.getParameter("date_dept"));

		java.sql.Date deptDateFormatted = DateUtils.convertStringToSqlDate(deptDtStr);

		ecDtsObj.setDeptDate(deptDateFormatted);
		ecDtsObj.setDeptPort(deptPort);
		ecDtsObj.setReasonType(deptRsn);
		ecDtsObj.setReasonDesc(deptRsnDesc);
		ecDtsObj.setAction(actionTkn);
		ecDtsObj.setInterrogatedBy(intBy);
		ecDtsObj.setPride(pride);
		//
		ECImpl infEcObj = new ECImpl();

		try {
			servMsg = infEcObj.saveECDts(ecDtsObj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if ("EC Details Saved Successfully".equals(servMsg)) {
			response.sendRedirect("index.jsp?status=success");
		} else {
			request.setAttribute("frmActn", servMsg);
			request.setAttribute("statusMessage", servMsg);
			RequestDispatcher objReqDisptcher = request.getRequestDispatcher("index.jsp");
			objReqDisptcher.forward(request, response);
		}
	}
}
