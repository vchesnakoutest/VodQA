package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;

import static io.appium.java_client.touch.offset.PointOption.point;

public class CarouselPage extends BasePage {
    @AndroidFindBy(xpath = "//*[@text='Carousel']")
    public MobileElement carousel;
    @AndroidFindBy(xpath = "//*[@text='Carousel - Swipe left/right']")
    public MobileElement carouselSwipe;
    @AndroidFindBy(className = "android.widget.HorizontalScrollView")
    public MobileElement scrollView;
    @AndroidFindBy(xpath = "//*[@text='2']")
    public MobileElement carouselElement;

    
    public CarouselPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        initElements(this);
    }

    @Override
    public void isPageOpened() {
        carouselSwipe.isDisplayed();
    }
    
    public CarouselPage openCarousel() {
        carousel.click();
        return this;
    }
    
    public CarouselPage swipeRightScroll() {
        int startX = (int) (scrollView.getSize().width * 0.90);
        int endX = (int) (scrollView.getSize().width * 0.10);
        int startY = scrollView.getSize().height / 2;
        TouchAction action = new TouchAction(driver);
        action.press(point(startX,startY)).moveTo(point(endX, startY)).release().perform();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }
}
