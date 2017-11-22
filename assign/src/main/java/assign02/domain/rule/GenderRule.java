package assign02.domain.rule;

import assign02.domain.entity.Customer;
import assign02.domain.entity.GenderType;

public class GenderRule implements Rule {
	
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
