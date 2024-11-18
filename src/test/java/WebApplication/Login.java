package WebApplication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login  {
	
	@FindBy(xpath="//input[@name='user_id']")
	private WebElement username;
	@FindBy(xpath="//input[@name='password']")
	private WebElement password;
	@FindBy(xpath="//button[@type='submit']")
	private WebElement signinbutton;
	
     public Login(WebDriver driver) {
    	 PageFactory.initElements(driver, this);
     }
	
	
	
	public WebElement getUsername() {
		return username;
	}
	public WebElement getPassword() {
		return password;
	}
	
	public void login(String user , String pass) {
		username.sendKeys(user);
		password.sendKeys(pass);
		signinbutton.click();
	}
	
	
	

}
