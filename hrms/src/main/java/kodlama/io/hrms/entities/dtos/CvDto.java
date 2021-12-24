package kodlama.io.hrms.entities.dtos;



import kodlama.io.hrms.entities.concretes.Candidate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CvDto {
	
	
	
	private Candidate candidate;
	private String jobFirmName;
	private String jobPosition;
	private String foreignLanguageName;
	private int foreignLanguageLevel;
	private String educationSchoolName;
	private String educationDepartment;
	private String programmingLanguageName;
	private int programmingLanguageLevel;
}
