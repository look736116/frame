package com.my.test;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestLog {
	
	private static Logger logger = Logger.getLogger("TestLog");
	public static void main(String[] args) {		
		logger.setLevel(Level.INFO);	
		
		//create console handler
        ConsoleHandler  consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);      
        consoleHandler.setFormatter(new LogFomat());
        logger.addHandler(consoleHandler);
       
        
        try {
			FileHandler fileHandler = new FileHandler("D:\\test\\test.txt",true);
			fileHandler.setLevel(Level.ALL);
			fileHandler.setFormatter(new LogFomat());
			logger.addHandler(fileHandler);
			
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        logger.info("99999!");
        
	}

}
