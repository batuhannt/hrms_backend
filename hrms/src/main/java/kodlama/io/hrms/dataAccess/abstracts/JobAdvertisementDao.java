package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlama.io.hrms.entities.concretes.JobAdvertisement;


public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{
	
	List<JobAdvertisement> getByjobPostingStaffValidation_isVerified(String isVerified);
	
	JobAdvertisement getByIdAndEmployer_Id(int id,int employer_id);
	
	JobAdvertisement getByOpenPositionAmount(int openPositionAmount);
	
	List<JobAdvertisement> getByEmployer_IdIn(List<Integer> employers);
	
	List<JobAdvertisement> getByCity_CityNameStartsWith(String cityName);
	
	@Query("From JobAdvertisement where positions.id=:id")
	List<JobAdvertisement> getAllPosition(int id);

}
