package space.davidboles.lib.database;

/**
 * A KayObjectPair provides a simple way to assign a String identifier to an Object.
 * @author David Boles
 *
 */
public class KeyObjectPair {
	String key;
	Object object;
	
	/**
	 * Initializes the KeyObjecyPair with the provided key and object.
	 * @param key The String identifier for the object.
	 * @param object The Object assigned the key.
	 */
	public KeyObjectPair(String key, Object object) {
		this.key = key;
		this.object = object;
	}
	
	/**
	 * Gets the key.
	 * @return The key.
	 */
	public String getKey() {
		return this.key;
	}
	
	/**
	 * Sets the key.
	 * @param key The new key to set.
	 */
	public void setKey(String key) {
		this.key = key;
	}
	
	/**
	 * Gets the object.
	 * @return The object.
	 */
	public Object getObject() {
		return this.object;
	}
	
	/**
	 * Sets the object.
	 * @param object The new object to set.
	 */
	public void setObject(Object object) {
		this.object = object;
	}
	
}
