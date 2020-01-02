import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserTest {

	private static String TAB_URL = "https://www.tab.co.nz";
	
	public static void main(String[] args) {
		
		/*
		String projPath = System.getProperty("user.dir");
		System.out.println(projPath);
		
		
		System.setProperty("webdriver.chrome.driver", projPath+"//Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.tab.co.nz");
		*/
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get(TAB_URL);
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement signUp = driver.findElement(By.className("sign-up"));
		
		signUp.click();
		//driver.close();
		//driver.quit();
	}
	
}
