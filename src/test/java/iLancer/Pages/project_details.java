package iLancer.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class project_details extends invoke_iLancer{
	
	public project_details()
	{
		//initialize elements
		PageFactory.initElements(driver, this);
	}

	public void projectdata(String projectname , String Description , String IntegraBookCode, String JobCardNo, String CustomerName, String Entity , String Segment , String Service , String Complexity , String Startdate, String Enddate ,  String Currency, String Rate ,  String CustomerCurrency , String Customerrate , String Paymenttype , String Contract , String Comments) throws InterruptedException 
	{

		Thread.sleep(500);
		
		//Enter Project name
		driver.findElement(By.xpath("//input[@id= 'input_31']")).sendKeys(projectname); 
		
		//Enter Description
		driver.findElement(By.xpath("//textarea[@id = 'input_32']")).sendKeys(Description);
		
		//Enter Integra Book Code and job Card No
		driver.findElement(By.xpath("//textarea[@id = 'input_33']")).sendKeys(IntegraBookCode);
		driver.findElement(By.xpath("//textarea[@id = 'input_34']")).sendKeys(JobCardNo);
		
		// Select Customer from drop down
		driver.findElement(By.xpath("//md-select[@ng-model='Job.CustomerId']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//md-select-menu[@id='select_menu_35']/md-content//div[contains(text(),'"+CustomerName+"')]")).click();
		System.out.println("Customer Selected - "+CustomerName);
		
		// Select Entity
		driver.findElement(By.xpath("//md-select[@ng-model='Job.EntityID']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//md-select-menu[@id='select_menu_37']/md-content//div[contains(text(),'"+Entity+"')]")).click();
		System.out.println("Entity Selected - "+Entity);

		// Select Segment
		driver.findElement(By.xpath("//md-select[@ng-model='Job.SegmentId']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//md-select-menu[@id='select_menu_39']/md-content//div[contains(text(),'"+Segment+"')]")).click();
		System.out.println("Segment Selected - "+Segment);
		
		//Select Service
		driver.findElement(By.xpath("//md-select[@ng-model='Job.ServiceGroup[s].ServiceId']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//md-select-menu[@id='select_menu_41']/md-content//div[contains(text(),'"+Service+"')]")).click();
		System.out.println("Service Selected - "+Service);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("//span[@class = 'md-title font-deep-clr']"));
		js.executeScript("arguments[0].scrollIntoView();", Element);

		// Select Complexity
		driver.findElement(By.xpath("//md-select[@ng-model='Job.ServiceGroup[s].ServiceTypeId']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//md-select-menu[@id='select_menu_45']/md-content//div[contains(text(),'"+Complexity+"')]")).click();
		System.out.println("Complexity Selected - "+Complexity);
		Thread.sleep(500);
		
		// Select Start date and End date
		//driver.findElement(By.xpath("md-input-container[@class = 'md-input-has-placeholder md-input-has-messages md-default-theme']//input[@ng-model = 'Job.ServiceGroup[s].DueDays']")).sendKeys(DueDays);
		//System.out.println("Due days is" +DueDays);
		//Thread.sleep(500);
		driver.findElement(By.xpath("//input[@placeholder = 'Start date']")).sendKeys(Startdate);
		Thread.sleep(500);

		driver.findElement(By.xpath("//input[@placeholder = 'End date']")).sendKeys(Enddate);
		System.out.println("date is entered as " +Startdate +" and " +Enddate);
		Thread.sleep(500);
		// Select file to be attached.
		//WebElement file = driver.findElement(By.xpath("//div[@class = 'iL-upload-image upload']/div/button//md-icon[@class = 'ng-scope ng-isolate-scope md-iLancerTheme-theme material-icons']")); 
		//file.click();
		//file.sendKeys("C:/Users/is6248/Downloads/Text_322_Details.xlsx");

		// Select Flat Rate
		driver.findElement(By.xpath("//span[contains(text(),'Flat Rate')]")).click();
		Thread.sleep(3000);
		
		//Select Currency
		driver.findElement(By.xpath("//md-select[@id = 'select_88']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//md-select-menu[@id='select_menu_87']/md-content//div[contains(text(),'"+Currency+"')]")).click();
		System.out.println("Currency Selected - "+Currency);

		//Enter Rate
		driver.findElement(By.xpath("//input[@id = 'input_89']")).sendKeys(Rate);

		//Select Customer Currency
		driver.findElement(By.xpath("//md-select[@id = 'select_91']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//md-select-menu[@id='select_menu_90']/md-content//div[contains(text(),'"+CustomerCurrency+"')]")).click();
		System.out.println("Customer Currency Selected - "+CustomerCurrency);

		//Enter rate
		driver.findElement(By.xpath("//input[@id = 'input_92']")).sendKeys(Customerrate);

		//Select Payment type
		driver.findElement(By.xpath("//md-select[@id = 'select_95']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//md-select-menu[@id='select_menu_94']/md-content//div[contains(text(),'"+Paymenttype+"')]")).click();
		System.out.println("Payment type Selected - "+Paymenttype);
		
		//Select Contract
		driver.findElement(By.xpath("//md-select[@ng-model='Job.ServiceGroup[s].Contractsflag']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//md-select-menu[@id='select_menu_52']/md-content//div[contains(text(),'"+Contract+"')]")).click();
		System.out.println("Contract Selected - "+Contract);

		//Enter comments
		driver.findElement(By.xpath("//textarea[@id = 'input_54']")).sendKeys(Comments);
		driver.findElement(By.xpath("//div[@class = 'md-layout-row layout-align-center-center']/div/button//md-icon[@class = 'ng-scope ng-isolate-scope md-iLancerTheme-theme material-icons']")).click();
		System.out.println("Project has been assigned to the respective freelancer");

	}

}
