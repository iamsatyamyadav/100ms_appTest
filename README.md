

---

## 100ms SDET Assignment

### Project Overview
This project automates the flow for 100ms Android App using Appium, covering the key user journey from app launch to joining a meeting and verifying the video is displayed. The assignment automates the following:
1. UI flow from app launch -> preview -> meeting page.
2. Handling app permissions.
3. Video on/off verification on the meeting page.

### Tech Stack
- **Appium**: For mobile UI automation.
- **Java**: Programming language used.
- **TestNG**: For test management.
- **AndroidDriver**: To interact with Android elements.

### Prerequisites
Before you begin, ensure you have met the following requirements:
- Installed Java (JDK 8 or above).
- Installed [Appium Desktop](https://appium.io/) and Appium Inspector.
- Installed Android Studio and SDK tools.
- Configured the Android device/emulator.
- The APK file for the 100ms app installed or available in the emulator.
- Maven installed for dependency management.

### Project Setup
1. Clone the repository:
    ```bash
    git clone https://github.com/iamsatyamyadav/100ms_appTest.git
    ```
2. Open the project in your IDE Eclipse.
3. Install the required dependencies:
    - Ensure you have Appium Java Client and TestNG in your `pom.xml`.

    ```xml
    <dependencies>
	  <dependency>
	    <groupId>io.appium</groupId>
	    <artifactId>java-client</artifactId>
	    <version>9.3.0</version>
  	</dependency>
    <dependency>
      <groupId>org.testng</groupId>
      <artifactId>testng</artifactId>
      <version>6.14.3</version>
      <scope>test</scope>
    </dependency>
    </dependencies>
    ```

4. Configure your Appium Server and Android Device (emulator or real device).

### How to Run the Tests
1. Launch the Appium Server.
2. Connect your Android device or start the Android emulator.
3. In the project, run the tests:


### Test Cases Automated
1. **App Launch and Join Meeting Flow:**
    - Automates the entire flow from app launch, inputting meeting URL, joining the meeting, and validating the user is on the meeting page.

2. **Video Verification:**
    - Checks whether the video is displayed upon joining the meeting (video on/off based on the element ID change).

### Key Files
- `src/test/java/com/automation/100ms/TestAutomation.java`: Contains the automation logic for the 100ms app.
- `src/test/resources/`: Holds configuration files, if applicable.

### Challenges and Assumptions
- The video element changes its ID when turned on or off, and this has been handled using conditional checks.
- Assumed that Appium will handle permission requests automatically.

### Future Improvements
- Add more edge case validations (e.g., handling network interruptions).
- Add more robust waits and exception handling.
- Extend the framework to automate additional flows in the 100ms app.


## 🤝 Thanks for taking the time to view the project! I hope that you found it interesting and informative.
