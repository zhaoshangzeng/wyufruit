package cn.fruit.service;

import cn.fruit.domain.User;
import cn.fruit.exception.UserExistException;

public interface UserService {

	//注册
	void register(User user) throws UserExistException;

	//登录
	User login(String phone, String password);

	//设置vip
	void setHy(String username);
	
	//根据用户名判断是否注册会员
	boolean ifHy(String username);
}