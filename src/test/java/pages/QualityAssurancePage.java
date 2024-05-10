package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.PageHelper;

public class QualityAssurancePage extends BasePage {
    public QualityAssurancePage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(linkText = "See all QA jobs")
    private WebElement btnSeeAllQaJobs;

    public void clickSeeAllQaJobsButton() {
        clickElementWithJs(btnSeeAllQaJobs);
    }
}
