package utils;

import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

public class WebElementActions implements WebElementsInf, WebDriverActions, WebDrivermethods{

    @Override
    public WebElement locateElement(String locator) {
        return null;
    }

    @Override
    public List<WebElement> locateElements(String locator) {
        return null;
    }

    @Override
    public void click() {

    }

    @Override
    public void click(WebElement element) {

    }

    @Override
    public void sendKeys(WebElement element, String data) {

    }

    @Override
    public void sendKeys(String data) {

    }

    @Override
    public void SelectDropDown(WebElement element, String type, String option) {

    }

    @Override
    public void switchWindow(Set<String> windowhandle) {

    }

    @Override
    public void getText(WebElement element) {

    }

    @Override
    public void getTitle() {

    }

    @Override
    public void startDriver() {

    }

    @Override
    public void quit() {

    }

    @Override
    public void close() {

    }
}
