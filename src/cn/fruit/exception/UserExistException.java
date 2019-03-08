package cn.fruit.exception;

/**
 * 用户已存在异常
 * 当能找到该用户，则抛该异常
 * 用于注册时，发现数据库有重复用户，则用该异常做处理
 * @author zzshang
 *
 */
public class UserExistException extends Exception {

	private static final long serialVersionUID = 1L;

	public UserExistException() {
		// TODO Auto-generated constructor stub
	}

	public UserExistException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UserExistException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public UserExistException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}
