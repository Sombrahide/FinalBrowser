package configuration;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
/**
 * @author sebastia tomas
 */
public class ConfigurationMON {
    private MongoCollection literalEs, literalEn, log;

    /**
     * Configuracio de Mongo de forma remota amb la URI i accés a la base de dades junt amb els seus documents.
     */
    public ConfigurationMON(){
        //MongoDB credentials:
        //User: finalbrowser - Password: finalbrowser123
        String uri = "mongodb+srv://finalbrowser:finalbrowser123@cluster0-3q1xm.mongodb.net/test?authSource=admin&replicaSet=Cluster0-shard-0&w=majority&readPreference=primary&appname=MongoDB%20Compass&retryWrites=true&ssl=true";
        MongoClientURI mongoClientURI = new MongoClientURI(uri);
        MongoClient mongoClient = new MongoClient(mongoClientURI);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("finalbrowser");
        this.literalEs = mongoDatabase.getCollection("literalEs");
        this.literalEn = mongoDatabase.getCollection("literalEn");
        this.log = mongoDatabase.getCollection("log");
    }

    public MongoCollection getLiteralEs() {
        return literalEs;
    }

    public MongoCollection getLiteralEn() {
        return literalEn;
    }

    public MongoCollection getLog() {
        return log;
    }
}