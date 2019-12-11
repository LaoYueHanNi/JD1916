package exception;
//自定义check异常
public class FirstException extends Exception{

	public FirstException() {
		super();
	}

	public FirstException(String message, Throwable cause) {
		super(message, cause);
	}

	public FirstException(String message) {
		super(message);
	}

	public FirstException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
