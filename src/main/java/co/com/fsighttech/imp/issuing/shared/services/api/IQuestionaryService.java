/**
 * 
 */
package co.com.fsighttech.imp.issuing.shared.services.api;

import co.com.fsighttech.imp.issuing.bo.Questionnaire;

/**
 * Service Interface that will provide services to the selector product wizard
 * 
 * @author jtorres
 *
 */
public interface IQuestionaryService {

	public Questionnaire getQuoteQuestionary (Long idGroup, String questionaryName);
}
