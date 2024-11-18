package WebApplication;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;


public class baseClass {
		WebDriver driver= null;
//		static WebDriver sdriver=null;

		@BeforeMethod
		public void launch() {
			 driver =new ChromeDriver();
			
//			sdriver= driver;		
		}

	}


