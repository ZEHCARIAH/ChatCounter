package edu.handong.csee.java.chatcounter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class MacParser {
	HashMap<String, Integer> map = new HashMap<String,Integer>();

	Scanner scan= null;

	public void MacParser(String inputStream) {
		
		Scanner scan = new Scanner(inputStream).useDelimiter(inputStream);
		FileLoader fileLoader = new FileLoader();
		fileLoader.readDirectory(inputStream);
		System.out.println()

		
	}

	public void parser(String Name) {

	}
}
