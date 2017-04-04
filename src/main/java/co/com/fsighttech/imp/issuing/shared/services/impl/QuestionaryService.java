/**
 * 
 */
package co.com.fsighttech.imp.issuing.shared.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import co.com.fsighttech.imp.issuing.bo.AnswerOption;
import co.com.fsighttech.imp.issuing.bo.Question;
import co.com.fsighttech.imp.issuing.bo.Questionnaire;
import co.com.fsighttech.imp.issuing.shared.services.api.IQuestionaryService;

/**
 * Service implementation that will provide services to get set of questions for
 * policy operations
 * 
 * @author jtorres
 *
 */
@Service
public class QuestionaryService implements IQuestionaryService {

	/**
	 * retrieve a questionary to quote a policy given idGroup and idQuestionary
	 * 
	 * @param idGroup,
	 *            in insurance context it is referred to the business line
	 * @param idQuestionary,
	 *            refers to the set of questions.
	 * @return Questionary, set of questions and answer options to quote a
	 *         policy.
	 */
	public Questionnaire getQuoteQuestionary(Long idGroup, String questionaryName) {

		Questionnaire questionnaire = new Questionnaire();
		List<Question> questions = new ArrayList<Question>();

		// Creating the mock used for demo proposes

		// 1. associating the information
		questionnaire.setId(1L);
		questionnaire.setIdGroup(idGroup);
		questionnaire.setUniqueName(questionaryName);

		// 2. creating set of questions

		// 2a. creating set of questions
		Question question1 = new Question();

		question1.setId(1L);
		question1.setTitleText("Tell us some things about your business!");
		question1.setQuestionText("What is your business's ZIP code?");
		question1.setTemplate("OP");
		question1.setQuestionType("S");
		question1.setTarget("policy.fixData");
		question1.setHelp(false);
		question1.setContentHelp("<h1><h1/>");

		// associating the answer options

		List<AnswerOption> answerOptions = new ArrayList<AnswerOption>();

		AnswerOption answerOp1 = new AnswerOption();
		answerOp1.setId(1L);
		answerOp1.setContent("Zip Code");
		answerOp1.setHelp(false);
		answerOp1.setContentHelp("<h1><h1/>");
		answerOptions.add(answerOp1);
		question1.setAnswerOptions(answerOptions);
		questions.add(question1);

		// 2c. creating set of questions
		question1 = new Question();

		question1.setId(3L);
		question1.setTitleText("");
		question1.setQuestionText("What is your industry?");
		question1.setTemplate("RB");
		question1.setQuestionType("S");
		question1.setTarget("policy.fixData");
		question1.setHelp(false);
		question1.setContentHelp("<h1><h1/>");

		// associating the answer options

		answerOptions = new ArrayList<AnswerOption>();

		answerOp1 = new AnswerOption();
		answerOp1.setId(1L);
		answerOp1.setContent("INDUSTRY A");
		answerOp1.setHelp(false);
		answerOp1.setContentHelp("");
		answerOptions.add(answerOp1);

		answerOp1 = new AnswerOption();
		answerOp1.setId(2L);
		answerOp1.setContent("INDUSTRY B");
		answerOp1.setHelp(false);
		answerOp1.setContentHelp("");
		answerOptions.add(answerOp1);

		answerOp1 = new AnswerOption();
		answerOp1.setId(3L);
		answerOp1.setContent("IT CONSULTING");
		answerOp1.setHelp(false);
		answerOp1.setContentHelp("");
		answerOptions.add(answerOp1);

		answerOp1 = new AnswerOption();
		answerOp1.setId(4L);
		answerOp1.setContent("INDUSTRY C");
		answerOp1.setHelp(false);
		answerOp1.setContentHelp("");
		answerOptions.add(answerOp1);

		answerOp1 = new AnswerOption();
		answerOp1.setId(5L);
		answerOp1.setContent("INDUSTRY D");
		answerOp1.setHelp(false);
		answerOp1.setContentHelp("");
		answerOptions.add(answerOp1);

		answerOp1 = new AnswerOption();
		answerOp1.setId(6L);
		answerOp1.setContent("INDUSTRY E");
		answerOp1.setHelp(false);
		answerOp1.setContentHelp("");
		answerOptions.add(answerOp1);

		answerOp1 = new AnswerOption();
		answerOp1.setId(7L);
		answerOp1.setContent("INDUSTRY F");
		answerOp1.setHelp(false);
		answerOp1.setContentHelp("");
		answerOptions.add(answerOp1);

		answerOp1 = new AnswerOption();
		answerOp1.setId(8L);
		answerOp1.setContent("INDUSTRY G");
		answerOp1.setHelp(false);
		answerOp1.setContentHelp("");
		answerOptions.add(answerOp1);
		question1.setAnswerOptions(answerOptions);
		questions.add(question1);

		// 2b. creating set of questions
		question1 = new Question();

		question1.setId(2L);
		question1.setTitleText("");
		question1.setQuestionText("How many employees do you have?");
		question1.setTemplate("RB");
		question1.setQuestionType("S");
		question1.setTarget("policy.fixData");
		question1.setHelp(false);
		question1.setContentHelp("<h1><h1/>");

		// associating the answer options

		answerOptions = new ArrayList<AnswerOption>();

		answerOp1 = new AnswerOption();
		answerOp1.setId(1L);
		answerOp1.setContent("1-4");
		answerOp1.setHelp(false);
		answerOp1.setContentHelp("");
		answerOptions.add(answerOp1);

		answerOp1 = new AnswerOption();
		answerOp1.setId(2L);
		answerOp1.setContent("5-10");
		answerOp1.setHelp(false);
		answerOp1.setContentHelp("");
		answerOptions.add(answerOp1);

		answerOp1 = new AnswerOption();
		answerOp1.setId(3L);
		answerOp1.setContent("11-50");
		answerOp1.setHelp(false);
		answerOp1.setContentHelp("");
		answerOptions.add(answerOp1);

		answerOp1 = new AnswerOption();
		answerOp1.setId(4L);
		answerOp1.setContent("51-100");
		answerOp1.setHelp(false);
		answerOp1.setContentHelp("");
		answerOptions.add(answerOp1);

		answerOp1 = new AnswerOption();
		answerOp1.setId(5L);
		answerOp1.setContent("101-200");
		answerOp1.setHelp(false);
		answerOp1.setContentHelp("");
		answerOptions.add(answerOp1);

		answerOp1 = new AnswerOption();
		answerOp1.setId(6L);
		answerOp1.setContent("201-500");
		answerOp1.setHelp(false);
		answerOp1.setContentHelp("");
		answerOptions.add(answerOp1);

		answerOp1 = new AnswerOption();
		answerOp1.setId(7L);
		answerOp1.setContent("501-1000");
		answerOp1.setHelp(false);
		answerOp1.setContentHelp("");
		answerOptions.add(answerOp1);

		answerOp1 = new AnswerOption();
		answerOp1.setId(8L);
		answerOp1.setContent("More than 1000");
		answerOp1.setHelp(false);
		answerOp1.setContentHelp("");
		answerOptions.add(answerOp1);
		question1.setAnswerOptions(answerOptions);
		questions.add(question1);

		// 2d. creating question
		question1 = new Question();

		question1.setId(4L);
		question1.setTitleText("");
		question1.setQuestionText(
				"Great, now lets g through the basic policy coverages. Which ones would you like to include?");
		question1.setTemplate("CL");
		question1.setQuestionType("M");
		question1.setTarget("policyvariabledata");
		question1.setHelp(false);
		question1.setContentHelp("<h1><h1/>");

		// associating the answer options

		answerOptions = new ArrayList<AnswerOption>();

		answerOp1 = new AnswerOption();
		answerOp1.setId(1L);
		answerOp1.setContent("Equipment Breakdown");
		answerOp1.setHelp(true);
		answerOp1.setContentHelp("<h1>Equipment Breakdown 75% of IT CONSULTING companies choose this coverage.<h1/>");
		answerOptions.add(answerOp1);

		answerOp1 = new AnswerOption();
		answerOp1.setId(2L);
		answerOp1.setContent("Data Compromise - Identity Recovery Coverage");
		answerOp1.setHelp(true);
		answerOp1.setContentHelp(
				"<h1>Identity Recovery Coverage 81% of IT CONSULTING companies choose this coverage.<h1/>");
		answerOptions.add(answerOp1);

		answerOp1 = new AnswerOption();
		answerOp1.setId(3L);
		answerOp1.setContent("CiberOne Liability");
		answerOp1.setHelp(false);
		answerOp1.setContentHelp("<h1>CiberOne Liability 69% of IT CONSULTING companies choose this coverage.<h1/>");
		answerOptions.add(answerOp1);
		question1.setAnswerOptions(answerOptions);
		questions.add(question1);
		
		//association the questions to the questionnaire
		questionnaire.setQuestions(questions);
		
		return questionnaire;

	}
}
