package TestPackage;

import org.testng.Assert;
import org.testng.annotations.Test;

import FactoryPackage.ThreadLocalDriver;

public class TestAmazon extends TestBase {
	
	@Test
	public void AmazonTitle() {
		ThreadLocalDriver.getTLDriver().get("https://amazon.in");
		String title = ThreadLocalDriver.getTLDriver().getTitle();
		System.out.println(title);
		String titleActual = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		Assert.assertEquals(title, titleActual);
	}
}
