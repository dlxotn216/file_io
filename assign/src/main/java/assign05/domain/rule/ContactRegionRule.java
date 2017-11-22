package assign05.domain.rule;

import assign05.domain.entity.Contact;
import assign05.domain.entity.ContactType;
import assign05.domain.entity.Customer;
import assign05.domain.exception.AssignException;

public class ContactRegionRule implements FilterRule {
	
	private String value;

	public ContactRegionRule(String value) {
		this.value = value;
	}

	@Override
	public boolean isSatisfied(Customer customer) {
		//
		try {
			Contact contact = customer.findContact(ContactType.HOME);
			return contact.getNo().startsWith(this.value);
		} catch (AssignException e) {
			return false;
		}
	}

}
