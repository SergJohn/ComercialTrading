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

/**
 * @author mrosa
 * */
public class TradingFacade {

	// ENUMS to be checked on the generateTrading method
	public static enum DepoType {

		DEPOA, DEPOB, DEPOC;

	}
	
	// Variables to hold the ENUM and make easier and cleaner the code
	DepoType depoA = DepoType.DEPOA;
	DepoType depoB = DepoType.DEPOB;
	DepoType depoC = DepoType.DEPOC;

	// BufferedWriters to write to the file after program runs
	BufferedWriter writeA;
	BufferedWriter writeB;
	BufferedWriter writeC;

	// Important Lists to hold the values to be displayed on the console later on
	static List<String> A = new ArrayList<>();
	static List<String> aBudget = new ArrayList<>();
	static List<String> bBudget = new ArrayList<>();
	static List<String> cBudget = new ArrayList<>();
	static List<String> Data = new ArrayList<>();

	/**
	 * Constructor
	 * */ 
	public TradingFacade() {
	}

	// Method created to make the facade work, receiving the type and using a switch to manage the logic
	/**
	 * @method generateTrading
	 * @params Depotype depo
	 * Method which receives a depo and forward the depo to the method 
	 * */
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

	// On this method we will fill the variable of the abstract type with the instance of the referred classes 
	/**
	 * @method makeTrading()
	 * @params DepoType depo, DepoType depo2, DepoType depo3
	 * Method to get the necessary instances to proceed with the trading.
	 * */
	private void makeTrading(DepoType depo, DepoType depo2, DepoType depo3) {

		if (depo.toString().equalsIgnoreCase("DepoA")) {

			Depo depoClass = DepoASingleton.getInstance();
			Company comp1 = CompanyASingleton.getInstance();

			Depo depoClass2 = DepoBSingleton.getInstance();
			Company comp2 = CompanyBSingleton.getInstance();

			Depo depoClass3 = DepoCSingleton.getInstance();
			Company comp3 = CompanyCSingleton.getInstance();
			
			// After getting the specific instances, calling the trading method
			trading(depoClass, comp1, depoClass2, comp2, depoClass3, comp3);

		}

		if (depo.toString().equalsIgnoreCase("DepoB")) {

			Depo depoClass = DepoBSingleton.getInstance();
			Company comp1 = CompanyBSingleton.getInstance();

			Depo depoClass2 = DepoASingleton.getInstance();
			Company comp2 = CompanyASingleton.getInstance();

			Depo depoClass3 = DepoCSingleton.getInstance();
			Company comp3 = CompanyCSingleton.getInstance();

			// After getting the specific instances, calling the trading method
			trading(depoClass, comp1, depoClass2, comp2, depoClass3, comp3);

		}

		if (depo.toString().equalsIgnoreCase("DepoC")) {

			Depo depoClass = DepoCSingleton.getInstance();
			Company comp1 = CompanyCSingleton.getInstance();

			Depo depoClass2 = DepoASingleton.getInstance();
			Company comp2 = CompanyASingleton.getInstance();

			Depo depoClass3 = DepoBSingleton.getInstance();
			Company comp3 = CompanyBSingleton.getInstance();

			// After getting the specific instances, calling the trading method
			trading(depoClass, comp1, depoClass2, comp2, depoClass3, comp3);

		}

	}

