package iCorrect.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class correction extends invoke_ICP {
	public static JavascriptExecutor js = (JavascriptExecutor)driver;
	static String Result=null;
	
	 @FindBy(xpath="//*[text()='Corrections List']")
	 public static WebElement correctionListButton;
	 
	 @FindBy(xpath="//*[@id='btnrefresh']")
	 public static WebElement refreshButton;
	 
	 @FindBy(xpath = "//span[@class='TimeASC_DSC']")
	 public static WebElement sortbyTime;
	 
	 @FindBy(xpath = "//input[@id='Desc_Corrections'][@type='checkbox']")
	 public static WebElement sortTimeByDecending;
	 
	 @FindBy(xpath = "//div[@ref='app_track_changes']//table[1]//tbody")
	 public static WebElement correctedList;
	 
	 public correction()
	 {
	  //initialize elements
	    PageFactory.initElements(driver, this);
	 }
	
	
	public static void verifytext(String TexttoVerify,String Modifiedtype) throws InterruptedException
	{

		System.out.println("\n<----------------Correction List------------------>");
		Thread.sleep(5000);
		
		//Click Correct List Tab
		correctionListButton.click();
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);	
		
		//Click Refresh button before proceeding.
		refreshButton.click();
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);	
		
		//Click "Time Based" button to sort the result with time.
		js.executeScript("arguments[0].click();", sortbyTime);
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);	
		
		//Choose "Descending with time" option to get latest one in front.
		js.executeScript("arguments[0].click();", sortTimeByDecending);
		js.executeScript("arguments[0].click();", sortbyTime);
		Thread.sleep(1000);
		
		try
		{
			//Get the text of 1st result
		 Result = correctedList.getText();
		}catch(Exception e)
		{
			//If no element available, catch will handle it as error and printing Error log.
			System.out.println("No result displayed in Correction list, Please check have you modified the document");
		}
		
		//Verify if the formatted text and formating options are displayed in result
		if(Result.contains(TexttoVerify) && Result.contains(Modifiedtype.toUpperCase()))
		{
			System.out.println("Modified Text displaying in Correction list as expected");
		}else {
			
			//If not matched, return error message along with displayed text for reference.
			System.err.println("Modified Text is not displaying in correction list, please refer the text;");
			System.err.println(Result);
		}
	}

}
