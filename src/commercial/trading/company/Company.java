package commercial.trading.company;

import java.util.ArrayList;
import java.util.List;

import commercial.trading.depo.Depo;
import commercial.trading.depo.DepoBSingleton;

/**
 * @author mrosa
 * */
public abstract class Company {

	// Variables to be used in all subclasses
	protected int count = 50;
	protected List<Depo> Depos;

	// Constructor
	public Company() {

	}
		
	// Getters and Setters
	public List<Depo> getDepos() {
		return Depos;
	}

	public void setDepos(List<Depo> depos) {
		Depos = depos;
	}
	
}
