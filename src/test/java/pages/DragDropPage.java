package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.offset.ElementOption;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DragDropPage extends BasePage {
    @AndroidFindBy(accessibility = "success")
    public MobileElement message;
    @AndroidFindBy(xpath = "//*[@text='Drag & Drop']")
    public MobileElement dragDrop;
    @AndroidFindBy(xpath = "//*[@text='Drag me!']")
    public MobileElement dragMeButton;
    @AndroidFindBy(xpath = "//*[@text='Drop here.']")
    public MobileElement dropHere;
    
    public DragDropPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        initElements(this);
    }

    @Override
    public void isPageOpened() {
        dragMeButton.isDisplayed();
    }

    public DragDropPage openDragDrop() {
        dragDrop.click();
        return this;
    }
    
    public DragDropPage dragDropAction() {
        TouchAction action = new TouchAction(driver);
        action.longPress(ElementOption.element(dragMeButton)).moveTo(ElementOption.element(dropHere)).release().perform();
         
        return this;
    }
    
    public DragDropPage checkSuccessMessage() {
        assertThat("Circle dropped", waitForElementToAppear(message), equalTo(true));
        return this;
    }
}
