package TestPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import FactoryPackage.ThreadLocalDriver;

public class TestGoogle extends TestBase {

	
	@Test
	public void titleTest1() {
		ThreadLocalDriver.getTLDriver().get("http://google.com");
		String title = ThreadLocalDriver.getTLDriver().getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Google");
	}
	
	@Test
	public void getLinksTest() {
		ThreadLocalDriver.getTLDriver().get("http://www.google.co.in");
		
		List<WebElement> languageList = ThreadLocalDriver.getTLDriver().findElements(By.xpath("//div[@id='SIvCob']"));
		System.out.println(languageList);
		
		for (int i=0; i<languageList.size(); i++) {
			String lang = languageList.get(i).getText();
			if (lang.equals("मराठी")){
				languageList.get(i).click();
				Assert.assertEquals("मराठी", true);
			}
		}
	}
}
