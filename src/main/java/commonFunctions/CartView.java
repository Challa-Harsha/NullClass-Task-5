package commonFunctions;

import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import config.AppUtil;

public class CartView extends AppUtil {
	public WebDriverWait wait;
	@Test(priority = 2)
	public void viewTheCart() {
			wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".a-changeover-inner")));
		} catch (TimeoutException e) {
			System.out.println("Overlay '.a-changeover-inner' didn't disappear in time.");
		}
		try {
			WebElement cartIcon = driver.findElement(By.id("nav-cart"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", cartIcon);
			
			try {
				cartIcon.click();
			} catch (Exception clickException) {
				System.out.println("Standard click failed, using JS click.");
				js.executeScript("arguments[0].click();", cartIcon);
			}

		} catch (Exception e) {
			System.out.println("Error locating or clicking cart icon: " + e.getMessage());
		}

	}
	@Test(priority = 3)
	public void getPrice() {
		 WebElement priceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".sc-price")));
         String priceText = priceElement.getText().replaceAll("[^0-9]", "");
         int price = Integer.parseInt(priceText);
         assert price > 500 : "Price is not greater than ₹500.";
         System.out.println("Price of the product is: "+price);
	}

}
