package commercial.trading.depo;

import java.util.List;

import commercial.trading.company.Company;
import commercial.trading.company.CompanyASingleton;
import commercial.trading.company.CompanyBSingleton;
import commercial.trading.company.CompanyCSingleton;
import commercial.trading.depo.Product.getProduct;

public class TradingFacade {

	public static enum DepoType {

		DEPOA, DEPOB, DEPOC;

	}

	DepoType depoA = DepoType.DEPOA;
	DepoType depoB = DepoType.DEPOB;
	DepoType depoC = DepoType.DEPOC;

	public TradingFacade() {
	}

	public void generateTrading(DepoType depo) {

		switch (depo) {
		case DEPOA:

			makeTrading(depo, depoB, depoC);

			break;

		case DEPOB:

			makeTrading(depo, depoA, depoC);

			break;

		case DEPOC:

			makeTrading(depo, depoA, depoB);

			break;

		}

	}

	private void makeTrading(DepoType depo, DepoType depo2, DepoType depo3) {

		if (depo.toString().equalsIgnoreCase("DepoA")) {

			System.out.println("It is equal, both are A");

			Depo depoClass = DepoASingleton.getInstance();
			Company comp = CompanyASingleton.getInstance();
			
			Depo depoClass2 = DepoBSingleton.getInstance();
			Company comp2 = CompanyBSingleton.getInstance();
			
			Depo depoClass3 = DepoCSingleton.getInstance();
			Company comp3 = CompanyCSingleton.getInstance();
			
			trading(depoClass, comp, depoClass2, comp2,  depoClass3, comp3);
		}

		if (depo.toString().equalsIgnoreCase("DepoB")) {

			System.out.println("It is equal, both are B");

			Depo depoClass = DepoBSingleton.getInstance();
			Company comp = CompanyBSingleton.getInstance();
			
			Depo depoClass2 = DepoASingleton.getInstance();
			Company comp2 = CompanyASingleton.getInstance();
			
			Depo depoClass3 = DepoCSingleton.getInstance();
			Company comp3 = CompanyCSingleton.getInstance();
			
			trading(depoClass, comp, depoClass2, comp2,  depoClass3, comp3);
		}

		if (depo.toString().equalsIgnoreCase("DepoC")) {

			System.out.println("It is equal, both are C");

			Depo depoClass = DepoCSingleton.getInstance();
			Company comp = CompanyCSingleton.getInstance();
			
			Depo depoClass2 = DepoASingleton.getInstance();
			Company comp2 = CompanyASingleton.getInstance();
			
			Depo depoClass3 = DepoBSingleton.getInstance();
			Company comp3 = CompanyBSingleton.getInstance();
			
			trading(depoClass, comp, depoClass2, comp2,  depoClass3, comp3);
		}

	}

	private void trading(Depo depoClass, Company comp, Depo depoClass2, Company comp2, Depo depoClass3, Company comp3) {

		// Buy and sell actually goes here no matter which company

		// Check if any productNative of the other two companies are available
		if ((depoClass2.getProductNative().size() > 3 || depoClass3.getProductNative().size() > 3)
				&& (depoClass.getProductExternal1().size() < 40 || depoClass.getProductExternal2().size() < 40)) {

			// How much for the product? do we have budget?
			if (comp.getBudget() > depoClass2.getPrice()) {

				// Add product external1 from productNative of the other companies
				depoClass.getProductExternal1().add(depoClass2.getProductNative().get(0));

				// Subtract from native of the other companies
				depoClass2.getProductNative().remove(0);

				// Deduct from the company budget
				comp.setBudget(comp.getBudget() - depoClass2.getPrice());
				
				// Send money to the other two companie's budget
				comp2.setBudget(comp2.getBudget() + depoClass2.getPrice());

			}

			if (comp.getBudget() > depoClass3.getPrice()) {
				
				// Add product external2 from productNative of the other companies
				depoClass.getProductExternal2().add(depoClass3.getProductNative().get(0));
				
				// Subtract from native of the other companies
				depoClass3.getProductNative().remove(0);

				// Deduct from the company budget
				comp.setBudget(comp.getBudget() - depoClass3.getPrice());

				// Send money to the other two companie's budget
				comp3.setBudget(comp3.getBudget() + depoClass3.getPrice());
			}

		} else {
			System.out.println("Trades no longer available");
		}

	}
}
