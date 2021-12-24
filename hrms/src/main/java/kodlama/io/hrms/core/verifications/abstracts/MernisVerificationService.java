package kodlama.io.hrms.core.verifications.abstracts;

public interface MernisVerificationService<T> {
	
	public boolean isVerified(T entity);

}
