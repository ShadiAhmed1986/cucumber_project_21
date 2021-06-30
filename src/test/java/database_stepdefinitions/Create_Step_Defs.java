package database_stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utilities.DBUtils;

import java.sql.SQLException;

public class Create_Step_Defs {

    @When("user creates new hotel with a {string}")
    public void user_creates_new_hotel_with_a(String hotelData) throws SQLException {
        String query = "INSERT INTO tHOTEL (Code, Name, Address, Phone, Email)"
        + "VALUES ("+hotelData+")";
        DBUtils.getStatement().executeUpdate(query);

    }
    @Then("verify the hotel is created successfully")
    public void verify_the_hotel_is_created_successfully() {
        String query = "SELECT Name FROM tHOTEL";
        Assert.assertTrue(DBUtils.getColumnData(query,"Name").toString().contains("Jumping Beans"));
    }
    @Then("close the connection")
    public void close_the_connection() {
        DBUtils.closeConnection();
    }
}
