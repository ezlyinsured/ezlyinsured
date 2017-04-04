/**
 * 
 */
package co.com.fsighttech.imp.issuing.shared.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import co.com.fsighttech.imp.issuing.bo.EmailPage;
import co.com.fsighttech.imp.issuing.bo.NegativeEndPage;
import co.com.fsighttech.imp.issuing.bo.PositiveEndPage;
import co.com.fsighttech.imp.issuing.bo.ProductSelector;
import co.com.fsighttech.imp.issuing.bo.QuestionElm;
import co.com.fsighttech.imp.issuing.bo.QuestionRail;
import co.com.fsighttech.imp.issuing.bo.StartPage;
import co.com.fsighttech.imp.issuing.shared.services.api.IProductSelectorService;

/**
 * Service implementation that will provide services to the selector product
 * wizard.
 * 
 * @author jtorres
 *
 */

@Service
public class ProductSelectorService implements IProductSelectorService {

	@Override
	public ProductSelector getProductSelector(String idProduct) {
		
		ProductSelector prodSelector = new ProductSelector();
		
		//Creating the mock used for demo proposes
		
			//1. creating the start page
			StartPage startPage =  new StartPage();
			startPage.setNotShureText("I'm not sure. Is BOP the right choice for me?");
			startPage.setProductLink("quotation/bop");
			startPage.setStartButtonText("Start");
			startPage.setTitleText("Welcome! Would you like to look for the best Business Owners Policy for your company");
			prodSelector.setStartPage(startPage);
			
			//2. creating the questions rail
			QuestionRail questionRail = new QuestionRail();
			questionRail.setIdkText("I don't know");
			questionRail.setNoText("No");
			questionRail.setYesText("Yes");
			
			//creating questions list
			QuestionElm question1 = new QuestionElm();
			question1.setId(1L);
			question1.setTitleText("Lets see if BOP is the right choice for you and your company.");
			question1.setQuestionText("Placeholder for question 1?");
			question1.setOnYes(2L);
			question1.setOnNo(4L);
			question1.setOnIdk(4L);
			
			QuestionElm question2 = new QuestionElm();
			question2.setId(2L);
			question2.setTitleText("Lets see if BOP is the right choice for you and your company");
			question2.setQuestionText("Placeholder for question 2?");
			question2.setOnYes(3L);
			question2.setOnNo(4L);
			question2.setOnIdk(4L);
			
			QuestionElm question3 = new QuestionElm();
			question3.setId(3L);
			question3.setTitleText("Lets see if BOP is the right choice for you and your company");
			question3.setQuestionText("Placeholder for question 3?");
			question3.setOnYes(-1L);
			question3.setOnNo(4L);
			question3.setOnIdk(4L);
			
			QuestionElm question4 = new QuestionElm();
			question4.setId(4L);
			question4.setTitleText("Lets see if BOP is the right choice for you and your company");
			question4.setQuestionText("Placeholder for question 4?");
			question4.setOnYes(-1L);
			question4.setOnNo(-2L);
			question4.setOnIdk(-2L);
			
			List<QuestionElm> questionList =  new ArrayList<QuestionElm>();
			questionList.add(question1);
			questionList.add(question2);
			questionList.add(question3);
			questionList.add(question4);
			
			questionRail.setQuestions(questionList);
			prodSelector.setQuestionRail(questionRail);
			
			//3. creating the positive page
			PositiveEndPage positiveEndPage = new PositiveEndPage();
			positiveEndPage.setTitleText("According to your answers, we think BOP is the right choice for you.");
			positiveEndPage.setLetsGoButtonText("GREAT, LETS GO");
			positiveEndPage.setNoThanksText("No, thanks.");
			positiveEndPage.setProductLink("quotation/bop");
			prodSelector.setPositiveEndPage(positiveEndPage);
			
			
			//4. creating the negative page
			NegativeEndPage negativeEndPage = new NegativeEndPage();
			negativeEndPage.setTitleText("According to your answers, we don't think BOP is the right choice for you.");
			negativeEndPage.setGoAnywayText("Would you like to look for one anyway?");
			negativeEndPage.setWhyNotButtonText("SURE, WHY NOT?");
			negativeEndPage.setProductLink("quotation/bop");
			negativeEndPage.setNoThanksText("No, thanks.");
			prodSelector.setNegativeEndPage(negativeEndPage);
			
			//5. creating the emailPage to inform
			EmailPage emailPage = new EmailPage();
			emailPage.setTitleText("Sorry, we are currently only offering Business Owner Policies.");
			emailPage.setOfferNotifyText("If you would like to be notified when we will offer more policies please enter your email below?");
			prodSelector.setEmailPage(emailPage);
			
		return prodSelector;
	}

}
