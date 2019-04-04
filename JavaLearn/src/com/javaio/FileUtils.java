package com.javaio;

import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.swing.text.DefaultEditorKit.CopyAction;

public class FileUtils {

	public static void main(String[] args) throws IOException {
	//String fname = "/JavaLearn/GreateBookByte.txt";
    String fname = "\\Users\\Eduard Kutsenco\\workspace\\JavaLearn\\GreateBookByte.txt";
	    //printIOFileDetails(fname);
	//	printIOFileDetails(fname);
		printNIOFileDetails(fname);
	}

	
	public static void printIOFileDetails(String path) {
		//Get path detsils
		File file = new File(path);
		
		System.out.println("Absolute path: " + file.getAbsolutePath());
		System.out.println("Relative path: " + file.getPath());
		System.out.println("Free space in MBytes: " + file.getFreeSpace()/1000000);
		System.out.println("Parent Directory: " + file.getParent());
		System.out.println("Is absolute path: " + file.isAbsolute());
		
		System.out.println("Current Directory: " + System.getProperty("user.dir"));
	}
	
	public static void printNIOFileDetails(String fileName) throws IOException  {
		//Get path detsils
		Path path = Paths.get(fileName);
		Path path1 = FileSystems.getDefault().getPath(fileName);
		Path path2 = Paths.get(System.getProperty("user.dir"), fileName);
		
		System.out.println("File name " + path.getFileName());
		System.out.println("Root dir " + path.getRoot());
		
		Path absolutePath = path.toAbsolutePath();
		System.out.println("Absolute Path " + absolutePath);
		System.out.println("Parent Dir " + absolutePath.getParent());
		System.out.println("Name count " + path.getNameCount());
		System.out.println("Sub Path " + absolutePath.subpath(1, 2));
		
	
		System.out.println("File exists: " + Files.exists(path));
		System.out.println("File is readable: " + Files.isReadable(path));
		System.out.println("File is writable: " + Files.isWritable(path));
		
		
		Path parentPath = absolutePath.getParent();
		Path filesPath = parentPath.resolve("Files");
		System.out.println(parentPath +   "  filesPath: "  + filesPath);
		System.out.println("Is exist " + Files.exists(filesPath));
		if(Files.notExists(filesPath))
			Files.createDirectory(filesPath);
		
		Files.copy(path, filesPath, CopyOption.class.);
		
		
		
	}
}
