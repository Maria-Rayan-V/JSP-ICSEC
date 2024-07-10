  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
   <%@ page language="java" session="true" contentType="text/html; charset=UTF-8" import="java.util.Iterator,java.util.List,ivfrt.icsec.facade.IcsMastersFac" pageEncoding="UTF-8" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Refusal Entry</title>
<script>
$(document).ready(function() {
    // Initialize form validation
    $("#ecForm").validate({
    	rules: {
    	    ddl_dutyBatch: {    
    	        required: true,
    	        maxlength: 2,
    	        digits:true
    	    },
    	    txt_paxName: {
    	        required: true,
    	        maxlength: 100
    	    },
    	    ddl_gender: {
    	        maxlength:1
    	    },
    	    ddl_nationality: {
    	        required: true,
    	        maxlength:3
    	    },
    	    date_dob: {
    	       
    	        date:true
    	    },
    	    txt_placeOfBirth: {
    	       
    	        maxlength: 1000
    	    },
    	    txt_parentage: {
    	       
    	        maxlength: 40
    	    },
    	    ddl_ECType: {
    	        maxlength:3
    	    },
    	    txt_ECno: {
    	      
    	        maxlength: 30
    	    },
    	    txt_ECPlaceOfIss: {
    	      
    	        maxlength: 30
    	    },
    	    date_ECIssue: {
    	        date:true
    	    },
    	    date_ECExpiry: {
    	        date:true
    	    },
    	    txt_visaNo: {
    	      
    	        maxlength: 20
    	    },
    	    ddl_visatype: {
    	        digits:true,
    	        maxlength:2
    	    },
    	    txt_visaPlace: {
    	      maxlength:100
    	    },
    	    date_visaIssue: {
    	     
    	        date: true
    	    },
    	    date_visaExpiry: {
    	       
    	        date: true
    	    },
    	    txt_visaEntries: {
    	      
    	        maxlength:500
    	    },
    	    txt_oldPptNo: {
    	        maxlength:20
    	    },
    	    txt_oldPptPlace: {
    	        maxlength:100
    	    },
    	    date_oldPptIssue: {
    	      
    	        date: true
    	    },
    	    date_oldPptExpiry: {
    	     
    	        date: true
    	    },
    	    date_arrival: {
    	        required: true,
    	        date: true
    	    },
    	    ddl_flitSelectlist: {
    	        required: true,
    	        maxlength:2
    	    },
    	    txt_flitNo: {
    	      
    	    },
    	    ddl_arriCtry: {
    	        required: true,
    	        maxlength:3
    	    },
    	    txt_arriPort: {
    	       maxlength:100
    	    },
    	    txtArea_addrAbroad: {
    	        maxlength:1000
    	    },
    	    txtArea_addrIndia: {
    	        maxlength:1000
    	    },
    	    date_dept: {
    	      
    	        date: true
    	    },
    	    txt_deptPort: {
    	      maxlength:100
    	    },
    	    ddl_reasonType: {
    	      digits:true,
    	      maxlength:2
    	    },
    	    txtArea_reasonDesc: {
    	       maxlength:500
    	    },
    	    txt_action: {
    	        maxlength:300
    	    },
    	    txt_interrogatedBy: {
    	        maxlength:100
    	    },
    	    txt_pride: {
    	       maxlength:1
    	    }

    	},
    	messages: {
    	     ddl_dutyBatch: {
    	            required: "Please enter your Duty Batch",
    	            maxlength: "Maximum 2 characters allowed for Duty Batch",
    	            digits:"Only numbers allowed for Duty Batch"
    	        },
    	        txt_paxName: {
    	            required: "Please enter your Pax Name",
    	            maxlength: "Maximum 100 characters allowed for Pax Name"
    	        },
    	        ddl_gender: {
    	            // required: "Please select your Gender",
    	             maxlength: "Maximum 1 character allowed for Gender"
    	        },
    	        ddl_nationality: {
    	            required: "Please select your Nationality",
    	            maxlength: "Maximum 3 character allowed for Nationality"
    	        },
    	        date_dob: {
    	            // required: "Please enter your Date of Birth",
    	           date: "Please enter a valid date"
    	        },
    	        txt_placeOfBirth: {
    	            // required: "Please enter your Place of Birth",
    	            maxlength: "Maximum 1000 characters allowed for Place of Birth"
    	        },
    	        txt_parentage: {
    	            // required: "Please enter your Parentage",
    	            maxlength: "Maximum 40 characters allowed for Parentage"
    	        },
    	        ddl_ECType: {
    	              maxlength: "Maximum 3 characters allowed for EC Type"
    	        },
    	        txt_ECno: {
    	            // required: "Please enter your EC Number",
    	            maxlength: "Maximum 30 characters allowed for EC Number"
    	        },
    	        txt_ECPlaceOfIss: {
    	            // required: "Please enter your EC Place of Issue",
    	            maxlength: "Maximum 30 characters allowed for EC Place of Issue"
    	        },
    	        date_ECIssue: {
    	            // required: "Please enter your EC Date of Issue"
    	            date: "Please enter a valid date"
    	        },
    	        date_ECExpiry: {
    	             date: "Please enter a valid date"
    	        },
    	        txt_visaNo: {
    	            // required: "Please enter your Visa Number",
    	            maxlength: "Maximum 20 characters allowed for Visa Number"
    	        },
    	        ddl_visatype: {
    	            maxlength:"Maximum 2 characters allowed for Visatype",
    	            digits:"Only Numbers Allowed"
    	        },
    	        txt_visaPlace: {
    	            maxlength:"Maximum 100 characters allowed for Visa Issue Place",
    	        },
    	        date_visaIssue: {
    	           
    	            date: "Please enter a valid date"
    	        },
    	        date_visaExpiry: {
    	           
    	            date: "Please enter a valid date"
    	        },
    	        txt_visaEntries: {
    	            maxlength:"Maximum 500 characters allowed for Visa Entries",
    	        },
    	        txt_oldPptNo: {
    	            maxlength:"Maximum 20 characters allowed for Old Passport Number",
    	        },
    	        txt_oldPptPlace: {
    	            maxlength:"Maximum 100 characters allowed for Old Passport Issue Place",
    	        },
    	        date_oldPptIssue: {
    	          
    	            date: "Please enter a valid date"
    	        },
    	        date_oldPptExpiry: {
    	           
    	            date: "Please enter a valid date"
    	        },
    	        date_arrival: {
    	            required: "Please enter the arrival date",
    	            date: "Please enter a valid date"
    	        },
    	        ddl_flitSelectlist: {
    	            required: "Please select the arrival flight number",
    	            maxlength:"Maximum 2 characters allowed for arrival flight number",
    	        },
    	        txt_flitNo: {
    	            required: "Please enter the arrival flight number"
    	        },
    	        ddl_arriCtry: {
    	            required: "Please select the arrived from country",
    	               maxlength: "Maximum 3 characters allowed for arrived from country"
    	        },
    	        txt_arriPort: {
    	          
    	              maxlength: "Maximum 100 characters allowed for arrived from port"
    	        },
    	        txtArea_addrAbroad: {
    	       
    	              maxlength: "Maximum 100 characters allowed for address abroad"
    	        },
    	        txtArea_addrIndia: {
    	          
    	                maxlength: "Maximum 100 characters allowed for address in India"
    	        },
    	        date_dept: {
    	           
    	            date: "Please enter a valid date"
    	        },
    	        txt_deptPort: {
    	             maxlength: "Maximum 500 characters allowed for departure port"
    	        },
    	        ddl_reasonType: {
    	          digits:"Only numbers allowed for Reason Type",
    	            maxlength: "Maximum 2 characters allowed for Reason Type"
    	        },
    	        txtArea_reasonDesc: {
    	           
    	             maxlength: "Maximum 500 characters allowed for reason description"
    	        },
    	        txt_action: {
    	          
    	            maxlength: "Maximum 500 characters allowed for action taken"
    	        },
    	        txt_interrogatedBy: {
    	        
    	              maxlength: "Maximum 100 characters allowed for the name of the person who interrogated"
    	        },
    	        txt_pride: {
    	           
    	               maxlength: "Maximum 1 characters allowed for pride check status"
    	        }
    	},
        errorElement: 'label',
        errorPlacement: function(error, element) {
            error.addClass('error-message');
            error.insertAfter(element); // Always insert error message after the element
        },
        highlight: function(element) {
            $(element).closest('.form-group').addClass('has-error');
        },
        unhighlight: function(element) {
            $(element).closest('.form-group').removeClass('has-error');
        },
        onfocusout: function(element) {
            this.element(element); // Trigger validation on focus out
        }
    });

    // Handle form submission
    $("#ecForm").submit(function(event) {
        // Perform validation
        if (!$(this).valid()) {
            event.preventDefault(); // Prevent the form from submitting

            console.log('Form is invalid in if:', $(this).valid());
         

            // Show the modal with error messages (optional)
         //   $('#errorModal').modal('show');
        } else {
            // Form is valid, proceed with form submission
            console.log('Form is valid in else:', $(this).valid());
           

            // Optionally, you can perform additional checks here before submission

            // If you want to proceed with submission after the alert, uncomment the line below:
            // return true;
        }
    });

    // Handle modal close event
    $('#errorModal').on('hidden.bs.modal', function() {
        // If form was invalid, keep error messages
        if (!$("#ecForm").valid()) {
            $("#ecForm").validate().showErrors();
        }
    });
});
</script>
</head>
<body>

    <br>
  <form id="refusalForm" action="refusalSave" method="post" onsubmit="return toUpperCaseForm();">
    <h2>IO Module - Refusal Entry</h2>
    <p class="form-instructions">Please fill out the form below. Fields marked with an asterisk (<span class="required-asterisk">*</span>) are required.</p>
      <jsp:useBean id="ObjIcsMstrs" scope="request" type="ivfrt.icsec.facade.IcsMastersFac" class="ivfrt.icsec.facade.IcsMastersFac" />
