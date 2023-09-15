package com.seleniumjava.Tests;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

class Test1 {

    public EdgeDriver getDriver() {

        EdgeDriver driver = new EdgeDriver();
        return driver;
    }

    @Test
    void testLoginFunctionality() {

        EdgeDriver driver = getDriver();
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
        Assert.assertEquals(expectedLoginText,loginText[0]);

        driver.close();
    }

    @Test
    void testDragAndDropFunctionality() {
        EdgeDriver driver = getDriver();

        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        WebElement fromElement = driver.findElement(By.id("column-a"));

        WebElement toElement = driver.findElement(By.id("column-b"));

        Actions action = new Actions(driver);

        action.dragAndDrop(fromElement,toElement).build().perform();

        Assert.assertEquals("B",toElement.getText());

        driver.close();
    }

    @Test
    void testFileUploadFunctionality() {
        EdgeDriver driver = getDriver();

        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/upload");

        //driver.manage().timeouts().setScriptTimeout(2000, TimeUnit.MILLISECONDS);

        driver.findElement(By.id("file-upload")).sendKeys("C:\\IDeaS_Practice\\Tech-Challenges\\Challenge-3\\data.js");

        driver.findElement(By.id("file-submit")).submit();

        String expectedOutput = "File Uploaded!";

        String element = driver.findElement(By.tagName("h3")).getText();

        Assert.assertEquals(expectedOutput,element);

        driver.close();
    }
}
