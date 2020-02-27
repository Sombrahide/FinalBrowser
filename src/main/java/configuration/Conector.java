package configuration;

import literals.LiteralHIB;
import literals.LiteralMON;
import literals.LiteralXML;

public class Conector {
    private LiteralXML xml_connection;
    private LiteralHIB hib_connection;
    private LiteralMON mon_connection;
    private ConfigurationHib configurationHib;
    private ConfigurationXML configurationXML;
    private ConfigurationMON configurationMON;
    
    public LiteralXML getXml_connection() {
        return xml_connection;
    }

    public void setXml_connection(LiteralXML xml_connection) {
        this.xml_connection = xml_connection;
    }

    public LiteralHIB getHib_connection() {
        return hib_connection;
    }

    public void setHib_connection(LiteralHIB hib_connection) {
        this.hib_connection = hib_connection;
    }

    public LiteralMON getMon_connection() {
        return mon_connection;
    }

    public void setMon_connection(LiteralMON mon_connection) {
        this.mon_connection = mon_connection;
    }

    public ConfigurationHib getConfigurationHib() {
        return configurationHib;
    }

    public void setConfigurationHib(ConfigurationHib configurationHib) {
        this.configurationHib = configurationHib;
    }

    public ConfigurationXML getConfigurationXML() {
        return configurationXML;
    }

    public void setConfigurationXML(ConfigurationXML configurationXML) {
        this.configurationXML = configurationXML;
    }

    public ConfigurationMON getConfigurationMON() {
        return configurationMON;
    }

    public void setConfigurationMON(ConfigurationMON configurationMON) {
        this.configurationMON = configurationMON;
    }

    public Conector(LiteralXML xml_connection, LiteralHIB hib_connection, LiteralMON mon_connection, ConfigurationHib configurationHib, ConfigurationXML configurationXML, ConfigurationMON configurationMON) {
        this.xml_connection = xml_connection;
        this.hib_connection = hib_connection;
        this.mon_connection = mon_connection;
        this.configurationHib = configurationHib;
        this.configurationXML = configurationXML;
        this.configurationMON = configurationMON;
    }




}
