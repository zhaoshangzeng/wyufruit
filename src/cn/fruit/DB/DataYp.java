package cn.fruit.DB;

import java.util.LinkedHashMap;
import java.util.Map;

import cn.fruit.domain.Fruit;

public class DataYp {
	private static Map<String,Fruit> map = new LinkedHashMap<String,Fruit>();
	static{
		map.put("xhl", Data.getAll().get("xhl"));
		map.put("mg", Data.getAll().get("mg"));
		map.put("bxg", Data.getAll().get("bxg"));
		map.put("sl", Data.getAll().get("sl"));
		map.put("nm", Data.getAll().get("nm"));
		map.put("dz", Data.getAll().get("dz"));
		map.put("xg", Data.getAll().get("xg"));
		map.put("hfs", Data.getAll().get("hfs"));
	}
	public static Map<String, Fruit> getAll(){
		return map;
	}
}
