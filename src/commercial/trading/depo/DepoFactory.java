package commercial.trading.depo;

import java.util.List;

/**
 * @author mrosa
 * */
public class DepoFactory {

	/**
	 * @method getProducts
	 * @params String depo
	 * method from Factory Design pattern to create the specific Depos
	 * */
	public static Depo getProduct(String depo) {

		// Logic necessary to check and create the desired Depot
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
