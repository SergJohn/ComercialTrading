package commercial.trading.depo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import commercial.trading.depo.Product.getProduct;

/**
 * @author mrosa
 * */
public class DepoBSingleton extends Depo {

	// Specific variables not in the Abstract Class
	private int quantNative;
	private int quantExternal1;
	private int quantExternal2;
	
	// Instance of the class declared as NULL
	private static DepoBSingleton instance = null;

	/**
	 * Private Constructor of the Singleton Class
	 * */ 
	private DepoBSingleton() {
		System.out.println("inside empty constructor");
	}

	/**
	 * DepoBSingleton()
	 * @params getProduct p1, getProduct p2, getProduct p3
	 * Constructor Overloading - a Public Constructor with the products necessaries as params
	 * */  
	public DepoBSingleton(getProduct product, getProduct producta, getProduct productc) {

		Random random = new Random();
		quantNative = random.nextInt(maxNative - minNative) + minNative;
		for (int i = 0; i < quantNative; i++) {
			ProductNative.add(product);
		}

		// Filling the externalProducts at the start
		quantExternal1 = random.nextInt(maxExternal1 - minExternal1) + minExternal1;
		for (int i = 0; i < quantExternal1; i++) {

			ProductExternal1.add(producta);
		}

		// Filling the externalProducts2 at the start
		quantExternal2 = random.nextInt(maxExternal2 - minExternal2) + minExternal2;
		for (int i = 0; i < quantExternal2; i++) {

			ProductExternal2.add(productc);
		}

		// Defining the values of the price, delivery and budget
		priceDelivery = random.nextInt(maxPrice - minPrice) + minPrice;
		price = random.nextInt(maxPrice - minPrice) + minPrice;
		price = price + priceDelivery;
		budget = random.nextInt(maxBudget - minBudget) + minBudget;
	}

	@Override
	public String toString() {
		return "DepoB";

	}
	
	// Getters and Setters
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
	
	/**
	 * @method getInstance
	 * @return instance:DepoBSingleton
	 * Checking if the instance exists and retrieving it or if it not creating a new one
	 * */
	public static DepoBSingleton getInstance() {

        if (instance == null) {
            instance = new DepoBSingleton(Product.getProduct.BOOK, Product.getProduct.PAPER, Product.getProduct.INK);
        }
        return instance;
    }
}
