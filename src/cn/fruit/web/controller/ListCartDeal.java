	package cn.fruit.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.fruit.DB.Data;
import cn.fruit.domain.Fruit;

public class ListCartDeal extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		//处理用户的水果，存到购物车列表，列表存到session
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		List<Fruit> listcart = (List<Fruit>) session.getAttribute("listcart");
		if(listcart == null){
			if(request.getParameter("buyid") != null){
				listcart = new ArrayList<Fruit>();
				session.setAttribute("listcart", listcart);
			}
		}
		String buyid = request.getParameter("buyid");
		Fruit fruit = Data.getAll().get(buyid);
		if(listcart != null && buyid != null){
			if(listcart.contains(fruit)){
				listcart.remove(fruit);
			}
			listcart.add(fruit);
		}
		//跳转到购物车
		String url = response.encodeURL(request.getContextPath() + "/ListCart");
		response.sendRedirect(url);
		return;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
