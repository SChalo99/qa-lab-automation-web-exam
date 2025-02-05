package com.nttdata.page;

import org.openqa.selenium.By;

public class ProductPage {
    public static By quantityBtn = By.xpath("/html/body/main/section/div/div/div/section/div[1]/div[2]/div[2]/div[2]/form/div[2]/div/div[1]/div/span[3]/button[1]");
    public static By shoppingBtn = By.xpath("/html/body/main/section/div/div/div/section/div[1]/div[2]/div[2]/div[2]/form/div[2]/div/div[2]/button");
    public static By modal = By.id("blockcart-modal");
    public static By productPrice = By.xpath("/html/body/div[1]/div/div/div[2]/div/div[1]/div/div[2]/p");
    public static By quantity = By.xpath("/html/body/div[1]/div/div/div[2]/div/div[1]/div/div[2]/span[3]/strong");
    public static By totalPrice = By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/div/p[4]/span[2]");
    public static By taxes = By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/div/p[5]/span");
}