	/**
	 * @method trading()
	 * @params Depo d, Company c, Depo d2, Company c2, Depo d3, Company c3
	 * Method which executes the trades and calls the writer afterwards
	 * */
	private void trading(Depo depoClass, Company comp1, Depo depoClass2, Company comp2, Depo depoClass3,
			Company comp3) {

		/*
		 * Buy and sell actually goes here no matter which company, because we have got the instances and passed them
		 * after checking in a if where they came from
		 * */ 

		/*
		 * Accessing the 50 depos of each Company, because through the instances it was not possible, because the instance is singleton
		 * and retrieves only its depo and products
		 * */ 
		List<Depo> listIntern = new ArrayList<>();
		listIntern.addAll(comp1.getDepos());

		List<Depo> listIntern2 = new ArrayList<>();
		listIntern2.addAll(comp2.getDepos());

		List<Depo> listIntern3 = new ArrayList<>();
		listIntern3.addAll(comp3.getDepos());
		
		// Nested for loop to "iterate" and run on each one of the 50 depos

		for (int i = 0; i < listIntern.size(); i++) {

			for (int j = 0; j < i; j++) {

				// Checking if any productNative of the other Companies are available
				if (listIntern2.get(j).getProductNative().size() > 3
						&& (listIntern.get(i).getProductExternal1().size() <= 40
								|| listIntern.get(i).getProductExternal2().size() <= 40)) {

					if (listIntern.get(i).getProductExternal1().size() > 40
							|| listIntern.get(i).getProductExternal2().size() > 40) {

					} else {

						// How much for the product? do we have budget?
						if (listIntern.get(i).getBudget() > listIntern2.get(j).getPrice()) {

							// Adding product external1 from productNative of the other companies
							listIntern.get(i).getProductExternal1().add(listIntern2.get(j).getProductNative().get(0));

							// Subtracting from native of the other company
							listIntern2.get(j).getProductNative().remove(0);

							// Deducting from the company budget
							listIntern.get(i).setBudget(listIntern.get(i).getBudget() - listIntern2.get(j).getPrice());

							// Sending money to the other company's budget
							listIntern2.get(j)
									.setBudget(listIntern2.get(j).getBudget() + listIntern2.get(j).getPrice());

							// Calling the method to write transaction by transaction
							writeFile(comp1, depoClass2);
							
							// Storing the results between two companie's trades in the proper List to displayed later on
							A.add("Trade done between " + depoClass2 + " and " + depoClass + " " + i + " of " + comp1
									+ " on " + new Date() + "\n");
							
							aBudget.add("The budget now is: " + listIntern.get(i).getBudget());
							bBudget.add("The budget now is: " + listIntern2.get(j).getBudget());
							cBudget.add("The budget now is: " + listIntern3.get(j).getBudget());
							Data.add("Native Products " + listIntern.get(i).getProductNative().get(0) + " " + listIntern.get(i).getProductNative().size());
							Data.add("External 1 Products " + listIntern.get(i).getProductExternal1().get(0) + " " + listIntern.get(i).getProductExternal1().size());

						}

						// Checking if any productNative of the other Company are available
						if (listIntern3.get(j).getProductNative().size() > 3) {
							if (listIntern.get(i).getBudget() > listIntern3.get(j).getPrice()) {

								// Add product external2 from productNative of the other companies
								listIntern.get(i).getProductExternal2()
										.add(listIntern3.get(j).getProductNative().get(0));

								// Subtract from native of the other companies
								listIntern3.get(j).getProductNative().remove(0);

								// Deduct from the company budget
								listIntern.get(i)
										.setBudget(listIntern.get(i).getBudget() - listIntern3.get(j).getPrice());

								// Send money to the other two companie's budget
								listIntern3.get(j)
										.setBudget(listIntern3.get(j).getBudget() + listIntern3.get(j).getPrice());

								// Calling the method to write transaction by transaction
								writeFile(comp1, depoClass3);
								
								// Storing the results of the other companie's trades in the proper List to displayed later on
								A.add("Trade done between " + depoClass3 + " and " + depoClass + " " + i + " of " + comp1
										+ " on " + new Date() + "\n");

								aBudget.add("The budget now is: " + listIntern.get(i).getBudget());
								bBudget.add("The budget now is: " + listIntern2.get(j).getBudget());
								cBudget.add("The budget now is: " + listIntern3.get(j).getBudget());
								Data.add("Native Products " + listIntern.get(i).getProductNative().get(0) + " " + listIntern.get(i).getProductNative().size());
								Data.add("External 2 Products " + listIntern.get(i).getProductExternal2().get(0) + " " + listIntern.get(i).getProductExternal2().size());

							}

						}
					}

				}

			}
		}

	}

	/**
	 * @method writeFile()
	 * @params Company, Depo
	 * method will instantiate a BufferedWriter and write the transaction to a file
	 * */
	private void writeFile(Company comp1, Depo depoClass) {

		if (comp1.toString().equals("Company A")) {
			try {
				writeA = new BufferedWriter(new FileWriter("TradingsA.txt", true));
				writeA.write(
						"ProductExternal from " + depoClass + " was bought for " + comp1 + " on " + new Date() + "\n");
				writeA.close();

			} catch (Exception e) {

			}
		} else if (comp1.toString().equals("Company B")) {

			try {
				writeB = new BufferedWriter(new FileWriter("TradingsB.txt", true));
				writeB.write(
						"ProductExternal from " + depoClass + " was bought for " + comp1 + " on " + new Date() + "\n");
				writeB.close();

			} catch (Exception e) {

			}

		} else if (comp1.toString().equals("Company C")) {

			try {
				writeC = new BufferedWriter(new FileWriter("TradingsC.txt", true));
				writeC.write(
						"ProductExternal from " + depoClass + " was bought for " + comp1 + " on " + new Date() + "\n");
				writeC.close();
			} catch (Exception e) {

			}

		}

	}

	/**
	 * @method menuMethod()
	 * method to display the menu to the user see the trades.
	 * */
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
				System.out.println(getA());
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
						for (int i = 0; i < getA().size(); i++) {
							if (getA().get(i).contains("Company A")) {
								System.out.println(getA().get(i));
								System.out.println(getaBudget().get(i) + " \n");
								System.out.println(getData().get(i));
								System.out.println("--------------------------------");

							}
						}

						break;

					case "2":
						for (int i = 0; i < getA().size(); i++) {
							if (getA().get(i).contains("Company B")) {
								System.out.println(getA().get(i));
								System.out.println(getbBudget().get(i));
								System.out.println(getData().get(i));
								System.out.println("--------------------------------");
							}

						}

						break;

					case "3":
						for (int i = 0; i < getA().size(); i++) {
							if (getA().get(i).contains("Company C")) {
								System.out.println(getA().get(i));
								System.out.println(getcBudget().get(i));
								System.out.println(getData().get(i));
								System.out.println("--------------------------------");
							}

						}

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
	
	// Getters and Setters

	public static List<String> getA() {
		return A;
	}

	public void setA(List<String> a) {
		A = a;
	}

	public static List<String> getaBudget() {
		return aBudget;
	}

	public static void setaBudget(List<String> aBudget) {
		TradingFacade.aBudget = aBudget;
	}

	public static List<String> getbBudget() {
		return bBudget;
	}

	public static void setbBudget(List<String> bBudget) {
		TradingFacade.bBudget = bBudget;
	}

	public static List<String> getcBudget() {
		return cBudget;
	}

	public static void setcBudget(List<String> cBudget) {
		TradingFacade.cBudget = cBudget;
	}

	public static List<String> getData() {
		return Data;
	}

	public static void setData(List<String> data) {
		Data = data;
	}

	public static List<String> getDataB() {
		return Data;
	}


}
