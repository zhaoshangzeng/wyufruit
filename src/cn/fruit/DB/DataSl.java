package cn.fruit.DB;

import java.util.LinkedHashMap;
import java.util.Map;

import cn.fruit.domain.Fruit;

public class DataSl {
	private static Map<String,Fruit> map = new LinkedHashMap<String,Fruit>();
	static{
		map.put("gg", Data.getAll().get("gg"));
		map.put("pt", Data.getAll().get("pt"));
		map.put("bxg", Data.getAll().get("bxg"));
		map.put("ht", Data.getAll().get("ht"));
		map.put("xhs", Data.getAll().get("xhs"));
		map.put("clz", Data.getAll().get("clz"));
		map.put("dz", Data.getAll().get("dz"));
		map.put("xj", Data.getAll().get("xj"));
		map.put("hfs", Data.getAll().get("hfs"));
	}
	public static Map<String, Fruit> getAll(){
		return map;
	}
}
