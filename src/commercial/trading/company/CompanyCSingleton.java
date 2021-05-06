package commercial.trading.company;

import java.util.ArrayList;
import java.util.List;

import commercial.trading.depo.Depo;
import commercial.trading.depo.DepoASingleton;
import commercial.trading.depo.DepoBSingleton;
import commercial.trading.depo.DepoCSingleton;
import commercial.trading.depo.Product;
import commercial.trading.depo.ProductFactory;

public class CompanyCSingleton extends Company {
	
	List<Depo> Depos;
	
	private static CompanyCSingleton instance = null;
	
	private CompanyCSingleton() {
		createDepos();
	}

	public void createDepos() {
		
		Depos = new ArrayList<>();

		for (int i = 0; i < count; i++) {
			
			Depos.add(ProductFactory.getProduct("DepoC"));
		}
//		System.out.println(Depos);
	}
	
	public List<Depo> getDepos() {
		return Depos;
	}

	public void setDepos(List<Depo> depos) {
		Depos = depos;
	}
	
	public static CompanyCSingleton getInstance() {

        if (instance == null) {
            instance = new CompanyCSingleton();
        }
        return instance;

    }
}
