package exception;
//�Զ���uncheck�쳣
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
