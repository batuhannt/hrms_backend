package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.CandidateCheckService;
import kodlama.io.hrms.business.abstracts.CandidateService;
import kodlama.io.hrms.business.abstracts.EducationService;
import kodlama.io.hrms.business.abstracts.ForeignLanguageService;
import kodlama.io.hrms.business.abstracts.ProgrammingLanguageService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.core.verifications.abstracts.MailVerificationService;
import kodlama.io.hrms.core.verifications.abstracts.MernisVerificationService;
import kodlama.io.hrms.dataAccess.abstracts.CandidateDao;
import kodlama.io.hrms.entities.concretes.Candidate;
import kodlama.io.hrms.entities.dtos.CvDto;
import kodlama.io.hrms.business.abstracts.JobExperienceService;



@Service
public class CandidateManager implements CandidateService{
	
	private CandidateDao candidateDao;
	private CandidateCheckService checkService;
	private MernisVerificationService<Candidate> mernisVerification;
	private MailVerificationService mailVerification;
	private EducationService educationService;
	private ForeignLanguageService foreignLanguageService;
	private ProgrammingLanguageService programmingLanguageService;
	private JobExperienceService jobExperienceService;
	
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao,CandidateCheckService checkService,
			MernisVerificationService<Candidate> mernisVerification,MailVerificationService mailVerification,
			JobExperienceService jobExperienceService,ProgrammingLanguageService programmingLanguageService,
			ForeignLanguageService foreignLanguageService,EducationService educationService) {
		super();
		this.candidateDao=candidateDao;
		this.checkService=checkService;
		this.mernisVerification=mernisVerification;
		this.mailVerification=mailVerification;
		this.educationService=educationService;
		this.programmingLanguageService=programmingLanguageService;
		this.jobExperienceService=jobExperienceService;
		this.foreignLanguageService=foreignLanguageService;
	}


	@Override
	public DataResult<List<Candidate>> getAll() {
		
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),"Data listelendi");
		
	}

	
	public Result add(Candidate candidate) {
		if(this.checkService.isEmailUnique(candidate)) {
			return new ErrorResult("Email kullanılıyor.Farklı bir Email deneyin.");
		}
		else if(!this.checkService.isEmailFormatCorrect(candidate)) {
			return new ErrorResult("Email formatı yanlış");
		}
		else if(!this.checkService.isNull(candidate)) {
			return new ErrorResult("Tüm alanlar zorunlu.");
		}
		else if(!this.checkService.checkPasswordLength(candidate)) {
			return new ErrorResult("Parola en az 7 karakterli olmalıdır");
		}
		else if(!this.checkService.checkIdentityNumber(candidate)) {
			return new ErrorResult("TC kimlik numarası sistemde kayıtlı.");
		}
		else if(!this.mernisVerification.isVerified(candidate)) {
			return new ErrorResult("Mernis doğrulanmadı.");
		}
		else if(!this.mailVerification.isVerified(candidate.getEMail())) {
			return new ErrorResult("Email Doğrulanmadı.");
		}
		else {
			this.candidateDao.save(candidate);
			return new SuccessResult("Başarılı bir şekilde eklendi.");
		}
		
	}
	
	public DataResult<CvDto> getByCandidateId(int candidateId){
		CvDto cv=new CvDto();
		
        System.out.println(this.educationService.findAllByCandidateId(candidateId).getData().getEducationDepartment());
		
		cv.setCandidate(this.findById(candidateId).getData());
		cv.setEducationSchoolName(this.educationService.findAllByCandidateId(candidateId).getData().getSchoolName());
		cv.setEducationDepartment(this.educationService.findAllByCandidateId(candidateId).getData().getEducationDepartment());
		
		cv.setForeignLanguageName(this.foreignLanguageService.findAllByCandidateId(candidateId).getData().getLanguageName());
		cv.setForeignLanguageLevel(this.foreignLanguageService.findAllByCandidateId(candidateId).getData().getLevel());
		cv.setJobFirmName(this.jobExperienceService.findAllByCandidateId(candidateId).getData().getFirmName());
		cv.setJobPosition(this.jobExperienceService.findAllByCandidateId(candidateId).getData().getPosition());
		
		cv.setProgrammingLanguageName(this.programmingLanguageService.findAllByCandidateId(candidateId).getData().getName());
		cv.setProgrammingLanguageLevel(this.programmingLanguageService.findAllByCandidateId(candidateId).getData().getLevel());
		
		return new SuccessDataResult<CvDto>(cv,"Cv getirildi.");
	}


	@Override
	public DataResult<Candidate> findById(int candidateId) {
		
		return new SuccessDataResult<Candidate>(this.candidateDao.findById(candidateId), "Candidate is here");
	}


	@Override
	public DataResult<List<Candidate>> findByFirstName(String firstName) {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findByFirstName(firstName),"Data getirildi");
	}


	@Override
	public Result deleteByCandidateId(int candidateId) {
		this.candidateDao.deleteById(candidateId);
		return new SuccessResult("Başarıyla Silindi");
		
	}


	
	
	

}
