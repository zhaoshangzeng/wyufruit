package cn.fruit.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.fruit.domain.User;
import cn.fruit.service.UserService;
import cn.fruit.service.impl.UserServiceImpl;

/**
 * 处理登录请求
 * @author zzshang
 *
 */
public class LoginDeal extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		//1.进行登陆
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		UserService us = new UserServiceImpl();
		User user = us.login(phone, password);
		
		//2.登陆失败则回显失败信息
		if(user == null){
			request.setAttribute("loginErrors", "手机号码或密码有误！请重新输入！");
			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
			return;
		}
		
		//3.登陆成功则跳转到成功提示页面
		//将用户名存到session，显示给用户，告诉成功登陆
		HttpSession session = request.getSession();
		String id = session.getId();
		Cookie cookie = new Cookie("JSESSIONID", id);
		cookie.setMaxAge(30 * 60);
		cookie.setPath(request.getContextPath());
		response.addCookie(cookie);
		session.setAttribute("username", user.getUsername());
		
		//4.同时将会员信息存到session
		if(us.ifHy(user.getUsername())){
			session.setAttribute("ishy", "yes");
		}else{
			session.setAttribute("ishy", "no");
		}
		//跳转到成功页面
		String url = response.encodeURL(request.getContextPath() + "/LoginCG");
		response.sendRedirect(url);
		return;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
