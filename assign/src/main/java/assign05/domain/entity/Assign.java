package assign05.domain.entity;

public class Assign {

	private Consultant consultant;
	
	private Customer customer;
	
	public Assign(Consultant consultant, Customer customer) {
		//
		this.consultant = consultant;
		this.customer = customer;
	}
	
	@Override
	public String toString() {
		//
		return consultant.getName() + ": " + customer.toString();
	}

	public Consultant getConsultant() {
		return consultant;
	}

	public Customer getCustomer() {
		return customer;
	}
	
}
