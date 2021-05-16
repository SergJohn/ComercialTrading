package commercial.trading.depo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Stack;

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

	BufferedWriter writeA;
	BufferedWriter writeB;
	BufferedWriter writeC;
	
	List<String> A = new ArrayList<>();

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

//			System.out.println("It is equal, both are A");

			
			Depo depoClass = DepoASingleton.getInstance();
			Company comp1 = CompanyASingleton.getInstance();

			Depo depoClass2 = DepoBSingleton.getInstance();
			Company comp2 = CompanyBSingleton.getInstance();

			Depo depoClass3 = DepoCSingleton.getInstance();
			Company comp3 = CompanyCSingleton.getInstance();

			trading(depoClass, comp1, depoClass2, comp2, depoClass3, comp3);

		}

		if (depo.toString().equalsIgnoreCase("DepoB")) {

//			System.out.println("It is equal, both are B");

			Depo depoClass = DepoBSingleton.getInstance();
			Company comp1 = CompanyBSingleton.getInstance();

			Depo depoClass2 = DepoASingleton.getInstance();
			Company comp2 = CompanyASingleton.getInstance();

			Depo depoClass3 = DepoCSingleton.getInstance();
			Company comp3 = CompanyCSingleton.getInstance();

			trading(depoClass, comp1, depoClass2, comp2, depoClass3, comp3);

		}

		if (depo.toString().equalsIgnoreCase("DepoC")) {

//			System.out.println("It is equal, both are C");

			Depo depoClass = DepoCSingleton.getInstance();
			Company comp1 = CompanyCSingleton.getInstance();

			Depo depoClass2 = DepoASingleton.getInstance();
			Company comp2 = CompanyASingleton.getInstance();

			Depo depoClass3 = DepoBSingleton.getInstance();
			Company comp3 = CompanyBSingleton.getInstance();

			trading(depoClass, comp1, depoClass2, comp2, depoClass3, comp3);

		}

	}

	private void trading(Depo depoClass, Company comp1, Depo depoClass2, Company comp2, Depo depoClass3, Company comp3) {

//		System.out.println("inside trading");

		// Buy and sell actually goes here no matter which company

		List<Depo> listIntern = new ArrayList<>();
		listIntern.addAll(comp1.getDepos());

		List<Depo> listIntern2 = new ArrayList<>();
		listIntern2.addAll(comp2.getDepos());

		List<Depo> listIntern3 = new ArrayList<>();
		listIntern3.addAll(comp3.getDepos());
		
			for (int i = 0; i < listIntern.size(); i++) {
//				System.out.println("inside 1st for");
				for (int j = 0; j < i; j++) {
//					System.out.println("inside 2nd for");
					for (int k = 0; k < j; k++) {
//						System.out.println("inside 3nd for");
//						 Check if any productNative of the other two companies are available
						if ((listIntern2.get(i).getProductNative().size() > 3
								|| listIntern3.get(i).getProductNative().size() > 3)
								&& (listIntern.get(i).getProductExternal1().size() <= 40
										|| listIntern.get(i).getProductExternal2().size() <= 40)) {

//							System.out.println("inside first if");
							if (listIntern.get(i).getProductExternal1().size() > 40
									|| listIntern.get(i).getProductExternal2().size() > 40) {
								System.out.println("Transactions finished, you will be redirected to a menu shortly");

							} else {
//								System.out.println("inside else");
								// How much for the product? do we have budget?
								if (depoClass.getBudget() > depoClass2.getPrice()) {

//									System.out.println("Inside first if else");
//									System.out.println(listIntern.get(i));
	//
//									System.out.println(depoClass.getBudget());
//									System.out.println(listIntern2.get(j).getProductNative().size());

									// Add product external1 from productNative of the other companies
									listIntern.get(i).getProductExternal1()
											.add(listIntern2.get(i).getProductNative().get(0));

									// Subtract from native of the other companies
									listIntern2.get(i).getProductNative().remove(0);

//									System.out.println(listIntern2.get(j).getProductNative().size());

									// Deduct from the company budget
									depoClass.setBudget(depoClass.getBudget() - depoClass2.getPrice());

//									System.out.println(depoClass.getBudget());

									// Send money to the other two companie's budget
									depoClass2.setBudget(depoClass2.getBudget() + depoClass2.getPrice());

//									System.out.println(depoClass.getBudget());
//									if(depoClass.getProductNative().get(i).equals(getProduct.PRODUCTA)) {
//										
//									}
									writeFile(comp1, depoClass2);
									A.add("Product " + depoClass2 + " bought for " + comp1 + " on " + new Date() + "\n");
//									System.out.println(A);

								}

								if (depoClass.getBudget() >= depoClass3.getPrice()) {

//									System.out.println("Inside second if");
//									System.out.println(listIntern.get(i));

//									System.out.println(listIntern.get(i).getProductExternal2().size());

									// Add product external2 from productNative of the other companies
									listIntern.get(i).getProductExternal2()
											.add(listIntern3.get(i).getProductNative().get(0));
//									System.out.println("LOOK AT HERE: " + listIntern3.get(k).getProductNative().size());

//									System.out.println(listIntern.get(i).getProductExternal2().size());

									// Subtract from native of the other companies
									listIntern3.get(i).getProductNative().remove(0);

									// Deduct from the company budget
									depoClass.setBudget(depoClass.getBudget() - depoClass3.getPrice());

//									System.out.println(depoClass.getBudget());

									// Send money to the other two companie's budget
									depoClass3.setBudget(depoClass3.getBudget() + depoClass3.getPrice());
									
									writeFile(comp1, depoClass3);

								}
							}

						} else {
							System.out.println("Trades no longer available");
						}
					}
				}

			}

	}

	private void writeFile(Company comp1, Depo depoClass) {
		
		if(comp1.toString().equals("Company A")) {
			try {
				writeA = new BufferedWriter(new FileWriter("TradingsA.txt", true));
				
//				System.out.println("Writing in a file");
				writeA.write("ProductExternal from " + depoClass + " was bought for " + comp1 + " on " + new Date() + "\n");
				writeA.close();
//				A.add("Product " + depoClass + " bought for " + comp1 + " on " + new Date() + "\n");
//				System.out.println(A);
				
			} catch (Exception e) {

			}
		} else if(comp1.toString().equals("Company B")) {
			
			try {
				writeB = new BufferedWriter(new FileWriter("TradingsB.txt", true));
				
//				System.out.println("Writing in a file");
				writeB.write("ProductExternal from " + depoClass + " was bought for " + comp1 + " on " + new Date() + "\n");
				writeB.close();
				
			} catch (Exception e) {

			}
			
			
		} else if(comp1.toString().equals("Company C")) {
			
			try {
				writeC = new BufferedWriter(new FileWriter("TradingsC.txt", true));
				
//				System.out.println("Writing in a file");
				writeC.write("ProductExternal from " + depoClass + " was bought for " + comp1 + " on " + new Date() + "\n");
				writeC.close();
			} catch (Exception e) {

			}
			
		}
		
		
	}

	public void menuMethod() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String choice = "";
		String innerChoice = "";

		do {

			System.out.println("MENU");
			System.out.println("--------------------");
			System.out.println("");
			System.out.println("1 - See all transactions");
			System.out.println("2 - See all transactions from a specific Company");
			System.out.println("3 - QUIT");
			System.out.println("");
			try {
				choice = reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(choice);

			switch (choice) {
			case "1":
				showTrades();
				break;

			case "2":
				do {

					System.out.println("Choose the Company:");
					System.out.println("-------------------");
					System.out.println("1 - Company A ?");
					System.out.println("2 - Company B ?");
					System.out.println("3 - Company C ?");
					System.out.println("4 - Back to main menu ?");
					System.out.println("5 - Quit program ?");
					System.out.println("Insert your choice below:");
					try {
						innerChoice = reader.readLine();
					} catch (IOException e) {
						e.printStackTrace();
					}
					System.out.println(innerChoice);

					switch (innerChoice) {
					case "1":
						
						break;

					case "2":

						break;

					case "3":

						break;

					case "4":
						menuMethod();
						break;

					case "5":
						System.out.println("Quitting program");
						System.exit(0);
						break;
					}

				} while (!choice.equals("1") || !choice.equals("2") || !choice.equals("3") || !choice.equals("4")
						|| !choice.equals("5"));

				break;

			case "3":

				System.out.println("Quitting program");
				System.exit(0);
				break;

			}

		} while (!choice.equals("1") || !choice.equals("2") || !choice.equals("3"));

	}

	private void showTrades() {
		
		System.out.println(A);
		
	}

}
