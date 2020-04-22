package com.techzone.taskcontroller.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatDate {

    // private String format = "dd/MM/yyyy";
    
    public static Date parse(String date, String format){
        
        SimpleDateFormat sdf = new SimpleDateFormat(format);

		try {
			return sdf.parse(date);
		} catch (ParseException e) {			
			throw new RuntimeException("Data inválida");
		}
    }
}