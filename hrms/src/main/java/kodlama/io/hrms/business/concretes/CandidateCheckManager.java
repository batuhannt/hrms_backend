package kodlama.io.hrms.business.concretes;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;


import kodlama.io.hrms.business.abstracts.CandidateCheckService;
import kodlama.io.hrms.dataAccess.abstracts.CandidateDao;
import kodlama.io.hrms.entities.concretes.Candidate;

@Service
public class CandidateCheckManager implements CandidateCheckService{
	
	private CandidateDao candidateDao;
	
	@Autowired
	public CandidateCheckManager(CandidateDao candidateDao) {
		super();
		this.candidateDao = candidateDao;
	}

	@Override
	public boolean checkFirstName(Candidate candidate) {
		if(candidate.getFirstName()==null) {return false;}
		return true;
	}

	@Override
	public boolean checkLastName(Candidate candidate) {
		if(candidate.getLastName()==null) {return false;}
		return true;
	}

	@Override
	public boolean checkEmail(Candidate candidate) {
		if(candidate.getEMail()==null) {return false;}
		return true;
	}

	@Override
	public boolean checkPassword(Candidate candidate) {
		if(candidate.getPassword()==null) {
			return false;}
			return true;
		}
	
	public boolean checkPasswordLength(Candidate candidate) {
		if(candidate.getPassword().length()<=6) {
			return false;
		}
		return true;
	}

	@Override
	public boolean checkIdentityNumber(Candidate candidate) {
		if(candidate.getIdentityNumber()==0) {return false;}
		return true;
	}

	@Override
	public boolean isEmailUnique(Candidate candidate) {

		var liste=this.candidateDao.findAll();
		
		for(Candidate tek:liste) {	
			
			if(tek.getEMail().contains(candidate.getEMail())) {
				return true;
			}		
		}
		return false;
		
	}

	@Override
	public boolean isEmailFormatCorrect(Candidate candidate) {
		
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(candidate.getEMail());
		return matcher.matches();
		
	}

	@Override
	public boolean isNull(Candidate candidate) {
		
		if(this.checkFirstName(candidate)&&this.checkLastName(candidate)&&this.checkEmail(candidate)
				&&this.checkPassword(candidate)&&this.checkIdentityNumber(candidate)) {
			System.out.println("Geçti");
			System.out.println(checkLastName(candidate));
			return true;
			}
		
		else {
			
			return false;
		}
			
		
	}

	@Override
	public boolean isIdentityUnique(Candidate candidate) {
		var liste=this.candidateDao.findAll();
		
		for(Candidate tek:liste) {	
			
			if(tek.getIdentityNumber()==(candidate.getIdentityNumber())) {
				return false;
			}		
		}
		return true;
	}
	

	

	
}
