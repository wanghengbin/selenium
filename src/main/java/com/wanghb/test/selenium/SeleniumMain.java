package com.wanghb.test.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class SeleniumMain {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/wanghb/Downloads/WebDriver/chromedriver");
        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.baidu.com");
//        //后退
////        driver.navigate().back();
//        //前进
////        driver.navigate().forward();
//        //刷新
//        driver.navigate().refresh();
//        //获取标题
//        String title = driver.getTitle();
//        //通过id获取元素
//        WebElement searchField= driver.findElement(By.id("kw"));
//        searchField.sendKeys("12306");
//        WebElement submitButton= driver.findElement(By.id("su"));
//        submitButton.click();

//        driver.get("https://www.12306.cn/index/");
        driver.get("https://kyfw.12306.cn/otn/resources/login.html");
        //通过class获取到账号登陆按钮，然后点击
        WebElement accountLogin= driver.findElement(By.className("login-hd-account"));
//        //如下执行一个不存在的元素会报错
//        WebElement accountLogin= driver.findElement(By.className("login-hd-account111"));
        accountLogin.click();
        //获取到用户名input，然后输入值
        WebElement accountElement = driver.findElement(By.id("J-userName"));
        accountElement.sendKeys("13300000001");
        //获取密码input，然后输入值
        WebElement passElement = driver.findElement(By.id("J-password"));
        passElement.sendKeys("test000001");
        //然后获取验证码，之后点击登陆

//        WebElement loginElement = driver.findElement(By.id("J-login"));
//        loginElement.click();

        WebElement loginImgElement = driver.findElement(By.id("J-loginImg"));
        System.out.println(loginImgElement.getAttribute("src"));
        //actions
        new Actions(driver);

/*        <ol id=cheese>
         <li id=cheddar>…
         <li id=brie>…
         <li id=rochefort>…
         <li id=camembert>…
        </ul>*/
//        driver.findElement(By.cssSelector("#cheese #cheddar"));
//        List<WebElement> muchoCheese = driver.findElements(By.cssSelector("#cheese li"));

        System.out.println("ok");
    }

//    public static void windowHandle(){
//        System.setProperty("webdriver.chrome.driver", "/Users/wanghb/Downloads/WebDriver/chromedriver");
//        WebDriver driver = new ChromeDriver();
//        //Store the ID of the original window
//        String originalWindow = driver.getWindowHandle();
//
//        //Check we don't have other windows open already
//        assert driver.getWindowHandles().size() == 1;
//
//        //Click the link which opens in a new window
//        driver.findElement(By.linkText("new window")).click();
//
//        //Wait for the new window or tab
//        wait.until(numberOfWindowsToBe(2));
//
//        //Loop through until we find a new window handle
//        for (String windowHandle : driver.getWindowHandles()) {
//            if(!originalWindow.contentEquals(windowHandle)) {
//                driver.switchTo().window(windowHandle);
//                break;
//            }
//        }
//
//        //Wait for the new tab to finish loading content
//        wait.until(titleIs("Selenium documentation"));
//
//
//
//        /**---------------------open new Tab or window--------------------------------*/
//        // Opens a new tab and switches to new tab
//        driver.switchTo().newWindow(WindowType.TAB);
//
//        // Opens a new window and switches to new window
//        driver.switchTo().newWindow(WindowType.WINDOW);
//
//
//
//        /**---------------------Close the tab or window--------------------------------*/
//        /**---------------------witch back to the old tab or window--------------------------------*/
//
//        //Close the tab or window
//        driver.close();
//
//        //Switch back to the old tab or window
//        driver.switchTo().window(originalWindow);
//
//
//        /**---------------------Quitting the browser at the end of a session--------------------------------*/
////        Quit will:
////          Close all the windows and tabs associated with that WebDriver session
////          Close the browser process
////          Close the background driver process
////          Notify Selenium Grid that the browser is no longer in use so it can be used by another session (if you are using Selenium Grid)
//
////        Failure to call quit will leave extra background processes and ports running on your machine which could cause you problems later.
//        driver.quit();
//
//        //If not running WebDriver in a test context, you may consider using try / finally which is offered by most languages so that an exception will still clean up the WebDriver session.
//        try {
//            //WebDriver code here...
//        } finally {
//            driver.quit();
//        }
//
//
//
//        //最大化
//        driver.manage().window().maximize();
//        //最小化
//        driver.manage().window().minimize();
//
//    }
}
