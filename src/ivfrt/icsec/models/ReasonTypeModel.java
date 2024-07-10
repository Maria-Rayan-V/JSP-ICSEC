package ivfrt.icsec.models;

public class ReasonTypeModel {
public ReasonTypeModel(String reasonType, String reasonDesc) {
		super();
		this.reasonType = reasonType;
		this.reasonDesc = reasonDesc;
	}
private String reasonType;
public String getReasonType() {
	return reasonType;
}
public void setReasonType(String reasonType) {
	this.reasonType = reasonType;
}
public String getReasonDesc() {
	return reasonDesc;
}
public void setReasonDesc(String reasonDesc) {
	this.reasonDesc = reasonDesc;
}
private String reasonDesc;
}
