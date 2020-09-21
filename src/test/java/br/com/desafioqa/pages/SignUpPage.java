package br.com.desafioqa.pages;

import br.com.desafioqa.core.DataGenerator;
import br.com.desafioqa.core.Driver;
import br.com.desafioqa.core.Element;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import javax.xml.stream.XMLStreamReader;

public class SignUpPage {
    private Driver driver;


    public WebElement getGender2(){return driver.findElementById("id_gender2");}
    public WebElement getCustomerFirstName(){return  driver.findElementById("customer_firstname");}
    public WebElement getCustomerLastName(){return driver.findElementById("customer_lastname");}
    public WebElement getEmail(){return driver.findElementById("email");}
    public WebElement getPassword(){return driver.findElementById("passwd");}
    public Select getDays(){return new Select(driver.findElementById("days")); }
    public Select getMonths(){return new Select(driver.findElementById("months"));}
    public Select getYears(){return new Select(driver.findElementById("years"));}
    public WebElement getNewsletter(){return driver.findElementById("newsletter");}
    public WebElement getOptin(){return driver.findElementById("optin");}
    public WebElement getFirstName(){return driver.findElementById("firstname");}
    public WebElement getLastName(){return driver.findElementById("lastname");}
    public WebElement getCompany(){return driver.findElementById("company");}
    public WebElement getAddress1(){return  driver.findElementById("address1");}
    public WebElement getAddress2(){return driver.findElementById("address2");}
    public WebElement getCity(){return driver.findElementById("city");}
    public Select getState(){return new Select(driver.findElementById("id_state"));}
    public WebElement getZipcode(){return driver.findElementById("postcode");}
    public Select getCountry(){return new Select(driver.findElementById("id_country"));}
    public WebElement getOther(){return driver.findElementById("other");}
    public WebElement getPhone(){return driver.findElementById("phone");}
    public WebElement getMobilePhone(){return driver.findElementById("phone_mobile");}
    public WebElement getAlias(){return driver.findElementById("alias"); }
    public WebElement getSubmitAccount(){return driver.findElementById("submitAccount"); }

    public void setDataOnForm(DataGenerator data) {
        getGender2().click();
        getCustomerFirstName().sendKeys(data.getFirstName());
        getCustomerLastName().sendKeys(data.getLastName());
        getEmail().clear();
        getEmail().sendKeys(data.getEmail());
        getPassword().sendKeys(data.getPassword());
        getDays().selectByIndex(1);
        getMonths().selectByIndex(8);
        getYears().selectByIndex(22);
        getNewsletter().click();
        getOptin().click();
        getCompany().sendKeys(data.getCompany());
        getAddress1().sendKeys(data.getAddressLine1());
        getAddress2().sendKeys(data.getAddressLine2());
        getCity().sendKeys(data.getCity());
        getState().selectByIndex(3);
        getZipcode().sendKeys("55555");
        getMobilePhone().sendKeys("7775554321");
        getPhone().sendKeys("7775554322");
        getOther().sendKeys("NDA");

    }

    public SignUpPage() {
        this.driver = null;
    }

    public SignUpPage(Driver driver) {
        this.driver = driver;
    }

    public WebElement getFormHeader() {
        return driver.findElementByXpath("//*[@id=\"noSlide\"]/h1");
    }
}