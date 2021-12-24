package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.EmployeeCheckService;
import kodlama.io.hrms.business.abstracts.EmployeeService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.core.verifications.abstracts.MailVerificationService;
import kodlama.io.hrms.core.verifications.abstracts.MernisVerificationService;

import kodlama.io.hrms.dataAccess.abstracts.EmployeeDao;

import kodlama.io.hrms.entities.concretes.Employee;

@Service
public class EmployeeManager implements EmployeeService{
	
	private EmployeeDao employeeDao;
	private EmployeeCheckService checkService;
	private MernisVerificationService<Employee> mernisVerification;
	private MailVerificationService mailVerification;
	
	@Autowired
	public EmployeeManager(EmployeeDao employeeDao,EmployeeCheckService checkService,
			MernisVerificationService<Employee> mernisVerification,MailVerificationService mailVerification) {
		super();
		this.employeeDao=employeeDao;
		this.checkService=checkService;
		this.mernisVerification=mernisVerification;
		this.mailVerification=mailVerification;
	}
	@Override
	public DataResult<List<Employee>> getAll() {
		return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll(),"Data listelendi");
	}

	@Override
	public Result add(Employee employee) {
		if(this.checkService.isEmailUnique(employee)) {
			return new ErrorResult("Email kullanılıyor.Farklı bir Email deneyin.");
		}
		else if(!this.checkService.isEmailFormatCorrect(employee)) {
			return new ErrorResult("Email formatı yanlış");
		}
		else if(!this.checkService.isNull(employee)) {
			return new ErrorResult("Tüm alanlar zorunlu.");
		}
		else if(!this.checkService.checkPasswordLength(employee)) {
			return new ErrorResult("Parola en az 7 karakterli olmalıdır");
		}
			
		else if(!this.mernisVerification.isVerified(employee)) {
			return new ErrorResult("Mernis doğrulanmadı.");
		}
		else if(!this.mailVerification.isVerified(employee.getEMail())) {
			return new ErrorResult("Email Doğrulanmadı.");
		}
		else {
			this.employeeDao.save(employee);
			return new SuccessResult("Başarılı bir şekilde eklendi.");
		}
	}

}
