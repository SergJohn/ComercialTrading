package commercial.trading.company;

import java.util.List;

import commercial.trading.depo.Depo;
import commercial.trading.depo.DepoBSingleton;

public abstract class Company {

	protected int count = 50;
	protected double budget;
	protected int minBudget;
	protected int maxBudget;

	public Company() {

		minBudget = 50;
		maxBudget = 100;
	}
	


	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public int getMinBudget() {
		return minBudget;
	}

	public void setMinBudget(int minBudget) {
		this.minBudget = minBudget;
	}

	public int getMaxBudget() {
		return maxBudget;
	}

	public void setMaxBudget(int maxBudget) {
		this.maxBudget = maxBudget;
	}
	
}
