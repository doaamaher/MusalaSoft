package musalaAutomationTestcases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.HomePage;

public class TestCase2 extends TestBase{
	
	HomePage homePageObject;
	@Test
	public void openCompanyProfileTestCase() throws InterruptedException
	{
//		homePageObject = new HomePage(driver);
		Thread.sleep(2000);
		homePageObject.goToCompany();
		assertEquals(driver.getTitle(),"Musala Soft | Musala Soft");
		assert(driver.getPageSource().contains("Leadership"));
		assert(driver.findElement(By.xpath("//section[@class='company-members']")).isDisplayed());
		driver.findElement(By.xpath("//*[@class='musala musala-icon-facebook']")).click();
		Thread.sleep(5000);
		String musalaSiteWindow = driver.getWindowHandle();

		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}

		String URL = driver.getCurrentUrl();
		assertEquals(URL, "https://www.facebook.com/MusalaSoft?fref=ts" );
		assertEquals(driver.getTitle(), "Musala Soft - Home | Facebook");
		WebElement musalaImage = driver.findElement(By.xpath("//image[@xlink:href='https://scontent.fcai2-2.fna.fbcdn.net/v/t1.6435-1/p148x148/158325737_3926723744014946_1132226306152824042_n.jpg?_nc_cat=100&ccb=1-5&_nc_sid=1eb0c7&_nc_ohc=bRr3kuWOM0IAX_RWR61&_nc_ht=scontent.fcai2-2.fna&oh=00_AT9YtTXjsoq-dgOQL_2JixlwBCuNxsvHspSjKATkMxnL0A&oe=6224EF44']"));
		assert(musalaImage.isDisplayed());
		
		driver.switchTo().window(musalaSiteWindow);
		
	}

}
