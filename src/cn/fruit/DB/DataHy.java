package cn.fruit.DB;

import java.util.LinkedHashMap;
import java.util.Map;

import cn.fruit.domain.Fruit;

public class DataHy {
	private static Map<String,Fruit> map = new LinkedHashMap<String,Fruit>();
	static{
		map.put("mg", Data.getAll().get("mg"));
		map.put("bxg", Data.getAll().get("bxg"));
		map.put("xhl", Data.getAll().get("xhl"));
		map.put("ht", Data.getAll().get("ht"));
		map.put("nm", Data.getAll().get("nm"));
		map.put("clz", Data.getAll().get("clz"));
		map.put("dz", Data.getAll().get("dz"));
		map.put("sl", Data.getAll().get("sl"));
		map.put("hfs", Data.getAll().get("hfs"));
	}
	public static Map<String, Fruit> getAll(){
		return map;
	}
}