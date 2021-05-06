package commercial.trading.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import commercial.trading.depo.*;

public class CompanyASingleton extends Company {
	
	List<Depo> Depos;
	
	private static CompanyASingleton instance = null;
		
	// Constructor
	private CompanyASingleton() {
		// Calling method to populate the List of Depos

		Random random = new Random();

		// Getting a random budget
		budget = random.nextInt(maxBudget - minBudget) + minBudget;
		createDepos();
	}
	
	public void createDepos() {
		
		Depos = new ArrayList<>();
		
		for(int i = 0; i < count; i++) {
			
			Depos.add(ProductFactory.getProduct("DepoA"));
			
		}
//		System.out.println(Depos);
	}
	
	public List<Depo> getDepos() {
		return Depos;
	}

	public void setDepos(List<Depo> depos) {
		Depos = depos;
	}
	
	public static CompanyASingleton getInstance() {

        if (instance == null) {
            instance = new CompanyASingleton();
        }
        return instance;
    }
	
}
