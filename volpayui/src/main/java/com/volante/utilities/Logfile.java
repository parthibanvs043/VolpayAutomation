package com.volante.utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Logfile
{
	     @SuppressWarnings("unused")
		 private static Logger Log = Logger.getLogger(Logger.class.getName());
			  
public static void  LogData() throws Exception
		{
			  String workingDir=System.getProperty("user.dir");
		      PropertyConfigurator.configure(workingDir+"..\\..\\RunTime\\class\\log4j.properties");

	    }
}
