package commercial.trading.depo;

import java.util.List;

public class ProductFactory {

	public static Depo getProduct(String depo) {

		if (depo.equals("DepoA")) {

			return DepoASingleton.getInstance();
		}
		else if (depo.equals("DepoB")) {

			return DepoBSingleton.getInstance();
		}
		else if (depo.equals("DepoC")) {

			return DepoCSingleton.getInstance();
		}

		return null;
	}

}
