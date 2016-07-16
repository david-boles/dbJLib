package space.davidboles.lib.database;

import java.io.Serializable;

/**
 * A DataInterchangeFormat object describes the way another object is formatted: its class and internal structure.
 * @author David Boles
 *
 */
public final class DataInterchangeFormat implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private final Class<?> formatClass;
	private final String[] formatStructure;
	
	public DataInterchangeFormat(Class<?> formatClass, String[] formatStructure) {
		this.formatClass = formatClass;
		this.formatStructure = formatStructure;
	}

	/**
	 * Checks if the argument provided is equivalent to this. The format Classes must .equal each other, the format structures must have the same length, and the internal Strings must .equal each other. (method calls this.equals(object))
	 * @param format The format being tested against this.
	 * @return If format is equivalent to this: true if satisfies above, false otherwise (including null arg)
	 */
	public boolean isEqualTo(DataInterchangeFormat object) {
	
		return this.equals(object);

	}
	
	/**
	 * Checks if this is a child to the arg. They cannot be equal, the arg's format class must be equal or a super class to this', the arg's format structure must be shorter to this', and otherwise the Strings must .equal each other.
	 * @param format The format being tested against this.
	 * @return True if satisfies above, false otherwise (including null arg)
	 */
	public boolean isChildTo(DataInterchangeFormat object) {
		if(DataInterchangeFormat.class.isInstance(object)) {//Check that object is a DataInterchangeFormat
			DataInterchangeFormat format = (DataInterchangeFormat) object;//Cast object to DataInterchangeFormat
			if(format.formatClass.isAssignableFrom(this.formatClass)) {//Check that formatClasses are assignable
				if(format.formatStructure.length <= this.formatStructure.length) {//Check that formatStructure lengths are correct
					for(int i = 0; i < format.formatStructure.length; i++) {//Iterate through formatStructures
						if(!format.formatStructure[i].equals(this.formatStructure[i])) return false;//Return false if part of format structure doesn't match
					}
					if(this.equals(object)) return false;//Return false if equal
					return true;//object is equal to this DataInterchangeFormat
				}
			}
		}
		
		return false;
	}
	
	/**
	 * Checks if this is a parent to the arg. They cannot be equal, the this' format class must be equal or a super class to the arg's, this' format structure must be shorter to arg's, and otherwise the Strings must .equal each other.
	 * @param format The format being tested against this.
	 * @return True if satisfies above, false otherwise (including null arg)
	 */
	public boolean isParentTo(DataInterchangeFormat object) {
		if(DataInterchangeFormat.class.isInstance(object)) {//Check that object is a DataInterchangeFormat
			DataInterchangeFormat format = (DataInterchangeFormat) object;//Cast object to DataInterchangeFormat
			if(this.formatClass.isAssignableFrom(format.formatClass)) {//Check that formatClasses are assignable
				if(format.formatStructure.length >= this.formatStructure.length) {//Check that formatStructure lengths are correct
					for(int i = 0; i < this.formatStructure.length; i++) {//Iterate through formatStructures
						if(!format.formatStructure[i].equals(this.formatStructure[i])) return false;//Return false if part of format structure doesn't match
					}
					if(this.equals(object)) return false;//Return false if equal
					return true;//object is equal to this DataInterchangeFormat
				}
			}
		}
		
		return false;
		
	}
	
	@Override
	public boolean equals(Object object) {
		if(DataInterchangeFormat.class.isInstance(object)) {//Check that object is a DataInterchangeFormat
			DataInterchangeFormat format = (DataInterchangeFormat) object;//Cast object to DataInterchangeFormat
			if(format.formatClass.equals(this.formatClass)) {//Check that formatClasses are equal
				if(format.formatStructure.length == this.formatStructure.length) {//Check that formatStructure lengths are equal
					for(int i = 0; i < this.formatStructure.length; i++) {//Iterate through formatStructures
						if(!format.formatStructure[i].equals(this.formatStructure[i])) return false;//Return false if part of format structure doesn't match
					}
					return true;//Object is equal to this DataInterchangeFormat
				}
			}
		}
		
		return false;
	}
	
}
