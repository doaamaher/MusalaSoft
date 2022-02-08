package musalaAutomationTestcases;

import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import Base.TestBase;
import Pages.ContactUsPage;
import Pages.HomePage;


public class Testcase1 extends TestBase{
		
	HomePage homePageObject;
	ContactUsPage contactUsPageObject;
	CSVReader reader;
	@Test
	public void ContactUsInvalidEmailTestCase() throws InterruptedException, CsvValidationException, IOException
	{
		 homePageObject = new HomePage(driver);
		 contactUsPageObject = new ContactUsPage(driver);
		 homePageObject.goToContactUs();
		 
		
		System.out.println("hi");
		String testDataFilePath = System.getProperty("user.dir")+"/resources/TestData.csv";
		try {
			reader = new CSVReader(new FileReader(testDataFilePath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String[] csvCell;
		while((csvCell = reader.readNext()) != null)
		{
			String email = csvCell[0];
			contactUsPageObject.fillContactUs(email);
			 //WebElement errorMsg = driver.findElement(By.xpath("//*[contains(text(), 'The e-mail address entered is invalid.')]"));
			 Thread.sleep(2000);
			 assertTrue(driver.getPageSource().contains("The e-mail address entered is invalid."));
			 contactUsPageObject.resetContactUs();
		}
		
		 
	}
}
