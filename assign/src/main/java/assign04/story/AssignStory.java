package assign04.story;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import assign04.domain.entity.Assign;
import assign04.domain.entity.Consultant;
import assign04.domain.entity.Customer;
import assign04.domain.rule.AgeRule;
import assign04.domain.rule.FilterRule;
import assign04.domain.rule.SortType;
import assign04.util.Generator;

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

		List<Consultant> consultants = Generator.generateConsultants();
		System.out.println("\nconsultatns");
		System.out.println("-------------------");
		System.out.println("count: " + consultants.size());
		System.out.println("-------------------");
		for (Consultant consultant: consultants) {
			System.out.println(consultant.toString());
		}

		FilterRule rule = new AgeRule(10, 20);
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
		Collections.sort(filteredCustomers, new AgeRule(SortType.DESCENDING));
		for (Customer customer: filteredCustomers) {
			System.out.println(customer.toString());
		}
		
		//
		int index = 0;
		List<Assign> assigns = new ArrayList<Assign>();
		for (Consultant consultant: consultants) {
			for (int i=0; i<consultant.getAssignLimit(); i++) {
				assigns.add(new Assign(consultant, fetchCustomer(filteredCustomers, index)));
				index++;
			}
		}
		System.out.println("\nassigns");
		System.out.println("-------------------");
		for (Assign assign: assigns) {
			System.out.println(assign.toString());
		}
	}
	
	public static Customer fetchCustomer(List<Customer> customers, int index) {
		//
		return customers.get(index);
	}
	
}
