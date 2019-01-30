package iLancer.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class searchDetails extends invoke_iLancer {
	
	@FindBy(xpath = "//a[@ui-sref='home.search']//md-icon")
	public static WebElement searchButton ;
	
	@FindBy(xpath = "//h2[contains(@class,'title')]")
	public static WebElement pageTitle ;
	
	@FindBy(xpath = "//md-select[@ng-model='SearchFreelancer.ServiceId']")
	public static WebElement serviceId ;
	
	@FindBy(xpath = "//md-select[@ng-model='SearchFreelancer.SpecializationId']")
	public static WebElement specializationId ;
	
	@FindBy(xpath = "//li[@ng-click = 'changeClass2(selectedProfile)']//a[contains(text(), 'HIRE NOW')]")
	public static WebElement hireNowButton ;
	
	public  searchDetails()
	{
		//initialize elements
		PageFactory.initElements(driver, this);
	}
	
	public static void clickSearch() throws InterruptedException
	{
		//Click Search icon
		Thread.sleep(6000);
		searchButton.click();
		
		//Verify Search result page displayed or not
		Thread.sleep(6000);
		if(pageTitle.isDisplayed())
		{
			System.out.println("Search page displayed.");
		}else
		{
			System.err.println("Search page is not displayed.");
		}
	}

	public void searchData(String service, String specialization , String freelancer ) throws InterruptedException
	{
		//Calling clickSearch method
		clickSearch();
		
		//Select Service
		serviceId.click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//md-select-menu[@id='select_menu_16']/md-content//div[contains(text(),'"+service+"')]")).click();
		System.out.println("Service Selected - "+service);
		
		Thread.sleep(6000);
		
		//Select Specialization
		specializationId.click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//md-select-menu[@id='select_menu_18']/md-content//div[text()='"+specialization+"']")).click();
		System.out.println("Service Selected - "+specialization);
		Thread.sleep(4000);
		
		
		//Select Hirer
		driver.findElement(By.xpath("//md-grid-tile[@role='listitem']/figure/div//div[contains(text(),'"+freelancer+"')]")).click();
		System.out.println("Hirer Selected - "+freelancer);
		Thread.sleep(1000);
		hireNowButton.click();
		System.out.println("Hire now is clicked");
	
	}
}
