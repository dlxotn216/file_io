package assign03.domain.rule;

import assign03.domain.entity.Customer;
import assign03.domain.entity.GenderType;

public class GenderRule implements FilterRule {
	
	private GenderType genderType;

	public GenderRule(GenderType genderType) {
		this.genderType = genderType;
	}

	@Override
	public boolean isSatisfied(Customer customer) {
		//
		return customer.getGender() == genderType ? true : false;
	}

}
