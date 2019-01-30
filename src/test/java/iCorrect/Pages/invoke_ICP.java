package iCorrect.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;

public class invoke_ICP {

	public static WebDriver driver;

	public invoke_ICP()
	{
		//initialize elements
		PageFactory.initElements(driver, this);
	}
	

	public void Invoke(String browser) throws InterruptedException
	{
		String path = System.getProperty("user.dir");

		// Set property for your browser
		if(browser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", path+"/Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", path+"/Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", path+"/Drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}else {
			System.err.println("Wrong Browser name, please check the browser imput.");
		}

		System.out.println("\n<------------Browser invoke--------------->");

		// Initialize browser
		System.out.println("Invoking browser instance");

		// Open url
		driver.get("https://testing-icorrectproof.azurewebsites.net/home/iviews?sample=CSMS_A_1495072_in&isCloud=true&icus=1");
		System.out.println("Loading the url...");

		// Maximize browser
		driver.manage().window().maximize();
		
		// Click Start Proof Button
		driver.findElement(By.xpath("//*[@id='lnkNextPage'][@class='viewproof']")).click();
	}
}
