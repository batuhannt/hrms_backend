package kodlama.io.hrms.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.EmployeeCheckService;
import kodlama.io.hrms.dataAccess.abstracts.EmployeeDao;

import kodlama.io.hrms.entities.concretes.Employee;

@Service
public class EmployeeCheckManager implements EmployeeCheckService{
	
	private EmployeeDao employeeDao;

	public EmployeeCheckManager(EmployeeDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}

	@Override
	public boolean checkFirstName(Employee employee) {
		if(employee.getFirstName()==null) {return false;}
		return true;
	}

	@Override
	public boolean checkLastName(Employee employee) {
		if(employee.getLastName()==null) {return false;}
		return true;
	}

	@Override
	public boolean checkEmail(Employee employee) {
		if(employee.getEMail()==null) {return false;}
		return true;
	}

	@Override
	public boolean checkPassword(Employee employee) {
		if(employee.getPassword()==null) {
			return false;}
			return true;
		}	
	

	@Override
	public boolean isEmailUnique(Employee employee) {
		var liste=this.employeeDao.findAll();
		
		for(Employee tek:liste) {	
			
			if(tek.getEMail().contains(employee.getEMail())) {
				return true;
			}		
		}
		return false;
	}

	@Override
	public boolean isEmailFormatCorrect(Employee employee) {
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(employee.getEMail());
		return matcher.matches();
	}

	@Override
	public boolean isNull(Employee employee) {
		if(this.checkFirstName(employee)&&this.checkLastName(employee)&&this.checkEmail(employee)
				&&this.checkPassword(employee)) {
			System.out.println("Geçti");
			System.out.println(checkLastName(employee));
			return true;
			}
		
		else {
			
			return false;
		}
	}


	@Override
	public boolean checkPasswordLength(Employee employee) {
		if(employee.getPassword().length()<=6) {
			return false;
		}
		return true;
	}


}
