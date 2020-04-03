
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class StepDefination {
    private WebDriver driver;
    private String baseurl;

    @Given("^i am on webpage$")
    public void i_am_on_webpage () {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        baseurl="https://www.argos.co.uk/";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get(baseurl);

    }

    @When("^i search for product$")
    public void i_search_for_product() throws InterruptedException {
        driver.findElement(By.id("searchTerm")).sendKeys("washing machine");
        driver.findElement(By.id("searchTerm")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);

    }


    public String selectAnyProduct() throws InterruptedException {
        List<WebElement> productWebElements = driver.findElements(By.cssSelector("a[data-test='component-product-card-title']"));
        if (productWebElements.size() == 0) {

            Random random = new Random();
            int randomNumber = random.nextInt(productWebElements.size() - 1);
            WebElement selectedElements = productWebElements.get(randomNumber);
            String selectedproductname = selectedElements.getText();
            selectedElements.click();
            Thread.sleep(3000);

        }
        return  selectAnyProduct();
    }


    @Then("^i should  select product and put it in basket\\.$")
    public void i_should_select_product_and_put_it_in_basket() {
        driver.findElement(By.cssSelector("button[data-test='component-att-button']")).click();
    }

}
