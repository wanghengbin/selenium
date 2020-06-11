package com.wanghb.test.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ThreadGuard;

/**
 * ThreadGuard checks that a driver is called only from the same thread that created it. Threading issues especially when running tests in Parallel may have mysterious and hard to diagnose errors. Using this wrapper prevents this category of errors and will raise an exception when it happens.
 * The following example simulate a clash of threads:
 */
public class DriverClash {
    //thread main (id 1) created this driver
    private WebDriver protectedDriver = ThreadGuard.protect(new ChromeDriver());

    static {
        System.setProperty("webdriver.chrome.driver", "<Set path to your Chromedriver>");
    }

    //Thread-1 (id 24) is calling the same driver causing the clash to happen
    Runnable r1 = () -> {protectedDriver.get("https://selenium.dev");};
    Thread thr1 = new Thread(r1);

    void runThreads(){
        thr1.start();
    }

    public static void main(String[] args) {
        new DriverClash().runThreads();
    }
}