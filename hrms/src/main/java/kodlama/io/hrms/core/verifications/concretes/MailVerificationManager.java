package kodlama.io.hrms.core.verifications.concretes;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.core.verifications.abstracts.MailVerificationService;

@Service
public class MailVerificationManager implements MailVerificationService{

	@Override
	public boolean isVerified(String mail) {
		
		return true;
	}

}
