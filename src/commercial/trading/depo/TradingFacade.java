package commercial.trading.depo;

import java.util.ArrayList;
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
			Company comp1 = CompanyASingleton.getInstance();

			Depo depoClass2 = DepoBSingleton.getInstance();
			Company comp2 = CompanyBSingleton.getInstance();

			Depo depoClass3 = DepoCSingleton.getInstance();
			Company comp3 = CompanyCSingleton.getInstance();

			trading(depoClass, comp1, depoClass2, comp2, depoClass3, comp3);

		}

		if (depo.toString().equalsIgnoreCase("DepoB")) {

			System.out.println("It is equal, both are B");

			Depo depoClass = DepoBSingleton.getInstance();
			Company comp1 = CompanyBSingleton.getInstance();

			Depo depoClass2 = DepoASingleton.getInstance();
			Company comp2 = CompanyASingleton.getInstance();

			Depo depoClass3 = DepoCSingleton.getInstance();
			Company comp3 = CompanyCSingleton.getInstance();

			trading(depoClass, comp1, depoClass2, comp2, depoClass3, comp3);

		}

		if (depo.toString().equalsIgnoreCase("DepoC")) {

			System.out.println("It is equal, both are C");

			Depo depoClass = DepoCSingleton.getInstance();
			Company comp1 = CompanyCSingleton.getInstance();

			Depo depoClass2 = DepoASingleton.getInstance();
			Company comp2 = CompanyASingleton.getInstance();

			Depo depoClass3 = DepoBSingleton.getInstance();
			Company comp3 = CompanyBSingleton.getInstance();
			
			trading(depoClass, comp1, depoClass2, comp2, depoClass3, comp3);

		}

	}

	private void trading(Depo depoClass, Company comp1, Depo depoClass2, Company comp2, Depo depoClass3,
			Company comp3) {

		System.out.println("inside trading");

		// Buy and sell actually goes here no matter which company

		List<Depo> listIntern = new ArrayList<>();
		listIntern.addAll(comp1.getDepos());

		List<Depo> listIntern2 = new ArrayList<>();
		listIntern2.addAll(comp2.getDepos());

		List<Depo> listIntern3 = new ArrayList<>();
		listIntern3.addAll(comp3.getDepos());

		for (int i = 0; i < listIntern.size(); i++) {
//			System.out.println("inside 1st for");
			for (int j = 0; j < i; j++) {
//				System.out.println("inside 2nd for");
				for (int k = 0; k < j; k++) {
//					System.out.println("inside 3nd for");
//					 Check if any productNative of the other two companies are available
					if ((listIntern2.get(j).getProductNative().size() > 3
							|| listIntern3.get(k).getProductNative().size() > 3)
							&& (listIntern.get(i).getProductExternal1().size() <= 40
									|| listIntern.get(i).getProductExternal2().size() <= 40)) {

//						System.out.println("inside first if");
						if (listIntern.get(i).getProductExternal1().size() > 40
								|| listIntern.get(i).getProductExternal2().size() > 40) {
							System.out.println("Transactions finished, you will be redirected to a menu shortly");
							test();
						} else {
//							System.out.println("inside else");
							// How much for the product? do we have budget?
							if (depoClass.getBudget() > depoClass2.getPrice()) {

								System.out.println("Inside first if else");
								System.out.println(listIntern.get(i));

								System.out.println(depoClass.getBudget());
								System.out.println(listIntern2.get(j).getProductNative().size());

								// Add product external1 from productNative of the other companies
								listIntern.get(i).getProductExternal1()
										.add(listIntern2.get(j).getProductNative().get(0));

								// Subtract from native of the other companies
								listIntern2.get(j).getProductNative().remove(0);

								System.out.println(listIntern2.get(j).getProductNative().size());

								// Deduct from the company budget
								depoClass.setBudget(depoClass.getBudget() - listIntern2.get(j).getPrice());

								System.out.println(depoClass.getBudget());

								// Send money to the other two companie's budget
								depoClass2.setBudget(depoClass2.getBudget() + listIntern2.get(j).getPrice());

								System.out.println(depoClass.getBudget());

							}

							if (depoClass.getBudget() >= depoClass3.getPrice()) {

								System.out.println("Inside second if");
								System.out.println(listIntern.get(i));

								System.out.println(listIntern.get(i).getProductExternal2().size());

								// Add product external2 from productNative of the other companies
								listIntern.get(i).getProductExternal2()
										.add(listIntern3.get(k).getProductNative().get(0));
								System.out.println("LOOK AT HERE: " + listIntern3.get(k).getProductNative().size());

//								System.out.println(listIntern.get(i).getProductExternal2().size());

								// Subtract from native of the other companies
								listIntern3.get(k).getProductNative().remove(0);

								// Deduct from the company budget
								depoClass.setBudget(depoClass.getBudget() - listIntern3.get(k).getPrice());

								System.out.println(depoClass.getBudget());

								// Send money to the other two companie's budget
								depoClass3.setBudget(depoClass3.getBudget() + listIntern3.get(k).getPrice());

							}
						}

					} else {
						System.out.println("Trades no longer available");
//						test();
					}
//					test();
				}
			}

		}
		test();

	}

	private void test() {
		// TODO Auto-generated method stub
		System.out.println("MENU");

	}
}
