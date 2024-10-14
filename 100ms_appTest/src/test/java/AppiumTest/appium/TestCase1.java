package AppiumTest.appium;


import java.net.MalformedURLException;
import java.time.Duration;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;



public class TestCase1 extends BaseTest {
	
	/*Here we are using the testNG Framework so for running the Driver i created the Method ConfigureAppium inside the  
	BaseTest class and using the @BeforClass annotation so that will run first*/
	
	// Url for joining the meeting 
	static String url = "https://satyam-livestream-1523.app.100ms.live/streaming/meeting/gsw-edtn-lxx";
	@Test
	public void  AppiumTest() throws  MalformedURLException, InterruptedException {
		
		 // Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		
		
		
		//finding Link bar Element using ID and sending the link 
		WebElement linkbar = 	driver.findElement(AppiumBy.id("live.hms.app2:id/edt_meeting_url"));
		linkbar.sendKeys(url);
		
		//using the Waits for until button is not click able 
		WebElement joinNowBtn = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("live.hms.app2:id/btn_join_now")));
		joinNowBtn.click();
		
		
		// For Camera and audio permission we are checking because this will not come all time 
		acceptPermissions(driver, wait);
		
		// for Join Meeting button
		WebElement JoinMeetbtn = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"live.hms.app2:id/button_join_meeting\"]")));
		JoinMeetbtn.click();
		
		
		
		// Now we are inside the meeting page now we have to check we are inside the meeting page.
		
		
		//Now we have are validating we are inside meet or not 
		
		// Validating we are on the Meeting Page
		WebElement meetingEndbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("live.hms.app2:id/button_end_call"))); 

		assert meetingEndbtn.isDisplayed() : "We are Not on the Meeting Page!";
//		System.out.println("Successfully navigated to the Meeting Page!");

		
		// Till this point we are done with the meeting now we have to check we are 
		
		// this is for checking only
		Thread.sleep(10000);
	
		WebElement videoOnElement = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("live.hms.app2:id/hms_video_view")));
//		System.out.println("Video is ON and displayed successfully!");
		assert videoOnElement.isDisplayed() : "Video should be ON but is not displayed!";

	}
	
	
	
	private static void acceptPermissions(AppiumDriver driver, WebDriverWait wait) {
        try {
            WebElement forCamerapermissions = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")));
            forCamerapermissions.click();

            forCamerapermissions = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_foreground_only_button\"]")));
            forCamerapermissions.click();

            WebElement allowButton = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]")));
            allowButton.click();
        } catch (Exception e) {
            System.out.println("Permissions already granted or an error occurred " + e.getMessage());
        }
        
	}
}
