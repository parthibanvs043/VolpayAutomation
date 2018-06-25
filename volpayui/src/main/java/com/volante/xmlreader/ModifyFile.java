package com.volante.xmlreader;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
//import org.w3c.dom.Element;
//import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import com.volante.utilities.LoadFile;

public class ModifyFile {
	public static LoadFile load;
	public static String MessageId;
	public static String GroupRefID;
	public static String MessageIdPacs02;
	public static String MessageIdPacs008;
	public static String ClearingMsgIdPacs02;

public static void ReponsePac02(String dt) throws SQLException,
			ClassNotFoundException, InterruptedException {

		try {
			String userhome = "user.dir";
			String path = System.getProperty(userhome);
			load = new LoadFile(path
					+ "/src/main/resources/class/Database.properties");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(
					LoadFile.prop.getProperty("Driver"),
					LoadFile.prop.getProperty("username"),
					LoadFile.prop.getProperty("Password"));
			Thread.sleep(2500);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM PAYMENTINPUTOUTPUTCORRELATION WHERE RELATION='Output'");
			System.out.println("rs=" + rs);
			while (rs.next()) {
				GroupRefID = rs.getString(2);
				// MessageId = rs.getString(5);
				MessageIdPacs02 = rs.getString(7);
				System.out.println("GroupRefID=" + GroupRefID);
				// System.out.println("MessageId=" + MessageId);
				System.out.println("MessageIdPacs02=" + MessageIdPacs02);
			}
			con.close();

			String filepath = dt;
			DocumentBuilderFactory docFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(filepath);

			// Get the root element
			// Node company = doc.getFirstChild();

			// Get the staff element , it may not working if tag has spaces, or
			// whatever weird characters in front...it's better to use
			// getElementsByTagName() to get it directly.
			// Node staff = company.getFirstChild();

			// Get the staff element by tag name directly
			Node GroupRefIDnode = doc.getElementsByTagName("OrgnlGrpInfAndSts")
					.item(0);
			// Node MessageIDnode =
			// doc.getElementsByTagName("TxInfAndSts").item(0);
			Node MessageIdPacs02node = doc.getElementsByTagName("TxInfAndSts")
					.item(0);
			Node MessageIdPacs014node = doc.getElementsByTagName("GrpHdr")
					.item(0);
			/*
			 * // update staff attribute NamedNodeMap attr =
			 * staff.getAttributes(); Node nodeAttr = attr.getNamedItem("id");
			 * nodeAttr.setTextContent("2");
			 * 
			 * // append a new node to staff Element age =
			 * doc.createElement("age");
			 * age.appendChild(doc.createTextNode("28"));
			 * staff.appendChild(age);
			 */
			// loop the staff child node
			NodeList list = GroupRefIDnode.getChildNodes();
			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				// get the salary element, and update the value
				if ("OrgnlMsgId".equals(node.getNodeName())) {
					node.setTextContent(GroupRefID);
				}
			}
			/*
			 * NodeList list1 = MessageIDnode.getChildNodes();
			 * 
			 * for (int j = 0; j < list1.getLength(); j++) {
			 * 
			 * Node node = list1.item(j);
			 * 
			 * // get the salary element, and update the value if
			 * ("OrgnlInstrId".equals(node.getNodeName())) {
			 * node.setTextContent(MessageId); } }
			 */
			// to get the payment distribution Id and update the value
			NodeList list2 = MessageIdPacs02node.getChildNodes();
			for (int k = 0; k < list2.getLength(); k++) {
				Node node = list2.item(k);
				// get the salary element, and update the value
				if ("OrgnlInstrId".equals(node.getNodeName())) {
					node.setTextContent(MessageIdPacs02);
				}
			}
			NodeList list3 = MessageIdPacs014node.getChildNodes();
			for (int l = 0; l < list3.getLength(); l++) {
				Node node = list3.item(l);
				// get the salary element, and update the value
				if ("MsgId".equals(node.getNodeName())) {
					node.setTextContent(GroupRefID);
				}
			}

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(filepath));
			transformer.transform(source, result);
			System.out.println("Done");
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (SAXException sae) {
			sae.printStackTrace();
		}
	}

