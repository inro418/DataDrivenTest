package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SignInTest {
	WebDriver driver;

	@Test(dataProvider = "icelandTest") 
	public void SignIn_Test(String username, String password) { 
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\koree\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get("https://www.iceland.co.uk/");

		WebElement SignInLink = driver.findElement(By.xpath("//*[@id='wrapper']/header/div[1]/div/ul/li[3]/a[2]"));
		SignInLink.click();

		WebElement EmailAddress = driver.findElement(By.name("dwfrm_login_username"));
		EmailAddress.sendKeys(username);

		WebElement Password = driver.findElement(By.name("dwfrm_login_password"));
		Password.sendKeys(password);

		WebElement SignInButton = driver.findElement(By.name("dwfrm_login_login"));
		SignInButton.click();

		driver.quit();
	}

	@DataProvider(name = "icelandTest")
	public Object[][] getData() {
		Object[][] data = new Object[6][2];

		data[0][0] = "intro4ebony@yahoo.com";
		data[0][1] = "isuA4188";

		data[1][0] = "intro4eboy@yahoo.com";
		data[1][1] = "isuA1888";

		data[2][0] = "intro4ebony@yahoo.com";
		data[2][1] = "isuA41588";

		data[3][0] = "intro4ebonyr@yahoo.com";
		data[3][1] = "isuA4188";

		data[4][0] = "intro4ebony@yahoo.com";
		data[4][1] = "isuA41688";

		data[5][0] = "intro4ebuony@yahoo.com";
		data[5][1] = "isuA41u88";
		
		return data;
	}
}