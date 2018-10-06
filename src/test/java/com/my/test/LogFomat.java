package com.my.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class LogFomat extends Formatter {

	@Override
	public String format(LogRecord log) {
		// TODO Auto-generated method stub
		 SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:MM:ss S");
		return format.format(new Date()) +" - "+ log.getLevel()+": " + log.getMessage()+"\n";
	}

}
