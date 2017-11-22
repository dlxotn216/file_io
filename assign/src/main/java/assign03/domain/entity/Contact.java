package assign03.domain.entity;

public class Contact {

	private ContactType contactType;
	
	private String no;
	
	public Contact(ContactType contactType, String no) {
		//
		this.contactType = contactType;
		this.no = no;
	}

	public ContactType getContactType() {
		return contactType;
	}

	public String getNo() {
		return no;
	}
}
