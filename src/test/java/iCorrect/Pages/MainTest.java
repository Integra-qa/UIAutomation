package iCorrect.Pages;
	

import org.testng.annotations.Test;	
import org.testng.annotations.BeforeTest;	
import org.testng.annotations.AfterTest;


public class MainTest {		
	
	static String browser = "chrome";
	static String ModifyText = "There";
	static String modifyType = "Bold";
	
	@BeforeTest
	public void browser() throws InterruptedException {	
		//Invoke Browser and open ICP 
		new invoke_ICP().Invoke(browser);
	}		
	
	    
		@SuppressWarnings("static-access")
		@Test				
		public void formatetext() throws InterruptedException {	
			//Search the Text
			if(new search().searchText(ModifyText)==true)
			{
				//Apply given formating
				new formate().Formate_text(modifyType, ModifyText);
				
				//Verify Edited Text in Correction list
				new correction().verifytext(formate.Modifedtext,formate.Modifytype);
			}
		}	
		
		
		@SuppressWarnings("static-access")
		@AfterTest
		public void afterTest() {
			new invoke_ICP().driver.quit();			
		}		
}