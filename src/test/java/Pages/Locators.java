package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Class which is used to find the different elements within
 * the website by using different locators such as id, className and 
 * xpath.
 * @author camm_rose
 */
public class Locators {

	private static WebElement element;
	
	public static WebElement joinNow(WebDriver driver) {
		return driver.findElement(By.className("sign-up"));
	}
	
	public static WebElement letsGetStarted(WebDriver driver) {
		return driver.findElement(By.className("registration-intro__sign-up-button"));
	}
	
	public static WebElement firstName(WebDriver driver) {
		return driver.findElement(By.id("firstName"));
	}
	
	public static WebElement middleName(WebDriver driver) {
		return driver.findElement(By.id("middleName"));
	}

	public static WebElement lastName(WebDriver driver) {
		return driver.findElement(By.id("lastName"));
	}

	public static WebElement dateOfBirth(WebDriver driver) {
		return driver.findElement(By.id("dob"));
	}
	
	public static WebElement continueBtn(WebDriver driver) {
		return driver.findElement(By.className("button-primary"));
	}
	
	public static WebElement emailAddress(WebDriver driver) {
		return driver.findElement(By.id("emailAddresses[0].address"));
	}
	
	public static WebElement phoneNumber(WebDriver driver) {
		return driver.findElement(By.id("phoneNumbers[0].number"));
	}
	
	public static WebElement manualAddress(WebDriver driver) {
		return driver.findElement(By.className("toggle-address-entry-button"));
	}
	
	public static WebElement addressLine1(WebDriver driver) {
		return driver.findElement(By.id("addresses[0].addressLine1"));
	}
	
	public static WebElement suburb(WebDriver driver) {
		return driver.findElement(By.id("addresses[0].addressLine3"));
	}
	
	public static WebElement city(WebDriver driver) {
		return driver.findElement(By.id("addresses[0].city"));
	}
	
	public static WebElement postcode(WebDriver driver) {
		return driver.findElement(By.id("addresses[0].postcode"));
	}
	
	public static WebElement identity(WebDriver driver) {
		return driver.findElement(By.id("OTHER_ID"));
	}
	
	public static Select industry(WebDriver driver) {
		return new Select(driver.findElement(By.name("industryRef")));
	}
	
	public static WebElement occupation(WebDriver driver) {
		return driver.findElement(By.id("occupationAdditionalInfo"));
	}
	
	public static Select bettingFrequency(WebDriver driver) {
		return new Select(driver.findElement(By.name("frequency")));
	}
	
	public static Select betSize(WebDriver driver) {
		return new Select(driver.findElement(By.id("stake")));
	}
	
	public static Select paymentMethod(WebDriver driver) {
		return new Select(driver.findElement(By.id("payMethodType")));
	}

	public static WebElement bettingInterests(WebDriver driver) {
		return driver.findElement(By.id("BOTH"));
	}
	
	public static WebElement username(WebDriver driver) {
		return driver.findElement(By.id("username"));
	}
	
	public static WebElement password(WebDriver driver) {
		return driver.findElement(By.id("password"));
	}
	
	public static WebElement pin(WebDriver driver) {
		return driver.findElement(By.id("pin"));
	}
	
	public static WebElement mothersMaidenName(WebDriver driver) {
		return driver.findElement(By.id("challengeQuestions[0].answer"));
	}
	
	public static WebElement termsAndConditions(WebDriver driver) {
		return driver.findElement(By.id("id_agreedTermsAndConditions"));
	}
	
	public static WebElement closeBtn(WebDriver driver) {
		return driver.findElement(By.className("close-button"));
	}
	
	public static WebElement signIn(WebDriver driver) {
		return driver.findElement(By.className("sign-in"));
	}
	
	public static WebElement usernameSignin(WebDriver driver) {
		return driver.findElement(By.id("LabeledTextField_username"));
	}
	
	public static WebElement passwordSignin(WebDriver driver) {
		return driver.findElement(By.id("LabeledTextField_login-password-id"));
	}
	
	public static WebElement loginBtn(WebDriver driver) {
		return driver.findElement(By.className("login-button"));
	}
	
