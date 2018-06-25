package com.volante.backup;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

public class MovetheFiles 
{
@Test
public static void moveTheFile () {
        try {
        	String path = System.getProperty("user.dir");
            File ExeDir = new File(path+"/temp");
            if(!ExeDir.exists()){
            	ExeDir.mkdir();
            }
            
           /* File SnapDir = new File(path+"/Backup/Snapshots");
            if(!SnapDir.exists()){
            	SnapDir.mkdir();
            }
            */
            
            File VolPayData = new File(path+"/VolPaydata/");
            File VolPayOutput = new File(path+"/VolPayoutput/");
            File dstTD = new File(path+"/temp");
            if(!dstTD.exists())
            {
            	FileUtils.copyFileToDirectory(VolPayData, ExeDir);
            }
            File dstTR = new File(path+"/temp");
            if(!dstTR.exists())
            {
            	FileUtils.copyFileToDirectory(VolPayOutput, ExeDir);
            }
            } catch(Exception e) {}
    }
}
