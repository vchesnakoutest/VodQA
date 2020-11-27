package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.offset.ElementOption;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class LongPressPage extends BasePage {
    @AndroidFindBy(id = "android:id/message")
    public MobileElement message;
    @AndroidFindBy(xpath = "//*[@text='Long Press']")
    public MobileElement longPress;
    @AndroidFindBy(xpath = "//*[@text='Long Press Demo']")
    public MobileElement longPressDemo;
    @AndroidFindBy(xpath = "//*[@text='Long Press Me']")
    public MobileElement longPressMeButton;
    
    public LongPressPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        initElements(this);
    }

    public LongPressPage openLongPress() {
        longPress.click();
        return this;
    }

    @Override
    public void isPageOpened() {
        longPressDemo.isDisplayed();
    }
    
    public LongPressPage longPressAction() {
        TouchAction action = new TouchAction(driver);
        action.longPress(ElementOption.element(longPressMeButton)).release().perform();
        return this;
    }

    public LongPressPage checkSuccessMessage() {
        assertThat("you pressed me hard :P", waitForElementToAppear(message), equalTo(true));
        return this;
    }
}
