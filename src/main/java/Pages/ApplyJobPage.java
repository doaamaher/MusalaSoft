package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Base.PageBase;

public class ApplyJobPage extends PageBase{

	public ApplyJobPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By nameTxt = By.name("your-name");
	By emailTxt = By.name("your-email");
	By mobileTxt = By.name("mobile-number");
	By cvFileUpload = By.name("uploadtextfield");
	By linkedinTxt = By.name("linkedin");
	By contactMsgTxt = By.name("your-message");
	By sendButton = By.xpath("//input[@value = 'Send']");

	
	public void fillApplyJobForm(String name,String email, String mobile, String msg) throws InterruptedException
	{
		
		driver.findElement(nameTxt).sendKeys(name);
		driver.findElement(emailTxt).sendKeys(email);
		driver.findElement(mobileTxt).sendKeys(mobile);
		driver.findElement(contactMsgTxt).sendKeys(msg);
		
		driver.findElement(cvFileUpload).sendKeys(".\\resources\\Doaa Maher Hassan abbreviated.pdf");
		
		driver.findElement(sendButton).click();
		
		driver.findElement(By.xpath("//button[@class ='close-form']")).click();
		Thread.sleep(2000);
		//document.getElementById('form').reset()


				
	}

	public void resetApplyForm()
	{
		//driver.findElements(By.tagName("input")).forEach(WebElement::clear);
		
		//driver.findElements(By.xpath("//input[text()!='Experienced Automation QA Engineer']")).forEach(WebElement::clear);
		driver.findElement(nameTxt).clear();
		driver.findElement(emailTxt).clear();
		driver.findElement(mobileTxt).clear();
		driver.findElement(contactMsgTxt).clear();
		driver.findElement(cvFileUpload).clear();
				
	}
}
