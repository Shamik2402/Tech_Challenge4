package com.seleniumjava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Selenium4 {
    public static void main(String[] args) {
        EdgeDriver driver = new EdgeDriver();

        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/upload");

        //driver.manage().timeouts().setScriptTimeout(2000, TimeUnit.MILLISECONDS);

        driver.findElement(By.id("file-upload")).sendKeys("C:\\IDeaS_Practice\\Tech-Challenges\\Challenge-3\\data.js");

        driver.findElement(By.id("file-submit")).submit();

        String expectedOutput = "File Uploaded!";

        String element = driver.findElement(By.tagName("h3")).getText();

        System.out.println(element);

        Assert.assertEquals(expectedOutput,element);

        driver.close();

    }
}
