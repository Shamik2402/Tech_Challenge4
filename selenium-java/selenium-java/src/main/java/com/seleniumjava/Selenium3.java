package com.seleniumjava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Selenium3 {
    public static void main(String[] args) {

        EdgeDriver driver = new EdgeDriver();

        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        WebElement fromElement = driver.findElement(By.id("column-a"));

        WebElement toElement = driver.findElement(By.id("column-b"));

        Actions action = new Actions(driver);

        action.dragAndDrop(fromElement,toElement).build().perform();

        System.out.println(toElement.getText());

        Assert.assertEquals("B",toElement.getText());

        driver.close();
    }
}
