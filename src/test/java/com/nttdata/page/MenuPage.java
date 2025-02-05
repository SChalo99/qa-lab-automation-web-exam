package com.nttdata.page;

import org.openqa.selenium.By;

public class MenuPage {
    public static By clothTab = By.xpath("/html/body/main/header/div[2]/div/div[1]/div[2]/div[1]/ul/li[1]/a");
    public static By menTab = By.xpath("/html/body/main/section/div/div/div[1]/div[1]/ul/li[2]/ul/li[1]/a");
    public static By clothTitle =By.xpath("/html/body/main/section/div/div/div[1]/div[1]/ul/li[1]/a");
    public static By menTitle = By.xpath("/html/body/main/section/div/div/div[1]/div[1]/ul/li/a");
    public static By userLogged = By.xpath("/html/body/main/header/nav/div/div/div[1]/div[2]/div[3]/div/a[2]/span");
}
