package iLancer.Pages;

import iLancer.Pages.invoke_iLancer;
import iLancer.Pages.project_details;
import iLancer.Pages.searchDetails;
import iLancer.Pages.Login;

public class mainILR extends invoke_iLancer{

	public static void main(String[] args) throws InterruptedException
	{
		//Invoke Browser and load ilancer Url 
		new invoke_iLancer().Invoke("chrome");
		
		//Login into iLancer and verify user can logged in successfully
		new Login().LoginintoWebpage();
		
		//Search Details
		new searchDetails().searchData("Content Development", "Social Sciences" , "Bhuvaneswaran Jeyabalan"); /**Change the service , specialization values and freelancer here.*/
		
		//Project Details
		new project_details().projectdata("Selenium project", "Description written down by Eclipse IDE" , "IBC001" , "JCN001" , "Cengage Learning" , "Integra Pondy, India" , "Others" , "Content Development" , "Light"  , "1/29/2019" , "03/01/2019" , "$" , "5000.56" , "$" , "6000.89" , "Single" , "Contract 2 – Integra Publishing Service Inc." , "Test Project assigning to check the automation"); /* Enter all the project details here.*/
		
		//Close browser
		driver.quit();
		
		
	}

}
