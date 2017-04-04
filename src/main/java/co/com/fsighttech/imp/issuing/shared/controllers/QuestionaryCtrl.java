/**
 * 
 */
package co.com.fsighttech.imp.issuing.shared.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.fsighttech.imp.issuing.bo.Questionnaire;
import co.com.fsighttech.imp.issuing.shared.services.api.IQuestionaryService;

/**
 * Controller to provide the set of questions and answer options configured to
 * quote a policy.
 * 
 * @author jtorres
 *
 */
@RestController
public class QuestionaryCtrl {

	@Autowired
	private IQuestionaryService questionaryService;

	/**
	 * expose a ws to get the configuration structure to identify the product to
	 * quote.
	 * 
	 * @return Questionnaire, set of questions
	 */
	@RequestMapping(value = "/questionnaire/{idGroup}/{questionaryName}", method = RequestMethod.GET)
	public Questionnaire getQuestionnaire(@PathVariable String idGroup, @PathVariable String questionaryName ) {

		//retrieving the questionnaire
		Questionnaire questionnaire =  questionaryService.getQuoteQuestionary(new Long (idGroup), questionaryName);
		
		return questionnaire;
	}
}
