import java.util.ArrayList;

public class Branch {
	private String branchName;
	private ArrayList<Customer> customers;
	
	public Branch(String branchName) {
		this.branchName = branchName;
		this.customers = new ArrayList<Customer>();
	}
	
	public String getBranchName() {
		return branchName;
	}
	public ArrayList<Customer> getCustomers() {
		return customers;
	}
	
	public boolean addCustomer(String customerName, double startAmount) {
		if (findCustomer(customerName) == null) {
			Customer customer = new Customer(customerName, startAmount); 
			this.customers.add(customer);
			return true;
		}
		return false;
	}
	
	public boolean addCustomerTransaction(String customerName, double amount) {
		Customer existingCustomer = findCustomer(customerName);
		if (existingCustomer != null) {
			existingCustomer.addTransaction(amount);
			return true;
		}
		return false;
	}
	
	private Customer findCustomer(String customerName) {
		for (int i = 0; i < customers.size(); i ++) {
			if (this.customers.get(i).getName() == customerName) {
				return this.customers.get(i);
			}
		}
		return null;
	}

}
