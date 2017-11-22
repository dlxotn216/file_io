package assign04.domain.rule;

import assign04.domain.entity.Customer;
import assign04.domain.entity.GenderType;
import assign04.domain.exception.AssignException;

public class GenderRule implements FilterRule, SortRule {
	
	private GenderType genderType;
	
	private SortType sortType;

	public GenderRule(GenderType genderType) {
		//
		this.genderType = genderType;
	}
	
	public GenderRule(SortType sortType) {
		//
		this.sortType = sortType;
	}

	@Override
	public boolean isSatisfied(Customer customer) {
		//
		return customer.getGender() == genderType ? true : false;
	}

	@Override
	public int compare(Customer o1, Customer o2) {
		//
		if (sortType == SortType.ASCENDING) {
			return o1.getGender().compareTo(o2.getGender());
		} else if (sortType == SortType.DESCENDING){
			return o1.getGender().compareTo(o2.getGender());
		} else {
			throw new AssignException("정렬 기준이 설정되지 않았습니다.");
		}
	}

}
