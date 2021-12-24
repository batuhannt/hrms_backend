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
@Table(name="educations")

public class Education {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="school_name")
	private String schoolName;
	
	@Column(name="education_department")
	private String educationDepartment;
	
	@Column(name="school_start_date")
	private Date schoolStartDate;
	
	@Column(name="school_end_date")
	private Date schoolEndDate;
	
	@ManyToOne()
	@JoinColumn(name="candidate_id")
	private Candidate candidate;
	


}
