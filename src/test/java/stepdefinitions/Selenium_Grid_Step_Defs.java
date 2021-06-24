package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utilities.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Selenium_Grid_Step_Defs {
    WebDriver driver;
    @Given("user is on the application_login page with chrome")
    public void user_is_on_the_application_login_page_with_chrome() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setBrowserName("chrome");
//        for Mac users
        cap.setPlatform(Platform.MAC);
//        for Windows users
//        cap.setPlatform(Platform.WINDOWS);
//        for any operating system
//        cap.setPlatform(Platform.ANY);

        ChromeOptions options = new ChromeOptions();
        options.merge(cap);

        String hubURL = "http://192.168.1.7:4445/wd/hub";

        driver = new RemoteWebDriver(new URL(hubURL),options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get(ConfigReader.getProperty("application_url"));
    }
    @Then("verify the title includes resortsline")
    public void verify_the_title_includes_resortsline() {
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("resortsline"));
    }
}
