package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Logout {

    private WebDriver driver;

    @Before
    public void init() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("http://localhost/login.php");
        driver.findElement(By.id("login")).sendKeys("bee");
        driver.findElement(By.id("password")).sendKeys("bug");
        driver.findElement(By.xpath("//button[@value='submit']")).click();
    }
    @AfterEach
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("user is logged on the portal page")
    public void userIsLoggedOnThePortalPage() {
        assertEquals("http://localhost/portal.php", driver.getCurrentUrl());
    }

    @When("user click on the logout button")
    public void userClickOnTheLogoutButton() {
        var logoutButton  = driver.findElement(By.cssSelector("a[href='logout.php']"));
        logoutButton.click();
    }

    @Then("user click is redirected to login page")
    public void userClickIsRedirectedToLoginPage() {
        assertEquals("http://localhost/login.php", driver.getCurrentUrl());
    }
}
