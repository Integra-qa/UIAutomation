package iCorrect.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class formate extends invoke_ICP {

	static WebElement highlightedtextafterdoubleclick = null;
	public static String Modifedtext = "";
	public static String Modifytype = "";
	
	@FindBy(xpath="//*[@class = 'bookmarks-text']")
	public static List<WebElement> bookMark;
	
	@FindBy(xpath="//*[@class='highlight highlightElement']")
	public static WebElement highlightedtext;
	
	@FindBy(xpath="//div[@class ='context-bar']")
	public static WebElement contextBar;
	
	
	 public formate()
	 {
	  //initialize elements
	    PageFactory.initElements(driver, this);
	 }

	 
	public static String Formate_text(String modifyType, String ModifyText)
			throws InterruptedException {
		
			// If bookMark result displayed,print the total no.of result displayed
			System.out.println("Total number of result(s) : " + bookMark.size());

			// Create loop to handle each result
			for (int i = 0; i < bookMark.size(); i++) {

				// Click the result, to highlight the test in document
				bookMark.get(i).click();
				System.out.println((i + 1) + " Book Mark selected.");
				Thread.sleep(5000);

				try {
					System.out.println("\n<----------------Editing List------------------>");

					// Double click on the highlighted text, to get formating options
					Actions action = new Actions(driver);
					action.doubleClick(highlightedtext).perform();
					driver.switchTo().activeElement();
					Thread.sleep(3000);

					// If formating options displayed
					if (contextBar.isDisplayed() == true) {
						// Assign formating details in variable, Modifytype, to handle formating type
						// dynamically.
						Modifytype = modifyType;

						// click given formating
						driver.findElement(By.xpath("//div[@class ='context-bar']//*[@title = '" + Modifytype + "']")).click();
						System.out.println(Modifytype + " Applied to selected text - " + highlightedtext.getText());

						// Stop the execution
						break;
					} else {

						// If formating options is not displayed, print the error message.
						System.err.println("Context bar is not displayed. So selected text is not allowed to edit.");
					}
				} catch (Exception e) {
					System.err.println("Highlighted text is not availble inside ICP-Body. Moving to next element...\n");
				}
			}
		Modifedtext = modifyType;
		return Modifedtext = highlightedtext.getText();
	}

}
