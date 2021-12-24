package kodlama.io.hrms.entities.concretes;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name="candidates")
@AllArgsConstructor
@PrimaryKeyJoinColumn(name="user_id", referencedColumnName = "id")
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Candidate extends User{
	
	
	
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="identity_number")
	private int identityNumber;
	
	@JsonIgnore
	@OneToMany(mappedBy="candidate")
	private List<Education> educations;
	
	@JsonIgnore
	@OneToMany(mappedBy="candidate")
	private List<JobExperience> jobExperiences;
	
	@JsonIgnore
	@OneToMany(mappedBy="candidate")
	private List<ForeignLanguage> foreignLanguages;
	
	@JsonIgnore
	@OneToMany(mappedBy="candidate")
	private List<ProgrammingLanguage> programmingLanguages;
	
	

}
