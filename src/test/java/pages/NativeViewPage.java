package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class NativeViewPage extends BasePage {
    @AndroidFindBy(accessibility = "container1")
    public MobileElement itemViewOne;
    @AndroidFindBy(accessibility = "container2")
    public MobileElement itemViewTwo;
    @AndroidFindBy(accessibility = "container3")
    public MobileElement itemViewThree;
    @AndroidFindBy(xpath = "//*[@text='Native View']")
    public MobileElement nativeView;
    @AndroidFindBy(xpath = "//*[@text='Native View Demo']")
    public MobileElement nativePage;

    public NativeViewPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        initElements(this);
    }

    @Override
    public void isPageOpened() {
        nativePage.isDisplayed();
    }

    public NativeViewPage openNativeView() {
        nativeView.click();
        return this;
    }

    public NativeViewPage listNativeViewShouldBeLoaded(){
        assertThat("Hello World, I'm View one", waitForElementToAppear(itemViewOne), equalTo(true));
        assertThat("Hello World, I'm View two", waitForElementToAppear(itemViewTwo), equalTo(true));
        assertThat("Hello World, I'm View three", waitForElementToAppear(itemViewThree), equalTo(true));
        return this;
    }
}
