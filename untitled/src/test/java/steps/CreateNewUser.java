package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateNewUser {

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
    @After
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
    @And("user click on the create user button on the menu")
    public void userClickOnTheCreateUserButtonOnTheMenu() {
        var button  = driver.findElement(By.cssSelector("a[href='user_extra.php']"));
        button.click();
    }

    @When("user is redirected to the new page")
    public void userIsRedirectedToTheNewPage() {
        assertEquals("http://localhost/user_extra.php", driver.getCurrentUrl());
    }

    @And("user fill the first input with his login")
    public void userFillTheFirstInputWithHisLogin() {
        driver.findElement(By.id("login")).sendKeys("Benjamin");
    }

    @And("user fill the second input with his email")
    public void userFillTheSecondInputWithHisEmail() {
        driver.findElement(By.id("email")).sendKeys("lecossois.benjamin@gmail.com");

    }

    @And("user fill the third input with his password")
    public void userFillTheThirdInputWithHisPassword() {
        driver.findElement(By.id("password")).sendKeys("bug");

    }

    @And("user fill the fourth input with his password confirmation")
    public void userFillTheFourthInputWithHisPasswordConfirmation() {
        driver.findElement(By.id("password_conf")).sendKeys("bug");

    }

    @And("user fill the fifth input with his secret")
    public void userFillTheFifthInputWithHisSecret() {
        driver.findElement(By.id("secret")).sendKeys("Beebug");

    }

    @Then("user click on the submit button")
    public void userClickOnTheSubmitButton() {
        driver.findElement(By.name("action")).click();
    }

    @And("user stay on the same page with a confirmation message on the screen")
    public void userStayOnTheSamePageWithAConfirmationMessageOnTheScreen() {
        assertEquals("http://localhost/user_extra.php", driver.getCurrentUrl());

        var message = driver.findElement(By.cssSelector("font[color='green']")).getText();
        assertEquals(message, "User successfully created!");

    }
}
