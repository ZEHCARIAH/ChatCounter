package edu.handong.csee.java.chatcounter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;


public class ChatCounter {
	

	public static void main(String[] args) {
		
		ChatCounter worker = new ChatCounter();
		worker.run(args[0]);
		System.out.print(args[0]);
		
	
	}

	private void run(String path) {
		
		FileLoader fileLoader = new FileLoader();
		fileLoader.readDirectory(path);
		
	}
}