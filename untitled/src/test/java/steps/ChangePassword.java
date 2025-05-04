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

public class ChangePassword {


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
    }   private WebDriver driver;



    @And("user click on the change password button on the menu")
    public void userClickOnTheChangePasswordButtonOnTheMenu() {
        var button  = driver.findElement(By.cssSelector("a[href='password_change.php']"));
        button.click();
    }

    @When("user is redirected to the password change page")
    public void userIsRedirectedToThePasswordChangePage() {
        assertEquals("http://localhost/password_change.php",driver.getCurrentUrl());
    }

    @And("user fill the first input with his old password")
    public void userFillTheFirstInputWithHisOldPassword() {
        driver.findElement(By.id("password_curr")).sendKeys("bug");
    }

    @And("user fill the second input with his new password")
    public void userFillTheSecondInputWithHisNewPassword() {
        driver.findElement(By.id("password_new")).sendKeys("Bee");
    }

    @And("user fill the third input with his new password again")
    public void userFillTheThirdInputWithHisNewPasswordAgain() {
        driver.findElement(By.id("password_conf")).sendKeys("Bee");
    }

    @Then("user click on the save button")
    public void userClickOnTheSaveButton() {
        driver.findElement(By.xpath("//button[@value='change']")).click();
    }

    @And("user can see a confirmation message on the screen")
    public void userCanSeeAConfirmationMessageOnTheScreen() {
        var message = driver.findElement(By.cssSelector("font[color='green']")).getText();
        assertEquals(message, "The password has been changed!");
    }
}
