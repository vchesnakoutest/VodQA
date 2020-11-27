package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;

import static io.appium.java_client.touch.offset.PointOption.point;

public class LoginPage extends BasePage{
    @AndroidFindBy(xpath = "//*[@text='LOG IN']")
    public MobileElement loginButton;
    @AndroidFindBy(className = "android.widget.ImageView")
    public MobileElement loginIcon;
    @AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc='scrollView']/android.view.ViewGroup")
    public MobileElement listView;
    
    public LoginPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        initElements(this);
    }
    
   @Override
    public void isPageOpened() {
       loginIcon.isDisplayed();
    }

    public LoginPage logInAsRegisteredUser() {
        loginButton.click();
        return this;
    }
    
    public LoginPage isListViewOpened() {
        listView.isDisplayed();
        return this;
    }
    
    public LoginPage swipeScrollView(double indexStart, double indexY) {
        int height = listView.getSize().getHeight();
        int width = listView.getSize().getWidth();
        int startX = width/2;
        int startY = (int) (height * indexStart);
        int endY = (int) (height * indexY);
        TouchAction action = new TouchAction(driver);
        action.press(point(startX,startY)).moveTo(point(startX, endY)).release().perform();
        return this;
    }
}
