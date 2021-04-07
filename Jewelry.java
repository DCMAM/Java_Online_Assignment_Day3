package javaH3;

import java.util.ArrayList;

public class Jewelry {
	
	static ArrayList<Jewelry> list = new ArrayList<Jewelry>();
	
	String name;
	float price;
	
	public Jewelry(String name, float price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	protected String getName() {
		return name;
	}
	protected void setName(String name) {
		this.name = name;
	}
	protected float getPrice() {
		return price;
	}
	protected void setPrice(float price) {
		this.price = price;
	}
}
