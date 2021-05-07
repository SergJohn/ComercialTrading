package commercial.trading.company;

import java.util.ArrayList;
import java.util.List;

import commercial.trading.depo.Depo;
import commercial.trading.depo.DepoBSingleton;

public abstract class Company {

	protected int count = 50;
	protected List<Depo> Depos;

	public Company() {

	}
	

	
	public List<Depo> getDepos() {
		return Depos;
	}

	public void setDepos(List<Depo> depos) {
		Depos = depos;
	}
	
}
