package cn.fruit.service.impl;

import cn.fruit.dao.UserDao;
import cn.fruit.dao.impl.UserDaoImpl;
import cn.fruit.domain.User;
import cn.fruit.exception.UserExistException;
import cn.fruit.service.UserService;
import cn.fruit.utils.ServiceUtils;

/**
 * 专门处理用户信息请求，然后将数据交给Dao层，即Controller和Dao的桥梁
 * @author zzshang
 *
 */
public class UserServiceImpl implements UserService {
	
	/**
	 * 连接dao层
	 */
	private UserDao dao = new UserDaoImpl(); //用工厂模式或spring可以让上层代码不用改	
	
	/**
	 * 注册
	 */
	public void register(User user) throws UserExistException{
		//判断当前注册的用户是否存在（判断是否有重复用户）
		boolean b = dao.find(user.getPhone());
		if(b){
			throw new UserExistException();//抛出编译时异常，提醒web处理这个异常
		}else{
			user.setPassword(ServiceUtils.md5(user.getPassword()));	//加密保存
			dao.add(user);
		}
	}
	
	/**
	 * 登录
	 */
	public User login(String phone, String password){
		
		password = ServiceUtils.md5(password);	//加密处理
		return dao.find(phone, password);
	}

	/**
	 * 设置会员
	 */
	public void setHy(String username) {
		
		dao.setVip(username);
	}

	/**
	 * 根据用户名判断是否是会员
	 */
	public boolean ifHy(String username) {
		
		User user = dao.findByName(username);
		if("0".equals(user.getIfvip())){
			return false;
		}else{
			return true;
		}
	}
}
