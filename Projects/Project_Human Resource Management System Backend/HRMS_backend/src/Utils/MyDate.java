package Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDate {
    public static String getDateTimeString(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    public static String getDateString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = sdf.format(new Date());
        return formattedDate;
    }

    public static Date stringToDate(String str) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.parse(str);
    }
}
