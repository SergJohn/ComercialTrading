package commercial.trading.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import commercial.trading.depo.Depo;
import commercial.trading.depo.DepoASingleton;
import commercial.trading.depo.DepoBSingleton;
import commercial.trading.depo.DepoCSingleton;
import commercial.trading.depo.Product;
import commercial.trading.depo.DepoFactory;

public class CompanyCSingleton extends Company {
		
	// Private Static Instance of the class declared as NULL
	private static CompanyCSingleton instance = null;
	
	// Constructor
	private CompanyCSingleton() {
		
		// Calling the createDepos() method
		createDepos();
	}

	/**
	 * @method createDepos()
	 * Method populates the Depo List with 50 new depos creates after calling the Factory class
	 * */
	public void createDepos() {
		
		Random random = new Random();
		
		Depos = new ArrayList<>();

		for (int i = 0; i < count; i++) {
			
			Depos.add(DepoFactory.getProduct("DepoC"));
		}
	}
	
	// Getters and Setters
	public List<Depo> getDepos() {
		return Depos;
	}

	public void setDepos(List<Depo> depos) {
		Depos = depos;
	}
	
	@Override
	public String toString() {
		return "Company C";
	}
	
	/**
	 * @method getInstance
	 * @return instance:CompanyCSingleton
	 * Checking if the instance exists and retrieving it or if it not creating a new one
	 * */
	public static CompanyCSingleton getInstance() {

        if (instance == null) {
            instance = new CompanyCSingleton();
        }
        return instance;

    }
}
