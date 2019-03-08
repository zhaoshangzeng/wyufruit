package cn.fruit.dao;

import cn.fruit.domain.User;

/**
 * 用户数据处理操作库
 * @author zzshang
 *
 */
public interface UserDao {

	/**
	 * 添加用户
	 * @param user
	 */
	void add(User user);

	/**
	 * 添加用户时，根据手机号码判断数据库是否有一样的
	 * @param phone
	 * @return
	 */
	Boolean find(String phone);

	/**
	 * 根据手机号码和密码判断登录
	 * @param phone
	 * @param password
	 * @return
	 */
	User find(String phone, String password);
	
	/**
	 * 根据姓名查找到用户信息，用于判断是否是会员
	 * @param username
	 * @return
	 */
	User findByName(String username);
	
	/**
	 * 设置vip
	 * @param username
	 * @return
	 */
	Boolean setVip(String username);

}