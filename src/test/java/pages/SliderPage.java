package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;

import static io.appium.java_client.touch.offset.PointOption.point;

public class SliderPage extends BasePage {
    @AndroidFindBy(id = "slider")
    public MobileElement slider;
    @AndroidFindBy(xpath = "//*[@text='Slider']")
    public MobileElement textSlider;
    
    public SliderPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        initElements(this);
    }

    @Override
    public void isPageOpened() {
       slider.isDisplayed();
    }

    public SliderPage openSlider() {
        textSlider.click();
       return this;
    }

    public SliderPage moveSlider(double index) {
        int start = slider.getLocation().getX();
        int y = slider.getLocation().getY();
        int end = slider.getSize().getWidth();
        TouchAction action = new TouchAction(driver);
        int moveTo = (int)(end*index);
        action.press(point(start,y)).moveTo(point(moveTo, y)).release().perform();
        return this;
    }
}
