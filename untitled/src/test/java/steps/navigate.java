package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class navigate {

    private WebDriver driver;

    @Before
    public void init() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("http://localhost/login.php");
        driver.manage().window().maximize();
        driver.findElement(By.id("login")).sendKeys("bee");
        driver.findElement(By.id("password")).sendKeys("bug");
        driver.findElement(By.xpath("//button[@value='submit']")).click();
    }
    @After
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
    @When("user click on the link in in the menu")
    public void userClickOnTheBlogInInTheMenu() {

        var button  = driver.findElement(By.cssSelector("a[href='credits.php']"));
        button.click();
    }

    @Then("user is redirected on the credits page")
    public void userIsRedirectedOnTheBlogPage() {
        assertEquals("http://localhost/credits.php", driver.getCurrentUrl());
    }
}
