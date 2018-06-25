package com.volante.volpayui;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class LoginObjects {
	
	public static String VolPayUser,VolPayPassword,LoginButton,PaymentDashboard,Usertext;
	public static String Username,Logoutbutton;
	
public static void VolPayLogin() throws DocumentException {

		String workingDir = System.getProperty("user.dir");
		File inputFile = new File(workingDir + "/src/main/resources/objectRespository/Login.xml");
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read(inputFile);
		
		VolPayUser = document.selectSingleNode("//Login/Username").getText();
		VolPayPassword = document.selectSingleNode("//Login/Password").getText();
		LoginButton= document.selectSingleNode("//Login/submitbutton").getText();
		PaymentDashboard= document.selectSingleNode("//Login/PaymentDashBoardText").getText();
		Usertext= document.selectSingleNode("//Login/UserText").getText();
		// for logout
		Username= document.selectSingleNode("//Login/Logout/Username").getText();
		Logoutbutton= document.selectSingleNode("//Login/Logout/logoutbutton").getText();
		
	}


}
