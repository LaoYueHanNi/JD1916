package exception;
//自定义uncheck异常
public class SecondException extends RuntimeException {

	public SecondException() {
		super();
	}

	public SecondException(String message, Throwable cause) {
		super(message, cause);
	}

	public SecondException(String message) {
		super(message);
	}

	public SecondException(Throwable cause) {
		super(cause);
	}
	
}
