package com.volante.backup;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;


public class ArchieveFiles 
{
	// Archiving the Files and Folders to Backup folder with Date and Timestamp
    public static void archiveFile ()
    {
    	try {
    		String path = System.getProperty("user.dir");
        	File srcDir = new File(path+"/temp");
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
    		Date date = new Date();
    	    String[] dt=dateFormat.format(date).split("-");
    		File dtbk=new File(path+"/temp"+"/Archived/backup("+dt[0]+"-"+dt[1]+"-"+dt[2]+"_h"+dt[3]+"-m"+dt[4]+"-s"+dt[5]+")");
    		FileUtils.copyDirectory(srcDir,dtbk);
        	} catch(Exception e) {}
    }
}
