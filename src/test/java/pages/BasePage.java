package pages;

import config.BaseConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import stepDefinitions.Hooks;
import utils.PageHelper;

public class BasePage  extends PageHelper {
    WebDriver driver = Hooks.getDriver();

    public BasePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".wt-cli-accept-all-btn")
    public WebElement acceptAllCookies;

    public void HomePage() {
        String url = System.getProperty("base.url") != null ? System.getProperty("base.url") : BaseConfig.getInstance().getUrl();
        driver.get(url);
    }

    public void acceptAllCookies() {
        if (acceptAllCookies.isDisplayed()) {
            clickElement(acceptAllCookies);
        }
    }

}