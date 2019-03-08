package cn.fruit.DB;

import java.util.LinkedHashMap;
import java.util.Map;

import cn.fruit.domain.Fruit;

public class DataBz {
	private static Map<String,Fruit> map = new LinkedHashMap<String,Fruit>();
	static{
		map.put("xj", Data.getAll().get("xj"));
		map.put("xg", Data.getAll().get("xg"));
		map.put("xhs", Data.getAll().get("xhs"));
		map.put("gg", Data.getAll().get("gg"));
		map.put("bxg", Data.getAll().get("bxg"));
		map.put("xhl", Data.getAll().get("xhl"));
		map.put("dz", Data.getAll().get("dz"));
		map.put("hfs", Data.getAll().get("hfs"));
	}
	public static Map<String, Fruit> getAll(){
		return map;
	}
}
