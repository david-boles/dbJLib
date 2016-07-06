package space.davidboles.lib.database;

import java.io.Serializable;

import space.davidboles.lib.database.exceptions.UnsupportedFormatException;

/**
 * The DataWrapperInterface provides an API for setting and getting data in different formats. Serialization should also store the internal data.
 * @author David Boles
 *
 */
public interface ArbitraryDataWrapperInterface extends Serializable {

	//Data get methods
	/**
	 * Checks if a get with the format provided will cause an UnsupportedFormatException.
	 * @param format The format that is checked.
	 * @return True if it won't be thrown, false otherwise.
	 */
	public boolean formatGetSupported(DataInterchangeFormat format);
	//TODO Add throws declaration
	/**
	 * Calls the full getData method with null info.
	 * @param format The format requested for the returned data.
	 * @return The data formatted as requested.
	 * @throws UnsupportedFormatException Thrown if the format was not supported.
	 * @throws OperationFailedException Thrown if the operation failed for another reason.
	 */
	public default Object getData(DataInterchangeFormat format) {
		return this.getData(format, null);
	}
	
	/**
	 * Gets and formats the data as requested.
	 * @param format The format requested for the returned data.
	 * @param info Any additional information as specified by the documentation of the format or the data wrapper, null or empty for none.
	 * @return The data formatted as requested.
	 * @throws UnsupportedFormatException Thrown if the format was not supported.
	 * @throws OperationFailedException Thrown if the operation failed for another reason.
	 */
	public Object getData(DataInterchangeFormat format, KeyObjectPair[] info);
	
	
	//Data set methods
	/**
	 * Checks if a set with the format provided will cause an UnsupportedFormatException.
	 * @param format The format that is checked.
	 * @return True if it won't be thrown, false otherwise.
	 * @throws UnsupportedFormatException Thrown if the format was not supported.
	 * @throws OperationFailedException Thrown if the operation failed for another reason.
	 */
	public boolean formatSetSupported(DataInterchangeFormat format);
	
	/**
	 * Calls the full setData method with null info.
	 * @param format The format requested for the input data.
	 * @param data The data to input.
	 * @throws UnsupportedFormatException Thrown if the format was not supported.
	 * @throws OperationFailedException Thrown if the operation failed for another reason.
	 */
	public default void setData(DataInterchangeFormat format, Object data) {
		this.setData(format, data, null);
	}
	
	/**
	 * Sets the data formatted as requested.
	 * @param format The format requested for the input data.
	 * @param data The data to input.
	 * @param info Any additional information as specified by the documentation of the format or the data wrapper, null or empty for none.
	 * @throws UnsupportedFormatException Thrown if the format was not supported.
	 * @throws OperationFailedException Thrown if the operation failed for another reason.
	 */
	public void setData(DataInterchangeFormat format, Object data, KeyObjectPair[] info);
	
}
