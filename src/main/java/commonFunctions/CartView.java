package commonFunctions;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import config.AppUtil;

public class CartView extends AppUtil{
	
	@Test(priority = 2)
	public void viewTheCart() {
		
		WebElement clickOnCart = driver.findElement(By.id("nav-cart"));
		clickOnCart.click();
		
		
	}

}
