package edu.handong.csee.java.chatcounter;


import java.util.ArrayList;

public class MacParser 
{
	
	private static ArrayList<String> macMessage = new ArrayList<String>();

	
	public static ArrayList<String> getMessage() 
	{
		return macMessage;
	}

	FileLoader file = new FileLoader();

	void message()
	{
		String line = "";
		for(int i=0; i<file.getMac().size()-1; i++) {
			
			line = line.concat(file.getMac().get(i));
			
			if(file.getMac().get(i+1).matches("2018-.*")) line = line.concat("]]]");
		}


		String[] String = line.split("]]]"); 
		for (int i = 0; i < String.length; i++) { 
			macMessage.add(String[i]); 
		}

		macMessage.add(file.getMac().get(file.getMac().size()-1));


	}

}