public static void Pacs008(String dt) throws SQLException,
			ClassNotFoundException, InterruptedException {

		try {
			String userhome = "user.dir";
			String path = System.getProperty(userhome);
			load = new LoadFile(path
					+ "/src/main/resources/class/Database.properties");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(
					LoadFile.prop.getProperty("Driver"),
					LoadFile.prop.getProperty("username"),
					LoadFile.prop.getProperty("Password"));
			Thread.sleep(2500);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM PAYMENTINPUTOUTPUTCORRELATION WHERE RELATION='Output'");
			System.out.println("rs=" + rs);
			while (rs.next()) {
				GroupRefID = rs.getString(2);
				// MessageId = rs.getString(5);
				MessageIdPacs008 = rs.getString(7);
				System.out.println("GroupRefID=" + GroupRefID);
				// System.out.println("MessageId=" + MessageId);
				System.out.println("MessageIdPacs008=" + MessageIdPacs008);
			}
			con.close();

			String filepath = dt;
			DocumentBuilderFactory docFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(filepath);

			// Get the root element
			// Node company = doc.getFirstChild();

			// Get the staff element , it may not working if tag has spaces, or
			// whatever weird characters in front...it's better to use
			// getElementsByTagName() to get it directly.
			// Node staff = company.getFirstChild();

			// Get the staff element by tag name directly

			// Node MessageIDnode =
			// doc.getElementsByTagName("TxInfAndSts").item(0);
			System.out.println("starting");
			Node MessageIdPacs008node = doc.getElementsByTagName("PmtId").item(
					0);
			/*
			 * // update staff attribute NamedNodeMap attr =
			 * staff.getAttributes(); Node nodeAttr = attr.getNamedItem("id");
			 * nodeAttr.setTextContent("2");
			 * 
			 * // append a new node to staff Element age =
			 * doc.createElement("age");
			 * age.appendChild(doc.createTextNode("28"));
			 * staff.appendChild(age);
			 */
			// loop the staff child node
			NodeList id = MessageIdPacs008node.getChildNodes();
			System.out.println("inside");
			for (int i = 0; i < id.getLength(); i++) {
				Node node = id.item(i);
				System.out.println("outside=" + i);
				// get the salary element, and update the value
				if ("TxId".equals(node.getNodeName())) {
					node.setTextContent(MessageIdPacs008);
					System.out.println("inside if");
				}
			}
			// to get the payment distribution Id and update the value
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(filepath));
			transformer.transform(source, result);
			System.out.println("Done");
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (SAXException sae) {
			sae.printStackTrace();
		}
	}

public static void RemittanceResponseFile(String dt) throws SQLException,
			ClassNotFoundException, InterruptedException {

		try {
			String userhome = "user.dir";
			String path = System.getProperty(userhome);
			load = new LoadFile(path
					+ "/src/main/resources/class/Database.properties");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(
					LoadFile.prop.getProperty("Driver"),
					LoadFile.prop.getProperty("username"),
					LoadFile.prop.getProperty("Password"));
			Thread.sleep(2500);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM PAYMENTINPUTOUTPUTCORRELATION WHERE ATTCHMSGFUNC='Remittance Advice'");
			System.out.println("rs=" + rs);
			while (rs.next()) {
				GroupRefID = rs.getString(2);
				// MessageId = rs.getString(5);
				MessageIdPacs02 = rs.getString(5);
				System.out.println("GroupRefID=" + GroupRefID);
				// System.out.println("MessageId=" + MessageId);
				System.out.println("MessageIdPacs02=" + MessageIdPacs02);
			}
			con.close();

			String filepath = dt;
			DocumentBuilderFactory docFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(filepath);

			// Get the root element
			// Node company = doc.getFirstChild();

			// Get the staff element , it may not working if tag has spaces, or
			// whatever weird characters in front...it's better to use
			// getElementsByTagName() to get it directly.
			// Node staff = company.getFirstChild();

			// Get the staff element by tag name directly
			Node GroupRefIDnode = doc.getElementsByTagName("OrgnlGrpInfAndSts")
					.item(0);
			// Node MessageIDnode =
			// doc.getElementsByTagName("TxInfAndSts").item(0);
			Node MessageIdPacs02node = doc.getElementsByTagName("TxInfAndSts")
					.item(0);
			// loop the staff child node
			NodeList list = GroupRefIDnode.getChildNodes();
			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				// get the salary element, and update the value
				if ("OrgnlMsgId".equals(node.getNodeName())) {
					node.setTextContent(GroupRefID);
				}
			}
			// to get the payment distribution Id and update the value
			NodeList list2 = MessageIdPacs02node.getChildNodes();
			for (int k = 0; k < list2.getLength(); k++) {
				Node node = list2.item(k);
				// get the salary element, and update the value
				if ("OrgnlInstrId".equals(node.getNodeName())) {
					node.setTextContent(MessageIdPacs02);
				}
			}

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(filepath));
			transformer.transform(source, result);
			System.out.println("Done");
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (SAXException sae) {
			sae.printStackTrace();
		}
	}
