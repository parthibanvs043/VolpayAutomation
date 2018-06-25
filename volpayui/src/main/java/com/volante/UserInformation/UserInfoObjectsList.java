package com.volante.UserInformation;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class UserInfoObjectsList {
	
	public static String GridView,GridViewAddButton;
	public static String UsernameVal,PasswordVal,SubmitButtonVal;
	public static String UserIDVal,FirstNameVal,LastNameVal,UserMailIDVal,adminpasswordVal,ConfirmPWVal,UserRoleIDVal,TimeZoneVal,	UserStatusVal,UserEffecFromDateVal,UserEffecTillDateVal,EffectiveFromDateVal,EffectiveTillDateVal,UserRoleStatusVal,ContinueVal,AdminSubmitVal,AdminBackVal;
	public static String OldPWVal,NewPWVal,ConfirmNewPWVal,UpdatebuttonVal;
	public static String AdminPanelLinkVal,UserMgmtLinkVal,RolesPermissionLinkVal;
	public static String RoleIDVal,RoleNameVal,RoleTypeVal,RoleStatusVal,RoleEffectiveFromDateVal,RoleEffectiveTillDateVal,BtnAddRoleVal;
	public static String FilterBtnVal,KeywordVal,SearchBtnVal,ResultVal,EditVal,IsForeceResetVal,EditSubmitVal;
	
	public static void UserInfoObject() throws DocumentException {
try{
		String workingDir = System.getProperty("user.dir");
		File inputFile = new File(workingDir + "/src/main/resources/objectRespository/UserInfo.xml");
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read(inputFile);
        
		// View buttons
		GridView = document.selectSingleNode("//UserInfo/GridView/View").getText();
		GridViewAddButton = document.selectSingleNode("//UserInfo/GridView/AddNewButton").getText();
		
		UsernameVal= document.selectSingleNode("//UserInfo/Login/Username").getText();
		PasswordVal = document.selectSingleNode("//UserInfo/Login/Password").getText();
		SubmitButtonVal = document.selectSingleNode("//UserInfo/Login/submitButton").getText();
		UserIDVal=document.selectSingleNode("//UserInfo/CreateUser/UserID").getText();
		FirstNameVal=document.selectSingleNode("//UserInfo/CreateUser/FirstName").getText();
		LastNameVal=document.selectSingleNode("//UserInfo/CreateUser/LastName").getText();
		UserMailIDVal=document.selectSingleNode("//UserInfo/CreateUser/UserMailID").getText();
		adminpasswordVal=document.selectSingleNode("//UserInfo/CreateUser/adminpassword").getText();
		ConfirmPWVal=document.selectSingleNode("//UserInfo/CreateUser/ConfirmPW").getText();
		UserRoleIDVal = document.selectSingleNode("//UserInfo/CreateUser/UserRoleID").getText();
		UserStatusVal =document.selectSingleNode("//UserInfo/CreateUser/UserStatus").getText();
		TimeZoneVal=document.selectSingleNode("//UserInfo/CreateUser/TimeZone").getText();
		UserEffecFromDateVal=document.selectSingleNode("//UserInfo/CreateUser/UserEffecFromDate").getText();
		UserEffecTillDateVal=document.selectSingleNode("//UserInfo/CreateUser/UserEffecTillDate").getText();
		UserRoleStatusVal =document.selectSingleNode("//UserInfo/CreateUser/UserRoleStatus").getText();
		EffectiveFromDateVal=document.selectSingleNode("//UserInfo/CreateUser/EffectiveFromDate").getText();
		EffectiveTillDateVal=document.selectSingleNode("//UserInfo/CreateUser/EffectiveTillDate").getText();
		ContinueVal=document.selectSingleNode("//UserInfo/CreateUser/Continue").getText();
		AdminSubmitVal=document.selectSingleNode("//UserInfo/CreateUser/AdminSubmit").getText();
		AdminBackVal=document.selectSingleNode("//UserInfo/CreateUser/AdminBack").getText();
		// PasswordReset
		OldPWVal =document.selectSingleNode("//UserInfo/PswdReset/OldPW").getText();
		NewPWVal=document.selectSingleNode("//UserInfo/PswdReset/NewPW").getText();
		ConfirmNewPWVal =document.selectSingleNode("//UserInfo/PswdReset/ConfirmNewPW").getText();
		UpdatebuttonVal =document.selectSingleNode("//UserInfo/PswdReset/Update").getText();
		//Links
		AdminPanelLinkVal =document.selectSingleNode("//UserInfo/Links/AdminPanel").getText();
		UserMgmtLinkVal =document.selectSingleNode("//UserInfo/Links/UserMgmt").getText();
		RolesPermissionLinkVal =document.selectSingleNode("//UserInfo/Links/RolesPermission").getText();
				
		//Roles&Resposibilities
		RoleIDVal =document.selectSingleNode("//UserInfo/Roles/RoleID").getText();
		RoleNameVal=document.selectSingleNode("//UserInfo/Roles/RoleName").getText();
		RoleTypeVal=document.selectSingleNode("//UserInfo/Roles/RoleType").getText();
		RoleStatusVal=document.selectSingleNode("//UserInfo/Roles/RoleStatus").getText();
		RoleEffectiveFromDateVal=document.selectSingleNode("//UserInfo/Roles/RoleEffectiveFromDate").getText();
		RoleEffectiveTillDateVal=document.selectSingleNode("//UserInfo/Roles/RoleEffectiveTillDate").getText();
		BtnAddRoleVal=document.selectSingleNode("//UserInfo/Roles/BtnAddRole").getText();
		
		//ForceReset
		FilterBtnVal =document.selectSingleNode("//UserInfo/ForceReset/FilterBtn").getText();
		KeywordVal =document.selectSingleNode("//UserInfo/ForceReset/Keyword").getText();
		SearchBtnVal =document.selectSingleNode("//UserInfo/ForceReset/SearchBtn").getText();
		ResultVal =document.selectSingleNode("//UserInfo/ForceReset/Result").getText();
		EditVal =document.selectSingleNode("//UserInfo/ForceReset/Edit").getText();
		IsForeceResetVal =document.selectSingleNode("//UserInfo/ForceReset/IsForeceReset").getText();
		EditSubmitVal =document.selectSingleNode("//UserInfo/ForceReset/EditSubmit").getText();			
}
catch (Exception e){
	System.out.println(" exception found");
}
	}
}
