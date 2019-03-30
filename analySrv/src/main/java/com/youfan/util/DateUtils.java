package com.youfan.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by li on 2019/1/5.
 */
public class DateUtils {
    public static String getYearbasebyAge(String age){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR,-Integer.valueOf(age));
        Date newdate = calendar.getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy");
        String newdatestring = dateFormat.format(newdate);
        Integer newdateinteger = Integer.valueOf(newdatestring);
        String yearbasetype = "未知";
        if(newdateinteger >= 1940 && newdateinteger < 1950){
            yearbasetype = "40后";
        }else if (newdateinteger >= 1950 && newdateinteger < 1960){
            yearbasetype = "50后";
        }else if (newdateinteger >= 1960 && newdateinteger < 1970){
            yearbasetype = "60后";
        }else if (newdateinteger >= 1970 && newdateinteger < 1980){
            yearbasetype = "70后";
        }else if (newdateinteger >= 1980 && newdateinteger < 1990){
            yearbasetype = "80后";
        }else if (newdateinteger >= 1990 && newdateinteger < 2000){
            yearbasetype = "90后";
        }else if (newdateinteger >= 2000 && newdateinteger < 2010){
            yearbasetype = "00后";
        }else if (newdateinteger >= 2010 ){
            yearbasetype = "10后";
        }
        return yearbasetype;
    }


    public static int getDaysBetweenbyStartAndend(String starttime,String endTime,String dateFormatstring) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat(dateFormatstring);
        Date start = dateFormat.parse(starttime);
        Date end = dateFormat.parse(endTime);
        Calendar startcalendar = Calendar.getInstance();
        Calendar endcalendar = Calendar.getInstance();
        startcalendar.setTime(start);
        endcalendar.setTime(end);
        int days = 0;
        while(startcalendar.before(endcalendar)){
                startcalendar.add(Calendar.DAY_OF_YEAR,1);
                days += 1;
        }
        return days;
    }

    public static String gethoursbydate(String timevalue) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd hhmmss");
        Date time = dateFormat.parse(timevalue);
        dateFormat = new SimpleDateFormat("hh");
        String resulthour = dateFormat.format(time);
        return resulthour;
    }
}
