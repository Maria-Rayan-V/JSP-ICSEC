package ivfrt.icsec.models;

public class CountryModel {
	 private String countryCode;
	    private String countryDesc;

	    public String getCountryCode() {
			return countryCode;
		}

		public void setCountryCode(String countryCode) {
			this.countryCode = countryCode;
		}

		public String getCountryDesc() {
			return countryDesc;
		}

		public void setCountryDesc(String countryDesc) {
			this.countryDesc = countryDesc;
		}

		// Constructor, getters, and setters
	    // Constructor, getters, and setters
	    public CountryModel(String countryCode, String countryDesc) {
	        this.countryCode = countryCode;
	        this.countryDesc = countryDesc;
	    }
	    
		public CountryModel()
		{
			super();
			countryCode = null;
			countryDesc = null;
		}
}
