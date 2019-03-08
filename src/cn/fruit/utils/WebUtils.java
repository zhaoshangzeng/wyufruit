package cn.fruit.utils;

import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class WebUtils {

	//请求参数转成bean属性值
	public static <T> T request2Bean(HttpServletRequest request, Class<T> beanClass){
		//参数定义为class，可以让调用者不用new对象，直接传class类型即可
		//使用泛型，可以让调用者获得结果时，不用强转类型
		try {
			//1.创建要封装数据的bean
			T bean = beanClass.newInstance();
			
			//2.把数据整到bean中
			@SuppressWarnings("unchecked")
			Map<String, String> map = request.getParameterMap();
			BeanUtils.populate(bean, map);
			
			return bean;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	//FormBean属性值 转成 UserBean属性值
	public static void copyBean(Object dest, Object src){
		try {
			BeanUtils.copyProperties(dest, src);
		} catch (Exception e){
			throw new RuntimeException(e);
		}
	}
	
	//产生用户id，产生全球唯一的id
	public static String generateID(){
		
		UUID randomUUID = UUID.randomUUID();
		String uuid = randomUUID.toString().replace("-", "").toUpperCase();
		return uuid;
	}
}
