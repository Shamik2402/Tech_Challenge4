package com.seleniumjava;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class Selenium2 {

    public static void main(String[] args) {

        System.setProperty("web.driver.edge","C:\\IDeaS_Practice\\Selenium_Practice\\edgedriver_win64\\msedgedriver.exe");

        EdgeDriver driver = new EdgeDriver();

        driver.manage().window().maximize();
        driver.get(" https://the-internet.herokuapp.com/checkboxes");

        driver.manage().timeouts().setScriptTimeout(2000, TimeUnit.MILLISECONDS);

        driver.findElement(By.xpath("//form/input[1]")).click();

        driver.findElement(By.xpath("//form/input[2]")).click();

        driver.findElement(By.xpath("//form/input[1]")).isSelected();

        driver.close();


    }
}
