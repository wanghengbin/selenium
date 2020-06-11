package com.wanghb.test.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WaitTest {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/wanghb/Downloads/WebDriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.baidu.com");
//        driver.findElement(By.id("kw")).sendKeys("cheese" + Keys.ENTER);
        // Initialize and wait till element(link) became clickable - timeout in 10 seconds
        //等待10s钟直到出现百度一下按钮
//        WebElement firstResult = new WebDriverWait(driver, 20)
//                .until(ExpectedConditions.elementToBeClickable(By.id("su")));
        WebElement foo = new WebDriverWait(driver, 20)
                .until(driver1 -> driver1.findElement(By.id("su")));
        // Print the first result
//        System.out.println(firstResult.getTagName());
//        System.out.println(firstResult.getAttribute("value"));
        System.out.println(foo.getTagName());
        System.out.println(foo.getAttribute("value"));


        /**
         * Implicit wait
         * There is a second type of wait that is distinct from explicit wait called implicit wait. By implicitly waiting, WebDriver polls the DOM for a certain duration when trying to find any element. This can be useful when certain elements on the webpage are not available immediately and need some time to load.
         *
         * Implicit waiting for elements to appear is disabled by default and will need to be manually enabled on a per-session basis. Mixing explicit waits and implicit waits will cause unintended consequences, namely waits sleeping for the maximum time even if the element is available or condition is true.
         *
         * Warning: Do not mix implicit and explicit waits. Doing so can cause unpredictable wait times. For example, setting an implicit wait of 10 seconds and an explicit wait of 15 seconds could cause a timeout to occur after 20 seconds.
         *
         * An implicit wait is to tell WebDriver to poll the DOM for a certain amount of time when trying to find an element or elements if they are not immediately available. The default setting is 0, meaning disabled. Once set, the implicit wait is set for the life of the session.
         */

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement myDynamicElement = driver.findElement(By.id("myDynamicElement"));


        /**
         * FluentWait
         * FluentWait instance defines the maximum amount of time to wait for a condition, as well as the frequency with which to check the condition.
         *
         * Users may configure the wait to ignore specific types of exceptions whilst waiting, such as NoSuchElementException when searching for an element on the page.
         */

        // Waiting 30 seconds for an element to be present on the page, checking
        // for its presence once every 5 seconds.
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        WebElement foo111 = wait.until(tempDriver -> tempDriver.findElement(By.id("foo")));

    }
}
