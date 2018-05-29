package edu.handong.csee.java.chatcounter;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MacandWindow {
	private static ArrayList<String> user = new ArrayList<String>();
	
	ArrayList<String> chatMessage = new ArrayList<String>();
	ArrayList<String> chatMessagess = new ArrayList<String>();
	ArrayList<String> time = new ArrayList<String>();
	ArrayList<String> timess = new ArrayList<String>();

	private static ArrayList<String> chatWin = new ArrayList<String>();
	
	private static ArrayList<String> macUser = new ArrayList<String>();
	
	ArrayList<String> macTime = new ArrayList<String>();
	
	private static ArrayList<String> chatMac = new ArrayList<String>();
	
	private static ArrayList<String> chatMacs = new ArrayList<String>();

	
	public static ArrayList<String> getWinChat() 
	{
		return chatWin;
	}


	public static ArrayList<String> getMacChat()
	{
		return chatMac;
	}


	public static ArrayList<String> getUser() 
	{
		return user;
	}



	public static ArrayList<String> getMacUser() 
	{
		return macUser;
	}


	FileLoader file = new FileLoader();
	MacParser mac = new MacParser();


	void splitWindow ()
	{

		Pattern pa = Pattern.compile("\\[(.+)\\]\\s\\[(.+)\\]\\s(.+)");

		for(int i=0; i<file.getWindow().size(); i++) {

			String line = file.getWindow().get(i);
			Matcher match = pa.matcher(line);

			while(match.find())
			{
				chatMessage.add(match.group(0));
				time.add(match.group(1));
				user.add(match.group(2));
	
			}
		}

		changeTime();

	}

	private void changeTime() 
	{

		String timea = null;
		String timeb = null;
		int Inttime;

		for(int i=0; i<time.size(); i++) 
		{

			String line = time.get(i);

			if(line.matches("오전\\s(.*)")||line.matches(".+\\sAM"))
			{

				Pattern pa = Pattern.compile("([0-9]+):([0-9]+)");
				Matcher match = pa.matcher(line);

				while(match.find()) 
				{

					timea = match.group(0);
					timeb = match.group(1);

				}
				if(timea.matches("12")){

					timea ="00";
					timess.add(i,timea+":"+timeb);

				}
				else if( timea.length()==1) 
				{
					timess.add(i,"0"+timea+":"+timeb);
				}
				else timess.add(i,timea+":"+timeb);
			}


			else if(line.matches("오후\\s(.*)")||line.matches(".+\\sPM"))
			{

				Pattern pa = Pattern.compile("([0-9]+):([0-9]+)");
				Matcher match = pa.matcher(line);

				while(match.find()) 
				{

					timea = match.group(0);
					timeb = match.group(1);

				}
				Inttime = Integer.parseInt(timea);
				if(Inttime!=12) 
				{
					Inttime = Inttime+12;
					timea = String.valueOf(Inttime);
				}
				timess.add(i,timea+":"+timeb);
			}
		}



		for(int i=0; i<user.size(); i++)
		{
			chatWin.add(i,user.get(i)+" "+timess.get(i)+" "+chatMessage.get(i));
		}

	}


	void SplitMac() 
	{

		Pattern pa = Pattern.compile(".+\\s([0-9]+:[0-9]+):[0-9]+,\"(.+)\",\"(.+)\"");


		for(int i=0; i<mac.getMessage().size(); i++)
		{

			String line = mac.getMessage().get(i);
			Matcher matcher = pa.matcher(line);

			while(matcher.find())
			{

				macTime.add(matcher.group(1));
				macUser.add(matcher.group(2));
				chatMac.add(matcher.group(2)+" "+matcher.group(1)+" "+matcher.group(3));

			}
		}

	}


}
