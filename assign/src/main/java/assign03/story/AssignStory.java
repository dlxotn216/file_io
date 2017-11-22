package assign03.story;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import assign03.domain.entity.Customer;
import assign03.domain.rule.AgeRule;
import assign03.domain.rule.FilterRule;
import assign03.util.Generator;

public class AssignStory {

	public static void main(String[] args) {
		//
		//Rule rule = new GenderRule(GenderType.MALE);
		FilterRule rule = new AgeRule(10, 20);

		List<Customer> customers = Generator.generateCustomers();
		System.out.println("customers");
		System.out.println("-------------------");
		System.out.println("count: " + customers.size());
		System.out.println("-------------------");
		for (Customer customer: customers) {
			System.out.println(customer.toString());
		}

		List<Customer> filteredCustomers = new ArrayList<Customer>();
		System.out.println("\nfiltered customers");
		System.out.println("-------------------");
		for (Customer customer: customers) {
			if (rule.isSatisfied(customer)) {
				filteredCustomers.add(customer);
				System.out.println(customer.toString());
			}
		}

		System.out.println("\nsorted customers");
		System.out.println("-------------------");
		Collections.sort(filteredCustomers, new Comparator<Customer>() {
			@Override
			public int compare(Customer o1, Customer o2) {
				//
				return o1.getAge() > o2.getAge() ? 1 : -1;
			}
		});
		for (Customer customer: filteredCustomers) {
			System.out.println(customer.toString());
		}
	}

}
