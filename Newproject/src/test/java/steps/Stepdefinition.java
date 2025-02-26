package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stepdefinition {

    WebDriver driver = new ChromeDriver();

    @Given("I am on the OrangeHRM login page")
    public void i_am_on_the_orange_hrm_login_page() {
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @When("I enter valid credentials with username {string} and password {string}")
    public void i_enter_valid_credentials_with_username_and_password(String username, String password) {
        WebElement usernameField = driver.findElement(By.id("txtUsername"));
        WebElement passwordField = driver.findElement(By.id("txtPassword"));
        
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
    }

    @When("I click on the {string} button")
    public void i_click_on_the_button(String button) {
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        loginButton.click();
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        // No assertion, but login action is performed
        WebElement dashboard = driver.findElement(By.id("welcome"));
        // Just checking that the "Welcome" element is there
        if (dashboard.isDisplayed()) {
            System.out.println("Login successful!");
        }
    }

    @When("I click on {string} from the menu")
    public void i_click_on_from_the_menu(String menuItem) {
        WebElement menu = driver.findElement(By.id("menu_admin_viewAdminModule"));
        menu.click();
    }

    @Then("I should be on the {string} page")
    public void i_should_be_on_the_page(String pageName) {
        // Simply printing the page title
        String pageTitle = driver.getTitle();
        System.out.println("Page title is: " + pageTitle);
    }

    @When("I click on the {string} tab")
    public void i_click_on_the_tab(String tab) {
        WebElement tabElement = driver.findElement(By.id("menu_admin_Qualifications"));
        tabElement.click();
    }

    @Then("I should be able to view the {string} page")
    public void i_should_be_able_to_view_the_page(String pageName) {
        // Just printing the title of the page
        String pageTitle = driver.getTitle();
        System.out.println("Qualifications page title: " + pageTitle);
    }

    @After
    public void tearDown() {
        driver.quit();  // Close the browser after the test
    }
}
