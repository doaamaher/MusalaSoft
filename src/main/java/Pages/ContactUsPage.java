package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Base.PageBase;

public class ContactUsPage extends PageBase{

	public ContactUsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By contactNameTxt = By.name("your-name");
	By contactEmailTxt = By.name("your-email");
	By contactMobileTxt = By.name("mobile-number");
	By contactSubjectTxt = By.name("your-subject");
	By contactMsgTxt = By.name("your-message");
	By sendButton = By.xpath("//input[@value = 'Send']");
	By invalidEmailErrorMsg = By.xpath("//*[contains(text(), 'The e-mail address entered is invalid.')]");
	String  invalidEmailMsg = "The e-mail address entered is invalid.";
	public void fillContactUs(String email)
	{
		driver.findElement(contactNameTxt).sendKeys("test name");
		driver.findElement(contactEmailTxt).sendKeys(email);
		//driver.findElement(contactMobileTxt).sendKeys(keysToSend);
		driver.findElement(contactSubjectTxt).sendKeys("test subject");
		driver.findElement(contactMsgTxt).sendKeys("test message");
		driver.findElement(sendButton).click();
					
	}
	
	public void resetContactUs()
	{
		driver.findElement(contactNameTxt).clear();
		driver.findElement(contactEmailTxt).clear();
		//driver.findElement(contactMobileTxt).sendKeys(keysToSend);
		driver.findElement(contactSubjectTxt).clear();
		driver.findElement(contactMsgTxt).clear();
		
	}
	
}
