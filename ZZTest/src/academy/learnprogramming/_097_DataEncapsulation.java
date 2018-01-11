package academy.learnprogramming;

public class _097_DataEncapsulation {

	public static void main(String[] args) {
		_097_Company company = new _097_Company();
		company.setName("MyCompany") ;
		company.addEmployees("John");
		company.addEmployees("Anthony");
		company.addEmployees(null);
		
		company.printSorted();
		

	}

}
