package exception;
/**
 * 资金异常类
 * @author hb
 *
 */
public class AccountException extends Exception{
	String message="";
	public AccountException(String ms) {
		super(ms);
		this.message=ms;
		
	}
	public String toString() {
		return message;
	}
}
