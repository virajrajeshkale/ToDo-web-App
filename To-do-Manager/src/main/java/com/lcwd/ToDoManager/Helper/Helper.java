package com.lcwd.ToDoManager.Helper;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

//this is ana class used to convert date format from database to system
public class Helper {

    public  static  Date pardedate(LocalDateTime localDateTime)
    {
        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        Date date  = Date.from(instant);
        return  date;
    }
}
