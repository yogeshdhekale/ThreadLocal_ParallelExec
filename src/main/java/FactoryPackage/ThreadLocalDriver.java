package FactoryPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class ThreadLocalDriver {
	
	
	
	private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
//	private static void tlDriver() {
//		
//		ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	public synchronized static void setTLDriver(String browser) {
		WebDriver driver;
		String chromePath = "/Users/yogeshdhekale/Downloads/chromedriver";
		String mozilaPath = "/Users/yogeshdhekale/Downloads/geckodriver";
		String safariPath = "/usr/bin/safaridriver";
		
		if (browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", chromePath);
		//	driver = new ChromeDriver();
			tlDriver = ThreadLocal.withInitial(() -> new ChromeDriver(OptionsManager.getChromeOptions()));
		}
			else if (browser.equals("Firefox")) {
				System.setProperty("webdriver.firefox.driver", mozilaPath);
			//	driver = new FirefoxDriver();
				tlDriver = ThreadLocal.withInitial(()-> new FirefoxDriver(OptionsManager.getFirefoxOptions()));
			}
			else if (browser.equals(safariPath)) {
				System.setProperty("webdriver.safari.driver", safariPath);
				driver = new SafariDriver();
			}
	}
	
	public synchronized static WebDriver getTLDriver() {
		return tlDriver.get();
	}
	
	

}
