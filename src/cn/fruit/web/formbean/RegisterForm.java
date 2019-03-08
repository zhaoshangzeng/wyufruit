package cn.fruit.web.formbean;

import java.util.HashMap;
import java.util.Map;

//注册表单bean
public class RegisterForm {
	
	private String username;	//用户名
	private String phone;	//手机号码
	private String address;	//地址
	private String password;	//密码
	private String password2;	//确认密码
	private String ifagree;	//是否同意注册协议，同意则为yes，不同意则为null
	
	private Map<String,String> errors = new HashMap<String,String>();	//存储校验结果，最后给到span

	
	public String getIfagree() {
		return ifagree;
	}
	public void setIfagree(String ifagree) {
		this.ifagree = ifagree;
	}
	public Map<String, String> getErrors() {
		return errors;
	}
	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username.trim();
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone.trim();
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address.trim();
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password.trim();
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2.trim();
	}
	
	//校验表单数据合法性
	public boolean validate(){
		boolean isOK = true;
		//定义规则：
		//名字不能为空，并且为中文字符
		if(this.username == null || this.username.trim().equals("")){
			isOK = false;
			errors.put("username", "姓名不能为空！");
		}else if(!this.username.trim().matches("[\u4e00-\u9fe5]+")){
			isOK = false;
			errors.put("username", "姓名应该为中文！外国友人也应该有中文名(*￣︶￣)");
		}else{
			//如果第一次姓名为空，有了错误信息。但第二次提交，姓名不为空时，应该去掉错误信息，下面同理
			errors.remove("username");
		}
		//手机不能为空，手机规则网上找
		if(this.phone == null || this.phone.trim().equals("")){
			isOK = false;
			errors.put("phone", "手机号码不能为空！");
		}else if(!this.phone.matches("^1(3|4|5|7|8)\\d{9}$")){
			isOK = false;
			errors.put("phone", "手机号码有误，请重填！");
		}else{
			errors.remove("phone");
		}
		//地址不能为空
		if(this.address == null || this.address.trim().equals("")){
			isOK = false;
			errors.put("address", "到货地址不能为空！");
		}else{
			errors.remove("address");
		}
		//密码不能为空，且为6-10位
		if(this.password == null || this.password.trim().equals("")){
			isOK = false;
			errors.put("password", "登录密码不能为空！");
		}else if(!this.password.matches("\\S{6,10}")){
			isOK = false;
			errors.put("password", "登录密码为6到10位数字、字母和英文符合组合！");
		}else{
			errors.remove("password");
		}
		//确认密码不能为空，且要和密码一致
		if(this.password2 == null || this.password2.trim().equals("")){
			isOK = false;
			errors.put("password2", "确认密码不能为空！");
		}else if(!this.password.trim().equals(this.password2.trim())){
			isOK = false;
			errors.put("password2", "确认密码和登录密码要一致！");
		}else{
			errors.remove("password2");
		}
		//判断是否勾选了注册协议
		if(this.ifagree == null){
			isOK = false;
			errors.put("ifagree", "您未勾选！请认真阅读并确认勾选！");
		}else{
			errors.remove("ifagree");
		}
		
		return isOK;
	}
}
