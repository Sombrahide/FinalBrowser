package configuration;

/**
 * <p>
 * The parent class from which the rest of the configuration classes will come
 * out
 * </p>
 * 
 * @author Juan Jose Marti Perez
 */

public class Configuration {
	private final boolean SAVELOG = true;
	private final ConnectorType PREFEREDCONNECTOR = ConnectorType.XML;
	private IdiomType _idiom;

	private enum ConnectorType {
		MONGODB, HIBERNATE, XML
	}

	public enum IdiomType {
		SPANISH, ENGLISH
	}

	/**
	 * <p>
	 * A simple method to return the SAVELOG variable
	 * </p>
	 * 
	 * @return Whether or not the program should save the logs
	 */
	public boolean saveLog() {
		return this.SAVELOG;
	}

	/**
	 * <p>
	 * A simple method to return which technology tries to use the program first
	 * </p>
	 * 
	 * @return What type of technology do you try to use first when starting the
	 *         application
	 */
	public ConnectorType ConnectorType() {
		return this.PREFEREDCONNECTOR;
	}

	/**
	 * <p>
	 * Get the idiom of the program
	 * </p>
	 * 
	 * @return The idiom the program will use in IdiomType format
	 */
	public IdiomType getIdiom() {
		return _idiom;
	}

	/**
	 * <p>
	 * Change the idiom of the program
	 * </p>
	 * 
	 * @param idiom The new idiom of the program
	 */
	public void changeIdiom(final IdiomType idiom_) {
		this._idiom = idiom_;
	}
}
