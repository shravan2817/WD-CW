package WebApplication;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Webtest extends baseClass{
	
@Test
public void Web() throws InterruptedException{
		
		driver.manage().window().maximize();
		driver.get("https://swwdce.dev.nidhi.apcfss.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Login LP= new Login(driver);
		LP.login("admin", "12345");
		
		Thread.sleep(2000);
		Dashboard db=new Dashboard(driver);
		db.dashboard(driver);
		Thread.sleep(2000);
//		db.getGetDataButton().click();
//		WebElement element = driver.findElement(By.xpath("//h1[text()='Supplementary Nutrition Program (SNP)']"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
//		db.getIndentGeneration().click();

//		WebElement web=driver.findElement(By.xpath("//select[@name='item']"));
//		Select itemDropdwon= new Select(web);
//		itemDropdwon.selectByVisibleText("Balamrutham");
		
		
		

}
}
