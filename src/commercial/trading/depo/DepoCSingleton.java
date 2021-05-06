package commercial.trading.depo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import commercial.trading.depo.Product.getProduct;

public class DepoCSingleton extends Depo {

	private int quantExternal1;
	private int quantExternal2;
	
	private static DepoCSingleton instance = null;

	private DepoCSingleton() {

	}

	private DepoCSingleton(getProduct product, getProduct producta, getProduct productb) {

		minExternal1 = 33;
		Random random = new Random();
		randomNum = random.nextInt(maxNative - minNative) + minNative;
//		System.out.println(randomNum);
		for (int i = 0; i < randomNum; i++) {
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
	}

	@Override
	public String toString() {
		return ProductNative + " " + ProductExternal1 + " " + ProductExternal2;

	}
	
	public static DepoCSingleton getInstance() {

        if (instance == null) {
            instance = new DepoCSingleton(Product.getProduct.PRODUCTC, Product.getProduct.PRODUCTA, Product.getProduct.PRODUCTB);
        }
        return instance;
    }
}
