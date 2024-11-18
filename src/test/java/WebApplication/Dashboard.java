	package WebApplication;
	
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.Select;
	
	public class Dashboard {
		private WebDriver driver;
		@FindBy(xpath="//h1[text()='Supplementary Nutrition Program (SNP)']")
		private WebElement SIP;
	
		@FindBy(xpath="//h3[text()='Indent Generation']")
		private WebElement indentGeneration;
	
		@FindBy(xpath="//select[@name='item']")
		private WebElement web;
	
		@FindBy(xpath="//select[@name='year']")
		private WebElement yearDropdown;
	
		@FindBy(xpath="//select[@name='month']")
		private WebElement monthDropdown;
	
		@FindBy(xpath="//button[text()=' Get Data ']")
		private WebElement getDataButton;
	
		@FindBy(xpath="//button[text()='Send Indent to Checker']")
		private  WebElement sendIndentToChecker;
	
		@FindBy(xpath="//div[text()='Do you want to send it to checker?']")
		private  WebElement sendItToChecker;
	
		@FindBy(xpath="//button[text()='submit']']")
		private  WebElement sweetAlertSubmitButton;
	
		@FindBy(xpath="//div[text()='Submitted Successfully']")
		private  WebElement successMessage;
	
		@FindBy(xpath="//button[text()='OK']")
		private  WebElement acceptTheSweeetAlert;
	
		@FindBy(xpath="//a[@id='collasible-nav-dropdown']")
		private  WebElement userProfile;
	
		@FindBy(xpath="//a[text()='Sign Out']")
		private  WebElement userSignOut;
	
		@FindBy(xpath="//b[text()=' Indent already generated and sent to checker']")
		private  WebElement indentalreadysent;
		public WebElement getIndentalreadysent() {
			return indentalreadysent;
		}
		public WebElement getUserProfile() {
			return userProfile;
		}
		public WebElement getUserSignOut() {
			return userSignOut;
		}
		public WebElement getSuccessMessage() {
			return successMessage;
		}
		public WebElement getAcceptTheSweeetAlert() {
			return acceptTheSweeetAlert;
		}
		public WebElement getSendItToChecker() {
			return sendItToChecker;
		}
		public WebElement getSweetAlertSubmitButton() {
			return sweetAlertSubmitButton;
		}
		public WebElement getSendIndentToChecker() {
			return sendIndentToChecker;
		}
		public WebElement getSIP() {
			return SIP;
		}
		public WebElement getYearDropdown() {
			return yearDropdown;
		}
		public WebElement getMonthDropdown() {
			return monthDropdown;
		}
		public WebElement getGetDataButton() {
			return getDataButton;
		}
		public Dashboard (WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		public WebElement getIndentGeneration() {
			return indentGeneration;
		}
		public void userActions() {
			userProfile.click();
			userSignOut.click();
		}
		//	@FindBy(xpath="//b[text()='Item']")
		//	private WebElement ItemDropdown;
		public void dashboard(WebDriver driver) throws InterruptedException {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", SIP);
			indentGeneration.click();
			Select itemDropdwon= new Select(web);
			itemDropdwon.selectByVisibleText("Balamrutham");
			
			Select yrDropdown=new Select(yearDropdown);
			yrDropdown.selectByVisibleText("2024");
			
			Thread.sleep(2000);
			Select mnthDropdown=new Select(monthDropdown);
			mnthDropdown.selectByVisibleText("November");
			
			getDataButton.click();
			
			JavascriptExecutor jsExecutor=(JavascriptExecutor)driver;
			try {		
				jsExecutor.executeScript("window.scrollTo(0, arguments[0].getBoundingClientRect().top +"
						+ "window.scrollY);", sendIndentToChecker);
				Thread.sleep(2000);
				sendIndentToChecker.click();
	   
				if(sendItToChecker.isDisplayed()) {
					sendIndentToChecker.click();
					Thread.sleep(2000);
					sweetAlertSubmitButton.click();
				}
				if(successMessage.isDisplayed()) {
					Thread.sleep(2000);
					acceptTheSweeetAlert.click();
				}	
			}
			catch(Exception e){
                             e.printStackTrace();			}
	try {
		jsExecutor.executeScript("window.scrollTo(0, arguments[0].getBoundingClientRect().top + window.scrollY);", indentalreadysent);	
		if(indentalreadysent.isDisplayed()){
			
			String textfor=indentalreadysent.getText();
			System.out.println(textfor);
		}
	}
	catch(Exception e) {
		 e.printStackTrace();		
	}
			userActions();
		}
	}
