package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
import utils.appium.AppiumServerJava;
import utils.driver.AndroidDriverManager;
import utils.driver.DriverManager;

public class BaseTest {
    private String deviceName = "Nexus5X";
    private String platform = "Android";
    
    AppiumDriverLocalService appiumService;
    AppiumDriver driver;
    LoginPage loginPage;
    NativeViewPage nativeViewPage;
    SliderPage sliderPage;
    VerticalSwipingPage verticalSwipingPage;
    DoubleTapPage doubleTapPage;
    DragDropPage dragDropPage;
    LongPressPage longPressPage;
    WheelPickerPage wheelPickerPage;
    CarouselPage carouselPage;

    void setCustomCapabilities(String _deviceName, String _platform){
        deviceName = _deviceName;
        platform = _platform;
    }
    
    @BeforeMethod
    void startAppiumServer() {
        appiumService = AppiumServerJava.startServer();
        DriverManager manager = new AndroidDriverManager();
        driver = manager.getDriver(appiumService, deviceName, platform);
        loginPage = new LoginPage(driver);
        nativeViewPage = new NativeViewPage(driver);
        sliderPage = new SliderPage(driver);
        verticalSwipingPage = new VerticalSwipingPage(driver);
        doubleTapPage = new DoubleTapPage(driver);
        dragDropPage = new DragDropPage(driver);
        longPressPage = new LongPressPage(driver);
        wheelPickerPage = new WheelPickerPage(driver);
        carouselPage = new CarouselPage(driver);
    }

    @AfterMethod (alwaysRun = true)
    void stopAppiumServer() {
        if(driver != null) {
            driver.quit();
        }
        appiumService.stop();
    }
}


