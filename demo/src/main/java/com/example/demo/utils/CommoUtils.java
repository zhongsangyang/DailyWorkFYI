package com.example.demo.utils;

import com.example.demo.entity.QRTZ_MYORDER;
import com.example.demo.service.QRTZ_MYORDERservice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class CommoUtils {
    private static Logger _log = LoggerFactory.getLogger(CommoUtils.class);

    public static void coommonRecord( QRTZ_MYORDER t, List<String> list){
        QRTZ_MYORDERservice qrtz_myordeRservice=SpringContextUtils.getBean(QRTZ_MYORDERservice.class);

        Calendar calendar= Calendar.getInstance();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        try {
            dateFormat.parse(dateFormat.format(calendar.getTime()));
        } catch (ParseException e) {
            _log.error(e.toString());
        }
        StringBuilder stringBuilder=new StringBuilder();
        for (String s: list) {
            stringBuilder.append(s+",");
        }
       t.setMailaccount(stringBuilder.substring(0,stringBuilder.lastIndexOf(",")));
       t.setTosomeone(list.toString());
       t.setCreatetime(calendar.getTime());
       qrtz_myordeRservice.insert(t);

    }
}