	public static WebElement userMenu(WebDriver driver) {
		return driver.findElement(By.className("account-preview"));
	}
	
	public static WebElement signoutBtn(WebDriver driver) {
		return driver.findElement(By.className("button-sign-out"));
	}
	
	public static WebElement nzEngBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/main/section[1]/div[2]/div[2]/div/div/div[1]/div/div/div[2]/div/article/div[2]/div/ul/li[3]/a/span/span"));
	}
	
	public static WebElement nzToWin(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/main/section[1]/div[2]/div[2]/div/div/div[2]/div/div/article/div/div[1]/article/div/div[2]/div[2]/div[1]/div[2]/div/div/div/div[1]/button/span/span[2]"));
	}
	
	public static WebElement singleBetAmount(WebDriver driver) {
		return driver.findElement(By.className("stake"));
	}
	
	public static WebElement placeBetBtn(WebDriver driver) {
		return driver.findElement(By.className("button--place-betslip"));
	}
	
	public static WebElement confirmBet(WebDriver driver) {
		return driver.findElement(By.className("button--accept-betslip"));
	}
	
	public static WebElement eplMatchesBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/main/section[1]/div[2]/div[2]/div/div/div[1]/div/div/div[2]/div/article/div[2]/div/ul/li[8]/a/span/span"));
	}
	
	public static WebElement addManCity(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/main/section[1]/div[2]/div[2]/div/div/div[2]/div/div/article/div/div[1]/article/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[2]/div[1]/div/div/div[3]/button/span"));
	}
	
	public static WebElement addChelsea(WebDriver driver) {	
		return driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/main/section[1]/div[2]/div[2]/div/div/div[2]/div/div/article/div/div[1]/article/div/div[2]/div[1]/div[2]/ul/li[3]/div/div[2]/div[1]/div/div/div[1]/button/span"));
	}
	
	public static WebElement addSpurs(WebDriver driver) {	
		return driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/main/section[1]/div[2]/div[2]/div/div/div[2]/div/div/article/div/div[1]/article/div/div[2]/div[1]/div[2]/ul/li[5]/div/div[2]/div[1]/div/div/div[1]/button/span"));
	}
	
	public static WebElement addManUtd(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/main/section[1]/div[2]/div[2]/div/div/div[2]/div/div/article/div/div[1]/article/div/div[2]/div[2]/div[2]/ul/li[4]/div/div[2]/div[1]/div/div/div[1]/button/span"));
	}

	public static WebElement multiBetAmount(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"ob-betslip-multiples-container\"]/div[2]/div/div[1]/div/div[2]/div[2]/div/div/input"));
	}
	
	public static WebElement sportBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/main/section[1]/section/div/div/div/div[2]/div[1]/article/ul/li[2]/a/span/span[1]/span/span"));
	}

	public static WebElement quickMultiBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/main/section[1]/div[1]/div[1]/div/div[2]/div/div[1]/div/div/div/div/article/ul/div/li[4]/a"));
	}
	
	public static WebElement topQuicklinksBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/main/section[1]/div[2]/div[2]/div/div/div[1]/div/div/div[2]/div/article/div[1]/div/ul/li[1]/a/span/span"));
	}
	
	public static WebElement homeBtn(WebDriver driver) {
		return driver.findElement(By.className("icon--logo"));
	}
	
	public static WebElement racingBtn(WebDriver driver) {
		return driver.findElement(By.className("icon--gallops"));
	}
	
	public static WebElement pick6Btn(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/main/section[1]/div[1]/div[1]/div/div[2]/div/div[1]/div/div/div/div/article/ul/div/li[3]/a"));
	}
	
	public static WebElement successfulBet(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/main/section[1]/div[2]/div[2]/div/div/div[3]/div[2]/article/div[1]/article/div/div/div[2]/div[1]/div/div/div/div[2]/div[1]"));
	}
	
	public static WebElement deleteBetSlip(WebDriver driver) {
		return driver.findElement(By.className("icon--clear-betslip"));
	}
	
	public static WebElement accountConfirmation(WebDriver driver) {
		return driver.findElement(By.className("blurb-body"));
	}
	
	
}
