package com.movil.test.utility;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;

import static io.appium.java_client.touch.offset.PointOption.point;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static java.time.Duration.ofSeconds;

public class CommunUtil {


    public static void insertValue(By element, String value) {
        Hook.getDriver().findElement(element).clear();
        Hook.getDriver().findElement(element).sendKeys(value);
    }

    public static void giveClick(By element) {
        Hook.getDriver().findElement(element).click();
    }

    public static void giveDoubleClick(MobileElement element) {
        element.click();
        element.click();
    }

    public static void uiScrollableByText(String _scrollContainer, String _childElement, String value) {
        MobileElement element = (MobileElement) Hook.getDriver().findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().descriptionContains(\"" + _scrollContainer + "\")).getChildByText("
                        + "new UiSelector().className(\"" + _childElement + "\"), \"" + value + "\")"));

        CommunUtil.giveDoubleClick(element);
    }

    public static void uiScrollableByDescription(String _scrollContainer, String _childElement, String value) {
        MobileElement element = (MobileElement) Hook.getDriver().findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().descriptionContains(\"" + _scrollContainer + "\")).getChildByDescription("
                        + "new UiSelector().className(\"" + _childElement + "\"), \"" + value + "\")"));

        CommunUtil.giveDoubleClick(element);
    }

    public static void uiScrollableByIntoViewText(String _scrollContainer, String value) {
        MobileElement element = (MobileElement) Hook.getDriver().findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().descriptionContains(\"" + _scrollContainer + "\")).scrollIntoView("
                        + "new UiSelector().text(\"" + value + "\"))"));

        System.out.println(element.getLocation());
    }


    public static void uiScrollableByIntoViewDescription(String _scrollContainer, String value) {
        MobileElement element = (MobileElement) Hook.getDriver().findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().descriptionContains(\"" + _scrollContainer + "\")).scrollIntoView("
                        + "new UiSelector().description(\"" + value + "\"))"));

        System.out.println(element.getLocation());
    }

    public static void uiScrollableByMaxSearchSwipes(String _scrollContainer, String value, int cantSwipe) {
        MobileElement element = (MobileElement) Hook.getDriver().findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().descriptionContains(\"" + _scrollContainer + "\")).setMaxSearchSwipes(" + cantSwipe + ").scrollIntoView("
                        + "new UiSelector().descriptionContains(\"" + value + "\"))"));

        System.out.println(element.getText());
    }

    public static void touchActionSwipe(int startx, int starty, int endx,int endy,int duration)
    {
        TouchAction touchAction = new TouchAction((PerformsTouchActions) Hook.getDriver());
        System.out.println(startx+" "+starty);
        System.out.println("Entering swipe");

        System.out.println("Swipe from "+startx +" " +starty +"to" +endx +" " +endy );
        touchAction.press(point(startx, starty)).waitAction(waitOptions(ofSeconds(duration))).moveTo(point(endx,endy)).release().perform();
    }


    public static void touchActionsByElements(MobileElement startElement, MobileElement endElement)
    {
        TouchAction actions = new TouchAction((PerformsTouchActions) Hook.getDriver());
        actions.press(ElementOption.element(startElement)).waitAction(waitOptions(ofSeconds(2))).moveTo(ElementOption.element(endElement)).release().perform();
    }

    public static void touchActionsByCoordinates(MobileElement _referencia)
    {
        Point point = _referencia.getLocation();
        int startX = point.x;
        int endX = point.x;

        int startY = (int) ((Hook.getDriver().manage().window().getSize().getHeight()) * 0.80);
        int endY = (int) ((Hook.getDriver().manage().window().getSize().getHeight()) * 0.20);

        TouchAction touchAction = new TouchAction((PerformsTouchActions) Hook.getDriver());
        touchAction.press(point(startX, startY)).waitAction(waitOptions(ofSeconds(2))).moveTo(point(endX,endY)).release().perform();
        System.out.println(_referencia.getLocation());
    }


    public static void touchActionsByLongClic(MobileElement element)
    {
        TouchAction actions = new TouchAction((PerformsTouchActions) Hook.getDriver());
        actions.longPress(ElementOption.element(element)).release().perform();
    }

    public static void touchActionsBytap(MobileElement element) {
        TouchAction actions = new TouchAction((PerformsTouchActions) Hook.getDriver());
        actions.tap(ElementOption.element(element)).release().perform();
    }


    public static void touchActionsByDragAndDrop(MobileElement elementInicio, MobileElement elementFin)
    {
        TouchAction actions = new TouchAction((PerformsTouchActions) Hook.getDriver());
        actions.longPress(ElementOption.element(elementInicio)).moveTo(ElementOption.element(elementFin)).release().perform();
    }


    public static void touchActionsBySlider(MobileElement seekbar)
    {
        int start=seekbar.getLocation().getX();
        int end=seekbar.getSize().getWidth();
        int y=seekbar.getLocation().getY();

        TouchAction action=new TouchAction((PerformsTouchActions) Hook.getDriver());

        //Move it 40%
        int moveTo=(int)(end*0.4);
        action.press(point(start,y)).moveTo(point(moveTo,y)).release().perform();
    }






    public static void waitSleep(int i) {

        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    public static void uiScrollableByText()
    {
        MobileElement element = (MobileElement) Hook.getDriver().findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().descriptionContains(\"scrollView\")).getChildByText("
                        + "new UiSelector().className(\"android.widget.TextView\"), \"Carousel\")"));

        CommunUtil.giveDoubleClick(element);
    }






}
