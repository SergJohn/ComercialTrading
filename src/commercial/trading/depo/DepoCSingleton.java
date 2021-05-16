package commercial.trading.depo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import commercial.trading.depo.Product.getProduct;

public class DepoCSingleton extends Depo {

	private int quantNative;
	private int quantExternal1;
	private int quantExternal2;
	
	private static DepoCSingleton instance = null;

	private DepoCSingleton() {

	}

	public DepoCSingleton(getProduct product, getProduct producta, getProduct productb) {

		Random random = new Random();
		quantNative = random.nextInt(maxNative - minNative) + minNative;
//		System.out.println(randomNum);
		for (int i = 0; i < quantNative; i++) {
			ProductNative.add(product);
		}

		// Filling the externalProducts at the start
		quantExternal1 = random.nextInt(maxExternal1 - minExternal1) + minExternal1;
//		System.out.println(quantExternal1);
		for (int i = 0; i < quantExternal1; i++) {

			ProductExternal1.add(producta);
		}

		// Filling the externalProducts2 at the start
		quantExternal2 = random.nextInt(maxExternal2 - minExternal2) + minExternal2;
//		System.out.println(quantExternal1);
		for (int i = 0; i < quantExternal2; i++) {

			ProductExternal2.add(productb);
		}
		
		priceDelivery = random.nextInt(maxPrice - minPrice) + minPrice;
		price = random.nextInt(maxPrice - minPrice) + minPrice;
		price = price + priceDelivery;
		budget = random.nextInt(maxBudget - minBudget) + minBudget;
	}

	@Override
	public String toString() {
		return "DepoC";

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
	
	public static DepoCSingleton getInstance() {

        if (instance == null) {
            instance = new DepoCSingleton(Product.getProduct.PRODUCTC, Product.getProduct.PRODUCTA, Product.getProduct.PRODUCTB);
        }
        return instance;
    }
}
