package br.com.desafioqa.pages;

import br.com.desafioqa.core.Driver;
import br.com.desafioqa.core.Element;
import org.openqa.selenium.WebElement;
import org.w3c.dom.html.HTMLInputElement;

public class SignInPage {
    private Driver driver;


    public WebElement getEmail() {
        return driver.findElementById("email");
    }

    public WebElement getPassword() {
        return driver.findElementById("passwd");
    }

    public WebElement getEmail_create() {
        return driver.findElementById("email_create");
    }

    public WebElement getButtonSubmitCreate() {
        return driver.findElementById("SubmitCreate");
    }

    public WebElement getButtonSubmitLogin() {
        return driver.findElementById("SubmitLogin");
    }

    public SignInPage() {
        this.driver = null;
    }

    public SignInPage(Driver driver) {
        this.driver = driver;
    }

    public WebElement getLoginError() {
        return driver.findElementByXpath("/html/body/div/div[2]/div/div[3]/div/div[1]/p");
    }
}