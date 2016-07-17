package space.davidboles.jlib.database;

import space.davidboles.lib.database.exceptions.UnsupportedFormatException;

public abstract class BaseWAD<T> implements ArbitraryDataWrapperInterface {

	private static final long serialVersionUID = 1L;

	T data;
	
	public BaseWAD(T data) {
		this.data = data;
	}
	
	@Override
	public synchronized boolean formatGetSupported(DataInterchangeFormat format) {
		DataInterchangeFormat[] supportedFs = this.getSupportedFormats();
		
		boolean fSupported = false;
		for(int i = 0; i < supportedFs.length; i++) {
			if(format.isParentTo(supportedFs[i])) {
				fSupported = true;
				i = supportedFs.length;
			}
		}
		
		return fSupported;
	}

	@Override
	public synchronized Object getData(DataInterchangeFormat format, KeyObjectPair[] info) throws UnsupportedFormatException {
		if(this.formatGetSupported(format)) {
			return this.convertToFormat(this.data, format);
		}else throw new UnsupportedFormatException();
	}

	@Override
	public synchronized boolean formatSetSupported(DataInterchangeFormat format) {
		DataInterchangeFormat[] supportedFs = this.getSupportedFormats();
		
		boolean fSupported = false;
		for(int i = 0; i < supportedFs.length; i++) {
			if(format.isParentTo(supportedFs[i])) {
				fSupported = true;
				i = supportedFs.length;
			}
		}
		
		return fSupported;
	}

	@Override
	public synchronized void setData(DataInterchangeFormat format, Object data, KeyObjectPair[] info) throws UnsupportedFormatException {
		if(this.formatSetSupported(format)) {
			this.data = this.convertFromFormat(format, data);
		}else throw new UnsupportedFormatException();
	}
	
	/**
	 * This should return an unchanging, externally unreferenced array of supported formats in order of preference (generally children formats first).
	 * @return The supported formats of the subclass.
	 */
	abstract DataInterchangeFormat[] getSupportedFormats();
	
	/**
	 * Determines if the object is formatted as provided.
	 * @param format A supported format as provided by getSupportedFormats().
	 * @param object The object to check the formatting of.
	 * @return true if the formatting is correct, false otherwise.
	 */
	abstract boolean isFormattingCorrect(DataInterchangeFormat format, Object object);
	
	/**
	 * Convert the data in a native format into the format requested.
	 * @param format The format to convert the data to.
	 * @param object The object to convert.
	 * @return The converted object in the requested format.
	 */
	abstract Object convertToFormat(T object, DataInterchangeFormat format);
	
	/**
	 * Convert the data in an external format into the native format.
	 * @param format The format the data is in.
	 * @param object The object to convert.
	 * @return The converted object in the native format.
	 */
	abstract T convertFromFormat(DataInterchangeFormat format, Object object);

}
