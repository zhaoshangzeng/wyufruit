package cn.fruit.DB;

import java.util.LinkedHashMap;
import java.util.Map;

import cn.fruit.domain.Fruit;

/**
 * 临时代表数据库
 * @author zzshang
 *
 */
public class Data {
	private static Map<String,Fruit> map = new LinkedHashMap<String,Fruit>();
	static{
	//String name, String description, int day, double delprice,
			//String unit, String tip,String pictureUrlb)
		map.put("sl", new Fruit("sl","云南蒙自石榴","云南蒙自水晶甜石榴，清甜爽口，晶莹水润，皮薄粒大",1,10.00,"个","石榴的营养特别丰富，含有多种人体所需的营养成分","rmd1.jpg"));
		map.put("xhs", new Fruit("xhs","普罗旺斯西红柿","普罗旺斯番茄新鲜自然熟沙瓤水果，味道沙甜，汁多爽口",1,9.90,"斤","生津止渴，凉血养肝，清热解毒，还具有美容功效","rmd2.jpg"));
		map.put("xg", new Fruit("xg","御麒麟西瓜","御麒麟西瓜皮薄多汁，果味甘甜，肉质细嫩，秋冬季节",2,12.00,"个","具有清热解暑、生津止渴、利尿除烦的功效","rmd3.jpg"));
		map.put("gg", new Fruit("gg","四川柑橘","来自北纬30°，全年超过三千小时日照，充足的阳光使得果实更香甜！",1,6.50,"斤","具有开胃健食、保肝明目、降压降脂的功效","rmx1.jpg"));
		map.put("dz", new Fruit("dz","山东沾化冬枣","皮薄肉脆、甘甜清香、营养丰富，被誉为“百果王”",3,12.00,"斤","具有增强免疫力、调理肠胃助消化、解酒解毒护肝的功效","rmx2.jpg"));
		map.put("xj", new Fruit("xj","广西香甜香蕉","白天阳光好，昼夜温差较大，因而香甜，品质好",1,8.50,"斤","具有益胃生津、疏通血脉、解酒毒的功效","rmx3.jpg"));
		map.put("pt", new Fruit("pt","大连红提子葡萄","大棚无公害葡萄,味美多汁,酸甜可口",1,9.50,"斤","具有生津消食、缓解疲劳、补血益气的功效","rmx4.jpg"));
		map.put("xhl", new Fruit("xhl","河北雪花梨","河北特产新鲜皇冠梨，鲜嫩多汁，口感清脆，皮薄爽口",2,5.00,"个","具有清热镇静、润肺止咳、润肠通便的功效","xpd1.jpg"));
		map.put("mg", new Fruit("mg","海南红心木瓜","海南冰糖红心木瓜，三亚热带特产，肉质细腻，甜蜜可口",2,10.50,"个","具有健脾消食、补充营养、抗疫杀虫的功效","xpd2.jpg"));
		map.put("clz", new Fruit("clz","美国樱桃/车厘子","美国车厘子美早红灯甜樱桃，肉厚多汁，营养丰富",2,90.00,"斤","具有祛风除湿，通痹止痛的功效","xpd3.jpg"));
		map.put("bxg", new Fruit("bxg","广西生态百香果","广西黄金百香果鸡蛋果，酸甜爽口，多肉多汁",2,12.00,"斤","具有生津利咽、润肠通便、排毒养颜的功效","xpx1.jpg"));
		map.put("ht", new Fruit("ht","云南精选红提子","国产新鲜红提葡萄提子水果红提",1,15.00,"斤","具有补气血、生津液、健脾开胃、利尿消肿的功效","xpx2.jpg"));
		map.put("nm", new Fruit("nm","四川安岳黄柠檬","酸爽可口 夏季DIY饮料必备",3,14.80,"斤","具有生津止渴、开胃提神、美白养肤的功效","xpx3.jpg"));
		map.put("hfs", new Fruit("hfs","烟台红富士苹果","新鲜山东烟台红富士苹果原生态,洗洗带皮吃",2,6.00,"个","具有补脑养血、宁神安眠、预防呼吸道感染的功效","xpx4.jpg"));
	}
	public static Map<String, Fruit> getAll(){
		return map;
	}
}
