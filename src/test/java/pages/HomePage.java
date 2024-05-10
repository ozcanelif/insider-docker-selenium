package pages;

import config.BaseConfig;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import stepDefinitions.Hooks;
import utils.PageHelper;

public class HomePage extends BasePage {


    public HomePage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public void clickMainMenu(String menuText) {
        String menuLocator = String.format("//a[@id='navbarDropdownMenuLink'][contains(text(), '%s')]", menuText);
        clickElementByXpath(menuLocator);
    }

    public void clickSubMenu(String submenu) {
        clickElementByLinkText(submenu);
    }

    public void verifyHomePage() {
        String expectedUrl = Hooks.getDriver().getCurrentUrl();
        String actualUrl = BaseConfig.getInstance().getUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
    }
}
