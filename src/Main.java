import commercial.trading.company.CompanyASingleton;
import commercial.trading.company.CompanyBSingleton;
import commercial.trading.company.CompanyCSingleton;
import commercial.trading.depo.DepoASingleton;
import commercial.trading.depo.TradingFacade;
import commercial.trading.depo.TradingFacade.DepoType;

public class Main {

	public static void main(String[] args) {
		
		// Call the Trading class/method
		new TradingFacade().generateTrading(DepoType.DEPOA);
		new TradingFacade().generateTrading(DepoType.DEPOB);
		new TradingFacade().generateTrading(DepoType.DEPOC);
		new TradingFacade().menuMethod();
	}

}
