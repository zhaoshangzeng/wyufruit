package cn.fruit.dao.impl;

import org.dom4j.Document;
import org.dom4j.Element;

import cn.fruit.dao.UserDao;
import cn.fruit.domain.User;
import cn.fruit.utils.XmlUtils;

/**
 * 处理用户信息数据的基本操作：增和查
 * @author zzshang
 *
 */
public class UserDaoImpl implements UserDao {
	
	/**
	 * 添加用户
	 */
	public void add(User user){
		try {
			Document document = XmlUtils.getDocument();
			Element root = document.getRootElement();
			
			Element user_tag = root.addElement("user");
			user_tag.addAttribute("id", user.getId());
			user_tag.addAttribute("username", user.getUsername());
			user_tag.addAttribute("phone", user.getPhone());
			user_tag.addAttribute("address", user.getAddress());
			user_tag.addAttribute("password", user.getPassword());
			user_tag.addAttribute("ifvip", user.getIfvip());
			
			XmlUtils.write2Xml(document);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * 添加用户时，根据手机号码判断数据库是否有一样的
	 */
	public Boolean find(String phone){
		try {
			Document document = XmlUtils.getDocument();
			Element e = (Element) document.selectSingleNode("//user[@phone='"+phone+"']");
			if(e == null){
				return false;
			}
			return true;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * 根据用户名和密码判断登录
	 */
	public User find(String phone, String password){
		try {
			Document document = XmlUtils.getDocument();
			//Dom4j的XPath
			Element e = (Element) document.selectSingleNode("//user[@phone='"+phone+"' and @password='"+password+"']");
			if(e == null){
				return null;
			}
			User user = new User();
			user.setId(e.attributeValue("id"));
			user.setUsername(e.attributeValue("username"));
			user.setPhone(e.attributeValue("phone"));
			user.setAddress(e.attributeValue("address"));
			user.setPassword(e.attributeValue("password"));
			user.setIfvip(e.attributeValue("ifvip"));
			return user;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


	/**
	 * 设置vip
	 */
	public Boolean setVip(String username) {
		try {
			Document document = XmlUtils.getDocument();
			//Dom4j的XPath
			Element e = (Element) document.selectSingleNode("//user[@username='"+username+"']");
			if(e == null){
				return false;
			}
			e.addAttribute("ifvip", "1");
			
			XmlUtils.write2Xml(document);
			return true;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


	/**
	 * 根据用户名获得用户信息，用于判断用户是否是会员
	 */
	public User findByName(String username) {
		try{
			Document document = XmlUtils.getDocument();
			//Dom4j的XPath
			Element e = (Element) document.selectSingleNode("//user[@username='"+username+"']");
			if(e == null){
				return null;
			}
			User user = new User();
			user.setId(e.attributeValue("id"));
			user.setUsername(e.attributeValue("username"));
			user.setPhone(e.attributeValue("phone"));
			user.setAddress(e.attributeValue("address"));
			user.setPassword(e.attributeValue("password"));
			user.setIfvip(e.attributeValue("ifvip"));
			return user;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
