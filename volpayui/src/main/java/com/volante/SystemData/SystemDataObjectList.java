package com.volante.SystemData;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class SystemDataObjectList {

	public static String SystemData, SubmitButton, GridViewAddButton, GridView, EffectiveTillDateVal, SuccessMsg,
			ChangeModule;

	public static String ApplicationConfigLinkVal, VolPayIDConfigurationLinkVal, ActionDefinitionLinkVal,
			StatusDefinitionLinkVal, IncidenceDefinitionLinkVal, StatusActionLinkVal, LogConfigurationLinkVal,
			ApprovalConditionLinkVal;

	public static String ACNameVal, ACValueVal, ACTypeVal;

	public static String VIDIDCodeVal, VIDPatternVal, VIDMinimumLengthVal, VIDMaximumLengthVal, VIDFixLengthVal,
			VIDFlowNameVal, VIDIsDefaultVal;

	public static String ADActionNameVal, ADWorkFlowCodeVal, ADDescriptionVal, ADFunctionNameVal, ADRestURLVal,
			ADRestMethodVal, ADSuccessURLVal, ADFailureURLVal, ADFlowNameVal, ADAdditionalConfigVal, ADStatusVal,
			ADEffectiveFromDateVal, ADEffectiveTillDateVal, ADDualControlRequiredVal, ADMandateNoteVal,
			ADGroupActionAllowedVal, ADAliasNameVal, ADClientAliasNameVal;
	public static String SDProcessStatusVal, SDWorkFlowCodeVal, SDDescriptionVal,SDUserControlVal,SDStatusVal,SDColourAVal,SDColourBVal,SDOpacityVal,SDEffectiveFromDateVal,SDEffectiveTillDateVal,SDAliasNameVal,SDClientAliasNameVal;
	
	public static String IDIncidenceTypeVal,IDIncidenceCodeVal,IDProcessNameVal,IDPSACodeVal,IDWorkFlowCodeVal,IDDescriptionVal,IDProcessStatusVal,IDIncidenceResolutionVal,IDSeverityVal,IDStatusVal,IDEffectiveFromDateVal,IDEffectiveTillDateVal,IDIncidenceOriginVal,IDCanClientSetPreferenceVal,IDOperationsSeverityPreferenceVal,IDClientSeverityPreferenceVal,IDRepairandManualInputVal;
	
	public static String SAWorkFlowCodeVal,SAActionVal,SAProcessStatusVal,SAProcessNameVal,SAStatusVal,SAEffectiveFromDateVal,SAEffectiveTillDateVal;
	public static String LCApplicationNameVal,LCCategoryVal,LCLogLevelVal,LCAppendersVal;
	public static String ACApprovalCountVal,ACResourceNameVal,ACOperationVal,ACStatusVal,ACEffectiveFromDateVal,ACEffectiveTillDateVal,ACAttributeNameVal,ACOperatorVal,ACondValueVal;
	
	
	public static void SystemDataObject() throws DocumentException {

		String workingDir = System.getProperty("user.dir");
		File inputFile = new File(workingDir + "/src/main/resources/objectRespository/SystemData.xml");
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read(inputFile);
		SystemData = document.selectSingleNode("//SystemData/SystemDataModule").getText();
		SubmitButton = document.selectSingleNode("//SystemData/Submit").getText();
		SuccessMsg = document.selectSingleNode("//SystemData/statusBox").getText();
		ChangeModule = document.selectSingleNode("//SystemData/ChangesModule").getText();
		// View buttons
		GridView = document.selectSingleNode("//SystemData/GridView/View").getText();
		GridViewAddButton = document.selectSingleNode("//SystemData/GridView/AddNewButton").getText();

		// Links in System Data Module
		ApplicationConfigLinkVal = document.selectSingleNode("//SystemData/Links/ApplicationConfigLink").getText();
		VolPayIDConfigurationLinkVal = document.selectSingleNode("//SystemData/Links/VolPayIDConfigurationLink").getText();
		ActionDefinitionLinkVal = document.selectSingleNode("//SystemData/Links/ActionDefinitionLink").getText();
		StatusDefinitionLinkVal = document.selectSingleNode("//SystemData/Links/StatusDefinitionLink").getText();
		IncidenceDefinitionLinkVal = document.selectSingleNode("//SystemData/Links/IncidenceDefinitionLink").getText();
		StatusActionLinkVal = document.selectSingleNode("//SystemData/Links/StatusActionLink").getText();
		LogConfigurationLinkVal = document.selectSingleNode("//SystemData/Links/LogConfigurationLink").getText();
		ApprovalConditionLinkVal = document.selectSingleNode("//SystemData/Links/ApprovalConditionLink").getText();

		// Application Config :
		ACNameVal = document.selectSingleNode("//SystemData/ApplicationConfig/Name").getText();
		ACValueVal = document.selectSingleNode("//SystemData/ApplicationConfig/Value").getText();
		ACTypeVal = document.selectSingleNode("//SystemData/ApplicationConfig/Type").getText();

		// VolPayIDConfiguration Config :
		VIDIDCodeVal = document.selectSingleNode("//SystemData/VolPayIDConfiguration/IDCode").getText();
		VIDPatternVal = document.selectSingleNode("//SystemData/VolPayIDConfiguration/Pattern").getText();
		VIDMinimumLengthVal = document.selectSingleNode("//SystemData/VolPayIDConfiguration/MinimumLength").getText();
		VIDMaximumLengthVal = document.selectSingleNode("//SystemData/VolPayIDConfiguration/MaximumLength").getText();
		VIDFixLengthVal = document.selectSingleNode("//SystemData/VolPayIDConfiguration/FixLength").getText();
		VIDFlowNameVal = document.selectSingleNode("//SystemData/VolPayIDConfiguration/FlowName").getText();
		VIDIsDefaultVal = document.selectSingleNode("//SystemData/VolPayIDConfiguration/IsDefault").getText();

		// Action Definition
		ADActionNameVal = document.selectSingleNode("//SystemData/ActionDefinition/ActionName").getText();
		ADWorkFlowCodeVal = document.selectSingleNode("//SystemData/ActionDefinition/WorkFlowCode").getText();
		ADDescriptionVal = document.selectSingleNode("//SystemData/ActionDefinition/Description").getText();
		ADFunctionNameVal = document.selectSingleNode("//SystemData/ActionDefinition/FunctionName").getText();
		ADRestURLVal = document.selectSingleNode("//SystemData/ActionDefinition/RestURL").getText();
		ADRestMethodVal = document.selectSingleNode("//SystemData/ActionDefinition/RestMethod").getText();
		ADSuccessURLVal = document.selectSingleNode("//SystemData/ActionDefinition/SuccessURL").getText();
		ADFailureURLVal = document.selectSingleNode("//SystemData/ActionDefinition/FailureURL").getText();
		ADFlowNameVal = document.selectSingleNode("//SystemData/ActionDefinition/FlowName").getText();
		ADAdditionalConfigVal = document.selectSingleNode("//SystemData/ActionDefinition/AdditionalConfig").getText();
		ADStatusVal = document.selectSingleNode("//SystemData/ActionDefinition/Status").getText();
		ADEffectiveFromDateVal = document.selectSingleNode("//SystemData/ActionDefinition/EffectiveFromDate").getText();
		ADEffectiveTillDateVal = document.selectSingleNode("//SystemData/ActionDefinition/EffectiveTillDate").getText();
		ADDualControlRequiredVal = document.selectSingleNode("//SystemData/ActionDefinition/DualControlRequired").getText();
		ADMandateNoteVal = document.selectSingleNode("//SystemData/ActionDefinition/MandateNote").getText();
		ADGroupActionAllowedVal = document.selectSingleNode("//SystemData/ActionDefinition/GroupActionAllowed").getText();
		ADAliasNameVal = document.selectSingleNode("//SystemData/ActionDefinition/AliasName").getText();
		ADClientAliasNameVal = document.selectSingleNode("//SystemData/ActionDefinition/ClientAliasName").getText();

		//Status Definition
		SDProcessStatusVal = document.selectSingleNode("//SystemData/StatusDefinition/ProcessStatus").getText();
		SDWorkFlowCodeVal = document.selectSingleNode("//SystemData/StatusDefinition/WorkFlowCode").getText();
		SDDescriptionVal = document.selectSingleNode("//SystemData/StatusDefinition/Description").getText();
		SDUserControlVal = document.selectSingleNode("//SystemData/StatusDefinition/UserControl").getText();
		SDStatusVal = document.selectSingleNode("//SystemData/StatusDefinition/Status").getText();
		SDColourAVal = document.selectSingleNode("//SystemData/StatusDefinition/ColourA").getText();
		SDColourBVal = document.selectSingleNode("//SystemData/StatusDefinition/ColourB").getText();
		SDOpacityVal = document.selectSingleNode("//SystemData/StatusDefinition/Opacity").getText();
		SDEffectiveFromDateVal = document.selectSingleNode("//SystemData/StatusDefinition/EffectiveFromDate").getText();
		SDEffectiveTillDateVal = document.selectSingleNode("//SystemData/StatusDefinition/EffectiveTillDate").getText();
		SDAliasNameVal = document.selectSingleNode("//SystemData/StatusDefinition/AliasName").getText();
		SDClientAliasNameVal = document.selectSingleNode("//SystemData/StatusDefinition/ClientAliasName").getText();				
		//Incidence Definition
		IDIncidenceTypeVal = document.selectSingleNode("//SystemData/IncidenceDefinition/IncidenceType").getText();
		IDIncidenceCodeVal = document.selectSingleNode("//SystemData/IncidenceDefinition/IncidenceCode").getText();
		IDProcessNameVal = document.selectSingleNode("//SystemData/IncidenceDefinition/ProcessName").getText();
		IDPSACodeVal = document.selectSingleNode("//SystemData/IncidenceDefinition/PartyServiceAssociationCode").getText();
		IDWorkFlowCodeVal = document.selectSingleNode("//SystemData/IncidenceDefinition/WorkFlowCode").getText();
		IDDescriptionVal = document.selectSingleNode("//SystemData/IncidenceDefinition/Description").getText();
		IDProcessStatusVal = document.selectSingleNode("//SystemData/IncidenceDefinition/ProcessStatus").getText();
		IDIncidenceResolutionVal = document.selectSingleNode("//SystemData/IncidenceDefinition/IncidenceResolution").getText();
		IDSeverityVal = document.selectSingleNode("//SystemData/IncidenceDefinition/Severity").getText();
		IDStatusVal = document.selectSingleNode("//SystemData/IncidenceDefinition/Status").getText();
		IDEffectiveFromDateVal = document.selectSingleNode("//SystemData/IncidenceDefinition/EffectiveFromDate").getText();
		IDEffectiveTillDateVal = document.selectSingleNode("//SystemData/IncidenceDefinition/EffectiveTillDate").getText();
		IDIncidenceOriginVal = document.selectSingleNode("//SystemData/IncidenceDefinition/IncidenceOrigin").getText();
		IDCanClientSetPreferenceVal = document.selectSingleNode("//SystemData/IncidenceDefinition/CanClientSetPreference").getText();
		IDOperationsSeverityPreferenceVal = document.selectSingleNode("//SystemData/IncidenceDefinition/OperationsSeverityPreference").getText();
		IDClientSeverityPreferenceVal = document.selectSingleNode("//SystemData/IncidenceDefinition/ClientSeverityPreference").getText();
		IDRepairandManualInputVal = document.selectSingleNode("//SystemData/IncidenceDefinition/RepairandManualInput").getText();	
		//Status Action
		SAWorkFlowCodeVal = document.selectSingleNode("//SystemData/StatusAction/WorkFlowCode").getText();
		SAActionVal = document.selectSingleNode("//SystemData/StatusAction/Action").getText();
		SAProcessStatusVal = document.selectSingleNode("//SystemData/StatusAction/ProcessStatus").getText();
		SAProcessNameVal = document.selectSingleNode("//SystemData/StatusAction/ProcessName").getText();
		SAStatusVal = document.selectSingleNode("//SystemData/StatusAction/Status").getText();
		SAEffectiveFromDateVal = document.selectSingleNode("//SystemData/StatusAction/EffectiveFromDate").getText();
		SAEffectiveTillDateVal = document.selectSingleNode("//SystemData/StatusAction/EffectiveTillDate").getText();		
		//LogConfig
		LCApplicationNameVal = document.selectSingleNode("//SystemData/LogConfiguration/ApplicationName").getText();
		LCCategoryVal = document.selectSingleNode("//SystemData/LogConfiguration/Category").getText();
		LCLogLevelVal = document.selectSingleNode("//SystemData/LogConfiguration/LogLevel").getText();
		LCAppendersVal = document.selectSingleNode("//SystemData/LogConfiguration/Appenders").getText();		
		//ApprovalCondition
		ACApprovalCountVal = document.selectSingleNode("//SystemData/ApprovalCondition/ApprovalCount").getText();
		ACResourceNameVal = document.selectSingleNode("//SystemData/ApprovalCondition/ResourceName").getText();
		ACOperationVal = document.selectSingleNode("//SystemData/ApprovalCondition/Operation").getText();
		ACStatusVal = document.selectSingleNode("//SystemData/ApprovalCondition/Status").getText();
		ACEffectiveFromDateVal = document.selectSingleNode("//SystemData/ApprovalCondition/EffectiveFromDate").getText();
		ACEffectiveTillDateVal = document.selectSingleNode("//SystemData/ApprovalCondition/EffectiveTillDate").getText();
		ACAttributeNameVal = document.selectSingleNode("//SystemData/ApprovalCondition/AttributeName").getText();
		ACOperatorVal = document.selectSingleNode("//SystemData/ApprovalCondition/Operator").getText();
		ACondValueVal = document.selectSingleNode("//SystemData/ApprovalCondition/Value").getText();		
	}

}
