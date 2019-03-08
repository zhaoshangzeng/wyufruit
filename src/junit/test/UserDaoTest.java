package junit.test;

import org.junit.Test;

import cn.fruit.dao.UserDao;
import cn.fruit.dao.impl.UserDaoImpl;
import cn.fruit.domain.User;

/**
 * 测试Dao层的用户数据的增和查
 * @author zzshang
 *
 */
public class UserDaoTest {
	
	@Test
	public void testAdd(){
		User user = new User();
		user.setId("12311311222");
		user.setUsername("张晓明");
		user.setPhone("13222222222");
		user.setAddress("西区宿舍10楼1011");
		user.setPassword("222222");
		user.setIfvip("0");
		
		UserDao userDaoImpl = new UserDaoImpl();
		userDaoImpl.add(user);
	}
	
	@Test
	public void testFindPhone(){
		UserDao userDaoImpl = new UserDaoImpl();
		Boolean find = userDaoImpl.find("13246874458");
		System.out.println(find);
	}
	
	@Test
	public void testLogin(){
		UserDao userDaoImpl = new UserDaoImpl();
		User find = userDaoImpl.find("13246874458", "123456");
		System.out.println(find);
	}
	
	@Test
	public void testFindName(){
		UserDao userDaoImpl = new UserDaoImpl();
		User user = userDaoImpl.findByName("游客");
		System.out.println(user);
	}
}
