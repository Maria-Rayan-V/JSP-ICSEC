package ivfrt.icsec.utils;

import java.text.SimpleDateFormat;
import java.util.List;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class ValidationUtils {
	public static void validateField(String value, String fieldName, List<String> errors, int maxLength, String type, boolean isRequired) throws java.text.ParseException {
	    if (isRequired && (value == null || value.trim().isEmpty())) {
	        errors.add(fieldName + " is required.");
	        return;
	    }
	    if (value != null && !value.trim().isEmpty()) {
	        if (value.length() > maxLength) {
	            errors.add(fieldName + " must not exceed " + maxLength + " characters.");
	        }
	        if ("number".equalsIgnoreCase(type)) {
	            if (!value.matches("\\d+")) {
	                errors.add(fieldName + " must be a valid number.");
	            }
	        } else if ("text".equalsIgnoreCase(type)) {
	            if (!value.matches("[a-zA-Z0-9\\s]+")) {
	                errors.add(fieldName + " must contain only alphanumeric characters.");
	            }
	        } else if ("date".equalsIgnoreCase(type)) {
	            validateDate(value, fieldName, errors);
	        }
	    }
	}

	public static void validateDate(String value, String fieldName, List<String> errors) throws java.text.ParseException {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    sdf.setLenient(false);
	    try {
	        sdf.parse(value);
	    } catch (ParseException e) {
	        errors.add(fieldName + " must be a valid date in the format YYYY-MM-DD.");
	    }
	}
}
