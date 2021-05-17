import commercial.trading.company.CompanyASingleton;
import commercial.trading.company.CompanyBSingleton;
import commercial.trading.company.CompanyCSingleton;
import commercial.trading.depo.DepoASingleton;
import commercial.trading.depo.TradingFacade;
import commercial.trading.depo.TradingFacade.DepoType;

/**
 * @author mrosa
 * */
public class Main {

	public static void main(String[] args) {
		
		// Calling constructor
		new Main();
		
	}
	
	public Main() {
		
		// Calling facade method
		facade();
		// Calling the menu after the trades are done
		new TradingFacade().menuMethod();
	}

	private void facade() {
		
		// Initializing each one of the facedes
		new TradingFacade().generateTrading(DepoType.DEPOA);
		new TradingFacade().generateTrading(DepoType.DEPOB);
		new TradingFacade().generateTrading(DepoType.DEPOC);
	}

}
