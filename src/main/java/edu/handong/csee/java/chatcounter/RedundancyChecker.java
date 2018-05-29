package edu.handong.csee.java.chatcounter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;




public class RedundancyChecker 
{
	MacandWindow parser = new MacandWindow();
	private static ArrayList<String> user = new ArrayList<String>();


	
	public static ArrayList<String> getMessage() 
	{
		return message;
	}

	public static ArrayList<String> getUser() 
	{
		return user;
	}



	private static ArrayList<String> message = new ArrayList<String>();

	void saveUsers() 
	{
		ArrayList<String> users = new ArrayList<String>();

		for(int i=0; i<parser.getUser().size();i++) 
		{
			users.add(parser.getUser().get(i));
		}

		users.addAll(parser.getMacUser());

		TreeSet<String> user = new TreeSet<String>(users);
		user.addAll(user);

	}

	void reduandancy() 
	{
		String line = "";

		ArrayList<String> messages = new ArrayList<String>();

		for(int i=0; i<parser.getMacChat().size();i++)
		{
			
			messages.add(parser.getMacChat().get(i));
		}
		for(int i=0; i<parser.getMacChat().size();i++) 
		{
			messages.add(parser.getWinChat().get(i));
		}

		TreeSet<String> message = new TreeSet<String>();
		
		ArrayList<String> oneMessage = new ArrayList<String>(message);

		for(int i=0; i < oneMessage.size()-1;i++)
		{

			if(oneMessage.get(i).length() > 50 && oneMessage.get(i+1).length() > 100 ) 
				
				line = oneMessage.get(i).substring(0, 30);

			if(line.length()==30 && oneMessage.get(i+1).contains(line)) 
			{
				continue;
			}

			oneMessage.add(oneMessage.get(i));
		}
		oneMessage.add(oneMessage.get(oneMessage.size()-1));


	}


}
