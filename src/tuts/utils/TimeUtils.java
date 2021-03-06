package tuts.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TimeUtils {

    private TimeUtils(){ }


    // Returns initialTime + millisToAdd
    // as a java.util.Date object.
    public static Date getFutureTime(Date initialTime, long millisToAdd){

        Calendar calendar = GregorianCalendar.getInstance();

        calendar.setTimeInMillis(initialTime.getTime()+ millisToAdd);


        return calendar.getTime();
    }

}
