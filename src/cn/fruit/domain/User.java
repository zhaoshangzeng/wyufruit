package cn.fruit.domain;

/**
 * 用户基本信息类
 * @author zzshang
 *
 */
public class User {
	private String id;	//唯一性识别码
	private String username;	//用户名
	private String phone;	//手机号码
	private String address;	//地址
	private String password;	//密码
	private String ifvip;	//是否为vip，0则不是，1则是
	
	{
		ifvip = "0";
	}
	public User() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIfvip() {
		return ifvip;
	}
	public void setIfvip(String ifvip) {
		this.ifvip = ifvip;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", phone=" + phone
				+ ", address=" + address + ", password=" + password
				+ ", ifvip=" + ifvip + "]";
	}
	
}
