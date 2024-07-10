package ivfrt.icsec.models;

public class ECType {
	 private String ecTypeCode;
	    public String getEcTypeCode() {
		return ecTypeCode;
	}
	public void setEcTypeCode(String ecTypeCode) {
		this.ecTypeCode = ecTypeCode;
	}
	public String getEcTypeDesc() {
		return ecTypeDesc;
	}
	public void setEcTypeDesc(String ecTypeDesc) {
		this.ecTypeDesc = ecTypeDesc;
	}
		private String ecTypeDesc;
		public ECType() {
			super();
			ecTypeCode=null;
			ecTypeDesc=null;
			// TODO Auto-generated constructor stub
		}
		public ECType(String ecTypeCode, String ecTypeDesc) {
			super();
			this.ecTypeCode = ecTypeCode;
			this.ecTypeDesc = ecTypeDesc;
		}
}
