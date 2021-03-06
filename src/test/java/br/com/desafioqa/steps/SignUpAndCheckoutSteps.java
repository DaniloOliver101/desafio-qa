package br.com.desafioqa.steps;

import br.com.desafioqa.core.DataGenerator;
import br.com.desafioqa.core.Driver;
import br.com.desafioqa.pages.AutomationPage;
import br.com.desafioqa.pages.CommonPage;
import br.com.desafioqa.pages.SignInPage;
import br.com.desafioqa.pages.SignUpPage;
import io.cucumber.java.*;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.ro.Si;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import java.util.concurrent.TimeUnit;

public class SignUpAndCheckoutSteps {
    static Driver driver;
    static CommonPage commonPage;
    static SignUpPage signUpPage;
    static SignInPage signInPage;
    static DataGenerator data = new DataGenerator();
    private static Scenario myScenario;

    @Before
    public static void setUp() {
        driver = new Driver();
        signInPage = new SignInPage(driver);
        commonPage = new CommonPage(driver);
        signUpPage = new SignUpPage(driver);

    }
    @Before()
    public void setUp(Scenario scenario){
        myScenario = scenario;
    }

    @AfterStep
    public static void afterStep(){
        try {
            myScenario.write("Current Page URL is " + driver.getDriver().getCurrentUrl());
            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            myScenario.embed(screenshot, "image/png");  // Stick it in the report
        } catch (WebDriverException webDriverException) {
            webDriverException.printStackTrace();
        } catch (ClassCastException cce) {
            cce.printStackTrace();
        }
    }

    @After
    public void after() {
        driver.quit();
    }


    @Then("form with data has been visible")
    public void formWithDataHasBeenVisible() {
        Assert.assertEquals(signUpPage.getFormHeader().getText(),"CREATE AND ACCOUNT");
    }

    @When("I fill all data on form")
    public void iFillAllDataOnForm() {
//    signUpPage.listElements();
        signUpPage.setDataOnForm(data);
    }

    @And("I submit the form")
    public void iSubmitTheForm() {
        signUpPage.getSubmitAccount().click();
    }

    @Then("account has been created with success")
    public void accountHasBeenCreatedWithSuccess() {
    }

    @Given("I Access the page {string}")
    public void iAccessThePage(String url) {
        driver.get(url);
    }

    @And("click on Sign In")
    public void clickOnSignIn() {
        commonPage.getSignInButton().click();
    }

    @And("I fill user email {string}")
    public void iFillUserEmail(String email) {
        signInPage.getEmail().sendKeys(email);
    }
    @And("I fill user email")
    public void iFillUserEmail() {
        signInPage.getEmail().sendKeys(data.getEmail());
    }

    @And("fill the password {string}")
    public void fillThePassword(String password) throws InterruptedException {
        signInPage.getPassword().sendKeys(password);
        driver.sleep(5);
    }
    @And("fill the password")
    public void fillThePassword() throws InterruptedException {
        signInPage.getPassword().sendKeys(data.getPassword());
        driver.sleep(5);
    }

    @When("fill email to create account")
    public void fillEmailToCreateAccount() {

        signInPage.getEmail_create().sendKeys(data.getEmail());
    }

    @And("I click on Sign In button")
    public void iClickOnSignInButton() {
        signInPage.getButtonSubmitLogin().click();
    }

    @And("I got the message Error")
    public void iGotTheMessageError() {
        Assert.assertEquals(signInPage.getLoginError().getText(),"There is 1 error");
    }

    @When("I fill email to create account")
    public void iFillEmailToCreateAccount() {
        signInPage.getEmail_create().sendKeys(data.getEmail());
    }

    @And("I click on Button Create Account")
    public void iClickOnButtonCreateAccount() {
        signInPage.getButtonSubmitCreate().click();
    }

    @Given("I click on T-SHIRT Menu Category")
    public void iClickOnTSHIRTMenuCategory() {
        commonPage.getMenuItem().click();
    }

    @And("add item to cart")
    public void addItemToCart() {
        commonPage.addItemToCart();
    }

    @And("I Proceed to Checkout")
    public void iProceedToCheckout() {
        commonPage.proceedToCheckout();
    }

    @And("I Confirm Order on History")
    public void iConfirmOrderOnHistory() {
        commonPage.personalInfo();
        Assert.assertEquals(commonPage.orderStatus().getText(), "On backorder");
    }
}
