package assign04.domain.rule;

import assign04.domain.entity.Contact;
import assign04.domain.entity.ContactType;
import assign04.domain.entity.Customer;
import assign04.domain.exception.AssignException;

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
