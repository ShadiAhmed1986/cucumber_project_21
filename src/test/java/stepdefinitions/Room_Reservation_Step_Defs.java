package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DefaultPage;
import pages.RoomReservationPage;
import utilities.Driver;

public class Room_Reservation_Step_Defs {
    DefaultPage defaultPage = new DefaultPage();
    RoomReservationPage roomReservationPage = new RoomReservationPage();
    Faker faker;

    @Given("user navigates to create_room_reservation_page")
    public void user_navigates_to_create_room_reservation_page() {
        defaultPage.hotelManagement.click();
        defaultPage.hotelRooms.click();
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
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.visibilityOf(roomReservationPage.actualSuccessMessage));
        Assert.assertEquals(roomReservationPage.actualSuccessMessage.getText(),"RoomReservation was inserted successfully");
    }
}
