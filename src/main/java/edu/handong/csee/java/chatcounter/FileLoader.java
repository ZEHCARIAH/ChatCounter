package edu.handong.csee.java.chatcounter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class FileLoader {

	private ArrayList<String> message;

	public void readDirectory(String path)
	{
		Scanner inputStream =null;

		ArrayList<File> fileNames = getFileNames(path);
		for(File fileNamess:fileNames)
		{
			System.out.println(fileNamess);


			String Name = fileNamess.toString();

			try 
			{
				inputStream=new Scanner(new File(Name),"utf8");
				String line= inputStream.nextLine();

				System.out.println(line);
				while(inputStream.hasNextLine())
				{
					line = inputStream.nextLine();
					System.out.println(line);
				}

			}
			catch (FileNotFoundException e)
			{
				e.printStackTrace();
				System.exit(0);

			}
			while(inputStream.hasNextLine()) {
				String line= inputStream.nextLine();
				String[]ary = line.split(",");
				System.out.println(line);	
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