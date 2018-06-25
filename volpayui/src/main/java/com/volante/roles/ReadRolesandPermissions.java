package com.volante.roles;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;
import com.volante.reports.GenerateReport;
import com.volante.utilities.GetScreenShot;

public class ReadRolesandPermissions 
{

	
 public static void Role(WebDriver wd,String dt,String module,String selectvalue, String strStep) throws IOException
 {
	 String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
	try
	{
	  //Get number of rows In table.
	  //int Row_count = wd.findElements(By.xpath(".//*[@id='accordion']/div[4]/div/div/div/div/form/div[2]")).size();
	  int Row_count = wd.findElements(By.xpath(".//*[@id='rolesTable']/tbody/tr")).size();
	  System.out.println("Number Of Rows in Roles table= "+Row_count);
	  
	  //Get number of columns In table.
	  int Col_count = wd.findElements(By.xpath(".//*[@id='rolesTable']/thead/tr[1]/th")).size();
	  System.out.println("Number Of Columns in Roles table = "+Col_count);
	  
	  for (int i=2;i<=Col_count;i++)
	  {
		    String sValue;
		    String ModuleName = null;
			sValue = wd.findElement(By.xpath(".//*[@id='rolesTable']/thead/tr/th["+i+"]")).getText();
			 System.out.println("sValue = "+sValue);
			 // To Match with Column Value
			if(sValue.equalsIgnoreCase(dt))
			{
				  //GenerateReport.test.log(LogStatus.PASS,strStep ," "+Methodname+" : Permissions Selected as" +sValue);
				 for(int r=1;r<=Row_count;r++)
				  {
					  //String rowvalue;
					  boolean ModulePresent=wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[1]")).isDisplayed(); 
					  if(ModulePresent==true)
					  {
						  WebElement rowvalue =wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[1]"));
						  rowvalue.getText();
						  System.out.println( rowvalue.getText());
						  ModuleName=rowvalue.getText();						 
						 // GenerateReport.test.log(LogStatus.PASS,strStep ," "+Methodname+" : Permissions Selected for" +ModuleName);				  
			               System.out.println("rowvalue true loop = "+rowvalue);
						  // Read Column table
							if(ModuleName.equalsIgnoreCase(module) && sValue.equalsIgnoreCase("Read"))
							  {   						  
								  boolean testelementdis=wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[2]/select")).isDisplayed();
								  if(testelementdis==true)
								  {
									   Select read=new Select(wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[2]/select")));
									   read.selectByVisibleText(selectvalue);
									   //System.out.println("SelectedValueforRead before = "+read);
									   GenerateReport.test.log(LogStatus.PASS, strStep," "+Methodname+" : Permissions selected for "+ModuleName+" "+sValue);
									 break; 
			                      }
								  else
								  {
									  System.out.println(" element not found ");
									 /* Select read=new Select(wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[2]/select")));
									 // System.out.println("fvsdgvbkjbgjbdskjbgk="+read);
									  read.selectByVisibleText(selectvalue);
									  //System.out.println("SelectedValueforRead After = "+read);
*/								  }
								  //GenerateReport.test.log(LogStatus.PASS, strStep," "+Methodname+" : Permissions selected for "+ModuleName+" "+sValue);
							  }
							/*GenerateReport.test.log(LogStatus.FAIL, strStep," "+Methodname+" : Permissions is not matched with the given "+ModuleName+" "+sValue);
							  String screenShotPath = GetScreenShot.capture(wd, strStep);
							  GenerateReport.test.log(LogStatus.FAIL, "Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));*/
							// Create column table
							if(ModuleName.equalsIgnoreCase(module) && sValue.equalsIgnoreCase("Create"))
							  {   
								 GenerateReport.test.log(LogStatus.PASS, strStep," "+Methodname+" : Permissions selected for "+ModuleName+" "+sValue);
								  boolean CreatePresent=wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[3]/select")).isDisplayed();
								  if(CreatePresent==true)
								  {
									   Select Create=new Select(wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[3]/select")));
									   Create.selectByVisibleText(selectvalue);
									   //System.out.println("SelectedValueforRead before = "+Create);
			                      }
								  else
								  {
									  Select Create=new Select(wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[3]/select")));
									  //System.out.println("fvsdgvbkjbgjbdskjbgk="+Create);
									  Create.selectByVisibleText(selectvalue);
									  //System.out.println("SelectedValueforRead After = "+Create);
								  } 
								 /* GenerateReport.test.log(LogStatus.FAIL, strStep," "+Methodname+" : Permissions is not matched with the given "+ModuleName+" "+sValue);
								  //String screenShotPath = GetScreenShot.capture(wd, strStep);
								  GenerateReport.test.log(LogStatus.FAIL, "Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));*/
							  }	
							//Update column table
							if(ModuleName.equalsIgnoreCase(module) && sValue.equalsIgnoreCase("Update"))
							  {   
								 GenerateReport.test.log(LogStatus.PASS, strStep," "+Methodname+" : Permissions selected for "+ModuleName+" "+sValue);
								  boolean UpdatePresent=wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[4]/select")).isDisplayed();
								  if(UpdatePresent==true)
								  {
									   Select Update=new Select(wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[4]/select")));
									   Update.selectByVisibleText(selectvalue);
									   //System.out.println("SelectedValueforRead before = "+Update);
			                      }
								  else
								  {
									  Select Update=new Select(wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[4]/select")));
									 // System.out.println("fvsdgvbkjbgjbdskjbgk="+Update);
									  Update.selectByVisibleText(selectvalue);
									  //System.out.println("SelectedValueforRead After = "+Update);
								  } 
								 /* GenerateReport.test.log(LogStatus.FAIL, strStep," "+Methodname+" : Permissions is not matched with the given "+ModuleName+" "+sValue);
								  //String screenShotPath = GetScreenShot.capture(wd, strStep);
								  GenerateReport.test.log(LogStatus.FAIL, "Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));*/
							  }
							// Delete column table
							if(ModuleName.equalsIgnoreCase(module) && sValue.equalsIgnoreCase("Delete"))
							  {   
								 GenerateReport.test.log(LogStatus.PASS, strStep," "+Methodname+" : Permissions selected for "+ModuleName+" "+sValue);
								  boolean DeletePresent=wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[5]/select")).isDisplayed();
								  if(DeletePresent==true)
								  {
									   Select Delete=new Select(wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[5]/select")));
									   Delete.selectByVisibleText(selectvalue);
									   //System.out.println("SelectedValueforRead before = "+Delete);
			                      }
								  else
								  {
									  Select Delete=new Select(wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[5]/select")));
									  //System.out.println("fvsdgvbkjbgjbdskjbgk="+Delete);
									  Delete.selectByVisibleText(selectvalue);
									  //System.out.println("SelectedValueforRead After = "+Delete);
								  }
								  /*GenerateReport.test.log(LogStatus.FAIL, strStep," "+Methodname+" : Permissions is not matched with the given "+ModuleName+" "+sValue);
								  //String screenShotPath = GetScreenShot.capture(wd, strStep);
								  GenerateReport.test.log(LogStatus.FAIL, "Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));*/
							  }
							//Approver1 table
							if(ModuleName.equalsIgnoreCase(module) && sValue.equalsIgnoreCase("Approve1"))
							  {   
								GenerateReport.test.log(LogStatus.PASS, strStep," "+Methodname+" : Permissions selected for "+ModuleName+" "+sValue);
								  boolean Approve1Present=wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[2]/select")).isDisplayed();
								  if(Approve1Present==true)
								  {
									   Select Approve1=new Select(wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[2]/select")));
									   Approve1.selectByVisibleText(selectvalue);
									   //System.out.println("SelectedValueforRead before = "+Approve1);
			                      }
								  else
								  {
									  Select Approve1=new Select(wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[2]/select")));
									  //System.out.println("fvsdgvbkjbgjbdskjbgk="+Approve1);
									  Approve1.selectByVisibleText(selectvalue);
									  //System.out.println("SelectedValueforRead After = "+Approve1);
								  } 
								 /* GenerateReport.test.log(LogStatus.FAIL, strStep," "+Methodname+" : Permissions is not matched with the given "+ModuleName+" "+sValue);
								 // String screenShotPath = GetScreenShot.capture(wd, strStep);
								  GenerateReport.test.log(LogStatus.FAIL, "Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));*/
							  }
							//Approver2 table
							if(ModuleName.equalsIgnoreCase(module) && sValue.equalsIgnoreCase("Approve2"))
							  {   
								GenerateReport.test.log(LogStatus.PASS, strStep," "+Methodname+" : Permissions selected for "+ModuleName+" "+sValue);
								  boolean Approve2Present=wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[3]/select")).isDisplayed();
								  if(Approve2Present==true)
								  {
									   Select Approve2=new Select(wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[3]/select")));
									   Approve2.selectByVisibleText(selectvalue);
									   //System.out.println("SelectedValueforRead before = "+Approve2);
			                      }
								  else
								  {
									  Select Approve2=new Select(wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[3]/select")));
									  //System.out.println("fvsdgvbkjbgjbdskjbgk="+Approve2);
									  Approve2.selectByVisibleText(selectvalue);
									 // System.out.println("SelectedValueforRead After = "+Approve2);
								  } 
								 /* GenerateReport.test.log(LogStatus.FAIL, strStep," "+Methodname+" : Permissions is not matched with the given "+ModuleName+" "+sValue);
								  //String screenShotPath = GetScreenShot.capture(wd, strStep);
								  GenerateReport.test.log(LogStatus.FAIL, "Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));*/
							  }
							//Approver3 table
							if(ModuleName.equalsIgnoreCase(module) && sValue.equalsIgnoreCase("Approver3"))
							  {   
								GenerateReport.test.log(LogStatus.PASS, strStep," "+Methodname+" : Permissions selected for "+ModuleName+" "+sValue);
								  boolean Approve3Present=wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[4]/select")).isDisplayed();
								  if(Approve3Present==true)
								  {
									   Select Approver3=new Select(wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[4]/select")));
									   Approver3.selectByVisibleText(selectvalue);
									   //System.out.println("SelectedValueforRead before = "+Approver3);
			                      }
								  else
								  {
									  Select Approver3=new Select(wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[4]/select")));
									  System.out.println("fvsdgvbkjbgjbdskjbgk="+Approver3);
									  Approver3.selectByVisibleText(selectvalue);
									 // System.out.println("SelectedValueforRead After = "+Approver3);
								  } 
								  /*GenerateReport.test.log(LogStatus.FAIL, strStep," "+Methodname+" : Permissions is not matched with the given "+ModuleName+" "+sValue);
								 // String screenShotPath = GetScreenShot.capture(wd, strStep);
								  GenerateReport.test.log(LogStatus.FAIL, "Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));*/
							  }
							//Approver4 table
							if(ModuleName.equalsIgnoreCase(module) && sValue.equalsIgnoreCase("Approver4"))
							  {   
								GenerateReport.test.log(LogStatus.PASS, strStep," "+Methodname+" : Permissions selected for "+ModuleName+" "+sValue);
								  boolean Approve4Present=wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[5]/select")).isDisplayed();
								  if(Approve4Present==true)
								  {
									   Select Approver4=new Select(wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[5]/select")));
									   Approver4.selectByVisibleText(selectvalue);
									   //System.out.println("SelectedValueforRead before = "+Approver4);
			                      }
								  else
								  {
									  Select Approver4=new Select(wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[5]/select")));
									  System.out.println("fvsdgvbkjbgjbdskjbgk="+Approver4);
									  Approver4.selectByVisibleText(selectvalue);
									  //System.out.println("SelectedValueforRead After = "+Approver4);
								  } 
								  /*GenerateReport.test.log(LogStatus.FAIL, strStep," "+Methodname+" : Permissions is not matched with the given "+ModuleName+" "+sValue);
								  //String screenShotPath = GetScreenShot.capture(wd, strStep);
								  GenerateReport.test.log(LogStatus.FAIL, "Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));*/
							  }
							//Approver5 table
							if(ModuleName.equalsIgnoreCase(module) && sValue.equalsIgnoreCase("Approver5"))
							  {   
								GenerateReport.test.log(LogStatus.PASS, strStep," "+Methodname+" : Permissions selected for "+ModuleName+" "+sValue);
								  boolean Approve5Present=wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[6]/select")).isDisplayed();
								  if(Approve5Present==true)
								  {
									   Select Approver5=new Select(wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[6]/select")));
									   Approver5.selectByVisibleText(selectvalue);
									   System.out.println("SelectedValueforRead before = "+Approver5);
			                      }
								  else
								  {
									  Select Approver5=new Select(wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[6]/select")));
									  System.out.println("fvsdgvbkjbgjbdskjbgk="+Approver5);
									  Approver5.selectByVisibleText(selectvalue);
									  System.out.println("SelectedValueforRead After = "+Approver5);
								  } 
							  }
							/*GenerateReport.test.log(LogStatus.FAIL, strStep," "+Methodname+" : Permissions is not matched with the given "+ModuleName+" "+sValue);
							 // String screenShotPath = GetScreenShot.capture(wd, strStep);
							  GenerateReport.test.log(LogStatus.FAIL, "Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));*/
					 //break;
					  }
					  else if(ModulePresent==false)
					  {
						   
						  WebElement rowvalue=wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[1]"));
						  rowvalue.getText();
						  System.out.println( rowvalue.getText());
						  System.out.println("rowvalue false loop = "+rowvalue); 
						  //ModuleName=rowvalue;
						  /*GenerateReport.test.log(LogStatus.FAIL,strStep ," "+Methodname+" : Permissions not match with given" +sValue);
						  String screenShotPath = GetScreenShot.capture(wd, strStep);
						  GenerateReport.test.log(LogStatus.FAIL, "Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));*/
					  }
					  
					  //String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
					  //GenerateReport.getmethodname(Methodname, VolPayDriver.scenario, strStep);
				}
			break;
			}
			 
			}
	}
	catch (NoSuchElementException e) {
		// TODO Auto-generated catch block
			GenerateReport.test.log(LogStatus.FAIL, strStep, " Failed to find element "+e.getMessage());
		   String screenShotPath = GetScreenShot.capture(wd, strStep);
		   GenerateReport.test.log(LogStatus.FAIL,"Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));

		//st.Fail(wd, pr, strTCNum, strStep, ScenarioNum, strPath);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		  GenerateReport.test.log(LogStatus.FAIL, strStep ,"Run time exception Occured :- "+e.getMessage());
			String screenShotPath = GetScreenShot.capture(wd, strStep);
		   GenerateReport.test.log(LogStatus.FAIL,"Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
		
		//st.Exception(wd, pr, strTCNum, strStep, ScenarioNum, strPath);
	}
	  }
	                // wd.findElement(By.xpath("//button[contains(text(),'Update')]")).click();
 

public static void AddAttribute(WebDriver wd)
{
	             wd.findElement(By.xpath("//button[contains(text(),'Add New')]")).click();
	           
}
}


