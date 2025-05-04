package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LoginFailure {

    private WebDriver driver;

    @Before
    public void init() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("http://localhost/login.php");

    }
    @AfterEach
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
    @And("user should not be redirected to portal page")
    public void userShouldNotBeRedirectedToPortalPage() {
        assertNotEquals("http://localhost/portal.php",driver.getCurrentUrl());
    }

    @And("user should see an error message")
    public void userShouldSeeAnErrorMessage() {
        var errorMessage = driver.findElement(By.cssSelector("font[color='red']")).getText();
        assertEquals(errorMessage, "Invalid credentials or user not activated!");
    }
}
