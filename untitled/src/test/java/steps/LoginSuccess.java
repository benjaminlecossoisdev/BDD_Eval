package steps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginSuccess {
    private WebDriver driver;

    @Before
    public void init() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("http://localhost/login.php");
    }

    @After
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("user is on the home page")
    public void userIsOnTheHomePage() {
        assertEquals("http://localhost/login.php", driver.getCurrentUrl());
    }

    @When("user fill the login input with {string}")
    public void whenUserFillTheLoginInputWith(String myLogin) {
        var loginInput = driver.findElement(By.id("login"));
        loginInput.clear();
        loginInput.sendKeys(myLogin);
    }

    @And("user fill the password input with {string}")
    public void userFillThePasswordInputWith(String myPassword) {
        var passwordInput = driver.findElement(By.id("password"));
        passwordInput.clear();
        passwordInput.sendKeys(myPassword);
    }

    @Then("user click on the login button")
    public void userClickOnTheLoginButton() {
        var button = driver.findElement(By.xpath("//button[@value='submit']"));
        button.click();
    }

    @And("user should be redirected to portal page")
    public void iShouldBeRedirectedToPortalPage() {
        assertEquals("http://localhost/portal.php", driver.getCurrentUrl());
    }
}
