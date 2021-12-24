package kodlama.io.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_experience")
public class JobExperience {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="firm_name")
	private String firmName;
	
	@Column(name="postion")
	private String position;
	
	@Column(name="job_start_date")
	private Date jobStartDate;
	
	@Column(name="job_end_date")
	private Date jobEndDate;
	
	@ManyToOne()
	@JoinColumn(name="candidate_id")
	private Candidate candidate;
	


}
