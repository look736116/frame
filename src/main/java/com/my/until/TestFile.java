package com.my.until;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestFile {
	public static void main(String[] args) {
		ObjectInputStream objectReader = null;
		ObjectOutputStream objectWriter = null;
		
		try {
			objectWriter = new ObjectOutputStream(new FileOutputStream("D:\\test\\input.txt"));
			
			objectWriter.writeObject(new Student("haha2"));
			objectWriter.writeObject(new Student("hehe3"));
			objectReader = new ObjectInputStream(new FileInputStream("D:\\test\\input.txt"));
			for (int i = 0; i < 2; i++) {
				System.out.println(objectReader.readObject());
			}
			
			
			
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				objectWriter.flush();
				objectWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
