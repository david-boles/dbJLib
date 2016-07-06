package space.davidboles.lib.database;

public abstract class BaseWAD<T> implements ArbitraryDataWrapperInterface {

	private static final long serialVersionUID = 1L;

	T data;
	
	public BaseWAD(T data) {
		this.data = data;
	}
	
	@Override
	public synchronized boolean formatGetSupported(DataInterchangeFormat format) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public synchronized Object getData(DataInterchangeFormat format, KeyObjectPair[] info) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public synchronized boolean formatSetSupported(DataInterchangeFormat format) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public synchronized void setData(DataInterchangeFormat format, Object data, KeyObjectPair[] info) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * This should return an unchanging, externally unreferenced array of supported formats in order of preference.
	 * @return The supported formats of the subclass.
	 */
	abstract DataInterchangeFormat[] getSupportedFormats();
	
	//TODO Documentation
	/**
	 * Convert the data provided into the format requested.
	 * @param format
	 * @param object
	 * @return
	 */
	abstract Object convertToFormat(DataInterchangeFormat format, T object);
	
	abstract T convertFromFormat(DataInterchangeFormat format, Object object);

}
