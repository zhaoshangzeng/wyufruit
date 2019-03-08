package junit.test;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import cn.fruit.domain.User;
import cn.fruit.exception.UserExistException;
import cn.fruit.service.UserService;
import cn.fruit.service.impl.UserServiceImpl;

/**
 * 测试userservice层
 * @author zzshang
 *
 */
public class UserServiceTest {
	
	UserService us = null;
	
	@Before
	public void getServiceObject(){
		us = new UserServiceImpl();
	}

	//注册
	@Test
	public void testRegister(){
		User user = new User();
		user.setId("3928399282");
		user.setUsername("邓焯元");
		user.setPhone("13246874450");
		user.setAddress("北区宿舍14栋213");
		user.setPassword("123456");
		user.setIfvip("1");
		
		try {
			us.register(user);
			System.out.println("注册成功");
		} catch (UserExistException e) {
			System.out.println("用户已经存在！");
		}
	}
	
	//登录
	@Test
	public void testLogin(){
		User user = us.login("13246874455", "123456");
		if(user == null){
			System.out.println("登录失败！");
		}else{
			System.out.println("登录成功！");
		}
	}
	
	//测试判断会员
	@Test
	public void testIfHy(){
		boolean ifHy = us.ifHy("游客");
		Assert.assertEquals(true, ifHy);
	}
	
	//测试注册会员
	@Test
	public void testBuyHy(){
		us.setHy("游客");
	}
}