<div class="container">
    <div class="row">  
        <div class="col-md-6">
        <div class="form-group">
            <label for="ddl_dutyBatch">Duty Batch:<span class="required-asterisk">*</span></label>
            <select id="ddl_dutyBatch" name="ddl_dutyBatch" class="form-control">
                <option value="">-- Select --</option>
                <c:forEach var="Flg" items="${ObjIcsMstrs.listOfAllBatch}">
                    <option value="${Flg.dutyBatchCode}" <c:if test="${param.ddl_dutyBatch eq Flg.dutyBatchCode}">selected</c:if>>${Flg.dutyBatchDesc}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="col-md-6">
        <div class="form-group">
            <label for="ddl_carrierLiability">CARRIER LIABILITY ISSUED:</label>
            <select id="ddl_carrierLiability" name="ddl_carrierLiability" class="form-control">
                <option value="">-- Select --</option>
                <c:forEach var="Flg" items="${ObjIcsMstrs.listOfAllBatch}">
                    <option value="${Flg.dutyBatchCode}" <c:if test="${param.ddl_carrierLiability eq Flg.dutyBatchCode}">selected</c:if>>${Flg.dutyBatchDesc}</option>
                </c:forEach>
            </select>
        </div>
    </div>
</div>
  
    <div class="row">
        <div class="col-md-12">
            <h5 >Personal Information</h5>
        </div>
    </div>
    <div class="row">
      <div class="col-md-4">
        <div class="form-group">
            <label for="txt_paxName">Pax Name:<span class="required-asterisk">*</span></label>
            <input value="${param.txt_paxName}" type="text" id="txt_paxName" name="txt_paxName" class="form-control" />
        </div>
      </div>
       
      <div class="col-md-4">
        <div class="form-group">
            <label for="txt_surname">Surname:</label>
            <input value="${param.txt_surname}" type="text" id="txt_surname" name="txt_surname" class="form-control" />
        </div>
      </div>
  
        <div class="col-md-4">
            <div class="form-group">
                <label for="ddl_gender">Gender:<span class="required-asterisk"></span></label>
                <select id="ddl_gender" name="ddl_gender" class="form-control">
                    <option value="">-- Select --</option>
                    <option value="M" <c:if test="${param.ddl_gender eq 'M'}">selected</c:if>>Male</option>
                    <option value="F" <c:if test="${param.ddl_gender eq 'F'}">selected</c:if>>Female</option>
                </select>
            </div>
        </div>
        <div class="col-md-4">
            <div class="form-group">
                <label for="ddl_nationality">Nationality:<span class="required-asterisk">*</span></label>
                <select id="ddl_nationality" name="ddl_nationality" class="form-control">
                    <option value="">-- Select --</option>
                    <c:forEach var="Flg" items="${ObjIcsMstrs.listOfAllCountries}">
                        <option value="${Flg.countryCode}" <c:if test="${param.ddl_nationality eq Flg.countryCode}">selected</c:if>>${Flg.countryDesc}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6">
            <div class="form-group">
                <label for="date_dob">Date Of Birth:</label>
                <input value="${param.date_dob}" max="<%= new SimpleDateFormat("yyyy-MM-dd").format(new Date()) %>"  type="date" id="date_dob" name="date_dob" class="form-control">
            </div>
        </div>
        <div class="col-md-6">
            <div class="form-group">
                <label for="txt_placeOfBirth">Place Of Birth:</label>
                <input value="${param.txt_placeOfBirth}" type="text" id="txt_placeOfBirth" name="txt_placeOfBirth" class="form-control" />
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6">
            <div class="form-group">
                <label for="txt_parentage">Parentage:</label>
                <input value="${param.txt_parentage}" type="text" id="txt_parentage" name="txt_parentage" class="form-control" />
            </div>
        </div>
    </div>
   <!--  Passport Details -->
   <div class="row">
    <div class="col-md-12">
        <h5>Passport Details</h5>
    </div>
