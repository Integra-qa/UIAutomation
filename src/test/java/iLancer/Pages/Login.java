package iLancer.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends invoke_iLancer {
	
	
	@FindBy(xpath = "//button[@aria-label='login']")
	public static WebElement loginButton;
	
	@FindBy(xpath = "//form[@name='loginUser']")
	public static WebElement loginForm;
	
	@FindBy(xpath = "//input[@type='email'][@id='input_0']")
	public static WebElement userName;
	
	@FindBy(xpath = "//input[@type='password'][@ng-model='User.Password']")
	public static WebElement passWord;
	
	@FindBy(xpath = "//button[@ng-click='login(User)']")
	public static WebElement logIn;
	
	@FindBy(xpath = "//span[@ng-if='showDashboardMenu']/a")
	public static WebElement homePageDashBoard;
	
	public Login()
	{
		//initialize elements
		PageFactory.initElements(driver, this);
	}

public void LoginintoWebpage() throws InterruptedException
{
	
	//Click Login Button
	loginButton.click();
	Thread.sleep(1000);
	
	//Verify Login form display
	if(driver.findElement(By.xpath("//form[@name='loginUser']")).isDisplayed()) {
		System.out.println("Login form displayed.");
	}else {
		System.err.println("Login form is not displayed");
	}
	
	//Enter User Email
	userName.sendKeys("srideepa.natesan@integra.co.in");

	//Enter Password
	passWord.sendKeys("testing@123");
	
	//Click Login button
	logIn.click();
	
	//Verify ilancer home page is displayed or not?
	Thread.sleep(7000);
	if(homePageDashBoard.isDisplayed())
	{
		System.out.println("Logged in Successfully, Dashboard(Default) page displayed");
	}else
	{
		System.err.println("Dashboard page is not displayed. confirm the login details and try once again");
	}
}

}
