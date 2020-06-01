package com.movil.test.pages;

import com.movil.test.utility.CommunUtil;
import com.movil.test.utility.Hook;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.AndroidKey;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static java.time.Duration.ofSeconds;

public class OperationPage {

    By txtUser   = By.id("username");
    By txtPass   = By.id("password");
    By btnLog    = By.xpath("//android.view.View[@content-desc='login']/android.widget.Button/android.widget.TextView");
    By btnSlider = By.xpath("//android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View[1]/android.view.View/android.view.View/android.widget.HorizontalScrollView/android.view.View/android.view.View/android.view.View");
    By listParent = By.xpath("//android.widget.ScrollView[@content-desc='scrollView']/android.view.View");

    String container = "scrollView";
    String child  = "android.widget.TextView";
    String startElementt = "//android.widget.TextView[@text = '$']";
    String endElementt = "//android.widget.TextView[@text = '$']";

    public void inserteUsuarioYPassword(String _user, String _pass )
    {
        if(!_user.isEmpty())
        {
            System.out.println("Insert user: "+_user);
            CommunUtil.insertValue(txtUser,_user);
        }

        if(!_pass.isEmpty())
        {
            System.out.println("Insert pass: "+_pass);
            CommunUtil.insertValue(txtPass,_pass);
        }
    }

    public void login()
    {
        System.out.println("Give clic button Log In");
        ((AndroidDriver) Hook.getDriver()).pressKey(new KeyEvent(AndroidKey.BACK));
        CommunUtil.giveClick(btnLog);
    }

    public void searchOptionsOne(String _option)
    {
        CommunUtil.waitSleep(1000);
        CommunUtil.uiScrollableByText(container,child,_option);
    }

    public void searchOptionsTwo(String _option)
    {
        CommunUtil.waitSleep(1000);
        CommunUtil.uiScrollableByDescription(container,child,_option);
    }

    public void searchOptionsThree(String _option)
    {
        CommunUtil.waitSleep(1000);
        CommunUtil.uiScrollableByIntoViewText(container,_option);
    }

    public void searchOptionsFour(String _option)
    {
        CommunUtil.waitSleep(1000);
        CommunUtil.uiScrollableByIntoViewDescription(container,_option);
    }

    public void searchOptionsFive(String _option)
    {
        CommunUtil.waitSleep(1000);
        CommunUtil.uiScrollableByMaxSearchSwipes(container,_option,3);
    }

    public void searchOptionsSix()
    {
        CommunUtil.waitSleep(1000);
        CommunUtil.touchActionSwipe(234,726,250,311,2);
    }

    public void searchOptionsSeven(String _inicio, String _fin)
    {
        MobileElement startElement = (MobileElement)Hook.getDriver().findElement(MobileBy.xpath(startElementt.replace("$",_inicio)));
        MobileElement endElement  = (MobileElement)Hook.getDriver().findElement(MobileBy.xpath(endElementt.replace("$",_fin)));
        CommunUtil.waitSleep(1000);
        CommunUtil.touchActionsByElements(startElement,endElement);
    }

    public void searchOptionsEight(String _referencia)
    {
        MobileElement startElement = (MobileElement)Hook.getDriver().findElement(MobileBy.xpath(startElementt.replace("$",_referencia)));
        CommunUtil.waitSleep(1000);
        CommunUtil.touchActionsByCoordinates(startElement);
    }


    public void searchOptionsNine()
    {
        By text = By.xpath("//android.widget.TextView[@text = 'Vertical swiping']");
        System.out.println("\nElemento identificado por @text: "+Hook.getDriver().findElement(text).getText());

        By containt = By.xpath("//android.widget.TextView[contains(@text(),'er')]");
        List<WebElement> list= Hook.getDriver().findElements(containt);
        for(WebElement value: list)
        {
            System.out.println("\nElemento identificado por contains: "+value.getText());
        }

        By sibling = By.xpath("//android.view.View[@content-desc=\"chainedView\"]/android.view.View/following-sibling:://android.widget.TextView[@content-desc=\"chainedView\"]");
        System.out.println("\nElemento identificado por sibling: "+Hook.getDriver().findElement(sibling).getText());
    }


    public void searchOptionsTen(String _value)
    {
        CommunUtil.uiScrollableByText(container,child,_value);
        MobileElement elementInicio = (MobileElement)Hook.getDriver().findElement(MobileBy.id("dragMe"));
        MobileElement elementFin = (MobileElement)Hook.getDriver().findElement(MobileBy.id("dropzone"));
        CommunUtil.touchActionsByDragAndDrop(elementInicio,elementFin);
    }

    public void searchOptionsEleven(String _value)
    {
        CommunUtil.uiScrollableByText(container,child,_value);
        MobileElement elementInicio = (MobileElement)Hook.getDriver().findElement(MobileBy.id("slider"));
        CommunUtil.touchActionsBySlider(elementInicio);
    }











}
