package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class catag {
    WebDriver driver=null;
boolean t=false;
    @Given("the user is on the home page")
    public void the_user_is_on_the_home_page() {
        driver=new ChromeDriver();
        driver.get("file://C://Users//PC//Desktop//selcuc//selcuc//src//main//resources//Home.html");
        try {
            Thread.sleep(2000);
        }
        catch (Exception e){
            System.out.println("Erooooooooooooooooooooor");
        }
    }



    @When("the user navigates to the {string} section")
    public void the_user_navigates_to_the_section(String string) {
        driver.get("file://C:/Users/PC/Desktop/selcuc/selcuc/src/main/resources/Interior Accesories.html");
        try {
            Thread.sleep(2000);
        }
        catch (Exception e){
            System.out.println("Erooooooooooooooooooooor");
        }
    }

    @Given("the user is on the accessories page")
    public void theUserIsOnTheAccessoriesPage() {
        driver=new ChromeDriver();
        driver.get("C://Users//PC//Desktop//selcuc//selcuc//src//main//resources//Interior Accesories.html");
        try {
            Thread.sleep(2000);
        }
        catch (Exception e){
            System.out.println("Erooooooooooooooooooooor");
        }

    }




    @When("the user clicks the Information button for  Seat Cover")
    public void theUserClicksTheInformationButtonForSeatCover() {
        driver.findElement(By.id("info")).isDisplayed();
        try {
            Thread.sleep(2000);
        }
        catch (Exception e){
            System.out.println("Erooooooooooooooooooooor");
        }
    }

    @Then("the user should see information about  Seat Cover")
    public void the_user_should_see_information_about_seat_cover() {

        WebElement element = driver.findElement(By.id("info"));
        ((JavascriptExecutor) driver).executeScript("toggleInformation('seat_cover_info')");
        try {
            Thread.sleep(2000);
        }
        catch (Exception e){
            System.out.println("Erooooooooooooooooooooor");
        }
    }


    @When("the user clicks the ShowLess button for  Seat Cover")
    public void theUserClicksTheShowLessButtonForSeatCover() {
        driver.findElement(By.id("showless")).isDisplayed();
    }

    @Then("the user should see Seat Cover without information")
    public void theUserShouldSeeSeatCoverWithoutInformation() {

    WebElement element = driver.findElement(By.id("showless"));
        ((JavascriptExecutor) driver).executeScript("showless('seat_cover_info')");
        try {
            Thread.sleep(2000);
        }
        catch (Exception e){
            System.out.println("Erooooooooooooooooooooor");
        }
    }

    @When("the user clicks on the Interior Accessories button")
    public void theUserClicksOnTheInteriorAccessoriesButton() {
        driver.get("file://C://Users//PC//Desktop//selcuc//selcuc//src//main//resources//Interior Accesories.html");

    }


    @When("the user clicks the Information button for  Floor Mate")
    public void theUserClicksTheInformationButtonForFloorMate() {
        driver.findElement(By.id("info_floor")).isDisplayed();

        try {
            Thread.sleep(2000);
        }
        catch (Exception e){
            System.out.println("Erooooooooooooooooooooor");
        }
    }

    @Then("the user should see information about   Floor Mate")
    public void theUserShouldSeeInformationAboutFloorMate() {
        WebElement element = driver.findElement(By.id("info_floor"));
        ((JavascriptExecutor) driver).executeScript("toggleInformation('floor_mats_info')");
        try {
            Thread.sleep(2000);
        }
        catch (Exception e){
            System.out.println("Erooooooooooooooooooooor");
        }
    }

    @When("the user clicks the ShowLess button for  Floor Mate")
    public void theUserClicksTheShowLessButtonForFloorMate() {
        driver.findElement(By.id("showless_floor")).isDisplayed();
        try {
            Thread.sleep(2000);
        }
        catch (Exception e){
            System.out.println("Erooooooooooooooooooooor");
        }
    }

    @Then("the user should see Floor Mate without information")
    public void theUserShouldSeeFloorMateWithoutInformation() {
        WebElement element = driver.findElement(By.id("showless_floor"));
        ((JavascriptExecutor) driver).executeScript("showless('floor_mats_info')");
        try {
            Thread.sleep(2000);
        }
        catch (Exception e){
            System.out.println("Erooooooooooooooooooooor");
        }
    }

    @When("the user clicks the Information button for  Dashboard covers")
    public void theUserClicksTheInformationButtonForDashboardCovers() {
        driver.findElement(By.id("info_Dash")).isDisplayed();
    }

    @Then("the user should see information about  Dashboard covers")
    public void theUserShouldSeeInformationAboutDashboardCovers() {
        WebElement element = this.driver.findElement(By.id("info_Dash"));
        ((JavascriptExecutor)this.driver).executeScript("toggleInformation('dashboard_covers_info')", new Object[0]);

        try {
            Thread.sleep(2000L);
        } catch (Exception var3) {
            System.out.println("Erooooooooooooooooooooor");
        }
    }

    @When("the user clicks the ShowLess button for  Dashboard covers")
    public void theUserClicksTheShowLessButtonForDashboardCovers() {
        driver.findElement(By.id("showless_dash"));
    }

    @Then("the user should see Dashboard covers without information")
    public void theUserShouldSeeDashboardCoversWithoutInformation() {
        WebElement element = driver.findElement(By.id("showless_dash"));
        ((JavascriptExecutor) driver).executeScript("showless('dashboard_covers_info')");
        try {
            Thread.sleep(2000);
        }
        catch (Exception e){
            System.out.println("Erooooooooooooooooooooor");
        }
    }


    @When("the user clicks the Information button for Steering wheel covers")
    public void the_user_clicks_the_information_button_for_steering_wheel_covers() {
        driver.findElement(By.id("info_wh")).isDisplayed();
    }

    @Then("the user should see information about Steering wheel covers")
    public void the_user_should_see_information_about_steering_wheel_covers() {
        WebElement element = this.driver.findElement(By.id("info_wh"));
        ((JavascriptExecutor)this.driver).executeScript("toggleInformation('steering_wheel_covers_info')", new Object[0]);

        try {
            Thread.sleep(2000L);
        } catch (Exception var3) {
            System.out.println("Erooooooooooooooooooooor");
        }

    }

    @When("the user clicks the ShowLess button for Steering wheel covers")
    public void the_user_clicks_the_show_less_button_for_steering_wheel_covers() {
        driver.findElement(By.id("showless_wh")).isDisplayed();
    }

    @Then("the user should see Steering wheel covers without information")
    public void the_user_should_see_steering_wheel_covers_without_information() {
        WebElement element = driver.findElement(By.id("showless_wh"));
        ((JavascriptExecutor) driver).executeScript("showless('steering_wheel_covers_info')");
        try {
            Thread.sleep(2000);
        }
        catch (Exception e){
            System.out.println("Erooooooooooooooooooooor");
        }
    }
}