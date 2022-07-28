package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class DbUtils {

    public void establishDBConnection(){

    }
    public void resetConnectionPool(){

    }

    public void executeQuery(){

    }

    @Test
    public void initializeDriver(String driver){

        if(driver.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            ChromeDriver chromeDriver = new ChromeDriver();
        }
        else if (driver.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            FirefoxDriver chromeDriver = new FirefoxDriver();
        }



    }
}
