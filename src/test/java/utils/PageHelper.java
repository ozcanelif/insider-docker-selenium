package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepDefinitions.Hooks;
import java.time.Duration;

public class PageHelper {

    WebDriver driver = Hooks.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    Actions actions = new Actions(driver);

    public void clickElement(WebElement element) {
        element.click();
    }

    public void clickElementByLinkText(String linkText) {
        WebElement element = driver.findElement(By.linkText(linkText));
        clickElement(element);
    }

    public void hoverOverElement(By locator) {
        WebElement element = driver.findElement(locator);
        actions.moveToElement(element).perform();
    }

    public void enterText(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.sendKeys(text);
    }

    public void swipeElement(By locator, int xOffset, int yOffset) {
        WebElement element = driver.findElement(locator);
        actions.dragAndDropBy(element, xOffset, yOffset).build().perform();
    }

    public void dragAndDrop(By sourceLocator, By targetLocator) {
        WebElement sourceElement = driver.findElement(sourceLocator);
        WebElement targetElement = driver.findElement(targetLocator);
        actions.dragAndDrop(sourceElement, targetElement).build().perform();
    }

    public void doubleClickElement(By locator) {
        WebElement element = driver.findElement(locator);
        actions.doubleClick(element).build().perform();
    }

    public void rightClickElement(By locator) {
        WebElement element = driver.findElement(locator);
        actions.contextClick(element).build().perform();
    }

    public void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void pageDown() {
        actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void clickElementWithJs(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public WebElement verifyElementVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickElementByXpath(String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();
    }

}