</div>
<div class="row">
    <div class="col-md-6">
        <div class="form-group">
            <label for="txt_PptNo">Passport Number:</label>
            <input value="${param.txt_PptNo}" type="text" id="txt_PptNo" name="txt_PptNo" class="form-control" />
        </div>
    </div>
    <div class="col-md-6">
        <div class="form-group">
            <label for="txt_PptPlace"> Passport Place Of Issue:</label>
            <input value="${param.txt_PptPlace}" type="text" id="txt_PptPlace" name="txt_PptPlace" class="form-control" />
        </div>
    </div>
  
   
</div>
<div class="row">
<div class="col-md-6">
    <div class="form-group">
        <label for="date_PptIssue"> Passport Issue Date:</label>
        <input value="${param.date_PptIssue}" max="<%= new SimpleDateFormat("yyyy-MM-dd").format(new Date()) %>" type="date" id="date_PptIssue" name="date_PptIssue" class="form-control" />
    </div>
</div>
<div class="col-md-6">
    <div class="form-group">
        <label for="date_PptExpiry"> Passport Expiry Date:</label>
        <input value="${param.date_PptExpiry}" min="<%= new SimpleDateFormat("yyyy-MM-dd").format(new Date()) %>"  type="date" id="date_PptExpiry" name="date_PptExpiry" class="form-control" />
    </div>
