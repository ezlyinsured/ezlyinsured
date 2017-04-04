package co.com.fsighttech.imp.issuing.bo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Questionnaire {
	
	private Long   	id;
	private Long   	idGroup;
	private String	uniqueName;
	private List<Question> questions;
}
