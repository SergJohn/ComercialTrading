package commercial.trading.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import commercial.trading.depo.*;

/**
 * @author mrosa
 * */
public class CompanyASingleton extends Company {
	
	// Private Static Instance of the class declared as NULL	
	private static CompanyASingleton instance = null;
		
	// Constructor
	private CompanyASingleton() {

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
		for(int i = 0; i < count; i++) {
			
			Depos.add(DepoFactory.getProduct("DepoA"));
			
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
		return "Company A";
	}
	
	/**
	 * @method getInstance
	 * @return instance:CompanyASingleton
	 * Checking if the instance exists and retrieving it or if it not creating a new one
	 * */
	public static CompanyASingleton getInstance() {

        if (instance == null) {
            instance = new CompanyASingleton();
        }
        return instance;
    }
	
}
