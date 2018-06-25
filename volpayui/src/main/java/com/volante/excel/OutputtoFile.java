package com.volante.excel;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OutputtoFile 
{
	public void writeoutputtofile(String strPath,String data) throws IOException 
	{
		
			    BufferedWriter writer = new BufferedWriter(new FileWriter(strPath));
			    writer.write(data);
			    writer.close();
			}
}
