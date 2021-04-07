package javaH3;

public class User {
	
	float money;
	int worker, drill, site;
	float gold, diamond, emerald, sapphire, ruby;
	
	public User(float money, int worker, int drill, int site, float gold, float diamond, float emerald, float sapphire,
			float ruby) {
		super();
		this.money = money;
		this.worker = worker;
		this.drill = drill;
		this.site = site;
		this.gold = gold;
		this.diamond = diamond;
		this.emerald = emerald;
		this.sapphire = sapphire;
		this.ruby = ruby;
	}
	
	protected float getMoney() {
		return money;
	}
	protected void setMoney(float money) {
		this.money = money;
	}
	protected int getWorker() {
		return worker;
	}
	protected void setWorker(int worker) {
		this.worker = worker;
	}
	protected int getDrill() {
		return drill;
	}
	protected void setDrill(int drill) {
		this.drill = drill;
	}
	protected int getSite() {
		return site;
	}
	protected void setSite(int site) {
		this.site = site;
	}
	protected float getGold() {
		return gold;
	}
	protected void setGold(float gold) {
		this.gold = gold;
	}
	protected float getDiamond() {
		return diamond;
	}
	protected void setDiamond(float diamond) {
		this.diamond = diamond;
	}
	protected float getEmerald() {
		return emerald;
	}
	protected void setEmerald(float emerald) {
		this.emerald = emerald;
	}
	protected float getSapphire() {
		return sapphire;
	}
	protected void setSapphire(float sapphire) {
		this.sapphire = sapphire;
	}
	protected float getRuby() {
		return ruby;
	}
	protected void setRuby(float ruby) {
		this.ruby = ruby;
	}
	

}
