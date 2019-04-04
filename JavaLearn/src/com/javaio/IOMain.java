package com.javaio;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.Set;

import com.map.treemap.AverageStudentGrade;
import com.map.treemap.SubjectGrade;
import com.map.treemap.TreeMapRunner;

public class IOMain {
	private final static String FILE_NAME = "GradeBook.txt";
	
	public static void main(String[] args) throws IOException {
		NavigableMap<AverageStudentGrade, Set<SubjectGrade>> grades = TreeMapRunner.createGrades();
		//writeFile(grades);
	//	readFile();
		System.out.println(System.getProperty("user.dir"));
		Formatter formatter = new Formatter("BankAccount.txt");
		Scanner scanner = new Scanner(System.in);
		int i =0;
//		while(i<3) {
//			try {
//			formatter.format("%d, %s, %s, %.2f" , scanner.nextInt(), scanner.next(), scanner.next(), scanner.nextFloat());
//			i++;
//			}catch(InputMismatchException e) {
//				System.out.println("please try again");
//				scanner.nextLine();
//			}
//		}
		
		try(FileInputStream reader = new FileInputStream(FILE_NAME); 
				FileOutputStream writer = new FileOutputStream("GreateBookByte.txt")) {
			int c;
			while((c = reader.read())!=-1) {
				System.out.print(c);
				writer.write(c);
			}
		}
		
		formatter.close();
		
		
		
		
		
		try(FileInputStream reader = new FileInputStream(FILE_NAME); 
			FileOutputStream writer = new FileOutputStream(FILE_NAME)){
			int c;
			while ((c = reader.read()) != -1){
				System.out.println(c);
			}
		}
	}

	private static void readFile() throws FileNotFoundException, IOException {
		BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
		while(reader.readLine() != null){
			System.out.println(reader.readLine());
		}
		reader.close();
	}

	private static void writeFile(NavigableMap<AverageStudentGrade, Set<SubjectGrade>> grades) throws IOException {
		//try (FileWriter writer = new FileWriter(FILE_NAME)) {
		try (PrintWriter writer = new PrintWriter(FILE_NAME)) {
			for (AverageStudentGrade gradeKey : grades.keySet()) {
				writer.write("==========================================\n");
				writer.write("Student: " + gradeKey.getName() + " Average grade: " + gradeKey.getAverageGrade() + "\n");
				for (SubjectGrade grade : grades.get(gradeKey)) {
					writer.write("Subject: " + grade.getSubject() + " Grade: " + grade.getGrade() + "\n");
				}
			}
		}
	}

}
