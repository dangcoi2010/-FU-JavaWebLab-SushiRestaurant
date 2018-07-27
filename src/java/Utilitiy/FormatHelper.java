
package Utilitiy;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FormatHelper {
    public String formatDate(java.sql.Date d) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        int day = cal.get(Calendar.DATE);
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        String m = (month + 1) < 10 ? "0" + (month + 1) : "" + (month + 1);
        return year + "/" + m + "/" + day;
    }
    
    public String dateToString(java.sql.Date d) {
        Date date = new Date(d.getTime());
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int day = cal.get(Calendar.DATE);
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        return year + "-" + month + "-" + day;
    }
    
    public String parseDate(java.sql.Date d){
        DateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
        return format.format(d);
    }
    public java.sql.Date convertDate(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date parsed = format.parse(s);
            return new java.sql.Date(parsed.getTime());
        } catch (ParseException ex) {
            Logger.getLogger(FormatHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
