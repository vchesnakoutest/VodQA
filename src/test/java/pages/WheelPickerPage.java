package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class WheelPickerPage extends BasePage {
    @AndroidFindBy(xpath = "//*[@text='Wheel Picker']")
    public MobileElement wheelPicker;
    @AndroidFindBy(xpath = "//*[@text='Wheel Picker Demo']")
    public MobileElement wheelPickerDemo;
    @AndroidFindBy(className = "android.widget.Spinner")
    public MobileElement spinner;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Color: black')]")
    public MobileElement currentColor;
    
    
    public WheelPickerPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        initElements(this);
    }

    @Override
    public void isPageOpened() {
        wheelPickerDemo.isDisplayed();
    }
    
    public WheelPickerPage openWheelPicker(){
        wheelPicker.click();
        return this;
    }
    
    public WheelPickerPage wheelPickerAction(int index) {
        spinner.click();
        driver.findElementsById("android:id/text1").get(index).click();
        return this;
    }
    
    public  WheelPickerPage currentColorShouldBeCorrect() {
        assertThat("Current Color: black", waitForElementToAppear(currentColor), equalTo(true));
        return this;
    }
}
