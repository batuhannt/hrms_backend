package kodlama.io.hrms.core.verifications.concretes;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.core.verifications.abstracts.MernisVerificationService;

@Service
public class MernisVerificationManager<T> implements MernisVerificationService<T>{
	
	@Override
	public boolean isVerified(T entity) {
		
		return true;
	}

}
