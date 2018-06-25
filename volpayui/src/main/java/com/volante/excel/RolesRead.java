package com.volante.excel;

import java.io.File;

import org.openqa.selenium.WebDriver;

import com.volante.reports.GenerateReport;
import com.volante.timeout.PageReadyState;

import jxl.Sheet;
import jxl.Workbook;

public class RolesRead 
{
public static void readExcelSheet(WebDriver wda, String destFile, int sheetNum, int SN)
	{ 
        try 
        {
             Workbook wb = Workbook.getWorkbook(new File(destFile));
             Sheet sheet = wb.getSheet(sheetNum);
             //String FileName = sheet.getName();
                 int rows = sheet.getRows();
                @SuppressWarnings("unused")
				String met, prop, data,  stepNo, stepDesc , modulename, permval;
                GenerateReport.getmethodname();
                PageReadyState.IsPageReady(wda);
                   for(int row = 0;row < rows;row++) {
                    		  stepNo = sheet.getCell(0, row).getContents();
                    		  stepDesc = sheet.getCell(1, row).getContents();

                              met = sheet.getCell(2, row).getContents();
                        	  prop = sheet.getCell(3, row).getContents();
                        	  data = sheet.getCell(4, row).getContents();
                        	  modulename = sheet.getCell(5, row).getContents();
                        	  permval = sheet.getCell(6,row).getContents();
                        	  
                        	  MethodsList.CallMethods(wda, met, prop, data, stepDesc,destFile,sheetNum);
                        	  MethodsList.RoleMethods(wda, met, prop, data, stepDesc, modulename, permval);
                        }
                   GenerateReport.extent.endTest(GenerateReport.test);
                  } catch(Exception ioe) {
                       ioe.printStackTrace();
                  }
             
          }

}
