package musalaAutomationTestcases;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.HomePage;

public class TestCase4 extends TestBase{
	HomePage homePageObject;
	@Test
	public void checkPositionsByCityTestcase()
	{
		homePageObject = new HomePage(driver);
		homePageObject.goToCareers();
		WebElement openpostionsButton = driver.findElement(By.xpath("//*[contains(text(),'Check our open positions')]"));
		openpostionsButton.click();
		assertEquals(driver.getCurrentUrl(),"https://www.musala.com/careers/join-us/");
		Select location = new Select(driver.findElement(By.id("get_location")));
		location.selectByValue("Sofia");
		
		System.out.println("Sofia");
		List<WebElement> jobsList = driver.findElements(By.xpath("//*[@class= 'card-jobsHot__title']"));
		List<WebElement> jobURLsList = driver.findElements(By.xpath("//*[@class= 'card-jobsHot__link']")); 
		int i = 0;
		while(i < jobsList.size()) {
		    String job = jobsList.get(i).getAttribute("data-alt");
			String jobURL = jobURLsList.get(i).getAttribute("href");
			System.out.println("position:"+job);
			System.out.println("More info:"+jobURL);
			i++;
								
		}
		
		location = new Select(driver.findElement(By.id("get_location")));
		location.selectByValue("Skopje");
		System.out.println("Skopje");
		List<WebElement> jobsList2 = driver.findElements(By.xpath("//*[@class= 'card-jobsHot__title']"));
		List<WebElement> jobURLsList2 = driver.findElements(By.xpath("//*[@class= 'card-jobsHot__link']")); 
		i = 0;
		while(i < jobsList2.size()) {
		    String job = jobsList2.get(i).getAttribute("data-alt");
			String jobURL = jobURLsList2.get(i).getAttribute("href");
			System.out.println("position:"+job);
			System.out.println("More info:"+jobURL);
			i++;
								
		}
		

	}
	

}
