package utils;

import org.openqa.selenium.WebElement;

import java.util.Set;

public interface WebDriverActions {

    void click();
    void click(WebElement element);

    void sendKeys(WebElement element, String data);
    void sendKeys(String data);
    void SelectDropDown(WebElement element, String type, String option);
    void switchWindow(Set<String> windowhandle);
    void getText(WebElement element);
    void getTitle();
}
