package commonFunctions;


import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import config.AppUtil;

public class SearchProduct extends AppUtil {
	public WebDriverWait wait;

	
	@Test(priority = 0)
	public void searchProduct() {

		// search for a product
		WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
		searchbox.sendKeys("shoes");
		searchbox.sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	@Test(priority = 1)
	public void clickOnAdd() {
		
		//Click Add button of first product 
		WebElement firstProduct =driver.findElement(By.xpath("//div[@class='rush-component s-expand-height']//button[contains(text(),'Add to cart')]"));
		firstProduct.click();
		
		WebElement popup = driver.findElement(By.xpath("//div[@class='a-popover-wrapper']//button[contains(text(),'Add to cart')]"));
		popup.click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement closealert = driver.findElement(By.xpath("//div[@class='a-popover-wrapper']//button[@class=' a-button-close a-declarative']"));
		closealert.click();
	}
}
