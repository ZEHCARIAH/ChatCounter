package edu.handong.csee.java.chatcounter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class PMcounter
{
	static HashMap<String, NDMD> ndmd = new HashMap<String,NDMD>();



	public static HashMap<String, NDMD> getCount() 
	{
		return ndmd;
	}

	RedundancyChecker check = new RedundancyChecker();

	int i = 0;
	int j=0;
	
	void messageNum() 
	{

		for(int a=0; a<check.getUser().size(); a++) 
		{

			String name = check.getUser().get(a);

			NDMD number = new NDMD();
			ndmd.put(name, number);



			for(int b=0;b<check.getMessage().size();b++) 
			{
				String line = check.getMessage().get(b);

				if(name.contains(")")) 
				{
					if(line.contains(name))
						number.setJ(number.getJ()+1);
				}
				else if(line.matches(name+".+")) {
					number.setJ(number.getJ()+1);					
				}
			}

		}
		sortHashMap(ndmd);

	}

	private void sortHashMap(HashMap<String, NDMD> ndmds) 
	{
		int a=0;
		int [] sort = new int[check.getUser().size()];

		for(String name : ndmds.keySet())
		{
			NDMD person = ndmds.get(name);
			sort[a] = person.getJ();
			a++;
		}

		Arrays.parallelSort(sort);

		a =0;
		for(String name : ndmd.keySet())
		{
			NDMD person = ndmds.get(name);
			for(int b=0; b<check.getUser().size(); b++)
			{
				if(sort[b]==person.getJ())
					person.setI(29-b);
			}
		}

	}


}