</div>
</div>
    <!-- Visa Details -->
    <div class="row">
        <div class="col-md-12">
            <h5>Visa Details</h5>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4">
            <div class="form-group">
                <label for="txt_visaNo">Visa Number:</label>
                <input value="${param.txt_visaNo}" type="text" id="txt_visaNo" name="txt_visaNo" class="form-control" />
            </div>
        </div>
        <div class="col-md-4">
            <div class="form-group">
                <label for="ddl_visatype">Visa Type:</label>
                <select id="ddl_visatype" name="ddl_visatype" class="form-control">
                    <option value="">Select...</option>
                    <c:forEach var="Flg" items="${ObjIcsMstrs.listOfAllVisatypes}">
                        <option value="${Flg.visatypeCode}" <c:if test="${param.ddl_visatype eq Flg.visatypeCode}">selected</c:if>>${Flg.visatypeDesc}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="col-md-4">
            <div class="form-group">
                <label for="txt_visaPlace">Visa Place Of Issue:</label>
                <input value="${param.txt_visaPlace}" type="text" id="txt_visaPlace" name="txt_visaPlace" class="form-control" />
            </div>
        </div>
       
    </div>
    <div class="row">
        <div class="col-md-6">
            <div class="form-group">
                <label for="date_visaIssue">Visa Issue Date:</label>
                <input value="${param.date_visaIssue}" max="<%= new SimpleDateFormat("yyyy-MM-dd").format(new Date()) %>"  type="date" id="date_visaIssue" name="date_visaIssue" class="form-control" />
            </div>
        </div>
        <div class="col-md-6">
            <div class="form-group">
                <label for="date_visaExpiry">Visa Expiry Date:</label>
                <input value="${param.date_visaExpiry}" min="<%= new SimpleDateFormat("yyyy-MM-dd").format(new Date()) %>" type="date" id="date_visaExpiry" name="date_visaExpiry" class="form-control" />
            </div>
        </div>
      
        
    </div>
      <div class="row">
        <div class="col-md-6">
          
                <div class="form-group">
                    <label for="txt_visaEntries">Visa Entries:</label>
                    <input value="${param.txt_visaEntries}" type="text" id="txt_visaEntries" name="txt_visaEntries" class="form-control" />
                </div>
           
        </div>

      </div>
  <!-- Reason Description -->
  <div class="row">
    <div class="col-md-4">
        <div class="form-group">
            <label for="ddl_reasonType">Reason Type:</label>
            <select id="ddl_reasonType" name="ddl_reasonType" class="form-control">
                <option value="">-- Select --</option>
                <c:forEach var="Flg" items="${ObjIcsMstrs.listOfAllRsntypes}">
                    <option value="${Flg.reasonType}" <c:if test="${param.ddl_reasonType eq Flg.reasonType}">selected</c:if>>${Flg.reasonDesc}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="col-md-4">
        <div class="form-group">
            <label for="txtArea_reasonDesc">Reason Description:</label>
            <textarea id="txtArea_reasonDesc" name="txtArea_reasonDesc" rows="2" cols="33" class="form-control">${param.txtArea_reasonDesc}</textarea>
        </div>
    </div>
 <div class="col-md-4">
   <div class="form-group">
    <label for="txtArea_docsDesc">Description of PPT/Documents:</label>
    <textarea id="txtArea_docsDesc" name="txtArea_docsDesc" rows="2" cols="33" class="form-control">${param.txtArea_docsDesc}</textarea>
   </div>
 </div>  
