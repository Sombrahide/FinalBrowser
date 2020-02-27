package importxml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import configuration.ConfigurationHib;
import mapping.literal;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class xmltohib{
    public xmltohib() {
        ConfigurationHib hib = new ConfigurationHib();
        hib.createSession();
        hib.openSession();
        hib.createfromxml();
        hib.closeSession();
    }
    public ArrayList<literal> start() {
        Document doc = openXmlDom(new File("literals.xml"));
        ArrayList<literal> lit = getliterals(doc);
        return lit;
    }
    public static Document openXmlDom(File f) {
        Document doc=null;
        //Create DocumentBuilderFactory object
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        //Don't load comments
        factory.setIgnoringComments(true);
        //Ignore white spaces
        factory.setIgnoringElementContentWhitespace(true);
        //Create DocumentBuilder to load DOM tree into it
        try {
            DocumentBuilder builder=factory.newDocumentBuilder();
            doc=builder.parse(f);
            doc.getDocumentElement().normalize(); //recommended
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        return doc;
    }

    public static String showDoc(Document doc, String lang, String error_id){
        NodeList nodes = doc.getElementsByTagName("literals");
        Element element = (Element) nodes.item(0);

        NodeList nodelist = element.getElementsByTagName("literal");
        Node n;
        String out = "";

        //Loop to read every item of node list
        for (int i=0;i<nodelist.getLength();i++){
            //Get set of items inside CD
            n=nodelist.item(i);
            //Check Node type is Element
            if (n.getNodeType()==Node.ELEMENT_NODE){
                //Cast to Element to use getElementsByTagName method
                Element el=(Element) n;
                //Use .item(0).getAttributes() to get atributes;
                if (el.hasAttribute("id") && el.getAttribute("id").equals(error_id)) {
                    out = el.getElementsByTagName(lang).item(0).getTextContent();
                    break;
                }
            }
        }
        return out;
    }

    public static ArrayList<literal> getliterals(Document doc){
        NodeList nodes = doc.getElementsByTagName("class");
        Element element = (Element) nodes.item(0);
        NodeList nodelist = element.getElementsByTagName("literal");
        Node n;
        String idi_cod = "";
        String lit_key = "";
        String lit_text = "";
        ArrayList<literal> lit_array = new ArrayList<literal>();
        //Loop to read every item of node list
        for (int i=0;i<nodelist.getLength();i++){
            //Get set of items inside CD
            n=nodelist.item(i);
            //Check Node type is Element
            if (n.getNodeType()==Node.ELEMENT_NODE){
                //Cast to Element to use getElementsByTagName method
                Element el=(Element) n;
                idi_cod = el.getElementsByTagName("idi_cod").item(0).getTextContent();
                lit_key = el.getElementsByTagName("lit_key").item(0).getTextContent();
                lit_text = el.getElementsByTagName("lit_text").item(0).getTextContent();
                lit_array.add(new literal(idi_cod, lit_key, lit_text));
            }
        }
        return lit_array;
    }
}