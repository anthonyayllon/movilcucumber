package com.movil.test.utility;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.seleniumhq.jetty9.util.Retainable;

import java.util.GregorianCalendar;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

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

    public static void touchActionSwipe(int startx, int starty, int endx, int endy, int duration) {
        TouchAction touchAction = new TouchAction((PerformsTouchActions) Hook.getDriver());
        System.out.println(startx + " " + starty);
        System.out.println("Entering swipe");

        System.out.println("Swipe from " + startx + " " + starty + "to" + endx + " " + endy);
        touchAction.press(point(startx, starty)).waitAction(waitOptions(ofSeconds(duration))).moveTo(point(endx, endy)).release().perform();
    }


    public static void touchActionsByElements(MobileElement startElement, MobileElement endElement) {
        TouchAction actions = new TouchAction((PerformsTouchActions) Hook.getDriver());
        actions.press(ElementOption.element(startElement)).waitAction(waitOptions(ofSeconds(2))).moveTo(ElementOption.element(endElement)).release().perform();
    }

    public static void touchActionsByCoordinates(MobileElement _referencia) {
        Point point = _referencia.getLocation();
        int startX = point.x;
        int endX = point.x;

        int startY = (int) ((Hook.getDriver().manage().window().getSize().getHeight()) * 0.80);
        int endY = (int) ((Hook.getDriver().manage().window().getSize().getHeight()) * 0.20);

        TouchAction touchAction = new TouchAction((PerformsTouchActions) Hook.getDriver());
        touchAction.press(point(startX, startY)).waitAction(waitOptions(ofSeconds(2))).moveTo(point(endX, endY)).release().perform();
        System.out.println(_referencia.getLocation());
    }


    public static void touchActionsByLongClic(MobileElement element) {
        TouchAction actions = new TouchAction((PerformsTouchActions) Hook.getDriver());
        actions.longPress(ElementOption.element(element)).release().perform();
    }

    public static void touchActionsBytap(MobileElement element) {
        TouchAction actions = new TouchAction((PerformsTouchActions) Hook.getDriver());
        actions.tap(ElementOption.element(element)).release().perform();
    }


    public static void touchActionsByDragAndDrop(MobileElement elementInicio, MobileElement elementFin) {
        TouchAction actions = new TouchAction((PerformsTouchActions) Hook.getDriver());
        actions.longPress(ElementOption.element(elementInicio)).moveTo(ElementOption.element(elementFin)).release().perform();
    }


    public static void touchActionsBySlider(MobileElement seekbar) {
        int start = seekbar.getLocation().getX();
        int end = seekbar.getSize().getWidth();
        int y = seekbar.getLocation().getY();

        TouchAction action = new TouchAction((PerformsTouchActions) Hook.getDriver());

        //Move it 40%
        int moveTo = (int) (end * 0.4);
        action.press(point(start, y)).moveTo(point(moveTo, y)).release().perform();
    }


    public static void waitSleep(int i) {

        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void uiScrollableByText() {
        MobileElement element = (MobileElement) Hook.getDriver().findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().descriptionContains(\"scrollView\")).getChildByText("
                        + "new UiSelector().className(\"android.widget.TextView\"), \"Carousel\")"));

        CommunUtil.giveDoubleClick(element);
    }


    //Funcion para generar DNI
    public static String randomDni() {

        String randonNumberDni = "";

        String SALTCHARS = "1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 8) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        randonNumberDni = salt.toString();
        return randonNumberDni;
    }

    //Funcion para generar numero de casa
    public static long randomNumberHouse() {
        long randonNumberHouse = 0;
        randonNumberHouse = Math.round(Math.random() * 100000);

        return randonNumberHouse;
    }

    //Funcion para generar numero de celular
    public static String randomNumberPhone() {
        String randonNumberPhone = "";

        String SALTCHARS = "1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 8) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        randonNumberPhone = "9"+salt.toString();

        return randonNumberPhone;

    }

    //Funcion generar cadenas aleatorias segun cantidad dada
    public static String randomStringMax(int countLetter) {
        Random r = new Random();
        String upToNCharacters = "";

        for (int i = 0; i < countLetter; i++) {
            char c = (char) (r.nextInt(26) + 'a');
            upToNCharacters += String.valueOf(c);
        }
        return upToNCharacters.toUpperCase();
    }

    //Funcion genera email aleatorios segun tipo email
    public static String randomEmail(String tipyEmail) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        saltStr = saltStr + tipyEmail;
        return saltStr;
    }


    public static String nameRandom() {
        String varNombres[] = {"Luis Jorge", "Roberto Luis ", "Marco Antonio", "Bryan Paul", "Leandro", "Beto", "Sebastian Leo", "Rodrigo Michael", "Alejandro", "Nolberto", "Anthony", "Bob", "Anibal", "Pedro Cruz", "Alex Carlos", "Oscar", "Martin", "Carlos", "Pablo Leo", "Omar Martin"};
        double varRandom = Math.floor((Math.random()) * 20); //donde 5 el la cantidad de nombres ^_^
        String value = varNombres[(int) (varRandom)]; //Muestras el nombre

        return value;
    }

    public static String lastNameRandom() {
        String varNombres[] = {"Bejarano", "Roberto", "Martines", "Rivadeneira", "Dejo", "Ruiz", "Donayre", "Veliz", "Velarde", "Castro", "Gomez", "Jurado", "Perez", "Hinostroza", "Carlos", "Pratt", "Justino", "Sanchez", "Arana", "Nicaragua"};
        double varRandom = Math.floor((Math.random()) * 20); //donde 5 el la cantidad de nombres ^_^
        String value = varNombres[(int) (varRandom)]; //Muestras el nombre

        return value;
    }

    public static String seconLastNameRandom() {
        String varNombres[] = {"Rosales", "Martinez", "Frío", "Santa Marina", "Espinoza", "Baigorria", "Vizcarra", "Leiva", "Ninanhuanca", "Osorio", "Chavez", "Cotera", "Bastidas", "Bellido", "Joaquin", "Peralta", "Fríaz", "Nina", "Nuñez", "Melendez"};
        double varRandom = Math.floor((Math.random()) * 20); //donde 5 el la cantidad de nombres ^_^
        String value = varNombres[(int) (varRandom)]; //Muestras el nombre

        return value;
    }

    public static String streetRandom() {
        String varNombres[] = {"Av. Rosales", "Ca. Martinez", "Jr. Frío", "Pje. Santa Marina", "Ca. Espinoza", "Jr. Baigorria", "Av. Vizcarra", "Ca. Leiva", "Jr. Ninanhuanca", "Av. Osorio", "Pje. Chavez", "Jr. Cotera", "Av. Bastidas", "Jr. Bellido", "Ca. Joaquin", "Pje. Peralta", "Ca. Fríaz", "Av. Nina", "Av. Nuñez", "Ca. Melendez"};
        double varRandom = Math.floor((Math.random()) * 20); //donde 5 el la cantidad de nombres ^_^
        String value = varNombres[(int) (varRandom)]; //Muestras el nombre

        return value;
    }

    public static String referensRandom() {
        String varNombres[] = {"Parque Grau", "A 2 cuadras del municipio", "Cerca del Hospital Grau", "A una cuadra del colegio Circo", "Al frente de la libreria Hola", "Al frente de la municipalidad", "Cerca al parque Pedro Ruiz", "A 2 cuadras del canal 4", "Al frente de una panaderia", "Cruzando la calle Perez", "Cruzando la iglesia", "A dos casas de la iglesia", "Al lado de la comisaria", "Junto al municipio", "Esquina con Av. Arequipa", "Al frente del restaurante 7 sopas", "A la espalda de la Sunat", "Al frente de Plaza Vea", "A una cuadra del canal 2", "A 5 cuadras de la torre de Interbank"};
        double varRandom = Math.floor((Math.random()) * 20); //donde 5 el la cantidad de nombres ^_^
        String value = varNombres[(int) (varRandom)]; //Muestras el nombre

        return value;
    }

    public static String countryRandom() {
        String varNombres[] = {"AD", "AF", "AG", "AI", "AL", "AM", "AO", "AR", "AT", "AU", "AW", "AZ", "BA", "BB", "BD", "BE", "BF", "BG", "BH", "BI"};
        double varRandom = Math.floor((Math.random()) * 20); //donde 5 el la cantidad de nombres ^_^
        String value = varNombres[(int) (varRandom)]; //Muestras el nombre

        return value;
    }

    public static String segmentation() {
        String varNombres[] = {"Diamond", "Platinum","Gold","Blue"};
        double varRandom = Math.floor((Math.random()) * 4); //donde 5 el la cantidad de nombres ^_^
        String value = varNombres[(int) (varRandom)]; //Muestras el nombre

        return value;
    }



    public static String randomCharacter()
    {
        Random r = new Random();
        char c = (char)(r.nextInt(26) + 'a');

        return (String.valueOf(c)).toUpperCase();
    }


    public static String randomDateOfBirth() {

        GregorianCalendar gc = new GregorianCalendar();
        int year = randBetween(1900, 2010);
        gc.set(gc.YEAR, year);
        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
        gc.set(gc.DAY_OF_YEAR, dayOfYear);

        String day =    gc.get(gc.DAY_OF_MONTH)+ "" ;
        if(day.length()==1)
        {
            day ="0"+day;
        }

        String month =  (gc.get(gc.MONTH) + 1)+ "" ;
        if(month.length()==1)
        {
            month ="0"+month;
        }

        String yearr =  gc.get(gc.YEAR)+"";

        String date = day+"/"+month+"/"+yearr;
        return date;
    }

    public static int randBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    //Generar 8 ó 9
    public static int randomNumber(int min, int max) {
        Random r = new Random();
        int result = r.nextInt(max-min) + min;
        return result;
    }


    public static void main(String[] args) {
        System.out.println(randomDateOfBirth());
        System.out.println(randomDateOfBirth());
        System.out.println(randomDateOfBirth());
    }


}
