package com.nttdata.page;

import org.openqa.selenium.By;

public class CheckoutPage {
    public static By finishingBtn = By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/div/div/a");
    public static By productPrice = By.xpath("/html/body/main/section/div/div/div/section/div/div[1]/div/div[2]/ul/li/div/div[3]/div/div[2]/div/div[2]/span/strong");
    public static By totalPrice = By.xpath("/html/body/main/section/div/div/div/section/div/div[2]/div[1]/div[1]/div[2]/div[2]/span[2]");
    public static By taxes = By.xpath("/html/body/main/section/div/div/div/section/div/div[2]/div[1]/div[1]/div[2]/div[3]/span[2]");
    public static By title = By.xpath("/html/body/main/section/div/div/div/section/div/div[1]/div/div[1]/h1");
}
