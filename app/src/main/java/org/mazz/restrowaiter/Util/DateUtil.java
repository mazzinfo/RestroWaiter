package org.mazz.restrowaiter.Util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtil {


    public static String getCurrentTime(){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("HH:mm");
        return ""+ mdformat.format(calendar.getTime());
    }
}

