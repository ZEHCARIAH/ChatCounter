package edu.handong.csee.java.chatcounter;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;



public class ChatCounter 
{
	String input;
	String output;
	boolean verbose;
	boolean help;


	private static ArrayList<String> csv = new ArrayList<String>();
	private static ArrayList<String> txt = new ArrayList<String>();


	public static void main(String[]args)
	{
		ChatCounter worker = new ChatCounter();
		worker.run(args);
	}

	private void run(String[] args)
	{
		Options options = createOptions();

		if(parseOptions(options, args))
		{
			if (help)
			{
				printHelp(options);
				return; 
			}
			File file  = new File(input);
			File arr[] = file.listFiles();

			ArrayList<String> name = new ArrayList<String>();

			for(int i=0 ; i<arr.length ; i++ ){

				name.add(arr[i].getName());

			}


			for(int i = 0; i < name.size(); i++)
			{
				String txts = name.get(i);
				if(txts.matches(".*csv"))
				{
					csv.add(input+"/"+txts);
				}
				else txt.add(input+"/"+txts);
			}


			FileLoader files = new FileLoader();
			MacParser mac = new MacParser();
			MacandWindow parser = new MacandWindow();
		
			for(int i=0; i<csv.size(); i++)
			{
				files.ReadDirectory(csv.get(i), 1);
				mac.getMessage();
				parser.SplitMac(); 
			}


			for(int i=0; i<txt.size(); i++) {
				files.ReadDirectory(txt.get(i), 0);
				parser.splitWindow();
			}

			RedundancyChecker checking = new RedundancyChecker();
			checking.saveUsers();
			checking.reduandancy();

			PMcounter people = new PMcounter();
			people.messageNum();

			FileWriter writer = new FileWriter();
			writer.CSVFile(output);


			if(verbose) {

				System.out.println("Your program is terminated. (This message is shown because you turned on -v option!");
			}
		}

	}

	private boolean parseOptions(Options options, String[] args)
	{
		CommandLineParser parser = new DefaultParser();



		try 
		{
			CommandLine cmd = parser.parse(options, args);

			input = cmd.getOptionValue("i");
			output = cmd.getOptionValue("o");
			verbose = cmd.hasOption("v");
			help = cmd.hasOption("h");

		}
		catch (Exception e) 
		{
			printHelp(options);
			return false;
		}
		return true;
	}
	private Options createOptions() 
	{
		Options options = new Options();

		options.addOption(Option.builder("i").longOpt("input")
				.desc("Set a path of a directory or a file to input")
				.hasArg()
				.argName("Path name to display")
				.required()
				.build());
		options.addOption(Option.builder("o").longOpt("output")
				.desc("Set a path of a directory or a file to output")
				.hasArg()
				.argName("Path name to display")
				.required()
				.build());
		options.addOption(Option.builder("v").longOpt("verbose")
				.desc("Display detailed messages!")
				//.hasArg()     // this option is intended not to have an option value but just an option
				.argName("verbose option")
				//.required() // this is an optional option. So disabled required().
				.build());

		// add options by using OptionBuilder
		options.addOption(Option.builder("h").longOpt("help")
				.desc("Help")
				.build());


		return options;	
	}

	
	private void printHelp(Options options)
	{
		// automatically generate the help statement
		HelpFormatter formatter = new HelpFormatter();
		String header = "Kakao Chat counter";
		String footer ="\nPlease report issues at https://github.com/ChatCounter/issues";
		formatter.printHelp("Kakao Chat counter", header, options, footer, true);
	}

	


}