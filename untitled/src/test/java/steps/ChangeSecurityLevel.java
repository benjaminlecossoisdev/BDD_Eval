package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChangeSecurityLevel {

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
    @AfterEach
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
    @Given("user is logged in and on the home page")
    public void userIsLoggedInAndOnTheHomePage() {
        assertEquals("http://localhost/portal.php", driver.getCurrentUrl());
    }

    @When("user click on the link in the menu bar")
    public void userClickOnTheLinkInTheMenuBar() {
        var button  = driver.findElement(By.cssSelector("a[href='security_level_set.php']"));
        button.click();

    }

    @And("user is redirected to a new page")
    public void userIsRedirectedToANewPage() {
        assertEquals("http://localhost/security_level_set.php", driver.getCurrentUrl());
    }

    @Then("user click on the dropdown to select a new option")
    public void userClickOnTheDropdownToSelectANewOption() {
       WebElement menu=  driver.findElement(By.name("security_level"));
        Select select = new Select(menu);
        select.selectByVisibleText("medium");
    }

    @And("user click on the  button")
    public void userClickOnTheButton() {
        driver.findElement(By.xpath("//button[@value='submit']")).click();
    }

    @And("security level is now updated")
    public void securityLevelIsNowUpdated() {
        var text = driver.findElement(By.cssSelector("p")).getText();
        assertEquals("Your security level is medium.", text);

    }
}
