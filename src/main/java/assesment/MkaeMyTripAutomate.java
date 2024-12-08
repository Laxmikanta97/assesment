package assesment;

import java.awt.AWTException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MkaeMyTripAutomate {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/src/main/java/testdata/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("http://makemytrip.com");
		driver.manage().window().maximize();

		Thread.sleep(3000);

		List<WebElement> closeModal = driver.findElements(By.cssSelector("span.commonModal__close"));

		if (closeModal.size() > 0) {

			closeModal.get(0).click();

		}
		driver.findElement(By.xpath("//span[text()='Flights']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[@data-cy='roundTrip']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='fromCity']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("HYD");
		Actions act = new Actions(driver);
		act.pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

		driver.findElement(By.xpath("//input[@id='toCity']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("MAA");
		act.pause(Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).sendKeys(Keys.ESCAPE).build()
				.perform();

		WebElement deptDateOnclick = driver.findElement(By.cssSelector("p[data-cy='departureDate']"));
		Thread.sleep(3000);
		deptDateOnclick.click();

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[@aria-selected='true'][@aria-disabled='false'])[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='DayPicker-Day'])[1]"))).click();

		WebElement serachbtn = driver.findElement(By.xpath("//a[contains(@class,'widgetSearchBtn')]"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].click();", serachbtn);

		// rest steps are blocked by make my trip ,getting "NETWORK PROBLEMWe are unable
		// to connect to our systems from your device. Please try again after a while"
		WebElement okGotItButton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='OKAY, GOT IT!']")));
		okGotItButton.click();
		// rest steps are blocked by make my trip ,getting "NETWORK PROBLEMWe are unable
		// to connect to our systems from your device. Please try again after a while"
	}

}
