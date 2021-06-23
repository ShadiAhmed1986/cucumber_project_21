package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pages.DefaultPage;
import pages.RoomReservationPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;
import java.util.List;

public class Room_Reservation_Step_Defs {
    DefaultPage defaultPage = new DefaultPage();
    RoomReservationPage roomReservationPage = new RoomReservationPage();
    Faker faker;

    @Given("user navigates to create_room_reservation_page")
    public void user_navigates_to_create_room_reservation_page() {
        defaultPage.hotelManagement.click();
        defaultPage.roomReservations.click();
        roomReservationPage.addRoomReservationButton.click();
    }
    @Given("user enters the IDUser")
    public void user_enters_the_id_user() {
        Select userIDdropDown = new Select(roomReservationPage.idUser);
        userIDdropDown.selectByIndex(1);
    }
    @Given("user enters the IDHotel")
    public void user_enters_the_id_hotel() {
        Select hotelIDdropDown = new Select(roomReservationPage.idHotelRoom);
        hotelIDdropDown.selectByIndex(2);
    }
    @Given("user enters the price")
    public void user_enters_the_price() {
        roomReservationPage.price.sendKeys("300");

    }
    @Given("user enters the date_start")
    public void user_enters_the_date_start() {
        roomReservationPage.dateStart.sendKeys("06/22/2021");

    }
    @Given("user enters the date_end")
    public void user_enters_the_date_end() {
        roomReservationPage.dateEnd.sendKeys("06/29/2021");

    }
    @Given("user enters the adult_amount")
    public void user_enters_the_adult_amount() {
        roomReservationPage.adultAmount.sendKeys("2");

    }
    @Given("user enters the children_amount")
    public void user_enters_the_children_amount() {
        roomReservationPage.childrenAmount.sendKeys("2");

    }
    @Given("user enters the contact_name")
    public void user_enters_the_contact_name() {
        faker = new Faker();
        roomReservationPage.nameAndSurname.sendKeys(faker.name().fullName());
    }
    @Given("user enters the contact_phone")
    public void user_enters_the_contact_phone() {
        faker = new Faker();
        roomReservationPage.contactPhone.sendKeys(faker.phoneNumber().phoneNumber());
    }
    @Given("user enters the contact_email")
    public void user_enters_the_contact_email() {
        faker = new Faker();
        roomReservationPage.contactEmail.sendKeys(faker.internet().emailAddress());
    }
    @Given("user enters the notes")
    public void user_enters_the_notes() {
        roomReservationPage.notes.sendKeys("No notes to enter");

    }
    @Given("user clicks on the approved checkbox")
    public void user_clicks_on_the_approved_checkbox() {
        roomReservationPage.approved.click();

    }
    @Given("user clicks on the is_paid checkbox")
    public void user_clicks_on_the_is_paid_checkbox() {
        roomReservationPage.isPaid.click();

    }
    @Given("user clicks on the save_button")
    public void user_clicks_on_the_save_button() {
        roomReservationPage.saveButton.click();

    }
    @Then("user verifies the success_message")
    public void user_verifies_the_success_message() {
        ReusableMethods.waitForVisibility(roomReservationPage.actualSuccessMessage,3);
        Assert.assertEquals(roomReservationPage.actualSuccessMessage.getText(), ConfigReader.getProperty("expectedReservationSuccessMessage"));
    }

//    ==================
    @Given("user enters the IDUser {string}")
    public void user_enters_the_id_user(String string) {
        Select userIDdropDown = new Select(roomReservationPage.idUser);
        userIDdropDown.selectByVisibleText(string);

    }
    @Given("user enters the IDHotel {string}")
    public void user_enters_the_id_hotel(String string) {
        Select hotelIDdropDown = new Select(roomReservationPage.idHotelRoom);
        hotelIDdropDown.selectByVisibleText(string);

    }
    @Given("user enters the price {string}")
    public void user_enters_the_price(String string) {
        roomReservationPage.price.sendKeys(string);

    }
    @Given("user enters the date_start {string}")
    public void user_enters_the_date_start(String string) {
        roomReservationPage.dateStart.sendKeys(string);

    }
    @Given("user enters the date_end {string}")
    public void user_enters_the_date_end(String string) {
        roomReservationPage.dateEnd.sendKeys(string);

    }
    @Given("user enters the adult_amount {string}")
    public void user_enters_the_adult_amount(String string) {
        roomReservationPage.adultAmount.sendKeys(string);

    }
    @Given("user enters the children_amount {string}")
    public void user_enters_the_children_amount(String string) {
        roomReservationPage.childrenAmount.sendKeys(string);

    }
    @Given("user enters the contact_name {string}")
    public void user_enters_the_contact_name(String string) {
        roomReservationPage.nameAndSurname.sendKeys(string);

    }
    @Given("user enters the contact_phone {string}")
    public void user_enters_the_contact_phone(String string) {
        roomReservationPage.contactPhone.sendKeys(string);

    }
    @Given("user enters the contact_email {string}")
    public void user_enters_the_contact_email(String string) {
        roomReservationPage.contactEmail.sendKeys(string);

    }
    @Given("user enters the notes {string}")
    public void user_enters_the_notes(String string) {
        roomReservationPage.notes.sendKeys(string);

    }
    @Then("user verifies the success_message {string}")
    public void user_verifies_the_success_message(String string) throws InterruptedException {
        ReusableMethods.waitForVisibility(roomReservationPage.actualSuccessMessage,10);
        Assert.assertEquals(roomReservationPage.actualSuccessMessage.getText(), string);
        roomReservationPage.okButton.click();
        Driver.refreshPage();
    }

    @Given("user enters all required fields")
    public void user_enters_all_required_fields(DataTable roomData) {
        List<String> testData = roomData.row(1);
        Select select = new Select(roomReservationPage.idUser);
        select.selectByVisibleText(testData.get(0));

        Select select1 = new Select(roomReservationPage.idHotelRoom);
        select1.selectByVisibleText(testData.get(1));

        roomReservationPage.price.sendKeys(testData.get(2));
        roomReservationPage.dateStart.sendKeys(testData.get(3));
        roomReservationPage.dateEnd.sendKeys(testData.get(4));
        roomReservationPage.adultAmount.sendKeys(testData.get(5));
        roomReservationPage.childrenAmount.sendKeys(testData.get(6));
        roomReservationPage.nameAndSurname.sendKeys(testData.get(7));
        roomReservationPage.contactPhone.sendKeys(testData.get(8));
        roomReservationPage.contactEmail.sendKeys(testData.get(9));
        roomReservationPage.notes.sendKeys(testData.get(10));
    }

    @Then("capture the screeenshot")
    public void capture_the_screeenshot() throws IOException {
        ReusableMethods.getScreenshot("ScreenShot For The Test");
    }
}
