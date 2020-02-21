package configuration;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ConfigurationXML extends Configuration {
	private File _xmlFile;
	private Document _doc;
	private XPath _xPath;

	/**
	 * <p>
	 * The constructor of the class
	 * </p>
	 * 
	 * @param fileName_ The name of the xml file
	 */
	public ConfigurationXML(final String fileName_) {
		// First the file is created
		_xmlFile = new File(fileName_);
		this.changeIdiom(IdiomType.SPANISH);

		/*
		 * It will be checked if the file already exists, otherwise you will try to
		 * create and notify the user
		 */
		try {
			boolean created = _xmlFile.createNewFile();
			if (created) {
				System.out.println(fileName_ + " created");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// The necessary constructors for the creation of the document will be created
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = null;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

		// The document will be created and then standardized.
		try {
			_doc = dBuilder.parse(_xmlFile);
		} catch (SAXException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();

		}
		_doc.getDocumentElement().normalize();

		// Now we will create the XPath that we require to do our searches for the xml
		// file
		XPathFactory xPathFactory = XPathFactory.newInstance();
		_xPath = xPathFactory.newXPath();
		//_xPath.setNamespaceContext(nsContext);
	}

	/**
	 * <p>
	 * An expression with which to search the document
	 * </p>
	 * 
	 * @param expression_ The expression to perform the search
	 * @return It will return a string with the search result
	 * @throws XPathExpressionException In case the expression is invalid it will
	 *                                  throw an error
	 */
	public String xPathSearch(final String expression_) throws XPathExpressionException {
		XPathExpression xPathExpression = _xPath.compile(expression_);
		NodeList node = (NodeList) xPathExpression.evaluate(_doc, XPathConstants.NODESET);
		String result = node.item(0).getTextContent();
		return result;
	}
}
