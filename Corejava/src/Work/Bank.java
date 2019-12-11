package Work;

public class Bank {
	private Customer[] customers;
	private int custNum;
	
	public Bank() {
		
	}
	public Bank(int length) {
		customers=new Customer[length];
	}
	public void addCustomer(Customer customer) {
		customers[custNum++]=customer;
	}
	public Customer getCustomer(int index) {
		return customers[index];
	}
	
	public int getCustomerNum() {
		return custNum;
	}
	
}
