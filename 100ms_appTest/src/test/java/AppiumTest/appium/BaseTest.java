package AppiumTest.appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterClass;  
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	static AndroidDriver driver;
	AppiumDriverLocalService service;
	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException {
		
		 service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\iamsa\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
		.withIPAddress("127.0.0.1").usingPort(4723).build();
		
		service.start();
	
		UiAutomator2Options option = new UiAutomator2Options();
		
		option.setDeviceName("Satyam Amulator");
		option.setApp("C:\\Users\\iamsa\\OneDrive\\Desktop\\Appium\\appium\\src\\test\\java\\resorces\\100ms-v2-5-0-0.apk");
		
		 driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),option);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();
	}

}
