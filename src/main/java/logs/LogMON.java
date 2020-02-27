package logs;

import com.mongodb.client.MongoCollection;
import configuration.ConfigurationMON;

/**
 * @author sebastia tomas
 */
public class LogMON {
    private MongoCollection log;

    public LogMON(){
        ConfigurationMON configurationMongoDB = new ConfigurationMON();
        this.log = configurationMongoDB.getLog();
    }
}