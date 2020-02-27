package literals;

import javax.xml.xpath.XPathExpressionException;

import configuration.Configuration.IdiomType;
import configuration.ConfigurationXML;

/**
 * <p>
 * A class that allows the recovery of literal giving a String
 * </p>
 * 
 * @author Juan Jose Marti Perez
 */

public class LiteralXML {
	private final String PATHXML = "src/main/resources/literal.xml";
	private ConfigurationXML _config;

	/**
	 * <p>
	 * The constructor of the class
	 * </p>
	 */
	public LiteralXML() {
		_config = new ConfigurationXML(PATHXML);
	}

	public String getLiteralText(String key) {
		String result;
		try {
			result = _config.xPathSearch("/class/literal[lit_key=\""+key+"\" and idi_cod=\""+this.getIdiomKey()+"\"]/lit_text");
			//result = _config.xPathSearch("/class/literal/lit_text");
		} catch (XPathExpressionException e) {
			e.printStackTrace();
			result = null;
		}
		return result;
	}
	/**
	 * <p><This method takes the language of the program, after which it returns the key used in the literal table so it can be used in searches/p>
	 * @return A brief String that contains the language key, used in MySQL searches of the literal table
	 */
	private String getIdiomKey() {
		IdiomType idiom = _config.getIdiom();
		switch(idiom) {
		case SPANISH:
			return "esp";
		case ENGLISH:
			return "eng";
		default:
			return null;
		}
	}
}
