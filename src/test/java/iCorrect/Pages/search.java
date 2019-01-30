package iCorrect.Pages;

import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class search extends invoke_ICP {

	public static Boolean result = true;
	
	 @FindBy(xpath="//*[text()='Search']")
	 public static WebElement searchButton;
	 
	 @FindBy(xpath="//input[@id='text-search01']")
	 public static WebElement searchInputTextBox;
	 
	 @FindBy(xpath="//*[@class = 'bookmarks-text']")
	 public static List<WebElement> bookMark;
	 
	 public search()
	 {
	  //initialize elements
	    PageFactory.initElements(driver, this);
	 }
	
	public boolean searchText(String texttosearch) throws InterruptedException {
		
		System.out.println("\n<----------------Search Text------------------>");
		
		Thread.sleep(5000);
		
		//Click Search tab
		searchButton.click();
		Thread.sleep(5000);	
		
		//Enter Text in search
		searchInputTextBox.sendKeys(texttosearch, Keys.ENTER);
		Thread.sleep(5000);
		
		// Get and store all the displayed result in variable , bookMark
		//If bookMark result = 0, Then stop the execution
				if (bookMark.size() <= 0) {
					System.out.println("Given text is not available in the document");
					result = false;
				} else {
					result = true;
				}
				
		return result;
	}

	
}
