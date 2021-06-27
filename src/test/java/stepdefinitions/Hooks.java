package stepdefinitions;
//jUnit @Before -> Before each @Test.
//Cucumber @Before -> Before each Scenario. No need to extend Hooks class

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

public class Hooks {
//    @Before
//    public void setUp(){
//        System.out.println("Calling the driver");
//    }
//
//    @After
//    public void tearDown(Scenario scenario){
//        final byte[] screenshot=((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
////        Attaching the screenshot to the reports if scenario fails
//        if (scenario.isFailed()){
//            scenario.attach(screenshot,"image/png","ScreenShot ");
//        }
//    }
}
