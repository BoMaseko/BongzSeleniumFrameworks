package org.bongz.pages;

import org.bongz.enums.WaitStrategy;
import org.openqa.selenium.By;

public final class QuestionnairePage extends BasePage{
	
	//private final By startNowBtn = By.xpath("//button[text()='Start Now']"); 
	private final By restartBtn = By.xpath("(//button[@name='action'])[1]"); 
	private final By nextBtn = By.xpath("(//button[@class='btn btn-primary'])[2]"); 
	private final By q1A2 = By.xpath("//div[text()='Last test was completely normal']"); 
	private final By q2A2 = By.xpath("(//div[@class='ng-binding'])[2]"); 
	private final By q3A2 = By.xpath("(//span[@class='radio']/following-sibling::div)[2]"); 
	private final By q4A1 = By.xpath("(//label[contains(@class,'ng-binding ng-scope')])[1]"); 
	private final By q4A2 = By.xpath("(//label[contains(@class,'ng-binding ng-scope')])[2]"); 
	private final By q5A10 = By.xpath("//label[text()[normalize-space()='No, none']]");
	private final By q6A1 = By.xpath("(//label[@class='ng-scope questionnaire-answer']//div)[1]");
	private final By q7A5 = By.xpath("//div[text()='I smoke occasionally']");
	private final By q8A2 = By.xpath("//div[text()='I drink alcohol some days of the week']");
	private final By q9A2 = By.xpath("//div[text()='4-6 servings a week']");
	private final By q10A3 = By.xpath("(//div[@class='ng-binding'])[3]");
	private final By q11A2 = By.xpath("(//label[@class='ng-scope questionnaire-answer'])[2]");
	private final By q12A2 = By.xpath("(//div[@class='ng-binding'])[2]");
	private final By q13A1 = By.xpath("(//div[@class='ng-binding'])[1]");
	private final By q14A13 = By.xpath("//label[text()[normalize-space()='Nothing bothers my sleep']]");
	private final By q15AL = By.xpath("//label[text()[normalize-space()='No I have not']]");
	private final By q16A2 = By.xpath("(//div[@class='ng-binding'])[2]");
	private final By q17A1 = By.xpath("(//div[@class='ng-binding'])[1]");
	private final By q18A1 = By.xpath("(//label[contains(@class,'ng-scope questionnaire-answer')])[1]");
	private final By q19A2 = By.xpath("(//label[@class='ng-scope questionnaire-answer'])[2]");
	private final By q20A1 = By.xpath("(//div[@class='ng-binding'])[1]");
	private final By q21A2 = By.xpath("(//div[@class='ng-binding'])[2]");
	private final By q22A3 = By.xpath("(//label[@class='ng-scope questionnaire-answer'])[3]");
	private final By q23A2 = By.xpath("(//label[contains(@class,'ng-scope questionnaire-answer')])[2]");
	
	
	public QuestionnairePage startQuestionnaire()  {
		
		click(restartBtn, WaitStrategy.CLICKABLE, "Start Now");
		click(q1A2, WaitStrategy.CLICKABLE, "1st Que --> 2nd Answer");
		click(nextBtn, WaitStrategy.CLICKABLE, "Next");
		click(q2A2, WaitStrategy.CLICKABLE, "2nd Que --> 2nd Answer");
		click(nextBtn, WaitStrategy.CLICKABLE, "Next");
		click(q3A2, WaitStrategy.CLICKABLE, "3rd Que --> 2nd Answer");
		click(nextBtn, WaitStrategy.CLICKABLE, "Next");
		click(q4A1, WaitStrategy.CLICKABLE, "4th Que --> 1st Answer");
		click(q4A2, WaitStrategy.CLICKABLE, "4th Que --> 2nd Answer");
		click(nextBtn, WaitStrategy.CLICKABLE, "Next");
		click(q5A10, WaitStrategy.CLICKABLE, "5th Que --> Last Answer");
		click(nextBtn, WaitStrategy.CLICKABLE, "Next");
		click(q6A1, WaitStrategy.CLICKABLE, "6th Que --> 1st Answer");
		click(nextBtn, WaitStrategy.CLICKABLE, "Next");
		click(q7A5, WaitStrategy.CLICKABLE, "7th Que --> 5th Answer");
		click(nextBtn, WaitStrategy.CLICKABLE, "Next");
		click(q8A2, WaitStrategy.CLICKABLE, "8th Que --> 2nd Answer");
		click(nextBtn, WaitStrategy.CLICKABLE, "Next");
		click(q9A2, WaitStrategy.CLICKABLE, "9th Que --> 2nd Answer");
		click(nextBtn, WaitStrategy.CLICKABLE, "Next");
		click(q10A3, WaitStrategy.CLICKABLE, "10th Que --> 3rd Answer");
		click(nextBtn, WaitStrategy.CLICKABLE, "Next");
		click(q11A2, WaitStrategy.CLICKABLE, "11th Que --> 2nd Answer");
		click(nextBtn, WaitStrategy.CLICKABLE, "Next");
		click(q12A2, WaitStrategy.CLICKABLE, "12th Que --> 2nd Answer");
		click(nextBtn, WaitStrategy.CLICKABLE, "Next");
		click(q13A1, WaitStrategy.CLICKABLE, "13th Que --> 1st Answer");
		click(nextBtn, WaitStrategy.CLICKABLE, "Next");
		click(q14A13, WaitStrategy.CLICKABLE, "14th Que --> Last Answer");
		click(nextBtn, WaitStrategy.CLICKABLE, "Next");
		click(q15AL, WaitStrategy.CLICKABLE, "15th Que --> Last Answer");
		click(nextBtn, WaitStrategy.CLICKABLE, "Next");
		click(q16A2, WaitStrategy.CLICKABLE, "16th Que --> 2nd Answer");
		click(nextBtn, WaitStrategy.CLICKABLE, "Next");
		click(q17A1, WaitStrategy.CLICKABLE, "17th Que --> 1st Answer");
		click(nextBtn, WaitStrategy.CLICKABLE, "Next");
		click(q18A1, WaitStrategy.CLICKABLE, "18th Que --> 1st Answer");
		click(nextBtn, WaitStrategy.CLICKABLE, "Next");
		click(q19A2, WaitStrategy.CLICKABLE, "19th Que --> 2nd Answer");
		click(nextBtn, WaitStrategy.CLICKABLE, "Next");
		click(q20A1, WaitStrategy.CLICKABLE, "20th Que --> 1st Answer");
		click(nextBtn, WaitStrategy.CLICKABLE, "Next");
		click(q21A2, WaitStrategy.CLICKABLE, "20th Que --> 1st Answer");
		click(nextBtn, WaitStrategy.CLICKABLE, "Next");
		click(q22A3, WaitStrategy.CLICKABLE, "20th Que --> 1st Answer");
		click(nextBtn, WaitStrategy.CLICKABLE, "Next");
		click(q23A2, WaitStrategy.CLICKABLE, "20th Que --> 1st Answer");
		click(nextBtn, WaitStrategy.CLICKABLE, "Next");
		System.out.println("Congratulatioins on completing your Health Questionnaire!!");
		return this;
	}

}
