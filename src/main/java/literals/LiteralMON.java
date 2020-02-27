package literals;

import com.mongodb.client.MongoCollection;
import configuration.ConfigurationMON;

/**
 * @author sebastia tomas
 */
public class LiteralMON {
    private MongoCollection literalEs;
    private MongoCollection literalEn;


    public LiteralMON(){
        ConfigurationMON configurationMongoDB = new ConfigurationMON();
        this.literalEs = configurationMongoDB.getLiteralEs();
        this.literalEn = configurationMongoDB.getLiteralEn();
    }

    /**
     *
     * @param language se especifica el lenguaje del literal que queremos buscar
     * @param id se especifica la id del literal que queremos buscar, independientemente del idioma
     * @return en caso de que el lenguaje especificado sea español o inglés se retorna el literal con la id especificada, si no, se devuelve error
     */
    public String getLiteralByLanguageAndId(String language, String id){
        switch (language){
            case "es":
                org.bson.Document documentEs = (org.bson.Document) this.literalEs.find().first();
                org.bson.Document literalEs = (org.bson.Document) documentEs.get(language);
                return (String) literalEs.get(id);
            case "en":
                org.bson.Document documentEn = (org.bson.Document) this.literalEn.find().first();
                org.bson.Document literalEn = (org.bson.Document) documentEn.get(language);
                return (String) literalEn.get(id);
        }
        return "Error";
    }





}