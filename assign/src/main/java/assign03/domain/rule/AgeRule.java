package assign03.domain.rule;

import assign03.domain.entity.Customer;

public class AgeRule implements FilterRule {
	
	private int min;
	private int max;
	
	public AgeRule(int min, int max) {
		//
		this.min = min;
		this.max = max;
	}

	@Override
	public boolean isSatisfied(Customer customer) {
		//
		int age = customer.getAge();
		
		if (min <= age && age <= max) {
			return true;
		} else {
			return false;
		}
	}

}
