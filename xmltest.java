import java.io.File;
import org.w3c.dom.Document;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException; 

import MicroTime.*;
import robotMessages.*;
import messageFromRobot.*;

public class xmltest
{
	//public static Document XML;
	
    public static void main (String argv [])
    {
    	String robotXMLTest = "<m><t>timeStamp</t><d>driverAddr</d><r>robotAddr</r><re>responseValue</re><co>comment</co></m>";
    	t = new messageFromRobot(robotXMLTest);
    	system.out.println(t.robotAddr);
//     try {
// 
// 		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
// 		DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
// 		//Document doc = docBuilder.parse (new File("my.xml"));
// 
// 		// normalize text representation
// 		//doc.getDocumentElement ().normalize ();
// //		System.out.println ("Root element of the doc is " + doc.getDocumentElement().getNodeName());
// 
// 		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
// 		DocumentBuilder db = dbf.newDocumentBuilder();
// 		XML = db.newDocument();
// 		Element m = XML.createElement("m");
// 		XML.appendChild(m);
// 		Element rootElement = XML.getDocumentElement();
// 
// // 		<t>timeStamp</t> 
// 		Element t = XML.createElement("t");
// 		t.appendChild (XML.createTextNode("timeStamp"));
// 		rootElement.appendChild(t);
// 
// 
//             NodeList nl = XML.getElementsByTagName("t");
//             Node n = nl.item(0);
//             Element e = (Element)n;
//             String s = e.getTextContent();
//             System.out.println("Name is " + e.getNodeName());
//             System.out.println("Text content " + s);
//            // System.out.println("Total no of people : " + totalPersons);
//         }catch (Throwable t) {
//         t.printStackTrace ();
//         }
//         //System.exit (0);
// 
    }//end of main


}