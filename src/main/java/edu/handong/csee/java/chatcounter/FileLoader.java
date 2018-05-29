package edu.handong.csee.java.chatcounter;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.*;
import java.io.PrintWriter;
import java.util.List;





public class FileLoader
{

	private static ArrayList<String> Mac = new ArrayList<String>();
	private static ArrayList<String> Window = new ArrayList<String>();


	public ArrayList<String> getWindow()
	{
		return Window;
	}



	public ArrayList<String> getMac() 
	{
		return Mac;
	}


	public void ReadDirectory (String path, int i)
	{

		Scanner inputStream = null;

		ArrayList<File> fileNames = getFileNames(path);
		
		for(File fileNamess:fileNames)

		{
			System.out.println(fileNames);
			String Name = fileNamess.toString();

			try
			{
				inputStream = new Scanner(new File(Name),"utf8");
				String line =inputStream.nextLine();

				System.out.println(line);

			


			}  catch (FileNotFoundException e)
			{ 
				e.printStackTrace();
				System.exit (0);
			}


			if(i == 1) {
				while (inputStream.hasNextLine ()) {
					String line = inputStream.nextLine ();
					Mac.add(line);
				}

			} else {
				while (inputStream.hasNextLine ()) {
					String line = inputStream.nextLine ();
					Window.add(line);
				}

			}

			inputStream.close();



		}
	}
	private ArrayList<File> getFileNames(String path){

		ArrayList<File> fileNames= new ArrayList<File>();
		File mypath= new File(path);

		for(File filesNames:mypath.listFiles()) {
			fileNames.add(filesNames); 
		}
		return fileNames; 
	}
}