</div>

  <!-- Arrival Details -->
    <div class="row">
        <div class="col-md-12">
            <h5>Arrival Details</h5>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6">
            <div class="form-group">
                <label for="date_arrival">Arrival Date:<span class="required-asterisk">*</span></label>
                <input value="${param.date_arrival}" max="<%= new SimpleDateFormat("yyyy-MM-dd").format(new Date()) %>"  type="date" id="date_arrival" name="date_arrival" class="form-control" />
            </div>
        </div>
        <div class="col-md-6">
            <div class="form-group">
                <label for="ddl_flitSelectlist">Arrival Flight Number :<span class="required-asterisk">*</span></label>
                <select id="ddl_flitSelectlist" name="ddl_flitSelectlist" class="form-control">
                    <option value="">Select...</option>
                    <c:forEach var="Flg" items="${ObjIcsMstrs.listOfAllFlights}">
                        <option value="${Flg.flightCode}" <c:if test="${param.ddl_flitSelectlist eq Flg.flightCode}">selected</c:if>>${Flg.flightDesc}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
     
    </div>



    <!-- Departure Details -->
    <div class="row">
        <div class="col-md-12">
            <h5>Departure Details</h5>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6">
            <div class="form-group">
                <label for="txt_airlines">Airlines:</label>
                <input value="${param.txt_airlines}" type="text" id="txt_airlines" name="txt_airlines" class="form-control" />
            </div>
        </div>
        <div class="col-md-6">
            <div class="form-group">
                <label for="txt_sendBackTo">Send Back To:</label>
                <input value="${param.txt_sendBackTo}" type="text" id="txt_sendBackTo" name="txt_sendBackTo" class="form-control" />
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6">
            <div class="form-group">
                <label for="ddl_sendBackflit">Send Back Flight Number :<span class="required-asterisk">*</span></label>
                <select id="ddl_sendBackflit" name="ddl_sendBackflit" class="form-control">
                    <option value="">Select...</option>
                    <c:forEach var="Flg" items="${ObjIcsMstrs.listOfAllFlights}">
                        <option value="${Flg.flightCode}" <c:if test="${param.ddl_sendBackflit eq Flg.flightCode}">selected</c:if>>${Flg.flightDesc}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="col-md-6">
            <div class="form-group">
                <label for="date_sendBackDate">Send Back Date:<span class="required-asterisk">*</span></label>
                <input value="${param.date_sendBackDate}" max="<%= new SimpleDateFormat("yyyy-MM-dd").format(new Date()) %>"  type="date" id="date_sendBackDate" name="date_sendBackDate" class="form-control" />
            </div>
        </div>
   
    </div>
  <div class="row">
    <div class="col-md-6">
        <div class="form-group">
            <label for="txt_icaoAirport">Icao Airport:</label>
            <input value="${param.txt_icaoAirport}" type="text" id="txt_icaoAirport" name="txt_icaoAirport" class="form-control" />
        </div>
    </div>
    <div class="col-md-6">
        <div class="form-group">
            <label for="ddl_icaoCtry">Icao Country:<span class="required-asterisk">*</span></label>
            <select id="ddl_icaoCtry" name="ddl_icaoCtry" class="form-control">
                <option value="">-- Select --</option>
                <c:forEach var="Flg" items="${ObjIcsMstrs.listOfAllCountries}">
                    <option value="${Flg.countryCode}" <c:if test="${param.ddl_icaoCtry eq Flg.countryCode}">selected</c:if>>${Flg.countryDesc}</option>
                </c:forEach>
            </select>
        </div>
    </div>
  </div>
    <div class="row">
        <div class="col-md-6">
            <div class="form-group">
                <label for="ddl_icaoCtry">Refused Deported:<span class="required-asterisk">*</span></label>
                <select id="ddl_icaoCtry" name="ddl_icaoCtry" class="form-control">
                    <option value="">-- Select --</option>
                    <c:forEach var="Flg" items="${ObjIcsMstrs.listOfAllCountries}">
                        <option value="${Flg.countryCode}" <c:if test="${param.ddl_icaoCtry eq Flg.countryCode}">selected</c:if>>${Flg.countryDesc}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
    </div>
