package cn.fruit.domain;

import java.io.Serializable;

/**
 * 水果基本信息类
 * @author zzshang
 *
 */
public class Fruit implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;	//标识
	private String name;	//名字
	private String description;		//描述
	private int day;	//上架天数
	private double delprice;	//要删除的价格
	private double price;	//正式价格
	private double discount; //折扣数
	private String unit; //计算单位
	private String tip;	//功效提示（在详情界面）
	private String pictureUrla;	//图片地址前半部分(固定)
	private String pictureUrlb; //图片地址后半部分(即图片名字)
	private String pictureUrl; //图片地址
	private int amount; //购买数量
	private double totalPrice; //价格x数量
	
	{
		pictureUrla = "${pageContext.request.contextPath }/img/";
		amount = 1;
	}
	public Fruit(String id, String name, String description, int day, double delprice,
					String unit, String tip, String pictureUrlb) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.day = day;
		this.delprice = delprice;
		this.unit = unit;
		this.tip = tip;
		this.pictureUrlb = pictureUrlb;
		jsdiscount();
		jsprice();
		jssumprice();
		hbUrl();
	}
	public Fruit() {
		super();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public double getDelprice() {
		return delprice;
	}
	public void setDelprice(double delprice) {
		this.delprice = delprice;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public String getPictureUrla() {
		return pictureUrla;
	}
	public void setPictureUrla(String pictureUrla) {
		this.pictureUrla = pictureUrla;
	}
	public String getPictureUrlb() {
		return pictureUrlb;
	}
	public void setPictureUrlb(String pictureUrlb) {
		this.pictureUrlb = pictureUrlb;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getPictureUrl() {
		return pictureUrl;
	}
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	//计算上架天数后折扣
	private void jsdiscount(){
		int day = this.day;
		switch(day){
			case 1:
				discount = 9.5;
				break;
			case 2:
				discount = 9;
				break;
			case 3:
				discount = 8.5;
		}
	}
	//计算折扣后价格
	public void jsprice(){
		price = delprice * discount * 0.1;
		price = (double) Math.round(price * 100) / 100;	//只取后两位 
	}
	//计算购买数量后价格
	public void jssumprice(){
		totalPrice = price * amount;
		totalPrice = (double) Math.round(totalPrice * 100) / 100;
	}
	//合并地址
	private void hbUrl(){
		this.pictureUrl = this.pictureUrla + this.pictureUrlb;
	}
	
	@Override
	public String toString() {
		return "Fruit [id=" + id + ", name=" + name + ", description="
				+ description + ", day=" + day + ", delprice=" + delprice
				+ ", price=" + price + ", discount=" + discount + ", unit="
				+ unit + ", tip=" + tip + ", pictureUrla=" + pictureUrla
				+ ", pictureUrlb=" + pictureUrlb + ", pictureUrl=" + pictureUrl
				+ ", amount=" + amount + ", totalPrice=" + totalPrice + "]";
	}
	
}
