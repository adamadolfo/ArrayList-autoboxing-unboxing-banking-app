import java.util.ArrayList;

public class Bank {
	private String name;
	private ArrayList<Branch> branches;
	
	public Bank(String name) {
		this.name = name;
		this.branches = new ArrayList<Branch>();
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Branch> getBranches() {
		return branches;
	}
	
	
	
	private Branch findBranch(String name) {
		
		for (int i = 0; i < this.branches.size(); i++){
			
			Branch currentBranch = this.branches.get(i);
			
			if(currentBranch.getBranchName().equals(name)) {
				return currentBranch;
			}
			
		}
		return null;
	}
	
	
	
	public boolean addBranch(String name) {
		if (findBranch(name) == null) {
			Branch newBranch = new Branch(name);
			this.branches.add(newBranch);
			return true;
		}
		return false;
	}
	
	
	
	
	public boolean addCustomerToBranch(String branchName, String name, double startAmount) {
		Branch foundBranch = findBranch(branchName);
		
		if (foundBranch != null) {
			foundBranch.addCustomer(name, startAmount);
			return true;
		}
		return false;
	}
	
	public boolean addCustomerTransaction(String branchName, String name, double amount) {
		Branch foundBranch = findBranch(branchName);
		
		if (foundBranch != null) {
			foundBranch.addCustomerTransaction(name, amount);
			return true;
		}
		return false;
	}
	
	public boolean listCustomers(String branchName, boolean showTransactions) {
		
		Branch foundBranch = findBranch(branchName);
		if (foundBranch != null) {
			System.out.println("customers for branch " + foundBranch.getBranchName());
			
			ArrayList<Customer> customers = foundBranch.getCustomers();
			
			for (int i = 0; i < customers.size(); i++) {
				Customer currentCustomer = customers.get(i);
				System.out.println("customer Name : " + currentCustomer.getName());
				if (showTransactions) {
					System.out.println(currentCustomer.getTransactions());
				}
			}			
			return true;
		}	
		return false;
	}
	

}
