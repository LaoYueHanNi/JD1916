package Work;

public class Customer {
	private Account account;
	private String name;
	public Customer(String name) {
		this.name=name;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getName() {
		return name;
	}
	
}
