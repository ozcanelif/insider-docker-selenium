package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CareerPage extends BasePage{

    public CareerPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//section[@id='page-head']//a[@href='https://useinsider.com/open-positions/']")
    public WebElement btnFindDreamJob;

    @FindBy(id = "career-find-our-calling")
    private WebElement teamsSection;

    @FindBy(id = "career-our-location")
    private WebElement locationSection;

    @FindBy(css = ".elementor-section.elementor-element-a8e7b90")
    private WebElement lifeAtInsiderSection;

    @FindBy(linkText = "See all teams")
    private WebElement btnSeeAllTeams;

    @FindBy(xpath = "//h3[text()='Quality Assurance']")
    private WebElement btnQaTeam;

    public void clickSeeAllTeamsButton() {
        clickElementWithJs(btnSeeAllTeams);
    }

    public void clickQaTeamButton() {
        verifyElementVisible(btnQaTeam);
        clickElementWithJs(btnQaTeam);
    }

    public void verifyCareerPage() {
        Assert.assertTrue(btnFindDreamJob.isDisplayed());
    }

    public void verifyTeamSection() {
        Assert.assertTrue(teamsSection.isDisplayed());
    }

    public void verifyLocationSection() {
        Assert.assertTrue(locationSection.isDisplayed());
    }

    public void verifyLifeAtInsiderSection() {
        Assert.assertTrue(lifeAtInsiderSection.isDisplayed());
    }
}
