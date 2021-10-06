package TestPackage;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import FactoryPackage.ThreadLocalDriver;

public class TestBase {
	
	public WebDriverWait wait;
	
	@BeforeMethod
	@Parameters(value= {"browser"})
	public void setUp(String browser) {
		ThreadLocalDriver.setTLDriver(browser);
		wait = new WebDriverWait(ThreadLocalDriver.getTLDriver(), 15);
	}
	
	
	
	@AfterMethod
	public synchronized void quitBrowser() {
		ThreadLocalDriver.getTLDriver().quit();
	}

}
