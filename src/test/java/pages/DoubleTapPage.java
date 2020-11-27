package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DoubleTapPage extends BasePage {
    @AndroidFindBy(id = "android:id/message")
    public MobileElement message;
    @AndroidFindBy(xpath = "//*[@text='Double Tap']")
    public MobileElement doubleTap;
    @AndroidFindBy(xpath = "//*[@text='Double Tap Demo']")
    public MobileElement doubleTapDemo;
    @AndroidFindBy(xpath = "//*[@text='Double Tap Me']")
    public MobileElement doubleTapMeButton;
    
    public DoubleTapPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        initElements(this);
    }

    public DoubleTapPage openDoubleTap() {
        doubleTap.click();
        return this;
    }
    
    @Override
    public void isPageOpened() {
        doubleTapDemo.isDisplayed();
    }
    
    public DoubleTapPage doubleTapAction() {
        TouchAction action = new TouchAction(driver);
        action.tap(TapOptions.tapOptions().withElement(ElementOption.element(doubleTapMeButton))
                .withTapsCount(2)).perform();
        return this;
    }
    
    public DoubleTapPage checkSuccessMessage() {
        assertThat("Double tap successful!", waitForElementToAppear(message), equalTo(true));
        return this;
    }
}

