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

public class RolesforPaymentModule 
{

public static void RoleforPayment(WebDriver wd,String dt,String module,String selectvalue, String strStep) throws IOException
	 {
		 String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
		try
		{
		  //Get number of rows In table.
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
					  GenerateReport.test.log(LogStatus.PASS,strStep ," "+Methodname+" : Permissions Selected as" +sValue);
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
							 
							  GenerateReport.test.log(LogStatus.PASS,strStep ," "+Methodname+" : Permissions Selected for" +ModuleName);
							  
				               System.out.println("rowvalue true loop = "+rowvalue);
							  // Accept Column table
								if(ModuleName.equalsIgnoreCase(module) && sValue.equalsIgnoreCase("Accept"))
								  {   
									  GenerateReport.test.log(LogStatus.PASS, strStep," "+Methodname+" : Permissions selected for "+ModuleName+" "+sValue);
									  boolean testelementdis=wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[2]/select")).isDisplayed();
									  if(testelementdis==true)
									  {
										   Select read=new Select(wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[2]/select")));
										   read.selectByVisibleText(selectvalue);  
				                      }
									  else
									  {
										  Select read=new Select(wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[2]/select")));
										 // System.out.println("fvsdgvbkjbgjbdskjbgk="+read);
										  read.selectByVisibleText(selectvalue);
										  //System.out.println("SelectedValueforRead After = "+read);
									  }
									  GenerateReport.test.log(LogStatus.FAIL, strStep," "+Methodname+" : Permissions is not matched with the given "+ModuleName+" "+sValue);
									  String screenShotPath = GetScreenShot.capture(wd, strStep);
									  GenerateReport.test.log(LogStatus.FAIL, "Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
								  }
								// Create column table
								if(ModuleName.equalsIgnoreCase(module) && sValue.equalsIgnoreCase("Add Notes"))
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
									  GenerateReport.test.log(LogStatus.FAIL, strStep," "+Methodname+" : Permissions is not matched with the given "+ModuleName+" "+sValue);
									  String screenShotPath = GetScreenShot.capture(wd, strStep);
									  GenerateReport.test.log(LogStatus.FAIL, "Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
								  }	
								//Update column table
								if(ModuleName.equalsIgnoreCase(module) && sValue.equalsIgnoreCase("Download"))
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
									  GenerateReport.test.log(LogStatus.FAIL, strStep," "+Methodname+" : Permissions is not matched with the given "+ModuleName+" "+sValue);
									  String screenShotPath = GetScreenShot.capture(wd, strStep);
									  GenerateReport.test.log(LogStatus.FAIL, "Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
								  }
								// Delete column table
								if(ModuleName.equalsIgnoreCase(module) && sValue.equalsIgnoreCase("File Upload"))
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
									  GenerateReport.test.log(LogStatus.FAIL, strStep," "+Methodname+" : Permissions is not matched with the given "+ModuleName+" "+sValue);
									  String screenShotPath = GetScreenShot.capture(wd, strStep);
									  GenerateReport.test.log(LogStatus.FAIL, "Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
								  }
								//Approver1 table
								if(ModuleName.equalsIgnoreCase(module) && sValue.equalsIgnoreCase("Read"))
								  {   
									GenerateReport.test.log(LogStatus.PASS, strStep," "+Methodname+" : Permissions selected for "+ModuleName+" "+sValue);
									  boolean Approve1Present=wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[6]/select")).isDisplayed();
									  if(Approve1Present==true)
									  {
										   Select Approve1=new Select(wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[6]/select")));
										   Approve1.selectByVisibleText(selectvalue);
										   //System.out.println("SelectedValueforRead before = "+Approve1);
				                      }
									  else
									  {
										  Select Approve1=new Select(wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[6]/select")));
										  //System.out.println("fvsdgvbkjbgjbdskjbgk="+Approve1);
										  Approve1.selectByVisibleText(selectvalue);
										  //System.out.println("SelectedValueforRead After = "+Approve1);
									  } 
									  GenerateReport.test.log(LogStatus.FAIL, strStep," "+Methodname+" : Permissions is not matched with the given "+ModuleName+" "+sValue);
									  String screenShotPath = GetScreenShot.capture(wd, strStep);
									  GenerateReport.test.log(LogStatus.FAIL, "Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
								  }
								//Approver2 table
								if(ModuleName.equalsIgnoreCase(module) && sValue.equalsIgnoreCase("Re Process"))
								  {   
									GenerateReport.test.log(LogStatus.PASS, strStep," "+Methodname+" : Permissions selected for "+ModuleName+" "+sValue);
									  boolean Approve2Present=wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[7]/select")).isDisplayed();
									  if(Approve2Present==true)
									  {
										   Select Approve2=new Select(wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[7]/select")));
										   Approve2.selectByVisibleText(selectvalue);
										   //System.out.println("SelectedValueforRead before = "+Approve2);
				                      }
									  else
									  {
										  Select Approve2=new Select(wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[7]/select")));
										  //System.out.println("fvsdgvbkjbgjbdskjbgk="+Approve2);
										  Approve2.selectByVisibleText(selectvalue);
										 // System.out.println("SelectedValueforRead After = "+Approve2);
									  } 
									  GenerateReport.test.log(LogStatus.FAIL, strStep," "+Methodname+" : Permissions is not matched with the given "+ModuleName+" "+sValue);
									  String screenShotPath = GetScreenShot.capture(wd, strStep);
									  GenerateReport.test.log(LogStatus.FAIL, "Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
								  }
								//Approver3 table
								if(ModuleName.equalsIgnoreCase(module) && sValue.equalsIgnoreCase("Reject"))
								  {   
									GenerateReport.test.log(LogStatus.PASS, strStep," "+Methodname+" : Permissions selected for "+ModuleName+" "+sValue);
									  boolean Approve3Present=wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[8]/select")).isDisplayed();
									  if(Approve3Present==true)
									  {
										   Select Approver3=new Select(wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[8]/select")));
										   Approver3.selectByVisibleText(selectvalue);
										   //System.out.println("SelectedValueforRead before = "+Approver3);
				                      }
									  else
									  {
										  Select Approver3=new Select(wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[8]/select")));
										  System.out.println("fvsdgvbkjbgjbdskjbgk="+Approver3);
										  Approver3.selectByVisibleText(selectvalue);
										 // System.out.println("SelectedValueforRead After = "+Approver3);
									  } 
									  GenerateReport.test.log(LogStatus.FAIL, strStep," "+Methodname+" : Permissions is not matched with the given "+ModuleName+" "+sValue);
									  String screenShotPath = GetScreenShot.capture(wd, strStep);
									  GenerateReport.test.log(LogStatus.FAIL, "Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
								  }
								//Approver4 table
								if(ModuleName.equalsIgnoreCase(module) && sValue.equalsIgnoreCase("Resend"))
								  {   
									GenerateReport.test.log(LogStatus.PASS, strStep," "+Methodname+" : Permissions selected for "+ModuleName+" "+sValue);
									  boolean Approve4Present=wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[9]/select")).isDisplayed();
									  if(Approve4Present==true)
									  {
										   Select Approver4=new Select(wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[9]/select")));
										   Approver4.selectByVisibleText(selectvalue);
										   //System.out.println("SelectedValueforRead before = "+Approver4);
				                      }
									  else
									  {
										  Select Approver4=new Select(wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[9]/select")));
										  System.out.println("fvsdgvbkjbgjbdskjbgk="+Approver4);
										  Approver4.selectByVisibleText(selectvalue);
										  //System.out.println("SelectedValueforRead After = "+Approver4);
									  } 
									  GenerateReport.test.log(LogStatus.FAIL, strStep," "+Methodname+" : Permissions is not matched with the given "+ModuleName+" "+sValue);
									  String screenShotPath = GetScreenShot.capture(wd, strStep);
									  GenerateReport.test.log(LogStatus.FAIL, "Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
								  }
								//Approver5 table
								if(ModuleName.equalsIgnoreCase(module) && sValue.equalsIgnoreCase("Bulk Payments"))
								  {   
									GenerateReport.test.log(LogStatus.PASS, strStep," "+Methodname+" : Permissions selected for "+ModuleName+" "+sValue);
									  boolean Approve5Present=wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[10]/select")).isDisplayed();
									  if(Approve5Present==true)
									  {
										   Select Approver5=new Select(wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[10]/select")));
										   Approver5.selectByVisibleText(selectvalue);
										   System.out.println("SelectedValueforRead before = "+Approver5);
				                      }
									  else
									  {
										  Select Approver5=new Select(wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[10]/select")));
										  System.out.println("fvsdgvbkjbgjbdskjbgk="+Approver5);
										  Approver5.selectByVisibleText(selectvalue);
										  System.out.println("SelectedValueforRead After = "+Approver5);
									  }
									  if(ModuleName.equalsIgnoreCase(module) && sValue.equalsIgnoreCase("Cancel Payment"))
									  {   
									       GenerateReport.test.log(LogStatus.PASS, strStep," "+Methodname+" : Permissions selected for "+ModuleName+" "+sValue);
										   boolean CancelPayment=wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[11]/select")).isDisplayed();
										   if(CancelPayment==true)
											{
											  Select CancelPaymentselect=new Select(wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[11]/select")));
											  CancelPaymentselect.selectByVisibleText(selectvalue);
											  System.out.println("SelectedValueforRead before = "+CancelPaymentselect);
										    }
										 else
											{
											  Select CancelPaymentselect=new Select(wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[11]/select")));
											  System.out.println("fvsdgvbkjbgjbdskjbgk="+CancelPaymentselect);
											  CancelPaymentselect.selectByVisibleText(selectvalue);
											  System.out.println("SelectedValueforRead After = "+CancelPaymentselect);
										    } 
									  }
									  
									if(ModuleName.equalsIgnoreCase(module) && sValue.equalsIgnoreCase("Generate RFI"))
									  {   
									       GenerateReport.test.log(LogStatus.PASS, strStep," "+Methodname+" : Permissions selected for "+ModuleName+" "+sValue);
										   boolean GenerateRFI=wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[12]/select")).isDisplayed();
										   if(GenerateRFI==true)
											{
											  Select GenerateRFISelect=new Select(wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[12]/select")));
											  GenerateRFISelect.selectByVisibleText(selectvalue);
											  System.out.println("SelectedValueforRead before = "+GenerateRFISelect);
										    }
										 else
											{
											  Select GenerateRFISelect=new Select(wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[12]/select")));
											  System.out.println("fvsdgvbkjbgjbdskjbgk="+GenerateRFISelect);
											  GenerateRFISelect.selectByVisibleText(selectvalue);
											  System.out.println("SelectedValueforRead After = "+GenerateRFISelect);
										    } 
									  }
									  
									if(ModuleName.equalsIgnoreCase(module) && sValue.equalsIgnoreCase("Generate ROF"))
									  {   
									       GenerateReport.test.log(LogStatus.PASS, strStep," "+Methodname+" : Permissions selected for "+ModuleName+" "+sValue);
										   boolean GenerateROF=wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[13]/select")).isDisplayed();
										   if(GenerateROF==true)
											{
											  Select GenerateROFSelect=new Select(wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[13]/select")));
											  GenerateROFSelect.selectByVisibleText(selectvalue);
											  System.out.println("SelectedValueforRead before = "+GenerateROFSelect);
										    }
										 else
											{
											  Select GenerateROFSelect=new Select(wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[13]/select")));
											  System.out.println("fvsdgvbkjbgjbdskjbgk="+GenerateROFSelect);
											  GenerateROFSelect.selectByVisibleText(selectvalue);
											  System.out.println("SelectedValueforRead After = "+GenerateROFSelect);
										    } 
									  }
									if(ModuleName.equalsIgnoreCase(module) && sValue.equalsIgnoreCase("Generate RRFI"))
									  {   
									       GenerateReport.test.log(LogStatus.PASS, strStep," "+Methodname+" : Permissions selected for "+ModuleName+" "+sValue);
										   boolean GenerateRRFI=wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[14]/select")).isDisplayed();
										   if(GenerateRRFI==true)
											{
											  Select GenerateRRFISelect=new Select(wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[14]/select")));
											  GenerateRRFISelect.selectByVisibleText(selectvalue);
											  System.out.println("SelectedValueforRead before = "+GenerateRRFISelect);
										    }
										 else
											{
											  Select GenerateRRFISelect=new Select(wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[14]/select")));
											  System.out.println("fvsdgvbkjbgjbdskjbgk="+GenerateRRFISelect);
											  GenerateRRFISelect.selectByVisibleText(selectvalue);
											  System.out.println("SelectedValueforRead After = "+GenerateRRFISelect);
										    } 
									  }
									if(ModuleName.equalsIgnoreCase(module) && sValue.equalsIgnoreCase("Generate RRFP"))
									  {   
									       GenerateReport.test.log(LogStatus.PASS, strStep," "+Methodname+" : Permissions selected for "+ModuleName+" "+sValue);
										   boolean GenerateRRFP=wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[15]/select")).isDisplayed();
										   if(GenerateRRFP==true)
											{
											  Select GenerateRRFPSelect=new Select(wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[15]/select")));
											  GenerateRRFPSelect.selectByVisibleText(selectvalue);
											  System.out.println("SelectedValueforRead before = "+GenerateRRFPSelect);
										    }
										 else
											{
											  Select GenerateRRFPSelect=new Select(wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[15]/select")));
											  System.out.println("fvsdgvbkjbgjbdskjbgk="+GenerateRRFPSelect);
											  GenerateRRFPSelect.selectByVisibleText(selectvalue);
											  System.out.println("SelectedValueforRead After = "+GenerateRRFPSelect);
										    } 
									  }
									if(ModuleName.equalsIgnoreCase(module) && sValue.equalsIgnoreCase("Generate RROF"))
									  {   
									       GenerateReport.test.log(LogStatus.PASS, strStep," "+Methodname+" : Permissions selected for "+ModuleName+" "+sValue);
										   boolean GenerateRROF=wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[16]/select")).isDisplayed();
										   if(GenerateRROF==true)
											{
											  Select GenerateRROFSelect=new Select(wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[16]/select")));
											  GenerateRROFSelect.selectByVisibleText(selectvalue);
											  System.out.println("SelectedValueforRead before = "+GenerateRROFSelect);
										    }
										 else
											{
											  Select GenerateRROFSelect=new Select(wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[16]/select")));
											  System.out.println("fvsdgvbkjbgjbdskjbgk="+GenerateRROFSelect);
											  GenerateRROFSelect.selectByVisibleText(selectvalue);
											  System.out.println("SelectedValueforRead After = "+GenerateRROFSelect);
										    } 
									  }
									if(ModuleName.equalsIgnoreCase(module) && sValue.equalsIgnoreCase("Override"))
									  {   
									       GenerateReport.test.log(LogStatus.PASS, strStep," "+Methodname+" : Permissions selected for "+ModuleName+" "+sValue);
										   boolean Override=wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[17]/select")).isDisplayed();
										   if(Override==true)
											{
											  Select OverrideSelect=new Select(wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[17]/select")));
											  OverrideSelect.selectByVisibleText(selectvalue);
											  System.out.println("SelectedValueforRead before = "+OverrideSelect);
										    }
										 else
											{
											  Select OverrideSelect=new Select(wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[17]/select")));
											  System.out.println("fvsdgvbkjbgjbdskjbgk="+OverrideSelect);
											  OverrideSelect.selectByVisibleText(selectvalue);
											  System.out.println("SelectedValueforRead After = "+OverrideSelect);
										    } 
									  }
									if(ModuleName.equalsIgnoreCase(module) && sValue.equalsIgnoreCase("Payment Ack"))
									  {   
									       GenerateReport.test.log(LogStatus.PASS, strStep," "+Methodname+" : Permissions selected for "+ModuleName+" "+sValue);
										   boolean PaymentAck=wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[18]/select")).isDisplayed();
										   if(PaymentAck==true)
											{
											  Select PaymentAckSelect=new Select(wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[18]/select")));
											  PaymentAckSelect.selectByVisibleText(selectvalue);
											  System.out.println("SelectedValueforRead before = "+PaymentAckSelect);
										    }
										 else
											{
											  Select PaymentAckSelect=new Select(wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[18]/select")));
											  System.out.println("fvsdgvbkjbgjbdskjbgk="+PaymentAckSelect);
											  PaymentAckSelect.selectByVisibleText(selectvalue);
											  System.out.println("SelectedValueforRead After = "+PaymentAckSelect);
										    } 
									  }
									if(ModuleName.equalsIgnoreCase(module) && sValue.equalsIgnoreCase("Payment Confirmation"))
									  {   
									       GenerateReport.test.log(LogStatus.PASS, strStep," "+Methodname+" : Permissions selected for "+ModuleName+" "+sValue);
										   boolean PaymentConfirmation=wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[19]/select")).isDisplayed();
										   if(PaymentConfirmation==true)
											{
											  Select PaymentConfirmationSelect=new Select(wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[19]/select")));
											  PaymentConfirmationSelect.selectByVisibleText(selectvalue);
											  System.out.println("SelectedValueforRead before = "+PaymentConfirmationSelect);
										    }
										 else
											{
											  Select PaymentConfirmationSelect=new Select(wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[19]/select")));
											  System.out.println("fvsdgvbkjbgjbdskjbgk="+PaymentConfirmationSelect);
											  PaymentConfirmationSelect.selectByVisibleText(selectvalue);
											  System.out.println("SelectedValueforRead After = "+PaymentConfirmationSelect);
										    } 
									  }
									if(ModuleName.equalsIgnoreCase(module) && sValue.equalsIgnoreCase("Payment Initiation"))
									  {   
									       GenerateReport.test.log(LogStatus.PASS, strStep," "+Methodname+" : Permissions selected for "+ModuleName+" "+sValue);
										   boolean PaymentInitiation=wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[20]/select")).isDisplayed();
										   if(PaymentInitiation==true)
											{
											  Select PaymentInitiationSelect=new Select(wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[20]/select")));
											  PaymentInitiationSelect.selectByVisibleText(selectvalue);
											  System.out.println("SelectedValueforRead before = "+PaymentInitiationSelect);
										    }
										 else
											{
											  Select PaymentInitiationSelect=new Select(wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[20]/select")));
											  System.out.println("fvsdgvbkjbgjbdskjbgk="+PaymentInitiationSelect);
											  PaymentInitiationSelect.selectByVisibleText(selectvalue);
											  System.out.println("SelectedValueforRead After = "+PaymentInitiationSelect);
										    } 
									  }
									if(ModuleName.equalsIgnoreCase(module) && sValue.equalsIgnoreCase("Repair"))
									  {   
									       GenerateReport.test.log(LogStatus.PASS, strStep," "+Methodname+" : Permissions selected for "+ModuleName+" "+sValue);
										   boolean Repair=wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[21]/select")).isDisplayed();
										   if(Repair==true)
											{
											  Select RepairSelect=new Select(wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[21]/select")));
											  RepairSelect.selectByVisibleText(selectvalue);
											  System.out.println("SelectedValueforRead before = "+RepairSelect);
										    }
										 else
											{
											  Select RepairSelect=new Select(wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[21]/select")));
											  System.out.println("fvsdgvbkjbgjbdskjbgk="+RepairSelect);
											  RepairSelect.selectByVisibleText(selectvalue);
											  System.out.println("SelectedValueforRead After = "+RepairSelect);
										    } 
									  }
								  }
								GenerateReport.test.log(LogStatus.FAIL, strStep," "+Methodname+" : Permissions is not matched with the given "+ModuleName+" "+sValue);
								  String screenShotPath = GetScreenShot.capture(wd, strStep);
								  GenerateReport.test.log(LogStatus.FAIL, "Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
						  }
						  else if(ModulePresent==false)
						  {
							   
							  WebElement rowvalue=wd.findElement(By.xpath(".//*[@id='rolesTable']/tbody/tr["+r+"]/td[1]"));
							  rowvalue.getText();
							  System.out.println( rowvalue.getText());
							  System.out.println("rowvalue false loop = "+rowvalue); 
							  //ModuleName=rowvalue;
						  }
						  //String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
						  //GenerateReport.getmethodname(Methodname, VolPayDriver.scenario, strStep);
					}
				}
				 GenerateReport.test.log(LogStatus.FAIL,strStep ," "+Methodname+" : Permissions not match with given" +sValue);
				  String screenShotPath = GetScreenShot.capture(wd, strStep);
				  GenerateReport.test.log(LogStatus.FAIL, "Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
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
	 

}
