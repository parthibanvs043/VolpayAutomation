package com.volante.volpayui;

import java.io.File;

import org.openqa.selenium.WebDriver;

import com.volante.BankData.BankDataBranch;
import com.volante.BankData.BankDataCalendar;
import com.volante.BankData.BankDataCountry;
import com.volante.BankData.BankDataCurrency;
import com.volante.BankData.BankDataDepartment;
import com.volante.BankData.BankDataFxRate;
import com.volante.BankData.BankDataOffice;
import com.volante.BankData.BankDataRegion;
import com.volante.DistributionData.DistributionDataBankRouting;
import com.volante.DistributionData.DistributionDataBulkProfile;
import com.volante.DistributionData.DistributionDataBulkProfileOverride;
import com.volante.DistributionData.DistributionDataCountryCorrespondent;
import com.volante.DistributionData.DistributionDataCurrencyCorrespondent;
import com.volante.DistributionData.DistributionDataCutOff;
import com.volante.DistributionData.DistributionDataMOP;
import com.volante.DistributionData.DistributionDataMOPPriority;
import com.volante.OnBoardingData.OnBoardingAccount;
import com.volante.OnBoardingData.OnBoardingParty;
import com.volante.OnBoardingData.OnBoardingProduct;
import com.volante.OnBoardingData.OnBoardingService;
import com.volante.OnBoardingData.OnBoardingServiceGroup;
import com.volante.PaymentModule.InitiateTransaction;
import com.volante.ReferenceData.AuditLog;
import com.volante.SystemData.ActionDefinition;
import com.volante.SystemData.ApplicationConfig;
import com.volante.SystemData.ApprovalCondition;
import com.volante.SystemData.IncidenceDefinition;
import com.volante.SystemData.LogConfiguration;
import com.volante.SystemData.StatusAction;
import com.volante.SystemData.StatusDefinition;
import com.volante.SystemData.VolPayIDConfiguration;
import com.volante.UserInformation.CreateUser;
import com.volante.UserInformation.CreateUserRole;
import com.volante.UserInformation.ForceReset;
import com.volante.UserInformation.SuperAdminPwdReset;
import com.volante.UserInformation.SuperAdminUser;

import jxl.Sheet;
import jxl.Workbook;

