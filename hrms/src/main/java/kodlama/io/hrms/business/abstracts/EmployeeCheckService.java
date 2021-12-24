package kodlama.io.hrms.business.abstracts;


import kodlama.io.hrms.entities.concretes.Employee;

public interface EmployeeCheckService {
	
	public boolean checkFirstName(Employee employee);
	public boolean checkLastName(Employee employee);
	public boolean checkEmail(Employee employee);
	public boolean checkPassword(Employee employee);
	
	public boolean isEmailUnique(Employee employee);
	public boolean isEmailFormatCorrect(Employee employee);
	public boolean isNull(Employee employee);
	public boolean checkPasswordLength(Employee employee);
}
