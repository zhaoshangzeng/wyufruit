package cn.fruit.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.fruit.domain.Fruit;
import cn.fruit.service.UserService;
import cn.fruit.service.impl.UserServiceImpl;

/**
 * 处理成订单
 * @author zzshang
 *
 */
public class OrderDeal extends HttpServlet {

	/**
	 * 序列化校验码
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
	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); //用于post方式表单提交和a标签提交的中文参数编码
		response.setContentType("text/html;charset=utf-8"); //用于控制浏览器编码，和输出流getWriter()解码
		//将购物车列表转为订单列表
		HttpSession session = request.getSession();
		List<Fruit> listcart = (List<Fruit>) session.getAttribute("listcart");
		List<Fruit> listorder = null;
		if(listcart != null){
			listorder = new ArrayList<Fruit>(listcart);
			listcart.clear();	//清空购物车
			session.setAttribute("listorder", listorder);
		}
		if(listorder != null){
			double orderSum = 0.0;
			for(Fruit f : listorder){
				orderSum += f.getTotalPrice();
			}
			orderSum = (double) Math.round(orderSum * 100) / 100;
			session.setAttribute("orderSum", orderSum);
		}
		//如果是会员，则增加打折
		String username = (String) session.getAttribute("username");
		UserService us = new UserServiceImpl();
		if(us.ifHy(username)){
			Object o = session.getAttribute("orderSum");
			if(o != null){
				double orderSum2 =  (Double) o;
				double hyPrice = orderSum2 * 0.9;
				hyPrice = (double) Math.round(hyPrice * 100) / 100;	//只取后两位 
				session.setAttribute("hyPrice", hyPrice);
			}
		}else{  //如果不是会员，把上次的记录清掉
			Object o2 = session.getAttribute("hyPrice");
			if(o2 != null){
				session.removeAttribute("hyPrice");
			}
		}
		//到订单页面
		String url = response.encodeURL(request.getContextPath() + "/Order");
		response.sendRedirect(url);
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