public class ReferenceDataExcel 
{
	@SuppressWarnings("unused")
	public static void RDExcelSheet(WebDriver wd, String destFile, String Sheetname)
	{ 
		   Sheet sheet;
        try 
        {
             Workbook wb = Workbook.getWorkbook(new File(destFile));
             System.out.println("ReferenceDataDriver.Methodname="+ReferenceDataDriver.Methodname);
         	 switch (ReferenceDataDriver.Methodname)
         	 {
         	         case "VolPayLogin": Login.VolPayLogin(wd, Sheetname, destFile);                 
                     break;
         	        case "DefaultLogin": Login.DefaultLogin(wd, Sheetname, destFile);                 
                    break;
         	        case "VolPayLogout": Login.VolPayLogout(wd, Sheetname, destFile);                 
                    break;
                     //Bank Data Execution Part
         	         case "ExecuteCalendar":BankDataCalendar.ExecuteCalendar(wd,Sheetname,destFile);
                     break;
         	         case "ExecuteCountry":BankDataCountry.ExecuteCountry(wd,Sheetname,destFile);
                     break;   
         	         case "ExecuteRegion": BankDataRegion.ExecuteRegion(wd,Sheetname,destFile);            
         	         break;
         	         case "ExecuteCurrency":BankDataCurrency.ExecuteCurrency(wd,Sheetname,destFile);      
         	         break;
         	         case "ExecuteDepartment":BankDataDepartment.ExecuteDepartment(wd,Sheetname,destFile);        
         	         break;
         	         case "ExecuteOffice":BankDataOffice.ExecuteOffice(wd,Sheetname,destFile);          
         	         break;
         	         case "ExecuteBranch":BankDataBranch.ExecuteBranch(wd,Sheetname,destFile);                
         	         break;
         	         case "ExecuteFxRate":BankDataFxRate.ExecuteFxRate(wd,Sheetname,destFile);              
         	         break;
         	         //Onboarding Modules
         	         case "ExecuteAccount":OnBoardingAccount.ExecuteAccount(wd, Sheetname, destFile);
                     break;
        	         case "ExecuteParty":OnBoardingParty.ExecuteParty(wd, Sheetname, destFile);
                     break;   
        	         case "ExecuteProduct": OnBoardingProduct.ExecuteProduct(wd, Sheetname, destFile);            
        	         break;
        	         case "ExecuteService":OnBoardingService.ExecuteService(wd, Sheetname, destFile);      
        	         break;
        	         case "ExecuteServiceGroup":OnBoardingServiceGroup.ExecuteServiceGroup(wd, Sheetname, destFile);        
        	         break;
        	         //Distribution Data Modules
         	         case "ExecuteBankRouting":DistributionDataBankRouting.ExecuteBankRouting(wd, Sheetname, destFile);
                     break;
        	         case "ExecuteCountryCorrespondent":DistributionDataCountryCorrespondent.ExecuteCountryCorrespondent(wd, Sheetname, destFile);
                     break;   
        	         case "ExecuteCurrencyCorrespondent": DistributionDataCurrencyCorrespondent.ExecuteCurrencyCorrespondent(wd, Sheetname, destFile);            
        	         break;
        	         case "ExecuteMOP":DistributionDataMOP.ExecuteMOP(wd, Sheetname, destFile);      
        	         break;
        	         case "ExecuteMOPPriority":DistributionDataMOPPriority.ExecuteMethodOfPaymentPriority(wd, Sheetname, destFile);        
        	         break;
        	         case "ExecuteCutOff":DistributionDataCutOff.ExecuteCutOff(wd, Sheetname, destFile);        
        	         break;
        	         case "ExecuteBulkProfile":DistributionDataBulkProfile.ExecuteBulkProfile(wd, Sheetname, destFile);        
        	         break;
        	         case "ExecuteBulkProfileOverride":DistributionDataBulkProfileOverride.ExecuteBulkProfileOverride(wd, Sheetname, destFile);        
        	         break;
        	         case "ExecuteInitiateTransaction":InitiateTransaction.ExecuteInitiateTransaction(wd, Sheetname, destFile);        
        	         break;        	         
        	         //SystemData
        	         case "ExecuteVolPayID":VolPayIDConfiguration.ExecuteVolPayID(wd, Sheetname, destFile);        
        	         break;
        	         case "ExecuteApplicationConfig":ApplicationConfig.ExecuteApplicationConfig(wd, Sheetname, destFile);        
        	         break;
        	         case "ExecuteActionDefinition":ActionDefinition.ExecuteActionDefinition(wd, Sheetname, destFile);        
        	         break;
        	         case "ExecuteStatusDefinition":StatusDefinition.ExecuteStatusDefinition(wd, Sheetname, destFile);        
        	         break;
        	         case "ExecuteIncidenceDefinition":IncidenceDefinition.ExecuteIncidenceDefinition(wd, Sheetname, destFile);        
        	         break;
        	         case "ExecuteStatusAction":StatusAction.ExecuteStatusAction(wd, Sheetname, destFile);        
        	         break;
        	         case "ExecuteLogConfiguration":LogConfiguration.ExecuteLogConfiguration(wd, Sheetname, destFile);        
        	         break;
        	         case "ExecuteApprovalCondition":ApprovalCondition.ExecuteApprovalCondition(wd, Sheetname, destFile);        
        	         break;   
        	        
        	         // User role & User creation
        	         case "ExecuteSuperAdmin":SuperAdminUser.ExecuteSuperAdmin(wd, Sheetname, destFile);        
        	         break;
        	         case "ExecuteAdminPwdReset":SuperAdminPwdReset.ExecuteAdminPwdReset(wd, Sheetname, destFile);        
        	         break;
        	         case "ExecuteCreateRole":CreateUserRole.ExecuteCreateRole(wd, Sheetname, destFile);        
        	         break;
        	         case "ExecuteCreateUser":CreateUser.ExecuteCreateUser(wd, Sheetname, destFile);        
        	         break;
        	         case "ExecuteForceReset":ForceReset.ExecuteForceReset(wd, Sheetname, destFile);        
        	         break;      	         
        	         case "AuditLogDetails":AuditLog.AuditLogDetails(wd, Sheetname, destFile);        
        	         break;
        	         
        	         
        	         
         	         default:            
         	     	 break;          
                        }
                  } catch(Exception ioe) 
                  {
                       ioe.printStackTrace();
                  }
             
          }

}
