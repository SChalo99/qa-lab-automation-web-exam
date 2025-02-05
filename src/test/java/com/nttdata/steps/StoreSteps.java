package com.nttdata.steps;

import com.nttdata.page.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StoreSteps {
    private WebDriver driver;

    public StoreSteps(WebDriver driver){
        this.driver = driver;
    }

    public void setUserText(String email){
        this.driver.findElement(LoginPage.userText).sendKeys(email);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.loginBtn));
    }
    public void setUserPassword(String password){
        this.driver.findElement(LoginPage.passwordText).sendKeys(password);
    }

    public void login(){
        this.driver.findElement(LoginPage.loginBtn).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(MenuPage.userLogged));
    }


    public String getUserLoged(){
        return this.driver.findElement(MenuPage.userLogged).getText();
    }

    public String navigateCloth(){
        this.driver.findElement(MenuPage.clothTab).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(MenuPage.clothTitle));
        return this.driver.findElement(MenuPage.clothTitle).getText();
    }
    public String navigateMen(){
        this.driver.findElement(MenuPage.menTab).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(MenuPage.menTitle));
        return this.driver.findElement(MenuPage.menTitle).getText();
    }

    public void clickProduct(){
        this.driver.findElements(MenPage.listProducts).get(0).findElement(MenPage.product).click();
    }
    public void addQuantity(int quantity){
        for(int i=1;i<quantity;i++){
            this.driver.findElement(ProductPage.quantityBtn).click();
        }
    }

    public void addToCart(){
        this.driver.findElement(ProductPage.shoppingBtn).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProductPage.modal));
    }
    public boolean validateModal(){
        return this.driver.findElement(ProductPage.modal).isDisplayed();
    }

    public double getProductPrice(){
        return Double.parseDouble(this.driver.findElement(ProductPage.productPrice).getText().split(" ")[1]);
    }
    public double getTaxes(){
        return Double.parseDouble(this.driver.findElement(ProductPage.taxes).getText().split(" ")[1]);
    }
    public double getTotalPrice (){
        return Double.parseDouble(this.driver.findElement(ProductPage.totalPrice).getText().split(" ")[1]);
    }
    public double getQuantity (){
        return Double.parseDouble(this.driver.findElement(ProductPage.quantity).getText());
    }

    public void toCheckout(){
        this.driver.findElement(CheckoutPage.finishingBtn).click();
    }
    public String validateTitleCheckout(){
        return this.driver.findElement(CheckoutPage.title).getText();
    }
    public double getPriceCheckout(){
        return Double.parseDouble(this.driver.findElement(CheckoutPage.productPrice).getText().split(" ")[1]);
    }
    public double getTotalPriceCheckout(){
        return Double.parseDouble(this.driver.findElement(CheckoutPage.totalPrice).getText().split(" ")[1]);
    }
    public double getTaxCheckout(){
        return Double.parseDouble(this.driver.findElement(CheckoutPage.taxes).getText().split(" ")[1]);
    }
}
