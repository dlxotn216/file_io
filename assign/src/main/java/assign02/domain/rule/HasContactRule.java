package assign02.domain.rule;

import assign02.domain.entity.Customer;

public class HasContactRule implements Rule {
	
	@Override
	public boolean isSatisfied(Customer customer) {
		//
		return customer.hasContact();
	}

}
