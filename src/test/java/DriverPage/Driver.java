package DriverPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class Driver {
    public static WebDriver driver;
    public String baseurl;

    @Before
    public void openbrowser(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        baseurl="https://www.argos.co.uk/";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get(baseurl);


    }
@After
    public void close(){
    driver.quit();
    }
}

