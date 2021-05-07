package commercial.trading.depo;

import java.util.List;

public class ProductFactory {

	public static Depo getProduct(String depo) {

		if (depo.equals("DepoA")) {

			return new DepoASingleton(Product.getProduct.PRODUCTA, Product.getProduct.PRODUCTB, Product.getProduct.PRODUCTC);
		}
		else if (depo.equals("DepoB")) {

			return new DepoBSingleton(Product.getProduct.PRODUCTB, Product.getProduct.PRODUCTA, Product.getProduct.PRODUCTC);
		}
		else if (depo.equals("DepoC")) {

			return new DepoCSingleton(Product.getProduct.PRODUCTC, Product.getProduct.PRODUCTA, Product.getProduct.PRODUCTB);
		}

		return null;
	}

}
