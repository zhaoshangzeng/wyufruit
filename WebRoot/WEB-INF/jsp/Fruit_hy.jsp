<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.fruit.cn" prefix="fruit" %>

<fruit:SendMap/>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <!-- 编码 -->
  <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0"> 
  <!-- 标题 -->
  <title>五邑大学鲜果商城</title>
  <!-- 匹配移动端 -->
  <meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width,initial-scale=1.0">
  <!-- css样式表 -->
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/index.css">
  <!-- js表 -->
  <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.3.1.min.js"></script>
  <script src="${pageContext.request.contextPath }/js/lb.js" type="text/javascript"></script>
  <script src="${pageContext.request.contextPath }/js/index.js"></script>

</head>
<body>
  <div class="big_wrap">
  <!-- 顶部面板 -->
  <form name="form1" method="post" id="form1">
    <div class="topbar">
      <ul>
        <li class="topbar_left">               
          <c:if test="${username == null }">
          	  您好，欢迎来到五邑大学鲜果商城&nbsp;——>
	          <a href="${pageContext.request.contextPath }/Login">[登录]</a>
	          <a href="${pageContext.request.contextPath }/Register">[注册]</a>
		  </c:if>
		  <c:if test="${username != null  }">
			  您好，${username}！欢迎来到五邑大学鲜果商城&nbsp;&nbsp;
			  <a href="${pageContext.request.contextPath }/Logout">[安全退出]</a>
			  <c:if test="${ishy == 'yes' }">
			  	<a>您是会员，尊享会员价</a>
			  </c:if>
			  <c:if test="${ishy == 'no' }">
			  	<a href="${pageContext.request.contextPath }/Buyhy">[购买会员]</a>
			  </c:if>
		  </c:if>
        </li>
        <li class="topbar_right">
            <a href="${pageContext.request.contextPath }/About_us?about=sx">商城详情&nbsp;|</a>
            <a href="${pageContext.request.contextPath }/About_us?about=jg">价格疑问&nbsp;|</a>
            <a href="${pageContext.request.contextPath }/About_us">问题反馈&nbsp;|</a>
            <span>热线电话：132-4687-4458</span>
        </li>
      </ul>
    </div>
  </form>
  <!-- 头部 -->
  <form name="form1" method="post" id="form1">
    <div class="wrap">
      <div class="header">
        <div class="logo">
          <h1>
            <a href="${pageContext.request.contextPath }"><img src="${pageContext.request.contextPath }/img/wyuf_logo.png" alt=""><i></i></a>
          </h1>
        </div>
        <div class="shopping">
          <a class="shopping_link">
            <span></span>购物车&nbsp;<i></i>
          </a>
          <div class="shopping_m">
            <span class="empty">您还没有选购商品</span>
            <c:if test="${username == null }">
            	<a href="${pageContext.request.contextPath }/Login" class="vw">去购物车结算</a>
			  </c:if>
			  <c:if test="${username != null  }">
            	<a href="${pageContext.request.contextPath }/ListCartDeal" class="vw">去购物车结算</a>
			  </c:if>
          </div>
        </div>
        <div class="searchbar">
          <ul>
            <li>
              <input id="wd" name="wd" class="input_key" type="text" placeholder="" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '请输入您需要的水果名称'; }" value='请输入您需要的水果名称'>
            </li>
            <li class="s_btn">
              <input type="image" class="input_btn" value="搜索" src="${pageContext.request.contextPath }/img/search.png">
            </li>
          </ul>
          <span>热门：
            <a href="${pageContext.request.contextPath }/Xq?id=hfs">${map.hfs.name }</a>
            <a href="${pageContext.request.contextPath }/Xq?id=xj">${map.xj.name }</a>
            <a href="${pageContext.request.contextPath }/Xq?id=ht">${map.ht.name }</a>
            <a href="${pageContext.request.contextPath }/Xq?id=sl">${map.sl.name }</a>
          </span>
        </div>
      </div>
    </div>
  </form>

  <!-- 主体分类面板 -->
  <div class="navmain">
    <div class="nav">
      <div class="menu">
        <!-- 下拉列表 -->
        <dl>
          <dt>全部分类<i></i></dt>
          <dd>
            <a href="${pageContext.request.contextPath }/Fruit_sl">
                时令水果
            </a>
            <a href="${pageContext.request.contextPath }/Fruit_yp">
                硬皮水果
            </a>
            <a href="${pageContext.request.contextPath }/Fruit_bz">
                本周特惠
            </a>
            <a href="${pageContext.request.contextPath }/Fruit_hy">
                会员专区
            </a>
          </dd>
        </dl>
        <!-- 横块分类 -->
        <ul>
          <li class="on">
              <a href="${pageContext.request.contextPath }">首页</a>
          </li>
          <li>
            <a href="${pageContext.request.contextPath }/Fruit_sl">时令水果</a>
          </li>
          <li>
            <a href="${pageContext.request.contextPath }/Fruit_yp">硬皮水果</a>
          </li>
          <li>
            <a href="${pageContext.request.contextPath }/Fruit_bz">本周特惠</a>
          </li>
          <li>
            <a href="${pageContext.request.contextPath }/Fruit_hy">会员专区</a>
          </li>
          <li>
            <a href="${pageContext.request.contextPath }/About_us">关于我们</a>
          </li>
        </ul>
      </div>
    </div>
  </div>
  
  <!-- 水果展示 -->
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/category.css">
   <div class="mauto">
     <div class="category_bar oh">
       <span class="fl">
         <%-- <a href="${pageContext.request.contextPath }">首页</a> &gt; <a>会员专区 --%>
         <div style="text-align: center;"><i style="color:red">会员价</i>：所有页面水果再打9折（价格见最终结算页面）（购买会员请先注册普通会员）</div></a>
       </span>
     </div>
     
     <div class="list_main">
         
       <ul>
   
       <!-- 遍历出每一个水果 -->
    	<c:forEach var="entry" items="${mapHy }">
    		<li>
	        <a href="${pageContext.request.contextPath }/Xq?id=${entry.key}" target="_blank">
	            <dl>
	                <dt>
	                    <img src="${pageContext.request.contextPath }/img/${entry.value.pictureUrlb }" width="210" height="210" alt="四川柑橘"></dt>
	                <dd class="pro_tit">${entry.value.name }</dd>
	                <dd><del>￥${entry.value.delprice }元/${map.value.unit }</del>&nbsp;&nbsp;<span>${entry.value.discount }折</span></dd>
	                <dd class="pro_price">￥<i>${entry.value.price }元/${entry.value.unit }</i></dd>   
	                <dd class="pro_num">上架第${entry.value.day }天</dd>
	            </dl>
	        </a>
        	</li>
    		
    	</c:forEach>
   
       </ul>
             
     </div>
     <!--flip-->
     <div id="dvPageList" class="flip">
         <ul><li class="on">1</li><li><span>共 1 页</span></li></ul>
     </div>
       
   </div>

  <!-- 底部 链接  -->
  <div class="main_foot">
    <div class="footer">
      <!-- 左边 -->
      <ul>
        <li>
          <span class="fw">关于我们</span>
          <a href="${pageContext.request.contextPath }/About_us">公司介绍</a>               
          <a href="${pageContext.request.contextPath }/About_us">联系我们</a>                 
          <a href="${pageContext.request.contextPath }/About_us">业务合作</a>                 
          <a href="${pageContext.request.contextPath }/About_us">招纳贤士</a>       
        </li>
        <li>
          <span class="fw">售后服务</span>
          <a href="${pageContext.request.contextPath }/About_us">退款说明</a>
          <a href="${pageContext.request.contextPath }/About_us">更换政策</a>
          <a href="${pageContext.request.contextPath }/About_us">退换货</a>    
          <a href="${pageContext.request.contextPath }/About_us">常见问题</a>     
        </li>
        <li>
          <span class="fw">配送方式</span>
          <a href="${pageContext.request.contextPath }/About_us">配送运费</a>
          <a href="${pageContext.request.contextPath }/About_us">配送范围</a>
          <a href="${pageContext.request.contextPath }/About_us">配送时间</a>     
        </li>
        <li>
          <span class="fw">付款方式</span>
          <a href="${pageContext.request.contextPath }/About_us">支付方式</a>
          <a href="${pageContext.request.contextPath }/About_us">充值说明</a>
          <a href="${pageContext.request.contextPath }/About_us">积分说明</a>     
        </li>
        <li>
          <span class="fw">新手入门</span>
          <a href="${pageContext.request.contextPath }/About_us">账号注册</a>
          <a href="${pageContext.request.contextPath }/About_us">购物流程</a>
          <a href="${pageContext.request.contextPath }/About_us">商品分类</a>     
        </li>
        <li class="foot_code">
          <i>
            <div class="logo">
              <h1>
                <a href="${pageContext.request.contextPath }"><img src="${pageContext.request.contextPath }/img/wyuf_logo.png" alt=""><i></i></a>
              </h1>
            </div>
          </i>
        </li>
        <!-- 右边 -->
        <li class="foot_phone">
          <em>400-234-6060</em>
          <p>周一至周五:09:00-18:00</p>
          <p>(仅收市话费用)</p>
          <a href="tencent://message/?uin=3486454&amp;Site=wyufruit&amp;Menu=yes" target="_blank"><p>24小时在线客服</p></a>
        </li>
      </ul>
    </div>
    <!-- 底部版权说明 -->
    <div class="copyright">
      <ul>
        <li class="cr_info">
          <a href="${pageContext.request.contextPath }/About_us?about=sx">商城详情</a>|
          <a href="tencent://message/?uin=3486454&amp;Site=wyufruit&amp;Menu=yes" target="_blank">在线客服</a>|
          <a href="${pageContext.request.contextPath }/About_us" target="_blank">帮助中心</a>|
          <a href="${pageContext.request.contextPath }/About_us" target="_blank">问题反馈</a>
          <i>&copy;wyufruit&nbsp;五邑大学鲜果商城&nbsp;版权所有&nbsp;
            <a href="http://www.miitbeian.gov.cn/" target="_blank">粤ICP备07803432号-70</a>
          </i>
        </li>
      </ul>
    </div>
    <!-- 回到最上方的图标 -->
    <div class="toTop">
      <a href="javascript:void();"><img src="${pageContext.request.contextPath }/img/0h.png" alt="图片不支持"></a>
    </div>
  </div>
  </div>
</body>
</html>
