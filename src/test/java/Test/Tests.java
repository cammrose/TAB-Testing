package Test;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import Pages.Locators;

/**
 * Test suite using Java, Selenium, Webdriver and TestNG
 * to run a variety of tests on five different use cases 
 * within tab.co.nz.
 * @author camm_rose
 */
public class Tests {

	private static String TAB_URL = "https://www.tab.co.nz";
	private static WebDriver driver;
	
	/**
	 * Loads and creates a new driver object for a Google
	 * Chrome browser.
	 * @param size	Size of the browser to load
	 */
	private void loadChromeDriver(String size, String url) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments(size);
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		
		driver.get(url);
	}
	
	/**
	 * Loads and creates a new driver object for a Firefox browser.
	 * @param size	Size of the browser to load
	 */
	private void loadFirefoxDriver(String size) {
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments(size);
		
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver(options);
		
		driver.get(TAB_URL);
	}
	
	/**
	 * Closes the driver object
	 */
	private void closeDriver() {
		driver.close();
	}

	/**
	 * Tests registering a new account by filling in all the required 
	 * details and information after pressing the 'join now' button on
	 * the home page. The console asks for a few quick details for testing 
	 * purposes so that a new account is created every time rather than getting
	 * duplicate account issues
	 */
	@Test
	private void testRegister() {
		
		loadChromeDriver("--start-fullscreen", TAB_URL);
		
		//Gather some basic account information for testing purposes so that the account hasn't already been created
		Scanner scan = new Scanner(System.in);  
		System.out.print("First Name: ");
		String fname = scan.next();
		
		scan = new Scanner(System.in);
		System.out.print("Last Name: ");
		String lname = scan.next();
		
		scan = new Scanner(System.in);
		System.out.print("Email Address: ");
		String email = scan.next();
		
		scan = new Scanner(System.in);
		System.out.print("Username: ");
		String username = scan.next();
		
		//Wait for site to load
		wait(5);
		
		//Press join now button
		Locators.joinNow(driver).click();
		
		wait(1);
		
		//Press lets get started button
		Locators.letsGetStarted(driver).click();
		
		//Page1 details
		Locators.firstName(driver).sendKeys(fname);
		Locators.middleName(driver).sendKeys("Martin");
		Locators.lastName(driver).sendKeys(lname);
		Locators.dateOfBirth(driver).sendKeys("08/07/1996");
		Locators.continueBtn(driver).click();
		
		//Page2 details
		Locators.emailAddress(driver).sendKeys(email);
		Locators.phoneNumber(driver).sendKeys("027 123 4567");
		Locators.manualAddress(driver).click();
		Locators.addressLine1(driver).sendKeys("3 Naureen Palmer Grove");
		Locators.suburb(driver).sendKeys("Aotea");
		Locators.city(driver).sendKeys("Porirua");
		Locators.postcode(driver).sendKeys("5024");
		Locators.continueBtn(driver).click();
		
		//Page3 details
		Locators.identity(driver).click();
		Locators.continueBtn(driver).click();
		
		//Page4 details
		Locators.industry(driver).selectByVisibleText("Information Media and Telecommunications");
		Locators.occupation(driver).sendKeys("Software Tester");
		Locators.bettingFrequency(driver).selectByVisibleText("Seasonally");
		Locators.betSize(driver).selectByVisibleText("Below $100");
		Locators.paymentMethod(driver).selectByVisibleText("Credit or debit card");
		Locators.bettingInterests(driver).click();
		Locators.continueBtn(driver).click();
		
		//Page5 details
		Locators.username(driver).sendKeys(username);
		Locators.password(driver).sendKeys("Test123*");
		Locators.pin(driver).sendKeys("1998");
		Locators.mothersMaidenName(driver).sendKeys("Bloggs");
		Locators.termsAndConditions(driver).click();
		Locators.continueBtn(driver).click();
		
		wait(2);
		
		if(!Locators.accountConfirmation(driver).getText().equals("You have successfully registered your new account.")) {
			org.testng.Assert.fail("Account not created");
		}
		
		//Close registration confirmation
		Locators.closeBtn(driver).click();
		
		wait(2);
		
		closeDriver();
	}
	
	/**
	 * Tests logging into a pre-existing account and then immediately
	 * logging out of that account.
	 */
	@Test (dependsOnMethods={"testRegister"})
	private void testLoginLogout() {
		
		loadChromeDriver("--start-fullscreen", TAB_URL);
		
		//Wait for site to load
		wait(5);
		
		//Click on 'log in' button
		Locators.signIn(driver).click();
		
		wait(1);
		
		//Add login credentials and click the log in button
		Locators.usernameSignin(driver).sendKeys("rose_camm");
		Locators.passwordSignin(driver).sendKeys("Test123*");
		Locators.loginBtn(driver).click();
		
		wait(2);
		
		//Click on drop down
		Locators.userMenu(driver).click();
		
		wait(1);
		
		//Press signout button
		Locators.signoutBtn(driver).click();
		
		wait(1);
		
		closeDriver();
	}
	
	/**
	 * Tests placing a single bet after logging in.
	 * The specific bet that is being tested is New Zealand
	 * to beat England in the 2nd cricket test match.
	 */
	@Test (dependsOnMethods={"testLoginLogout"})
	private void testSingleBet() {
		
		loadChromeDriver("--start-fullscreen", "https://www.tab.co.nz/sports/event/264916/new-zealand-v-england");
		
		//Wait for site to load
		wait(5);
		
		//Sign into account
		Locators.signIn(driver).click();
		wait(1);
		Locators.usernameSignin(driver).sendKeys("rose_camm");
		Locators.passwordSignin(driver).sendKeys("Test123*");
		Locators.loginBtn(driver).click();
		
		wait(2);
		
		//Add New Zealand to win to the bet slip
		Locators.nzToWin(driver).click();
		
		wait(2);
		
		//Add a bet amount of $0.5
		Locators.singleBetAmount(driver).sendKeys("0.5");
		
		wait(1);
		
		//Click place bet
		Locators.placeBetBtn(driver).click();
		
		wait(1);
		
		//Click again to confirm the bet
		Locators.confirmBet(driver).click();
		
		wait(3);
		
		if(!Locators.successfulBet(driver).getText().equals("Bet Placed Successfully")) {
			org.testng.Assert.fail("Bet not placed successfully");
		}

		wait(3);
		
		closeDriver();
		
	}
	
	/**
	 * Tests attempting to place a single bet after logging in with 
	 * a value of $100. The bet should not be placed due to the user
	 * having insufficient funds.
	 */
	@Test (dependsOnMethods={"testSingleBet"})
	private void testFailedSingleBet() {
		
		loadChromeDriver("--start-fullscreen", "https://www.tab.co.nz/sports/event/264916/new-zealand-v-england");
		
		//Wait for site to load
		wait(5);
		
		//Sign into account
		Locators.signIn(driver).click();
		wait(1);
		Locators.usernameSignin(driver).sendKeys("rose_camm");
		Locators.passwordSignin(driver).sendKeys("Test123*");
		Locators.loginBtn(driver).click();
		
		wait(2);
		
		//Add New Zealand to win to the bet slip
		Locators.nzToWin(driver).click();
		
		wait(2);
		
		//Add a bet amount of $0.5
		Locators.singleBetAmount(driver).sendKeys("100");
		
		wait(1);
		
		//Click place bet
		Locators.placeBetBtn(driver).click();
		
		wait(1);
		
		//Click again to confirm the bet
		Locators.confirmBet(driver).click();
		
		wait(3);
		
		if(!Locators.successfulBet(driver).getText().equals("You have insufficient funds to place your bet. Please top up or amend stake values.")) {
			org.testng.Assert.fail("Placed bet when user has insufficient funds.");
		}

		wait(3);
		
		closeDriver();
	}
	
	/**
	 * Tests attempting to place a single bet after not logging in.
	 * An appropriate message should show, telling the user they can't
	 * place the bet because they aren't logged in.
	 */
	@Test (dependsOnMethods={"testFailedSingleBet"})
	private void testNotLoggedInBet() {
		
		loadChromeDriver("--start-fullscreen", "https://www.tab.co.nz/sports/event/264916/new-zealand-v-england");
		
		//Wait for site to load
		wait(5);
		
		//Add New Zealand to win to the bet slip
		Locators.nzToWin(driver).click();
		
		wait(2);
		
		//Add a bet amount of $0.5
		Locators.singleBetAmount(driver).sendKeys("100");
		
		wait(1);
		
		//Click place bet
		Locators.placeBetBtn(driver).click();
		
		wait(1);
		
		//Click again to confirm the bet
		Locators.confirmBet(driver).click();
		
		wait(3);
		
		if(!Locators.successfulBet(driver).getText().equals("You must be signed in to perform that action.")) {
			org.testng.Assert.fail("Placed bet when user wasn't logged in.");
		}

		wait(3);
		
		closeDriver();
	}
	
	/**
	 * Tests placing a multi bet after logging in.
	 * The bets that are included in the multi are 
	 * Man City, Chelsea, Spurs and Man Utd all to win
	 * in gameweek 14 in the English Premier League.
	 */
	@Test (dependsOnMethods={"testNotLoggedInBet"})
	private void testMultiBet() {
		
		loadChromeDriver("--start-fullscreen", "https://www.tab.co.nz/sports/competition/6815/test-matches/matches");
		
		//Wait for site to load
		wait(5);
				
		//Sign into account
		Locators.signIn(driver).click();
		wait(1);
		Locators.usernameSignin(driver).sendKeys("rose_camm");
		Locators.passwordSignin(driver).sendKeys("Test123*");
		Locators.loginBtn(driver).click();
		
		wait(5);
		
		//Add Man City, Chelsea, Spurs and Man Utd to the betslip for the multi
		Locators.addManCity(driver).click();
		Locators.addChelsea(driver).click();
		Locators.addSpurs(driver).click();
		Locators.addManUtd(driver).click();
		
		wait(2);
		
		//Add a bet amount of $0.5
		Locators.multiBetAmount(driver).sendKeys("0.5");
		
		wait(1);
		
		//Click place bet
		Locators.placeBetBtn(driver).click();
		
		wait(1);
		
		//Click again to confirm the bet
		Locators.confirmBet(driver).click();
		
		wait(1);
		
		if(!Locators.successfulBet(driver).getText().equals("Bet Placed Successfully")) {
			org.testng.Assert.fail("Bet not placed successfully");
		}
		
		wait(3);
		
		closeDriver();
		
	}
	
	/**
	 * Tests removing a whole bet slip by adding 4 games 
	 * to the multi and then pressing the clear betslip
	 * button.
	 */
	@Test (dependsOnMethods={"testMultiBet"})
	private void testRemoveBetslip() {
		
		loadChromeDriver("--start-fullscreen", "https://www.tab.co.nz/sports/competition/6815/test-matches/matches");
		
		//Wait for site to load
		wait(5);
				
		//Sign into account
		Locators.signIn(driver).click();
		wait(1);
		Locators.usernameSignin(driver).sendKeys("rose_camm");
		Locators.passwordSignin(driver).sendKeys("Test123*");
		Locators.loginBtn(driver).click();
		
		wait(5);
		
		//Add Man City, Chelsea, Spurs and Man Utd to the betslip for the multi
		Locators.addManCity(driver).click();
		Locators.addChelsea(driver).click();
		Locators.addSpurs(driver).click();
		Locators.addManUtd(driver).click();
		
		wait(2);
		
		Locators.deleteBetSlip(driver).click();
		
		wait(2);
		
		closeDriver();
		
	}
	
	/**
	 * Tests navigating through the website with a smaller sized 
	 * form factor of 360x640, which would be somewhat of a simulation
	 * of a Phone.
	 */
	@Test (dependsOnMethods={"testRemoveBetslip"})
	private void testChromeSmallFormFactor() {
		loadChromeDriver("--window-size=360,640", TAB_URL);
		
		//Wait for site to load
		wait(5);
		
		Locators.sportBtn(driver).click();
		
		wait(1);
		
		Locators.quickMultiBtn(driver).click();
		
		wait(1);
		
		Locators.topQuicklinksBtn(driver).click();
		
		wait(1);
		
		Locators.homeBtn(driver).click();
		
		wait(1);
		
		Locators.racingBtn(driver).click();
		
		wait(1);
		
		Locators.pick6Btn(driver).click();
		
		wait(1);
		
		Locators.homeBtn(driver).click();
		
		wait(1);
		
		closeDriver();
	}
	
	/**
	 * Tests navigating through the website with a larger sized 
	 * form factor of 1000x700, which would be somewhat of a simulation
	 * of a Tablet/IPad.
	 */
	@Test (dependsOnMethods={"testChromeSmallFormFactor"})
	private void testChromeLargeFormFactor() {
		loadChromeDriver("--window-size=1000,700", TAB_URL);
		
		//Wait for site to load
		wait(5);

		Locators.sportBtn(driver).click();

		wait(1);

		Locators.quickMultiBtn(driver).click();

		wait(1);

		Locators.topQuicklinksBtn(driver).click();

		wait(1);

		Locators.homeBtn(driver).click();

		wait(1);

		Locators.racingBtn(driver).click();

		wait(1);

		Locators.pick6Btn(driver).click();

		wait(1);

		Locators.homeBtn(driver).click();

		wait(1);

		closeDriver();
	}
	
	/**
	 * Tests navigating through the website with a full sized 
	 * form factor, which would be somewhat of a simulation
	 * of using the website on a Latop/PC.
	 */
	@Test (dependsOnMethods={"testChromeLargeFormFactor"})
	private void testChromeFullScreenFormFactor() {
		loadChromeDriver("--start-fullscreen", TAB_URL);
		
		//Wait for site to load
		wait(5);

		Locators.sportBtn(driver).click();

		wait(1);

		Locators.quickMultiBtn(driver).click();

		wait(1);

		Locators.topQuicklinksBtn(driver).click();

		wait(1);

		Locators.homeBtn(driver).click();

		wait(1);

		Locators.racingBtn(driver).click();

		wait(1);

		Locators.pick6Btn(driver).click();

		wait(1);

		Locators.homeBtn(driver).click();

		wait(1);

		closeDriver();
	}
	
	/**
	 * Tests navigating through the website but using Chrome
	 * rather than Chrome. Useful for checking that the functionality 
	 * works not just in one browser.
	 */
	@Test (dependsOnMethods={"testChromeFullScreenFormFactor"})
	private void testFirefox() {
		loadFirefoxDriver("--start-fullscreen");
		
		//Wait for site to load
		wait(5);

		Locators.sportBtn(driver).click();

		wait(1);

		Locators.quickMultiBtn(driver).click();

		wait(1);

		Locators.topQuicklinksBtn(driver).click();

		wait(1);

		Locators.homeBtn(driver).click();

		wait(1);

		Locators.racingBtn(driver).click();

		wait(1);

		Locators.pick6Btn(driver).click();

		wait(1);

		Locators.homeBtn(driver).click();

		wait(1);

		closeDriver();
	}
	
	/**
	 * Called so that the page can be given time to load all elements
	 * in the website to allow Selenium to access the locators.
	 * @param time	The amount of time for the program to wait
	 */
	private void wait(int time) {
		try {
			TimeUnit.SECONDS.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

