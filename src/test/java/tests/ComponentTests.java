package tests;

import io.qameta.allure.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ComponentTests extends BaseTest {
   
    @Parameters(value={"deviceName", "platform"})
    @BeforeClass
    public void setupDeviceParameters (@Optional("Pixel_3a_API_30_x86") String deviceName, @Optional("Android") String platform) {
        setCustomCapabilities(deviceName, platform);
    }
    
    @Test
    @Description("Check Native view")
    public void nativeViewTest() {
        loginPage.logInAsRegisteredUser()
                 .isListViewOpened();
        nativeViewPage.openNativeView()
                      .isPageOpened();
        nativeViewPage.listNativeViewShouldBeLoaded();
    }

    @Test
    @Description("Slide your number")
    public void sliderTest() {
        loginPage.logInAsRegisteredUser()
                 .isListViewOpened(); 
        double index = 0.5;
        sliderPage.openSlider()
                  .isPageOpened();
        sliderPage.moveSlider(index);
    }
    
    @Test
    @Description("Vertical Swiping")
    public void swipeTest() {
        loginPage.logInAsRegisteredUser()
                 .isListViewOpened();
        double indexStart = 0.5;
        double indexY = 0.2;
        verticalSwipingPage.openVerticalSwiping()
                           .swipeScrollView(indexStart, indexY);
    } 
    
    @Test
    @Description("Double tap")
    public void doubleTapTest() {
        loginPage.logInAsRegisteredUser()
                .isListViewOpened();
        doubleTapPage.openDoubleTap()
                     .isPageOpened();
        doubleTapPage.doubleTapAction()
                     .checkSuccessMessage();
    }

    @Test
    @Description("Drag and drop")
    public void dragDropTest() {
        loginPage.logInAsRegisteredUser()
                .isListViewOpened();
        dragDropPage.openDragDrop()
                .isPageOpened();
        dragDropPage.dragDropAction()
                .checkSuccessMessage();
    }

    @Test
    @Description("Long Press")
    public void longPressTest() {
        loginPage.logInAsRegisteredUser()
                .isListViewOpened();
        longPressPage.openLongPress()
                .isPageOpened();
        longPressPage.longPressAction()
                .checkSuccessMessage();
    }
    
    @Test
    @Description("Wheel Picker")
    public void wheelPickerTest() {
        double indexStart = 0.5;
        double indexY = 0.2;
        loginPage.logInAsRegisteredUser()
                .isListViewOpened()
                .swipeScrollView(indexStart, indexY);
        wheelPickerPage.openWheelPicker()
                .isPageOpened();
        wheelPickerPage.wheelPickerAction(3)
                .currentColorShouldBeCorrect();
    }
    
    @Test
    @Description("Carousel - Swipe left/right")
    public void carouselTest() {
        double indexStart = 0.5;
        double indexY = 0.2;
        loginPage.logInAsRegisteredUser()
                .isListViewOpened()
                .swipeScrollView(indexStart, indexY);
        carouselPage.openCarousel()
                    .isPageOpened();
        carouselPage.swipeRightScroll();
    }
}
