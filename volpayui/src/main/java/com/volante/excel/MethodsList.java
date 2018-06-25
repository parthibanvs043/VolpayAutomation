package com.volante.excel;

import org.openqa.selenium.WebDriver;

import com.volante.Payments.ReadPayments;
import com.volante.Payments.UploadFile;
import com.volante.app.*;
import com.volante.calender.*;
import com.volante.elements.*;
import com.volante.instructions.ReadInstruction;
import com.volante.pages.*;
import com.volante.roles.ReadRolesandPermissions;
import com.volante.table.ByColumn;
import com.volante.timeout.WaitTime;
import com.volante.view.viewtype;
import com.volante.windowshandles.HadlingBrowserTabs;
import com.volante.xmlreader.CopyFile;
import com.volante.xmlreader.DeleteTables;
import com.volante.xmlreader.ModifyFile;

public class MethodsList 
{
	
public static void CallMethods(WebDriver wda,String met,String prop,String data,String stepDesc,String destFile,int Sheetno) throws Exception
{
	 switch (met) 
	 {
     case "Launch_App":LaunchApplication.Launch_App(wda, prop,stepDesc);                   
     break;
     case "Enter_ID":ElementByID.Enter_ID(wda,prop,data,stepDesc);
     break;
     case "Click_ID":ElementByID.Click_ID(wda,prop,stepDesc);
     break;
     case "Select_ID":ElementByID.Select_ID(wda,prop,data,stepDesc);
     break;
     case "DropDown_Text_ID":ElementByID.DropDown_Text_ID(wda,prop,data,stepDesc);
     break;
     case "DropDown_Index_ID":ElementByID.DropDown_Index_ID(wda,prop,data,stepDesc);
     break;
     case "View_ID":ElementByID.View_ID(wda,prop,stepDesc);
     break;
     case "Enter_Name":ElementByName.Enter_Name(wda,prop,data,stepDesc);
     break;
     case "Click_Name":ElementByName.Click_Name(wda,prop,stepDesc);
     break;
     case "Select_Name":ElementByName.Select_Name(wda,prop,data,stepDesc);
     break;
     case "DropDown_Text_Name":ElementByName.DropDown_Text_Name(wda,prop,data,stepDesc);
     break;
     case "DropDown_Index_Name":ElementByName.DropDown_Index_Name(wda,prop,data,stepDesc);
     break;
     case "View_Name":ElementByName.View_Name(wda,prop,stepDesc);
     break;
     case "Enter_CSS":ElementByCSS.Enter_CSS(wda,prop,data,stepDesc);
     break;
     case "Click_CSS":ElementByCSS.Click_CSS(wda,prop,stepDesc);
     break;
     case "Select_CSS":ElementByCSS.Select_CSS(wda,prop,data,stepDesc);
     break;
     case "DropDown_Text_CSS":ElementByCSS.DropDown_Text_CSS(wda,prop,data,stepDesc);
     break;
     case "DropDown_Index_CSS":ElementByCSS.DropDown_Index_CSS(wda,prop,data,stepDesc);
     break;
     case "View_CSS":ElementByCSS.View_CSS(wda,prop,stepDesc);
     break;
     case "Enter_XPath":ElementByXPATH.Enter_XPath(wda,prop,data,stepDesc);
     break;
     case "Click_XPath":ElementByXPATH.Click_XPath(wda,prop,stepDesc);
     break;
     case "Select_XPath":ElementByXPATH.Select_XPath(wda,prop,data,stepDesc);
     break;
     case "DropDown_Text_XPath":ElementByXPATH.DropDown_Text_XPath(wda,prop,data,stepDesc);
     break;
     case "DropDown_Index_XPath":ElementByXPATH.DropDown_Index_XPath(wda,prop,data,stepDesc);
     break;
     case "View_XPath":ElementByXPATH.View_XPath(wda,prop,stepDesc);
     break;
     case "Click_Link":ElementByLinks.Click_Link(wda,prop,stepDesc);
     break;
     case "Verify_linkText":ElementByLinks.Verify_linkText(wda,prop,stepDesc);
     break;
      // Need to Change the below Methods
     case "FromDate": CalenderFromDate.FromDate(wda,prop,stepDesc);
	 break;
     case "TillDate": CalenderTillDate.TillDate(wda,prop,stepDesc);
	 break;
     case "SelectDate": GetDate.SelectDate(wda,prop,stepDesc);
	 break;
     case "ScrollDownByXPath": PageScrollDown.ScrollDownByXPath(wda,prop,stepDesc);
	 break;
     case "ScrollDownByName": PageScrollDown.ScrollDownByName(wda,prop,stepDesc);
	 break;
     case "ScrollDownById": PageScrollDown.ScrollDownById(wda,prop,stepDesc);
	 break;
     case "ScrollDownByCSS": PageScrollDown.ScrollDownByCSS(wda,prop,stepDesc);
	 break;
     case "ScrollDownByPosition": ScrollDown.ScrollDownByPosition(wda,prop,data,stepDesc);
	 break;
     case "RadioEnter_name": RadioButton.RadioEnter_name(wda,prop,data,stepDesc);
	  break;
     case "RadioEnter_Id": RadioButton.RadioEnter_Id(wda,prop,data,stepDesc);
	  break;
     case "GetStatusByID": StatusBox.GetStatusByID(wda,prop,data,stepDesc);
	  break;
     case "MultiSelect_CSS": MultiSelect.MultiSelect_CSS(wda,prop,data,stepDesc);
	  break;
     case "MultiSelect_Id": MultiSelect.MultiSelect_Id(wda,prop,data,stepDesc);
	  break;
     case "MultiSelect_XPath": MultiSelect.MultiSelect_XPath(wda,prop,data,stepDesc);
	  break;
     case "Click_Class":ElementByClass.Click_Class(wda,prop,stepDesc);
     break;
     case "Quit_Driver": CloseApplication.Quit_Driver(wda,stepDesc);
	  break;
     case "OpenBrowserinSameWindow": HadlingBrowserTabs.OpenBrowserinSameWindow(wda,prop,stepDesc);
	  break;
     case "AdminWindow": HadlingBrowserTabs.AdminWindow(wda,stepDesc);
	  break;
     case "ApproverWindow": HadlingBrowserTabs.ApproverWindow(wda,stepDesc);
	  break;
     case "verifyTextinPage": PageText.verifyTextinPage(wda,prop,data,stepDesc);
	  break;
     case "Text_XPath": TextValidation.Text_XPath(wda,prop,data,stepDesc);
	  break;
     case "NoText_XPath": TextValidation.NoText_XPath(wda,prop,data,stepDesc);
	  break;
     case "CheckingChkbox": CheckBox.CheckingChkbox(wda,prop,stepDesc);
	  break;
     case "TextPresent_XPath": TextValidation.TextPresent_XPath(wda,prop,data,stepDesc);
	  break;
     case "ByColumnName": ByColumn.ByColumnName(wda,prop,data,stepDesc);
	  break;
     case "OperatorWindow": HadlingBrowserTabs.OperatorWindow(wda,stepDesc);
	  break;
     case "DropListSelectText_Xpath": DropListSelect.DropListSelectText_Xpath(wda,prop,data,stepDesc);
	  break;
     case "DropListSelectText_CSS": DropListSelect.DropListSelectText_CSS(wda,prop,data,stepDesc);
	  break;
     case "grid": viewtype.grid(wda,stepDesc);
	  break;
     case "list": viewtype.list(wda,stepDesc);
	  break;
     case "Fileupload": UploadFile.Fileupload(wda,prop,data,stepDesc);
	 break;
     case "PaymentProcessing": ReadPayments.PaymentProcessing(wda,prop,data,stepDesc,destFile,Sheetno);
	 break;
     case "InstructionProcessing": ReadInstruction.InstructionProcessing(wda,data,stepDesc);
	 break;
     case "DropTable": DeleteTables.DropTable(stepDesc);
	 break;
	 case "Copyxml": CopyFile.Copyxml(prop,data);
	 break;
	 case "ReponsePac02": ModifyFile.ReponsePac02(data);
	 break;
	 case "Pacs008": ModifyFile.Pacs008(data);
	 break;
	 case "RemittanceResponseFile": ModifyFile.RemittanceResponseFile(data);
	 break;
	 case "WaitInSeconds": WaitTime.WaitInSeconds(wda,data,stepDesc);
	 break;
	 case "Mouseclick_CSS":MouseOver.Mouseclick_CSS(wda,prop,stepDesc);
     break;
	 case "SelectText_Xpath":DropListSelect.SelectText_Xpath(wda,prop,data,stepDesc);
     break;
	 case "DropdownSelectAction_Xpath":DropListSelect.DropdownSelectAction_Xpath(wda,prop,data,stepDesc);
	 break;
	 case "DropListEnterText_Xpath":DropListSelect.DropListEnterText_Xpath(wda,prop,data,stepDesc);
	 break;
	 case "ClearingPacs02":ModifyFile.ClearingPacs02(data);
	 break;
	 case "ButtonsAlert":HandleAlert.ButtonsAlert(wda,prop,data,stepDesc);
	 break;
	/* case "DropdownEnterVal":DropListSelect.DropdownEnterVal(wda,prop,data,stepDesc);
	 	break;*/
	  default:            
	  break;

}
}
public static void RoleMethods(WebDriver wda,String met,String prop,String data,String stepDesc,String modulename ,String permval) throws Exception
{
	 switch (met) 
	 { 
	      case "Role": ReadRolesandPermissions.Role(wda,data,modulename,permval,stepDesc);
	      break;
         default:            
         break;
 }
}
}

