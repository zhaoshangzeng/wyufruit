package cn.fruit.web.UI;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Fruit_yp extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		//防盗链，如果用户第一次访问，通过url直接登录该页面，而没有登录首页，则让用户回到首页
		//即让用户必须先访问首页，一是新消息在首页，二是初始化代码也在首页
		String referer = request.getHeader("referer");
		if(referer==null){
			response.sendRedirect("/wyufruit");  //让用户看到网址改变，告诉用户不能直接进入
			return;
		}
		//跳转到Fruit_yp.jsp
		request.getRequestDispatcher("/WEB-INF/jsp/Fruit_yp.jsp").forward(request, response);
		return;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
