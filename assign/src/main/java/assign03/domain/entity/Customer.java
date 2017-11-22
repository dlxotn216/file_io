package assign03.domain.entity;

import java.util.ArrayList;
import java.util.List;

import assign03.domain.exception.AssignException;

public class Customer {

	private String id;
	
	private String name;
	
	private GenderType gender;
	
	private Birthday birthday;
	
	private List<Contact> contacts;
	
	public Customer() {
		//
		contacts = new ArrayList<Contact>();
	}
	
	public Customer(String id, String name) {
		//
		this();
		
		this.id = id;
		this.name = name;
	}
	
	public Customer(String id, String name, GenderType gender) {
		//
		this(id, name);
		
		this.gender = gender;
	}
	
	public Customer(String id, String name, GenderType gender, Birthday birthday) {
		//
		this(id, name, gender);
		
		this.birthday = birthday;
	}
	
	public void addContact(Contact contact) {
		//
		if (!contacts.contains(contact)) {
			contacts.add(contact);
		}
	}
	
	public Contact findContact(ContactType contactType) {
		//
		for (Contact contact: contacts) {
			if (contact.getContactType() == contactType) {
				return contact;
			}
		}
		
		throw new AssignException();
	}
	
	public int getAge() {
		//
		return birthday.getYearAge();
	}
	
	@Override
	public String toString() {
		//
		return this.name + "(" + this.getAge() + ") " + this.getGender();
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public GenderType getGender() {
		return gender;
	}

}
