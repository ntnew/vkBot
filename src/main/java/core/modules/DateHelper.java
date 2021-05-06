package core.modules;

import java.text.SimpleDateFormat;

/**
 * Для работа с датой и временем
 */
public class DateHelper {

    public static String getDate(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm");
        return simpleDateFormat.format(new java.util.Date());
    }

    public static String getTimeNow(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        return simpleDateFormat.format(new java.util.Date());
    }
}
