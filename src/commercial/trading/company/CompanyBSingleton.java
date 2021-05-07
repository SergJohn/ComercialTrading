package commercial.trading.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import commercial.trading.depo.Depo;
import commercial.trading.depo.DepoASingleton;
import commercial.trading.depo.DepoBSingleton;
import commercial.trading.depo.Product;
import commercial.trading.depo.ProductFactory;

public class CompanyBSingleton extends Company {
		
	List<Depo> Depos;
	
	private static CompanyBSingleton instance = null;
	
	private CompanyBSingleton() {
		createDepos();
	}

	public void createDepos() {
		
		Random random = new Random();
		
		Depos = new ArrayList<>();

		for (int i = 0; i < count; i++) {
			
			Depos.add(ProductFactory.getProduct("DepoB"));
		}
//		System.out.println(Depos);
	}
	public List<Depo> getDepos() {
		return Depos;
	}

	public void setDepos(List<Depo> depos) {
		Depos = depos;
	}
	
	public static CompanyBSingleton getInstance() {

        if (instance == null) {
            instance = new CompanyBSingleton();
        }
        return instance;

    }
}
