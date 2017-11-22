package assign02.domain.rule;

import assign02.domain.entity.Customer;

public interface Rule {
	
	public abstract boolean isSatisfied(Customer customer);
	
}
