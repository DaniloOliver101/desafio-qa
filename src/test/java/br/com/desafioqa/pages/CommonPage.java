package br.com.desafioqa.pages;

import br.com.desafioqa.core.Driver;
import br.com.desafioqa.core.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonPage {
    private final Driver driver;

    public CommonPage() {
        this.driver = null;
    }

    public CommonPage(Driver driver) {
        this.driver = driver;
    }

    public WebElement getSignOutButton() {
        return driver.findElementByLinkText("Sign out");
    }

    public WebElement getSignInButton() {
        return driver.findElementByLinkText("Sign in");
    }

    public WebElement getMenuItem() {
        return driver.findElementByXpath("/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[3]/a");
    }
    public void addItemToCart(){
        driver.findElementByXpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/h5/a").click();
driver.findElementByXpath("//*[@id=\"add_to_cart\"]/button/span").click();

    }
}