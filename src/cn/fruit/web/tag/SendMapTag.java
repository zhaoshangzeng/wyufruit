package cn.fruit.web.tag;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import cn.fruit.DB.Data;
import cn.fruit.DB.DataBz;
import cn.fruit.DB.DataHy;
import cn.fruit.DB.DataSl;
import cn.fruit.DB.DataYp;

/**
 * 自定义标签库--标签处理器类
 * 功能：将所有fruit数据存到session中，方便jsp调用，即用于水果数据初始化
 * 它的标签库描述文件tld是fruitmap.tld
 * @author zzshang
 *
 */
public class SendMapTag extends TagSupport {

	private static final long serialVersionUID = 1L;

	@Override
	public int doStartTag() throws JspException {
		HttpSession session = this.pageContext.getSession();
		HttpServletRequest request = (HttpServletRequest) this.pageContext.getRequest();
		HttpServletResponse response = (HttpServletResponse) this.pageContext.getResponse();
		
		//存水果数据到会话中
		session.setAttribute("map", Data.getAll()); 
		session.setAttribute("mapSl", DataSl.getAll()); 
		session.setAttribute("mapYp", DataYp.getAll()); 
		session.setAttribute("mapBz", DataBz.getAll()); 
		session.setAttribute("mapHy", DataHy.getAll()); 
		
		//延长session
		String id = session.getId();
		Cookie cookie = new Cookie("JSESSIONID", id);
		cookie.setMaxAge(5*60*60);
		cookie.setPath(request.getContextPath());
		response.addCookie(cookie);
		
		return super.doStartTag();
	}
	//移除的代码：
//	<%-- <%@page import="cn.fruit.DB.Data"%> --%>
//	<%-- <%session.setAttribute("map", Data.getAll()); 
//	//延长session
//	String id = session.getId();Cookie cookie = new Cookie("JSESSIONID", id);cookie.setMaxAge(5*60*60);cookie.setPath(request.getContextPath());response.addCookie(cookie);
//	%> --%>
	
//	<%@page import="cn.fruit.DB.DataSl"%>
//	<%session.setAttribute("mapSl", DataSl.getAll()); %>
}
