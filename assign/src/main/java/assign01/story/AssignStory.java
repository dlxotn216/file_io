package assign01.story;

import java.util.ArrayList;
import java.util.List;

import assign01.domain.entity.Customer;
import assign01.domain.entity.GenderType;
import assign01.util.Generator;

public class AssignStory {

	public static void main(String[] args) {
		//
		List<Customer> customers = Generator.generateCustomers();
		System.out.println("customers");
		System.out.println("-------------------");
		System.out.println("count: " + customers.size());
		System.out.println("-------------------");
		for (Customer customer: customers) {
			System.out.println(customer.toString());
		}

		System.out.println("-------------------");
		List<Customer> filteredCustomers = new ArrayList<Customer>();
		System.out.println("\nfiltered customers");
		System.out.println("-------------------");
		for (Customer customer: customers) {
			if (customer.getGender() == GenderType.MALE) {
				filteredCustomers.add(customer);
				System.out.println(customer.toString());
			}
		}
	}
	
}
