package assign05.util;

import java.util.ArrayList;
import java.util.List;

import assign05.domain.entity.Birthday;
import assign05.domain.entity.Consultant;
import assign05.domain.entity.Contact;
import assign05.domain.entity.ContactType;
import assign05.domain.entity.Customer;
import assign05.domain.entity.GenderType;

public class Generator {
	
	public static List<Consultant> generateConsultants() {
		//
		List<Consultant> consultants = new ArrayList<Consultant>();
		
		consultants.add(new Consultant(100, "김상담", 1));
		consultants.add(new Consultant(200, "이상담", 2));
		
		return consultants;
	}

	public static List<Customer> generateCustomers() {
		//
		List<Customer> customers = new ArrayList<Customer>();
		
		//
		Customer customer1 = new Customer("100", "조재윤", GenderType.MALE, new Birthday("19810101"));
		Contact homeContact1 = new Contact(ContactType.HOME, "0311234567");
		customer1.addContact(homeContact1);
		customers.add(customer1);
		
		Customer customer2 = new Customer("101", "김영희", GenderType.FEMALE, new Birthday("19981209"));
		customers.add(customer2);
		
		Customer customer3 = new Customer("102", "김철수", GenderType.MALE, new Birthday("20040623"));
		Contact homeContact3 = new Contact(ContactType.HOME, "0311234567");
		customer3.addContact(homeContact3);
		Contact mobileContact1 = new Contact(ContactType.MOBILE, "01012345678");
		customer3.addContact(mobileContact1);
		customers.add(customer3);
		
		Customer customer4 = new Customer("103", "이동윤", GenderType.FEMALE, new Birthday("20011029"));
		Contact mobileContact2 = new Contact(ContactType.MOBILE, "01058749387");
		customer4.addContact(mobileContact2);
		customers.add(customer4);
		
		return customers;
	}

}
