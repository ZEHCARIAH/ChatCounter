package edu.handong.csee.java.chatcounter;


import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class FileWriter
{
	PMcounter people = new PMcounter();
	RedundancyChecker check = new RedundancyChecker();


	public void CSVFile(String output) 
	{
		String fileName = output;
		PrintWriter outputStream = null;

		try
		{
			outputStream = new PrintWriter(fileName);
			
		}
		catch(FileNotFoundException e) 
		{
			System.out.println(fileName);
			System.exit(0);
		}

		outputStream.println("kakao id count");

		for(int i = 1; i<31; i++)
		{

			for(String name : people.getCount().keySet()) {

				NDMD person = people.getCount().get(name);

				if(i==person.getI())
				{
					outputStream.println(name+","+person.getJ());
					continue;
				}
			}


		}

		outputStream.close();

	}

}
