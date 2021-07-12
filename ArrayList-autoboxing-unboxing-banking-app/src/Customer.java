import java.util.ArrayList;

public class Customer {
	private String name;
	private ArrayList<Double> transactions;
	
	public Customer(String name, double startAmount) {
		this.name = name;
		this.transactions = new ArrayList<Double>();
		addTransaction(startAmount);
	}
	
	public void addTransaction(double amount) {
		this.transactions.add(amount);
	}
	
	public String getName() {
		return this.name;
	}
	
	public ArrayList<Double> getTransactions() {
		return this.transactions;
	}

}
