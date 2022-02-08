package musalaAutomationTestcases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;



import Base.TestBase;
import Pages.ApplyJobPage;
import Pages.HomePage;

public class TestCase3 extends TestBase{
//01204444945
	HomePage homePageObject;
	ApplyJobPage applyJobPageObject; 
	@Test
	public void fillcareerFormTestCase() throws InterruptedException
	{
		homePageObject = new HomePage(driver);
		homePageObject.goToCareers();
		WebElement openpostionsButton = driver.findElement(By.xpath("//*[contains(text(),'Check our open positions')]"));
		openpostionsButton.click();
		assertEquals(driver.getCurrentUrl(),"https://www.musala.com/careers/join-us/");
		Select location = new Select(driver.findElement(By.id("get_location")));
		location.selectByValue("Sofia");
		WebElement AutomationJobLink = driver.findElement(By.xpath("//h2[text()='Experienced Automation QA Engineer']"));
		AutomationJobLink.click();
		assertEquals(driver.getCurrentUrl(),"https://www.musala.com/job/experienced-automation-qa-engineer/");
		assert(driver.getPageSource().contains("General description"));
		assert(driver.getPageSource().contains("Requirements"));
		assert(driver.getPageSource().contains("Responsibilities"));
		assert(driver.getPageSource().contains("What we offer"));
		
		//Thread.sleep("2000");
		WebElement apply = driver.findElement(By.xpath("//input[@type = 'button' and @value = 'Apply']"));
		assert(apply.isDisplayed());
		apply.click();
		applyJobPageObject = new ApplyJobPage(driver);
		
		applyJobPageObject.fillApplyJobForm("","Musala@hotmail.com","01096363566","test message");
		assert(driver.getPageSource().contains("The field is required"));
		applyJobPageObject.resetApplyForm();
		
		applyJobPageObject.fillApplyJobForm("candidate Name","","01096363566", "test message");
		assert(driver.getPageSource().contains("The field is required."));
		applyJobPageObject.resetApplyForm();
		
		applyJobPageObject.fillApplyJobForm("candidate Name","Musala@hotmail.com","", "test message" );
		assert(driver.getPageSource().contains("The field is required."));
		applyJobPageObject.resetApplyForm();
		
		applyJobPageObject.fillApplyJobForm("candidate Name","Musala@hotmail.com","01096363566", "" );
		assert(driver.getPageSource().contains("The field is required."));
		applyJobPageObject.resetApplyForm();
		
		applyJobPageObject.fillApplyJobForm("candidate Name","Test@Test","01096363566","test message" );
		assert(driver.getPageSource().contains("The e-mail address entered is invalid."));
		applyJobPageObject.resetApplyForm();
		
	}
	
}
