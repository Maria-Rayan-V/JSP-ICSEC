<%@ page import="java.sql.*, javax.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, javax.sql.*, ivfrt.icsec.DB.ECPdfDao,ivfrt.icsec.models.ECResModel" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Deportee Interrogation Form</title>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
            padding: 5px;
        }
        
        table {
            width: 100%;
        }
        .table-heading{
        	font-weight:bold;
        }
        #ec_form {
            display: none;
        }
       
        
    </style>
     <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/0.4.1/html2canvas.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.3.2/jspdf.min.js"></script>
</head>
<body>
<div class="form"  id="ec_form">
<h2>EC INTERROGATION FORM</h2>

<%
ECPdfDao pdfDao = new ECPdfDao();
ECResModel ec_model = pdfDao.getAllDeportees(); 
	
	if (ec_model != null ) {
	    
	%>
	<table >
    <tr>
    	
        <td>1. Name of The Pax</td>
        <td><%= ec_model.getPaxName() %></td>
    </tr>
    <tr>
        <td>2. Gender</td>
        <td><%= pdfDao.getGenderDescription(ec_model.getGender())  %></td>
    </tr>
    <tr>
        <td>3. Date of Birth</td>
        <td><%=  ec_model.getDob() %></td>
    </tr>
    <tr>
        <td>4. Place of Birth</td>
        <td><%= ec_model.getPlaceOfBirth() %></td>
    </tr>
    <tr>
        <td>5. Nationality</td>
        <td><%= pdfDao.getCountryDescription(ec_model.getNationality()) %> </td>
    </tr>
    <tr>
        <td>6. Parentage</td>
        <td><%= ec_model.getParentage() %></td>
    </tr>
     <tr>
        <td colspan="2" class="table-heading">7. EC Details</td>
       
    </tr>
    <tr>
        <td colspan="2">
            <table>
                <tr>
                    <th>EC Number</th>
                    <th>Place of Issue</th>
                    <th>Date of Issue</th>
                    <th>Date of Expiry</th>
                </tr>
                <tr>
                    <td><%= ec_model.getEcNum() %></td>
                    <td><%= ec_model.getEcPlaceOfIssue() %></td>
                    <td><%= ec_model.getEcIssueDate() %></td>
                    <td><%= ec_model.getEcExpiryDate() %></td>
                </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td colspan="2" class="table-heading">8. Old Passport Details</td>
    </tr>
    <tr>
        <td colspan="2">
            <table>
                <tr>
                    <th>Passport No</th>
                    <th>Place of Issue</th>
                    <th>Date of Issue</th>
                    <th>Date of Expiry</th>
                </tr>
                <tr>
                     <td><%= ec_model.getOldPptNo() %></td>
                    <td><%= ec_model.getOldPptPlace() %></td>
                    <td><%= ec_model.getOldPptIssueDate() %></td>
                    <td><%= ec_model.getOldPptExpiryDate() %></td>
                </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td colspan="2" class="table-heading">9. Visa Details(Foreigners only)</td>
       
    </tr>
    <tr>
        <td colspan="2">
            <table>
                <tr>
                    <th>Visa No</th>
                    <th>Type</th>
                    <th>Place of Issue</th>
                    <th>Date of Issue</th>
                    <th>Date of Expiry</th>
                </tr>
                <tr>
                <td><%= ec_model.getVisaNum() %></td>
                    <td><%= pdfDao.getVisaTypeDescription(ec_model.getVisatype())  %></td>
                    <td><%= ec_model.getVisaPlace() %></td>
                    <td><%= ec_model.getVisaIssueDate() %></td>
                    <td><%= ec_model.getVisaExpiryDate() %></td>
                   
                    
                </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <table>
           
                <tr>
                    <th> Departure Date</th>
                    <th>Departing Port</th>
                   
                </tr>
                <tr>
                     <td><%= ec_model.getDeptDate() %></td>
                    <td><%= ec_model.getDeptPort() %></td>
                </tr>
            </table>
        </td>
    </tr>
   
    <tr>
        <td colspan="2" class="table-heading">10. Arrival Details</td>
        
    </tr>
    <tr>
        <td colspan="2">
            <table>
                <tr>
                    <th>Arrival Country</th>
                    <th>Arrived Port</th>
                    <th>Arrived Flight Number</th>
                    <th>Arrived Date</th>
                </tr>
                <tr>
                    <td><%= pdfDao.getCountryDescription(ec_model.getArrivalCity()) %></td>
                    <td><%= ec_model.getArrivalPort() %></td>
                    <td><%= ec_model.getFlightNum() %></td>
                    <td><%= ec_model.getArrivalDate() %></td>
                </tr>
            </table>
        </td>
    </tr>

    <tr>
        <td>12. Reason for Obtaining EC</td>
       <td><%= pdfDao.getReasonDescription(ec_model.getReasonType())   %></td>
    </tr>
    <tr>
        <td>13. Description</td>
        <td><%= ec_model.getReasonDesc() %></td>
    </tr>
    <tr>
        <td>14. Action Taken</td>
        <td><%= ec_model.getAction() %></td>
    </tr>
    <tr>
        <td>15. Whether Checked in Pride Database</td>
        <td><%= pdfDao.getPrideDescription(ec_model.getPride())  %></td>
    </tr>
    <tr>
        <td>16. Address in India</td>
        <td><%= ec_model.getAddrInd() %></td>
    </tr>
</table>

<div>
    <p>Interrogated By: <%= ec_model.getInterrogatedBy() %></p>
    <p>Signature of the Pax Come on EC:</p>
    
</div>
</div>
 
	    <iframe id="pdfViewer" width="100%" height="900">
        This browser does not support PDFs. Please download the PDF to view it: 
       
    </iframe>
        
<%
    } else {
        out.println("No record found for the given ID.");
    }
%>


<script>
$(document).ready(function () {  
	ec_form.style.display = 'block';
    var form = $('.form'),     
    a4 = [595.28, 841.89]; // for a4 size paper width and height  
    createPDF();   
    function createPDF() { 
    	const ec_form = document.getElementById('ec_form');
    	
        getCanvas().then(function (canvas) {  
          
             doc = new jsPDF({  
                 unit: 'px',  
                 format: 'a4'  
             });  
             var img = canvas.toDataURL("image/png");
            doc.addImage(img, 'JPEG', 20, 20);  
        
             const pdfBlob = doc.output('blob');

            // Create an object URL for the Blob
            const pdfUrl = URL.createObjectURL(pdfBlob);

     		 document.getElementById('pdfViewer').src = pdfUrl;
       
     		ec_form.style.display = 'none';

        });  
    }  
      
    function getCanvas() {  
        form.width((a4[0] * 1.33333) - 80).css('max-width', 'none');  
        return html2canvas(form, {  
            imageTimeout: 2000,  
            removeContainer: true  
        });  
    }
});
</script>

</body>
</html>
