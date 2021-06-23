package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import pages.DefaultPage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class Login_Step_Defs {
    LoginPage loginPage = new LoginPage();
    DefaultPage defaultPage = new DefaultPage();

    @Given("user is on the application_login page")
    public void user_is_on_the_application_login_page() {
        Driver.getDriver().get(ConfigReader.getProperty("application_login_url"));
    }
    @Given("user enters manager_id {string}")
    public void user_enters_manager_id(String string) {
        loginPage.username.sendKeys(string);
    }
    @Given("user enters manager_password {string}")
    public void user_enters_manager_password(String string) {
        loginPage.password.sendKeys(string);
    }
    @Given("clicks on login button")
    public void clicks_on_login_button() {
        loginPage.loginButton.click();
    }
    @Given("verify login {string} is displayed")
    public void verify_login_is_displayed(String string) {
        Assert.assertEquals(defaultPage.userID.getText(),string);
    }

    @Given("user enters manager_username and manager_password")
    public void user_enters_manager_username_and_manager_password(DataTable credentials) {
        List<String> managerCredentials = credentials.row(0);
        loginPage.username.sendKeys(managerCredentials.get(0));
        loginPage.password.sendKeys(managerCredentials.get(1));
    }
}
