package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Base.PageBase;

public class HomePage extends PageBase{
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	By contactUsButton = By.xpath("//*[contains(text(),'Contact us')]");
	By companyLink = By.linkText("COMPANY");
	By careersLink = By.linkText("CAREERS");
	
	public void goToContactUs()
	{
		driver.findElement(contactUsButton).click();
	}
	
	public void goToCompany()
	{
		driver.findElement(companyLink).click();
	}

	public void goToCareers()
	{
		driver.findElement(careersLink).click();
	}
}
