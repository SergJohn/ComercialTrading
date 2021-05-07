package commercial.trading.depo;

import java.util.ArrayList;
import java.util.List;

import commercial.trading.depo.Product.getProduct;

public abstract class Depo {
	
	protected double budget;
	protected int minBudget;
	protected int maxBudget;
	protected double price;
	protected int maxPrice;
	protected int minPrice;
	protected double priceDelivery;
	protected int randomNum;
	protected int minNative;
	protected int maxNative;
	protected int minExternal1;
	protected int maxExternal1;
	protected int minExternal2;
	protected int maxExternal2;

	protected List<getProduct> ProductNative = new ArrayList<>();
	protected List<getProduct> ProductExternal1 = new ArrayList<>();
	protected List<getProduct> ProductExternal2 = new ArrayList<>();

	public Depo() {
		

		minBudget = 50;
		maxBudget = 100;
		minNative = 15;
		maxNative = 50;
		maxExternal1= 40;
		minExternal1 = 3;
		minExternal2 = 3;
		maxExternal2 = 40;
		maxPrice = 10;
		minPrice = 1;
	}
	


	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public int getMinBudget() {
		return minBudget;
	}

	public void setMinBudget(int minBudget) {
		this.minBudget = minBudget;
	}

	public int getMaxBudget() {
		return maxBudget;
	}

	public void setMaxBudget(int maxBudget) {
		this.maxBudget = maxBudget;
	}
	
	public int getRandomNum() {
		return randomNum;
	}

	public void setRandomNum(int randomNum) {
		this.randomNum = randomNum;
	}

	public int getMinNative() {
		return minNative;
	}

	public void setMinNative(int minNative) {
		this.minNative = minNative;
	}

	public int getMaxNative() {
		return maxNative;
	}

	public void setMaxNative(int maxNative) {
		this.maxNative = maxNative;
	}

	public int getMinExternal1() {
		return minExternal1;
	}

	public void setMinExternal1(int minExternal1) {
		this.minExternal1 = minExternal1;
	}

	public int getMaxExternal1() {
		return maxExternal1;
	}

	public void setMaxExternal1(int maxExternal1) {
		this.maxExternal1 = maxExternal1;
	}

	public int getMinExternal2() {
		return minExternal2;
	}

	public void setMinExternal2(int minExternal2) {
		this.minExternal2 = minExternal2;
	}
	
	public List<getProduct> getProductNative() {
		return ProductNative;
	}

	public void setProductNative(List<getProduct> productNative) {
		ProductNative = productNative;
	}

	public List<getProduct> getProductExternal1() {
		return ProductExternal1;
	}

	public void setProductExternal1(List<getProduct> productExternal1) {
		ProductExternal1 = productExternal1;
	}

	public List<getProduct> getProductExternal2() {
		return ProductExternal2;
	}

	public void setProductExternal2(List<getProduct> productExternal2) {
		ProductExternal2 = productExternal2;
	}
	

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(int maxPrice) {
		this.maxPrice = maxPrice;
	}

	public int getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(int minPrice) {
		this.minPrice = minPrice;
	}

	public int getMaxExternal2() {
		return maxExternal2;
	}

	public void setMaxExternal2(int maxExternal2) {
		this.maxExternal2 = maxExternal2;
	}
	
	public double getPriceDelivery() {
		return priceDelivery;
	}

	public void setPriceDelivery(double priceDelivery) {
		this.priceDelivery = priceDelivery;
	}
		
}
