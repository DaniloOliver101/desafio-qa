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
    public void proceedToCheckout(){
        driver.findElementByLinkText("Proceed to checkout").click();
        driver.findElementByXpath("//*[@id=\"center_column\"]/p[2]/a[1]/span").click();
        driver.findElementByXpath("/html/body/div/div[2]/div/div[3]/div/form/p/button/span").click();
        driver.findElementById("cgv").click();
        driver.findElementByXpath("/html/body/div/div[2]/div/div[3]/div/div/form/p/button/span").click();
        driver.findElementByXpath("/html/body/div/div[2]/div/div[3]/div/div/div[3]/div[1]/div/p/a").click();
        driver.findElementByXpath("//*[@id=\"cart_navigation\"]/button/span").click();

    }
    public void personalInfo(){
        driver.findElementByXpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a/span").click();
        driver.findElementByXpath("/html/body/div/div[2]/div/div[3]/div/div/div[1]/ul/li[1]/a/span").click();
    }
    public WebElement orderStatus(){
        return driver.findElementByXpath("/html/body/div/div[2]/div/div[3]/div/div/table/tbody/tr/td[5]/span");
    }
}