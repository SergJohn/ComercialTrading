package commercial.trading.depo;

import java.util.List;

public class ProductFactory {

	public static Depo getProduct(String depo) {

		if (depo.equals("DepoA")) {

			return new DepoASingleton(Product.getProduct.PAPER, Product.getProduct.BOOK, Product.getProduct.INK);
		}
		else if (depo.equals("DepoB")) {

			return new DepoBSingleton(Product.getProduct.BOOK, Product.getProduct.PAPER, Product.getProduct.INK);
		}
		else if (depo.equals("DepoC")) {

			return new DepoCSingleton(Product.getProduct.INK, Product.getProduct.PAPER, Product.getProduct.BOOK);
		}

		return null;
	}

}
