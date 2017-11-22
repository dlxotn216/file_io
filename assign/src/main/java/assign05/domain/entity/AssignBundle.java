package assign05.domain.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import assign05.domain.rule.FilterRule;
import assign05.domain.rule.SortRule;

public class AssignBundle {

	private List<Customer> candidates;
	
	private List<Consultant> consultants;
	
	private List<FilterRule> filters;
	
	private SortRule sorter;
	
	public AssignBundle() {
		//
		candidates = new ArrayList<Customer>();
		consultants = new ArrayList<Consultant>();
		filters = new ArrayList<FilterRule>();
	}
	
	public List<Assign> assign() {
		//
		List<Customer> satisfiedCustomers = filter();
		sort(satisfiedCustomers);
		List<Assign> assigns = distribute(satisfiedCustomers, consultants);
		
		return assigns;
	}
	
	private List<Assign> distribute(List<Customer> satisfiedCustomers, List<Consultant> consultants2) {
		//
		int index = 0;
		List<Assign> assigns = new ArrayList<Assign>();
		for (Consultant consultant: consultants) {
			for (int i=0; i<consultant.getAssignLimit(); i++) {
				assigns.add(new Assign(consultant, fetchCustomer(satisfiedCustomers, index)));
				index++;
			}
		}
		
		return assigns;
	}
	
	private Customer fetchCustomer(List<Customer> satisfiedCustomers, int index) {
		//
		return satisfiedCustomers.get(index);
	}

	private List<Customer> filter() {
		//
		List<Customer> satistiedCustomers = new ArrayList<Customer>();

		for (FilterRule filter: filters) {
			for (Customer candidate: candidates) {
				if (filter.isSatisfied(candidate)) {
					satistiedCustomers.add(candidate);
				}
			}
		}
		
		return satistiedCustomers;
	}
	
	private void sort(List<Customer> satisfiedCustomers) {
		//
		Collections.sort(satisfiedCustomers, sorter);
	}
	
	public void addFilter(FilterRule filter) {
		//
		this.filters.add(filter);
	}
	
	public void addCandidates(List<Customer> candidates) {
		//
		this.candidates.addAll(candidates);
	}
	
	public void addConstultans(List<Consultant> consultants) {
		//
		this.consultants.addAll(consultants);
	}
	
	public List<Customer> getCandidates() {
		return candidates;
	}

	public List<Consultant> getConsultants() {
		return consultants;
	}

	public List<FilterRule> getFilters() {
		return filters;
	}

	public SortRule getSorter() {
		return sorter;
	}

	public void setSorter(SortRule sorter) {
		this.sorter = sorter;
	}

}
