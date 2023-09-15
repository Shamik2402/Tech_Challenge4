package com.seleniumjava;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Selenium1 {
    public static void main(String[] args) {

        System.setProperty("webdriver.edge.driver","C:\\IDeaS_Practice\\Selenium_Practice\\edgedriver_win64\\msedgedriver.exe");

        EdgeDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");

        String username = driver.findElement(By.xpath("//h4/em[1]")).getText();

        String password = driver.findElement(By.xpath("//h4/em[2]")).getText();

        driver.findElement(By.name("username")).sendKeys(username);

        driver.findElement(By.cssSelector("input[name='password']")).sendKeys(password);

        driver.findElement(By.className("fa-sign-in")).click();

        driver.manage().timeouts().setScriptTimeout(2000, TimeUnit.MILLISECONDS);

        String loginText[] = driver.findElement(By.id("flash")).getText().trim().split("!");

        String expectedLoginText = "You logged into a secure area";
        System.out.println(loginText[0]);
        Assert.assertEquals(expectedLoginText,loginText[0].trim());
//        driver.close();
    }
}
