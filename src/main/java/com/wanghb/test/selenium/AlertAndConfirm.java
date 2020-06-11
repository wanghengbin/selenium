package com.wanghb.test.selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertAndConfirm {

    /**
     * alert只有确认，confirm和Prompts都有取消
     */
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/wanghb/Downloads/WebDriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        /**
         * The simplest of these is referred to as an alert, which shows a custom message, and a single button which dismisses the alert, labelled in most browsers as OK. It can also be dismissed in most browsers by pressing the close button, but this will always do the same thing as the OK button. See an example alert.
         *
         * WebDriver can get the text from the popup and accept or dismiss these alerts.
         */
        //Click the link to activate the alert
        driver.findElement(By.linkText("See an example alert")).click();
        WebDriverWait wait = new WebDriverWait(driver, 20);

        //Wait for the alert to be displayed and store it in a variable
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        //Store the alert text in a variable
        String text = alert.getText();

        //Press the OK button
        alert.accept();

        /**
         * A confirm box is similar to an alert, except the user can also choose to cancel the message. See a sample confirm.
         *
         * This example also shows a different approach to storing an alert:
         */

        //Click the link to activate the alert
        driver.findElement(By.linkText("See a sample confirm")).click();

        //Wait for the alert to be displayed
        wait.until(ExpectedConditions.alertIsPresent());

        //Store the alert in a variable
        Alert alert2 = driver.switchTo().alert();

        //Store the alert in a variable for reuse
        String text2 = alert2.getText();

        //Press the Cancel button
        alert2.dismiss();

        /**
         * Prompts are similar to confirm boxes, except they also include a text input. Similar to working with form elements,
         * you can use WebDriver’s send keys to fill in a response. This will completely replace the placeholder text.
         * Pressing the cancel button will not submit any text. See a sample prompt.
         */


        //Click the link to activate the alert
        driver.findElement(By.linkText("See a sample prompt")).click();

        //Wait for the alert to be displayed and store it in a variable
        Alert alert3 = wait.until(ExpectedConditions.alertIsPresent());

        //Type your message
        alert3.sendKeys("Selenium");

        //Press the OK button
        alert3.accept();

    }
}
