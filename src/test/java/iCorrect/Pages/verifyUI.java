package iCorrect.Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class verifyUI extends invoke_ICP {
	
	public static void verify_sidebar()
	{
		WebElement Logo = driver.findElement(By.xpath("//li[@class='logo']//img[@src = '../img/logo.png']"));
		Assert.assertEquals(Logo,Logo);
	}

}
