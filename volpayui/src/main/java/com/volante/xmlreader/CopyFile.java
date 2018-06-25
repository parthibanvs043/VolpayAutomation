package com.volante.xmlreader;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
public class CopyFile {

	public static void Copyxml(String pr, String dt) throws IOException {
		
		File sourceFile = new File(pr);
		if (!sourceFile.exists()) {
			System.out.println("Source File Not Found!");
		}
		File destFile = new File(dt);
		FileUtils.copyFile(sourceFile, destFile);
		System.out.println("Copied successfully");
	}
	
}
	    	




