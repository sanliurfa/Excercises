package academy.learnprogramming;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


// POJO (Plain Old Java Object)

public class _097_Company {
	
//	public String name;
//	public List<String> employees = new ArrayList<>();
	
	private String name;									// bij encapsulation zet je het op private
	private List<String> employees = new ArrayList<>();
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null) {
			System.out.println("name can't be null");
			return;
		}
		this.name = name;
	}

	public List<String> getEmployees() {
		return employees;
	}

	public void addEmployees(String name) {
		if(name == null || name.isEmpty()) {
			System.out.println("can't add null employee");
			return;
		}
		employees.add(name);
	}

	
//	public _097_Company() {}								// standaard constructor, dit hoeft niet omdat het door de compiler standaard ook aangemaakt word
	
	public void printSorted() {
		System.out.println("companyName "+ name);
		Collections.sort(employees);
		System.out.println("sorted= "+ employees);
		
	}

}
