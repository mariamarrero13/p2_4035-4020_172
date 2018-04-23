package DataReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

import Customer.Customer;
import java.util.Deque;
import java.util.Queue;

public class DataReader {

	public static ArrayList<String> readFileNames() throws FileNotFoundException {
		ArrayList<String> data = new ArrayList<String>();
		String fileName = "dataFiles.txt"; 
		Scanner inputFile = new Scanner(new File("inputFiles",fileName)); 
		ArrayList<String> fileContent = new ArrayList<>(); 
		while (inputFile.hasNext())
			fileContent.add(inputFile.nextLine());
		inputFile.close();
		return fileContent; 
	}
	public static ArrayList<Queue<Customer>> readData() throws FileNotFoundException{
		ArrayList<String> fileNames = readFileNames();
		ArrayList<Queue<Customer>> files = new ArrayList<Queue<Customer>>();
		for (String fileName : fileNames) {
			Scanner inputFile = new Scanner(new File("inputFiles",fileName));
			ArrayList<String> fileContent = new ArrayList<>(); 
			while (inputFile.hasNext())
				fileContent.add(inputFile.nextLine());
			inputFile.close();
			Queue<Customer> cd = new ArrayDeque<>();
			int i=0;
			for (String s : fileContent){
				String[] inputs = s.split(" ");
				Customer nc = new Customer(i++, Integer.valueOf(inputs[0]), Integer.valueOf(inputs[1]));
				cd.add(nc);
			}
			files.add(cd);
		}
		return files;
	}
}
