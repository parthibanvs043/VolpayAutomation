package com.volante.Payments;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class OverrideObjectlist {
	public static String CancelButton, SubmitButton;
	public static String GroupStatusReasonVal,GroupStatusReasonInfoVal,OwnerVal,StatusReasonVal,NumberOfHitsVal,HitCategoryVal,OriginalStatusReasonVal,StatusInformationVal;
	public static void OverrideObject() throws DocumentException {

		String workingDir = System.getProperty("user.dir");
		File inputFile = new File(workingDir + "/src/main/resources/objectRespository/InterfaceOverride.xml");
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read(inputFile);
        
		
		SubmitButton = document.selectSingleNode("//InterfaceOverride/Submit").getText();
		CancelButton = document.selectSingleNode("//InterfaceOverride/Cancel").getText();
		
		//override fields
		GroupStatusReasonVal = document.selectSingleNode("//InterfaceOverride/Override/GroupStatusReason").getText();
		GroupStatusReasonInfoVal = document.selectSingleNode("//InterfaceOverride/Override/GroupStatusReasonInformation").getText();
		OwnerVal = document.selectSingleNode("//InterfaceOverride/Override/Owner").getText();
		StatusReasonVal = document.selectSingleNode("//InterfaceOverride/Override/StatusReason").getText();
		NumberOfHitsVal = document.selectSingleNode("//InterfaceOverride/Override/NumberOfHits").getText();
		HitCategoryVal = document.selectSingleNode("//InterfaceOverride/Override/HitCategory").getText();
		OriginalStatusReasonVal = document.selectSingleNode("//InterfaceOverride/Override/OriginalStatusReason").getText();
		StatusInformationVal = document.selectSingleNode("//InterfaceOverride/Override/StatusInformation").getText();
	}
}



