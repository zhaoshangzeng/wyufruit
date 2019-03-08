package cn.fruit.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.fruit.domain.User;
import cn.fruit.exception.UserExistException;
import cn.fruit.service.UserService;
import cn.fruit.service.impl.UserServiceImpl;
import cn.fruit.utils.WebUtils;
import cn.fruit.web.formbean.RegisterForm;

/**
 * 处理注册请求
 * @author zzshang
 *
 */
public class RegisterDeal extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		//1.校验提交表单数据，使用formbean，将表单数据存到formbean对象中，调用formbean对象的校验方法
		RegisterForm Rform = WebUtils.request2Bean(request, RegisterForm.class);
		boolean Rb = Rform.validate();
		
		//2.如果校验失败，则回到表单页面，回显校验失败信息（通过span标签）
		if(!Rb){
			request.setAttribute("Rform", Rform);
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
			return ;
		}
		
		//3.如果校验成功，则处理注册
		User user = new User();
		WebUtils.copyBean(user, Rform); //将FormBean的属性值 转到 UserBean中
		user.setId(WebUtils.generateID()); //设置全球唯一的id
		UserService us = new UserServiceImpl();
		try {
			us.register(user);	//进行注册（注册过程发现phone已存在则抛异常）
			
			//6.如果注册成功，则跳转到成功提示页面
			//将用户名存到session，显示给用户，告诉成功登陆
			HttpSession session = request.getSession();
			String id = session.getId();
			Cookie cookie = new Cookie("JSESSIONID", id);
			cookie.setMaxAge(30 * 60);
			cookie.setPath(request.getContextPath());
			response.addCookie(cookie);
			session.setAttribute("username", request.getParameter("username"));
			//告诉页面是普通用户
			session.setAttribute("ishy", "no");
			//跳转到成功页面
			String url = response.encodeURL(request.getContextPath() + "/RegisterCG");
			response.sendRedirect(url);
			return;
		} catch (UserExistException e) {
			//4.如果注册不成功，如果不成功原因是已存在，则回到表单页面，回显原因
			Rform.getErrors().put("phone", "该手机号码已存在！");
			request.setAttribute("Rform", Rform);
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
			return;
		} catch (Exception e2){
			//5.如果注册不成功，如果不成功原因是其他问题，则跳转到全局异常页面
			//其他系统异常存到日志中
			//这里为了看到异常，则先打印出来
			e2.printStackTrace();
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
