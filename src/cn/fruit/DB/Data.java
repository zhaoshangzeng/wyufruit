package cn.fruit.DB;

import java.util.LinkedHashMap;
import java.util.Map;

import cn.fruit.domain.Fruit;

/**
 * ��ʱ�������ݿ�
 * @author zzshang
 *
 */
public class Data {
	private static Map<String,Fruit> map = new LinkedHashMap<String,Fruit>();
	static{
	//String name, String description, int day, double delprice,
			//String unit, String tip,String pictureUrlb)
		map.put("sl", new Fruit("sl","��������ʯ��","��������ˮ����ʯ������ˬ�ڣ���Өˮ��Ƥ������",1,10.00,"��","ʯ���Ӫ���ر�ḻ�����ж������������Ӫ���ɷ�","rmd1.jpg"));
		map.put("xhs", new Fruit("xhs","������˹������","������˹����������Ȼ��ɳȿˮ����ζ��ɳ��֭��ˬ��",1,9.90,"��","����ֹ�ʣ���Ѫ���Σ����Ƚⶾ�����������ݹ�Ч","rmd2.jpg"));
		map.put("xg", new Fruit("xg","����������","����������Ƥ����֭����ζ��������ϸ�ۣ��ﶬ����",2,12.00,"��","�������Ƚ������ֹ�ʡ���������Ĺ�Ч","rmd3.jpg"));
		map.put("gg", new Fruit("gg","�Ĵ�����","���Ա�γ30�㣬ȫ�곬����ǧСʱ���գ����������ʹ�ù�ʵ������",1,6.50,"��","���п�θ��ʳ��������Ŀ����ѹ��֬�Ĺ�Ч","rmx1.jpg"));
		map.put("dz", new Fruit("dz","ɽ��մ������","Ƥ����ࡢ�������㡢Ӫ���ḻ������Ϊ���ٹ�����",3,12.00,"��","������ǿ��������������θ����������ƽⶾ���εĹ�Ч","rmx2.jpg"));
		map.put("xj", new Fruit("xj","���������㽶","��������ã���ҹ�²�ϴ��������Ʒ�ʺ�",1,8.50,"��","������θ������ͨѪ������ƶ��Ĺ�Ч","rmx3.jpg"));
		map.put("pt", new Fruit("pt","��������������","�����޹�������,ζ����֭,����ɿ�",1,9.50,"��","����������ʳ������ƣ�͡���Ѫ�����Ĺ�Ч","rmx4.jpg"));
		map.put("xhl", new Fruit("xhl","�ӱ�ѩ����","�ӱ��ز����ʻʹ��棬���۶�֭���ڸ���࣬Ƥ��ˬ��",2,5.00,"��","���������򾲡����ֹ�ȡ���ͨ��Ĺ�Ч","xpd1.jpg"));
		map.put("mg", new Fruit("mg","���Ϻ���ľ��","���ϱ��Ǻ���ľ�ϣ������ȴ��ز�������ϸ�壬���ۿɿ�",2,10.50,"��","���н�Ƣ��ʳ������Ӫ��������ɱ��Ĺ�Ч","xpd2.jpg"));
		map.put("clz", new Fruit("clz","����ӣ��/������","������������������ӣ�ң�����֭��Ӫ���ḻ",2,90.00,"��","��������ʪ��ͨ��ֹʹ�Ĺ�Ч","xpd3.jpg"));
		map.put("bxg", new Fruit("bxg","������̬�����","�����ƽ�����������������ˬ�ڣ������֭",2,12.00,"��","�����������ʡ���ͨ�㡢�Ŷ����յĹ�Ч","xpx1.jpg"));
		map.put("ht", new Fruit("ht","���Ͼ�ѡ������","�������ʺ�����������ˮ������",1,15.00,"��","���в���Ѫ������Һ����Ƣ��θ���������׵Ĺ�Ч","xpx2.jpg"));
		map.put("nm", new Fruit("nm","�Ĵ�����������","��ˬ�ɿ� �ļ�DIY���ϱر�",3,14.80,"��","��������ֹ�ʡ���θ�������������Ĺ�Ч","xpx3.jpg"));
		map.put("hfs", new Fruit("hfs","��̨�츻ʿƻ��","����ɽ����̨�츻ʿƻ��ԭ��̬,ϴϴ��Ƥ��",2,6.00,"��","���в�����Ѫ�������ߡ�Ԥ����������Ⱦ�Ĺ�Ч","xpx4.jpg"));
	}
	public static Map<String, Fruit> getAll(){
		return map;
	}
}