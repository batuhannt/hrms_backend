package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.entities.concretes.Candidate;

public interface CandidateCheckService {
	
	public boolean checkFirstName(Candidate candidate);
	public boolean checkLastName(Candidate candidate);
	public boolean checkEmail(Candidate candidate);
	public boolean checkPassword(Candidate candidate);
	public boolean checkIdentityNumber(Candidate candidate);
	public boolean isEmailUnique(Candidate candidate);
	public boolean isEmailFormatCorrect(Candidate candidate);
	public boolean isNull(Candidate candidate);
	public boolean isIdentityUnique(Candidate candidate);
	public boolean checkPasswordLength(Candidate candidate);
}
