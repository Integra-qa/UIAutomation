package iCorrect.Test;

import iCorrect.Pages.correction;
import iCorrect.Pages.formate;
import iCorrect.Pages.invoke_ICP;
import iCorrect.Pages.search;

public class mainICP extends invoke_ICP
{
	static String browser = "chrome";
	static String ModifyText = "There";
	static String modifyType = "Bold";
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws InterruptedException
	{
		//Invoke Browser and open ICP 
		new invoke_ICP().Invoke(browser);
	
		//Search the Text
		if(new search().searchText(ModifyText)==true)
		{
			//Apply given formating
			new formate().Formate_text(modifyType, ModifyText);
			
			//Verify Edited Text in Correction list
			new correction().verifytext(formate.Modifedtext,formate.Modifytype);
		}
		
		// Close browser
		driver.quit();
	}
}