</div>
       
     <div class="button-container">
    <button type="submit"  tabindex="8"  style="background-color: #007bff; /* Blue */
      border: none;
      color: white;
      padding: 15px 32px;
      text-align: center;
      text-decoration: none;
      display: inline-block;
      font-size: 16px;
      margin: 4px 2px;
      transition-duration: 0.4s;
      cursor: pointer;
      border-radius: 8px;">Save</button>
</div>


       	<input   type="hidden" id="hdnClickEvent" name="hdnClickEvent" value="EcEntry:SearchByName"></input>
    </form>
 <div class="modal fade" id="errorModal" tabindex="-1" role="dialog" aria-labelledby="errorModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="errorModalLabel">Validation Errors</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <ul>
                    <c:forEach items="${errors}" var="error">
                        <li>${error}</li>
                    </c:forEach>
                </ul>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

<!-- JavaScript to populate form fields and show modal -->
<c:if test="${not empty errors}">
    <script type="text/javascript">
        $(document).ready(function() {
            // Populate form fields with stored data
            var formData = localStorage.getItem('formData');
            if (formData) {
                $('#ecForm').deserialize(formData);
            }

            // Show modal
            $('#errorModal').modal('show');
        });
    </script>
</c:if><div class="modal fade" id="successModal" tabindex="-1" role="dialog" aria-labelledby="successModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h6 class="modal-title" id="successModalLabel">Success</h6>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                EC Details Saved Successfully.
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="viewDetails()">Generate Pdf</button>
            </div>
        </div>
    </div>
</div>


<script>
    function viewDetails() {
        //window.location.href = 'JSPFiles/pdf-generator.jsp'; // This navigates to pdf-generator.jsp in the current window
         window.open('JSPFiles/pdf-generator.jsp', '_blank'); // Uncomment this line if you want to open it in a new tab
    }
</script>
    <script>
        // Check if status=success in URL
        const urlParams = new URLSearchParams(window.location.search);
        if (urlParams.get('status') === 'success') {
            $('#successModal').modal('show');
        }
    </script>
</body>
</html>