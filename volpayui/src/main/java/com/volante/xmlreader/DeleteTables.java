package com.volante.xmlreader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import com.relevantcodes.extentreports.LogStatus;
import com.volante.reports.GenerateReport;
import com.volante.utilities.LoadFile;

public class DeleteTables {
	
	 public static LoadFile load;

public static void DropTable(String strStep)
{
	try {
		String userhome = "user.dir";
		String path = System.getProperty(userhome);
		load = new LoadFile(path + "/src/main/resources/class/Database.properties");
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(
				LoadFile.prop.getProperty("Driver"),
				LoadFile.prop.getProperty("username"),
				LoadFile.prop.getProperty("Password"));
		Thread.sleep(2500);
		Statement stmt = con.createStatement();
		System.out.println("Connection Success");
		//ResultSet rs=stmt.executeQuery("Select * from INSTRUCTIONRAWDATA");
		//System.out.println("RS="+rs.getString(2));
		stmt.executeUpdate("TRUNCATE TABLE INSTRUCTIONAUDIT");
		stmt.executeUpdate("TRUNCATE TABLE PAYMENTAUDIT");
		stmt.executeUpdate("TRUNCATE TABLE SYSTEMAUDIT");
		stmt.executeUpdate("TRUNCATE TABLE PAYMENTCONTROLDATA");
		stmt.executeUpdate("TRUNCATE TABLE FLOWSCHEDULERDYNAMICDATA");
		stmt.executeUpdate("TRUNCATE TABLE BANKINTERACTIONDATA");
		stmt.executeUpdate("TRUNCATE TABLE PAYMENTFIELDDATA");
		stmt.executeUpdate("TRUNCATE TABLE CURRENCYWISESUM");
		stmt.executeUpdate("DELETE FROM INSTRUCTIONRAWDATA");
		stmt.executeUpdate("TRUNCATE TABLE PAYMENTOUTPUTDATA");
		stmt.executeUpdate("TRUNCATE TABLE PAYMENTINPUTOUTPUTCORRELATION");
		stmt.executeUpdate("TRUNCATE TABLE PAYMENTREPAIRDETAILS");
		stmt.executeUpdate("TRUNCATE TABLE ACKDETAILS");
		stmt.executeUpdate("TRUNCATE TABLE USERSESSIONAUDIT");
		stmt.executeUpdate("TRUNCATE TABLE USERPROFILELOG");
		stmt.executeUpdate("TRUNCATE TABLE REQFROMCORE");
		stmt.executeUpdate("TRUNCATE TABLE RESPFROMINTERFACE");
		stmt.executeUpdate("TRUNCATE TABLE REQTOINTERFACE");
		stmt.executeUpdate("TRUNCATE TABLE REQTRACKER");
		stmt.executeUpdate("TRUNCATE TABLE RespToCore");
		stmt.executeUpdate("TRUNCATE TABLE INSTRUCTIONDATA");
		stmt.executeUpdate("TRUNCATE TABLE APPROVALDETAILS");
		stmt.executeUpdate("TRUNCATE TABLE INTERFACEBULKING");
		stmt.executeUpdate("TRUNCATE TABLE NOTIFEVENT");
		stmt.executeUpdate("TRUNCATE TABLE CONFIRMATIONCONTROLDATA");
		stmt.executeUpdate("TRUNCATE TABLE ACCOUNTPOSTINGS");
		stmt.executeUpdate("TRUNCATE TABLE INTERFACETIMEOUTMANAGER");
		stmt.executeUpdate("TRUNCATE TABLE TRANSPORTLOGAUDIT");
		stmt.executeUpdate("TRUNCATE TABLE INSTRERRORINFO");
		stmt.executeUpdate("TRUNCATE TABLE TRANSERRORINFO");
		stmt.executeUpdate("TRUNCATE TABLE ATTACHEDMESSAGE");
		stmt.executeUpdate("TRUNCATE TABLE HASHREGISTRY");
		stmt.executeUpdate("TRUNCATE TABLE LINKEDMESSAGES");
		stmt.executeUpdate("TRUNCATE TABLE INSTRHASHREGISTRY");
		stmt.executeUpdate("TRUNCATE TABLE INSTRFLDHASHREGISTRY");
		stmt.executeUpdate("TRUNCATE TABLE INSTRBANKINTERACTIONDATA");
		stmt.executeUpdate("TRUNCATE TABLE INSTRREQFROMCORE");
		stmt.executeUpdate("TRUNCATE TABLE INSTRREQTOINTERFACE");
		stmt.executeUpdate("TRUNCATE TABLE INSTRREQTRACKER");
		stmt.executeUpdate("TRUNCATE TABLE INSTRRESTOCORE");
		stmt.executeUpdate("TRUNCATE TABLE INSTRRESFROMINTERFACE");
		stmt.executeUpdate("TRUNCATE TABLE DISTRIBUTIONLOG");
		stmt.executeUpdate("TRUNCATE TABLE ASYNCPROCESSREGISTRY");
		stmt.executeUpdate("TRUNCATE TABLE SCHEDULEDROUTELOGAUDIT");
		stmt.executeUpdate("TRUNCATE TABLE INSTREVENTSOURCE");
		stmt.executeUpdate("TRUNCATE TABLE PAYMENTEVENTSOURCE");
		stmt.executeUpdate("TRUNCATE TABLE INSTRCONFSTATUS");
		stmt.executeUpdate("TRUNCATE TABLE ASYNCPROCESSREGISTRY");
		stmt.executeUpdate("TRUNCATE TABLE SCHEDULEDROUTELOGAUDIT");
		stmt.executeUpdate("TRUNCATE TABLE INSTREVENTSOURCE");
		stmt.executeUpdate("TRUNCATE TABLE PAYMENTEVENTSOURCE");
		Thread.sleep(8000);
		GenerateReport.test.log(LogStatus.PASS, strStep, "Tables Dropped Successfully");
		con.close();
	}
	catch (ClassNotFoundException e) {
		System.out.println("Exceptions =:"+e);

	}
	catch(Exception sqException)
	{
		System.out.println("Exceptions occurred:"+sqException);
	}
}
}
