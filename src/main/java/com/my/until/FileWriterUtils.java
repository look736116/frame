package com.my.until;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class FileWriterUtils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File  file = new File("D:\\test\\test.txt");
		try {
			FileWriter fw1 = new FileWriter(file,false);
			BufferedWriter fw = new BufferedWriter(fw1);
			fw.write("qqqaaaaaa") ;
			fw.write("wwwbbbbbb\n");
			fw.write("uuubbbbbb");
			fw.flush();
			fw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int count = 0;
		FileReader fr =null;
		try {
			 fr = new FileReader(file);
			char[] ch = new char[8];
			int len = 0;
			while ((len = fr.read(ch))!=-1) {
				System.out.println(len);
				System.out.println(new String(ch,0,len));
				count++;				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
			
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	


}
