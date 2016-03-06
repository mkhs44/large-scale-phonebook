package main.java;

import java.util.*;
import java.io.*;

public class PhoneDirectory{
	static Properties properties = new Properties();

	public PhoneDirectory() throws IOException{
		    InputStream inFile = new FileInputStream("src/main/resources/phone.properties"); 
			Properties prop = new Properties();
			prop.load(inFile);
			for (String property : prop.stringPropertyNames()) {
				String value = prop.getProperty(property);
				addEntry(property, value);
			}
		} 
	
	
	public void addEntry(String name, String number) throws IOException{
		OutputStream outFile = new FileOutputStream("src/main/resources/phone.properties");
		properties.setProperty(name, number);
		properties.store(outFile, "Phone Directory");
		}
	
	
	public void deleteEntry(String name) throws IOException{
		OutputStream outFile = new FileOutputStream("src/main/resources/phone.properties");
		   properties.remove(name);
		   properties.store(outFile, "Phone Directory");
		}
	

	public String getNumber(String name){
		return properties.getProperty(name);
	}

	public void changeEntry(String name, String number) throws IOException{
		addEntry(name,number);	
	 }
	
	public void print(){
		System.out.printf("%-15s%-15s","Name","Number");
		System.out.println();
		for (String property : properties.stringPropertyNames()) {
			String value = properties.getProperty(property);
			System.out.printf("%-15s%-15s",property, value);
			System.out.println();
		}
	}
}

