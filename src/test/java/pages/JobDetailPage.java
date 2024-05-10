package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import stepDefinitions.Hooks;

import java.util.ArrayList;

public class JobDetailPage {
    WebDriver driver = Hooks.getDriver();

    public JobDetailPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "(//a[@class='postings-btn template-btn-submit shamrock'])[1]")
    private WebElement btnApplyJob;

    public void verifyJobDetailPage() {
        ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTb.get(1));
        Assert.assertTrue(btnApplyJob.isDisplayed());
    }
}
