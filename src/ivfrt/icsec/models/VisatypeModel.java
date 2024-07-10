package ivfrt.icsec.models;

public class VisatypeModel {
private String visatypeCode;
public VisatypeModel(String visatypeCode, String visatypeDesc) {
	super();
	this.visatypeCode = visatypeCode;
	this.visatypeDesc = visatypeDesc;
}
public String getVisatypeCode() {
	return visatypeCode;
}
public void setVisatypeCode(String visatypeCode) {
	this.visatypeCode = visatypeCode;
}
public String getVisatypeDesc() {
	return visatypeDesc;
}
public void setVisatypeDesc(String visatypeDesc) {
	this.visatypeDesc = visatypeDesc;
}
private String visatypeDesc;
}
