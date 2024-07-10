package ivfrt.icsec.models;

public class FlightNumModel {
private String flightCode;
public FlightNumModel(String flightCode, String flightDesc) {
	super();
	this.flightCode = flightCode;
	this.flightDesc = flightDesc;
}
public String getFlightCode() {
	return flightCode;
}
public void setFlightCode(String flightCode) {
	this.flightCode = flightCode;
}
public String getFlightDesc() {
	return flightDesc;
}
public void setFlightDesc(String flightDesc) {
	this.flightDesc = flightDesc;
}
private String flightDesc;
}
