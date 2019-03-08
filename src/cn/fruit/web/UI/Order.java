package cn.fruit.web.UI;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 订单页面
 * @author zzshang
 *
 */
public class Order extends HttpServlet {

	/**
	 * 序列化校验
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 方法说明：get服务。
	 * 方法目标：处理请求方式为get请求。
	 * 方法使用：地址栏请求、a标签请求或form表单的get请求。
	 * @param HttpServletRequest request
	 * @param HttpServletResponse response
	 * @throws ServletException
	 * @throws IOException
	 * @see javax.servlet.http.HttpServlet#doGet
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); //用于post方式表单提交和a标签提交的中文参数编码
		response.setContentType("text/html;charset=utf-8"); //用于控制浏览器编码，和输出流getWriter()解码
		//防盗链，如果用户第一次访问，通过url直接登录该页面，而没有登录首页，则让用户回到首页
		//即让用户必须先访问首页，一是新消息在首页，二是初始化代码也在首页
		String referer = request.getHeader("referer");
		if(referer==null){
			response.sendRedirect("/wyufruit");  //让用户看到网址改变，告诉用户不能直接进入
			return;
		}
		//跳转到order.jsp
		request.getRequestDispatcher("/WEB-INF/jsp/order.jsp").forward(request, response);
		return;
	}

	/**
	 * 方法说明：post服务。
	 * 方法目标：处理请求方式为post请求。
	 * 方法使用：form表单的post请求。
	 * @param HttpServletRequest request
	 * @param HttpServletResponse response
	 * @throws ServletException
	 * @throws IOException
	 * @see javax.servlet.http.HttpServlet#doPost
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
