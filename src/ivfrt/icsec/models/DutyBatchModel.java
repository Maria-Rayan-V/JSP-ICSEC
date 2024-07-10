package ivfrt.icsec.models;

public class DutyBatchModel {
 private String dutyBatchCode;
 public DutyBatchModel(String dutyBatchCode, String dutyBatchDesc) {
	super();
	this.dutyBatchCode = dutyBatchCode;
	this.dutyBatchDesc = dutyBatchDesc;
}
public String getDutyBatchCode() {
	return dutyBatchCode;
}
public void setDutyBatchCode(String dutyBatchCode) {
	this.dutyBatchCode = dutyBatchCode;
}
public String getDutyBatchDesc() {
	return dutyBatchDesc;
}
public void setDutyBatchDesc(String dutyBatchDesc) {
	this.dutyBatchDesc = dutyBatchDesc;
}
private String dutyBatchDesc;
}
