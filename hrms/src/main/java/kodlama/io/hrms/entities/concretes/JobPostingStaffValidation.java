package kodlama.io.hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_posting_staff_validation")
public class JobPostingStaffValidation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="is_verified")
	private String isVerified;
	
	@Column(name="verified_at")
	private Date verifiedAt;
	
	@OneToOne
	@JoinColumn(name="job_advertisement_id",referencedColumnName = "id")
	private JobAdvertisement jobAdvertisement;
	
}