public static void ClearingPacs02(String dt) throws SQLException,
ClassNotFoundException, InterruptedException {

try {
String userhome = "user.dir";
String path = System.getProperty(userhome);
load = new LoadFile(path
		+ "/src/main/resources/class/Database.properties");
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con = DriverManager.getConnection(
		LoadFile.prop.getProperty("Driver"),
		LoadFile.prop.getProperty("username"),
		LoadFile.prop.getProperty("Password"));
Thread.sleep(2500);
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery("SELECT * FROM ACKDETAILS WHERE ACKDESTINATIONCHANNEL='9000001235_DEMO_ISOPACS008Clearing'");
System.out.println("rs=" + rs);
while (rs.next()) {
	ClearingMsgIdPacs02 = rs.getString(2);
	System.out.println("ClearingMsgIdPacs02=" + ClearingMsgIdPacs02);
	}
con.close();
String filepath = dt;
DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
Document doc = docBuilder.parse(filepath);

// Get the root element
// Node company = doc.getFirstChild();

// Get the staff element , it may not working if tag has spaces, or
// whatever weird characters in front...it's better to use
// getElementsByTagName() to get it directly.
// Node staff = company.getFirstChild();

// Get the staff element by tag name directly

// Node MessageIDnode =
// doc.getElementsByTagName("TxInfAndSts").item(0);
System.out.println("starting");
Node ClearingMsgIdPacs02node = doc.getElementsByTagName("GrpHdr").item(0);
// loop the staff child node
NodeList id = ClearingMsgIdPacs02node.getChildNodes();
System.out.println("inside");
for (int i = 0; i < id.getLength(); i++) {
	Node node = id.item(i);
	System.out.println("outside=" + i);
	// get the salary element, and update the value
	if ("MsgId".equals(node.getNodeName())) {
		node.setTextContent(ClearingMsgIdPacs02);
		System.out.println("inside if");
	}
}
// to get the payment distribution Id and update the value
// write the content into xml file
TransformerFactory transformerFactory = TransformerFactory
		.newInstance();
Transformer transformer = transformerFactory.newTransformer();
DOMSource source = new DOMSource(doc);
StreamResult result = new StreamResult(new File(filepath));
transformer.transform(source, result);
System.out.println("Done");
} catch (ParserConfigurationException pce) {
pce.printStackTrace();
} catch (TransformerException tfe) {
tfe.printStackTrace();
} catch (IOException ioe) {
ioe.printStackTrace();
} catch (SAXException sae) {
sae.printStackTrace();
}
}
public static void Update(String pr, String dt) throws SQLException,
ClassNotFoundException, InterruptedException {
	  PreparedStatement pstmt;
try{	  
String userhome = "user.dir";
String path = System.getProperty(userhome);
load = new LoadFile(path+ "/src/main/resources/class/Database.properties");
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con = DriverManager.getConnection(LoadFile.prop.getProperty("Driver"),LoadFile.prop.getProperty("username"),LoadFile.prop.getProperty("Password"));
Thread.sleep(2500);
Statement stmt = con.createStatement();
pstmt = con.prepareStatement("UPDATE PARTYSERVICEASSOCIATION SET PARTYCODE='"+pr+"' WHERE PARTYSERVICEASSOCIATIONCODE='"+dt+"'");
Thread.sleep(2500);  
pstmt.executeUpdate();
String query = "select * from PARTYSERVICEASSOCIATION";
ResultSet res = stmt.executeQuery(query);
System.out.println("rs=" + res);
System.out.println("Record updated" );
con.close();
}
catch (Exception e) {
	   e.printStackTrace();
}
}
}
