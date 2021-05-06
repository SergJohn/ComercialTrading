package commercial.trading.depo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import commercial.trading.company.CompanyASingleton;
import commercial.trading.depo.Product.getProduct;

public class DepoASingleton extends Depo {

	private int quantNative;
	private int quantExternal1;
	private int quantExternal2;
	
	
	private static DepoASingleton instance = null;

	private DepoASingleton() {

	}

	private DepoASingleton(getProduct producta, getProduct productb, getProduct productc) {
		// Filling the Native products on the start
		Random random = new Random();
		quantNative = random.nextInt(maxNative - minNative) + minNative;
//		System.out.println(quantNative + "Random number");
		for (int i = 0; i < quantNative; i++) {

			ProductNative.add(producta);
		}

		// Filling the externalProducts at the start
		quantExternal1 = random.nextInt(maxExternal1 - minExternal1) + minExternal1;
//		System.out.println(quantExternal1);
		for (int i = 0; i < quantExternal1; i++) {

			ProductExternal1.add(productb);
		}

		// Filling the externalProducts2 at the start
		quantExternal2 = random.nextInt(maxExternal2 - minExternal2) + minExternal2;
//		System.out.println(quantExternal1);
		for (int i = 0; i < quantExternal2; i++) {

			ProductExternal2.add(productc);
		}
		
		price = random.nextInt(maxPrice - minPrice) + minPrice;

	}

	@Override
	public String toString() {
		return ProductNative + " " + ProductExternal1 + " " + ProductExternal2 + "\n\n\n\n";

	}
	
	public static DepoASingleton getInstance() {

        if (instance == null) {
            instance = new DepoASingleton(Product.getProduct.PRODUCTA, Product.getProduct.PRODUCTB, Product.getProduct.PRODUCTC);
        }
        return instance;
    }

}