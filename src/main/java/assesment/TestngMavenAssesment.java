package assesment;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestngMavenAssesment {
	WebDriver driver;

	@BeforeMethod
	public void launchBrowser() {
		System.out.println("launching Chrome browser");
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/src/main/java/testdata/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.indiapost.gov.in");
	}

	@Test
	public void postalRedirection() {

		String landingPageUrl = "https://www.indiapost.gov.in/vas/Pages/IndiaPostHome.aspx";
		String curl=driver.getCurrentUrl();
		assertEquals(landingPageUrl, curl);

		
	}

	@AfterMethod
	public void quitDriver() {
		driver.quit();
		System.out.println("driver sessions are closed");
	}
}
