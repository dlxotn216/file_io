package assign04.domain.rule;

import assign04.domain.entity.Customer;
import assign04.domain.exception.AssignException;

public class AgeRule implements FilterRule, SortRule {
	
	private int min;
	private int max;
	
	private SortType sortType = SortType.NONE;
	
	public AgeRule(int min, int max) {
		//
		this.min = min;
		this.max = max;
	}
	
	public AgeRule(SortType sortType) {
		//
		this.sortType = sortType;
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

	@Override
	public int compare(Customer o1, Customer o2) {
		//
		if (sortType == SortType.ASCENDING) {
			return o1.getAge() > o2.getAge() ? 1 : -1;
		} else if (sortType == SortType.DESCENDING){
			return o1.getAge() > o2.getAge() ? -1 : 1;
		} else {
			throw new AssignException("정렬 기준이 설정되지 않았습니다.");
		}
	}

}
