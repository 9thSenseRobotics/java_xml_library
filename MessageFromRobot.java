package java_xml_library;
import java.io.*;

import org.w3c.dom.*;

import javax.xml.parsers.*;
//import org.xml.sax.InputSource;
//import org.xml.sax.InputSource;
//import org.xml.sax.InputSource;
//import javax.xml.transform.*;
//import javax.xml.transform.dom.*;
//import javax.xml.transform.stream.*;

//import robotMessages.*;
//import MicroTime.*;

class MessageFromRobot extends RobotMessages
// For messages that are sent from a driver or controller to the robot
//
// Usage:
// 
//	$mfr = new messageFromRobot($rawXMLString); // build from the raw XML
//	$mfr = new messageToRobot($driverAddr, $robotAddr, $responseValue [, $comment]);
{	
	public MessageFromRobot(String xmlStr) 
	// single-argument constructor: Build this class from its XML string
	{
		timeStamp = new MicroTime().smicrotime();
		// parse XML string to create Document
									// 		SAXParserFactory factory = SAXParserFactory.newInstance();
									// 		  try {
									// 		
									// 				out = new OutputStreamWriter (System.out, "UTF8");
									// 				SAXParser saxParser = factory.newSAXParser();
									// 				saxParser.parse( new File(XML_FILE_NAME), new BooksLibrary() );
									// 		
									// 		  } catch (Throwable err) {
									// 				err.printStackTrace ();
									// 		  }
	
		try
		{
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setValidating(false);
			dbf.setFeature("http://xml.org/sax/features/namespaces", false);
			dbf.setFeature("http://xml.org/sax/features/validation", false);
			dbf.setFeature("http://apache.org/xml/features/nonvalidating/load-dtd-grammar", false);
			dbf.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
			DocumentBuilder db = dbf.newDocumentBuilder();
			ByteArrayInputStream stream = new ByteArrayInputStream(xmlStr.getBytes());
			XML = db.parse(stream);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Element rootElement = XML.getDocumentElement();

// 		<t>timeStamp</t> 
		Element t = XML.createElement("t");
		t.appendChild (XML.createTextNode(timeStamp));
		rootElement.appendChild(t);

// 		<d>driverAddr</d> 
		NodeList nl = XML.getElementsByTagName("d");
		Node n = nl.item(0);
		Element e = (Element)n;
		driverAddr = e.getTextContent();
	
// 		<r>robotAddr</r> 
		nl = XML.getElementsByTagName("r");
		n = nl.item(0);
		e = (Element)n;
		robotAddr = e.getTextContent();

// 		<re>responseValue</re>
		nl = XML.getElementsByTagName("re");
		n = nl.item(0);
		e = (Element)n;
		responseValue = e.getTextContent();

// 		<co>comment</co>
		nl = XML.getElementsByTagName("co");
		n = nl.item(0);
		e = (Element)n;
		comment = e.getTextContent();
	}

	public MessageFromRobot(String da, String ra, String rv)
	// 3-argument constructor: build this class from its component data with a response but without a comment
	{
		// set the class' properties from the passed-in values; if they're unspecified, set as empty
		timeStamp = new MicroTime().smicrotime();
		driverAddr = da;
		robotAddr = ra;
		responseValue = rv;
		comment = "";

		Element m = XML.createElement("m");
		XML.appendChild(m);
		Element rootElement = XML.getDocumentElement();

// 		<t>timeStamp</t> 
		Element t = XML.createElement("t");
		t.appendChild (XML.createTextNode(timeStamp));
		rootElement.appendChild(t);

// 		$this->XML->addChild('d', $this->driverAddr);
		Element d = XML.createElement("d");
		d.appendChild (XML.createTextNode(driverAddr));
		rootElement.appendChild(d);

// 		$this->XML->addChild('r', $this->robotAddr);
		Element r = XML.createElement("r");
		r.appendChild (XML.createTextNode(robotAddr));
		rootElement.appendChild(r);

// 		$this->XML->addChild('re', $this->responseValue);
		Element re = XML.createElement("re");
		re.appendChild (XML.createTextNode(responseValue));
		rootElement.appendChild(re);

// 		$this->XML->addChild('co', $this->comment);
		Element co = XML.createElement("co");
		co.appendChild (XML.createTextNode(comment));
		rootElement.appendChild(re);
	}

	public MessageFromRobot(String da, String ra, String rv, String co)
	// 4-argument constructor: build this class from its component data with a response and a comment
	{
		// set the class' properties from the passed-in values; if they're unspecified, set as empty
		timeStamp = new MicroTime().smicrotime();
		driverAddr = da;
		robotAddr = ra;
		responseValue = rv;
		comment = co;

		Element m = XML.createElement("m");
		XML.appendChild(m);
		Element rootElement = XML.getDocumentElement();

// 		<t>timeStamp</t> 
		Element t = XML.createElement("t");
		t.appendChild (XML.createTextNode(timeStamp));
		rootElement.appendChild(t);

// 		$this->XML->addChild('d', $this->driverAddr);
		Element d = XML.createElement("d");
		d.appendChild (XML.createTextNode(driverAddr));
		rootElement.appendChild(d);

// 		$this->XML->addChild('r', $this->robotAddr);
		Element r = XML.createElement("r");
		r.appendChild (XML.createTextNode(robotAddr));
		rootElement.appendChild(r);

// 		$this->XML->addChild('re', $this->responseValue);
		Element re = XML.createElement("re");
		re.appendChild (XML.createTextNode(responseValue));
		rootElement.appendChild(re);

// 		$this->XML->addChild('co', $this->comment);
		Element c = XML.createElement("co");
		c.appendChild (XML.createTextNode(comment));
		rootElement.appendChild(c);
	}
}