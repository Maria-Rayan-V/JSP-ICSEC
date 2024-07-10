package ivfrt.icsec.utils;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DateUtils {
    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final String OUTPUT_DATE_FORMAT = "yyyy-MM-dd";
    private static final Logger LOGGER = Logger.getLogger(DateUtils.class.getName());

    public static Date convertStringToSqlDate(String dateStr) {
        if (dateStr == null || dateStr.trim().isEmpty()) {
            return null; // or handle as per your application logic
        }

        SimpleDateFormat sdfInput = new SimpleDateFormat(DATE_FORMAT, Locale.ENGLISH);
        SimpleDateFormat sdfOutput = new SimpleDateFormat(OUTPUT_DATE_FORMAT);
        try {
            java.util.Date utilDate = sdfInput.parse(dateStr);
            return Date.valueOf(sdfOutput.format(utilDate)); // Convert to SQL Date using yyyy-MM-dd format
        } catch (ParseException e) {
            LOGGER.log(Level.SEVERE, "Invalid date format: " + dateStr, e);
            return null;
        }
    }

    public static Date convertStringToUtilDate(String dateStr) {
        if (dateStr == null || dateStr.trim().isEmpty()) {
            return null; // or handle as per your application logic
        }

        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        try {
            return (Date) sdf.parse(dateStr);
        } catch (ParseException e) {
            LOGGER.log(Level.SEVERE, "Invalid date format: " + dateStr, e);
            return null; // Or handle it differently, e.g., throw a custom exception or return a default date
        }
    }
}
