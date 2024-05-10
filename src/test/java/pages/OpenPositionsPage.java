package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class OpenPositionsPage extends BasePage {
    public OpenPositionsPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }
    @FindBy(id = "career-position-filter")
    private WebElement filterSection;

    @FindBy(id = "select2-filter-by-location-container")
    private WebElement listLocation;

    @FindBy(id = "select2-filter-by-department-container")
    private WebElement listDepartment;

    @FindAll(@FindBy(css = ".position-location"))
    private static List<WebElement> txtAllJobLocation;

    @FindAll(@FindBy(css = ".position-list-item.col-12.col-lg-4"))
    private static List<WebElement> txtAllJobDepartmentName;

    @FindAll(@FindBy(css = "#jobs-list .position-list-item:nth-of-type(1) .btn"))
    private WebElement btnJobViewRole;

    @FindBy(id = "jobs-list")
    private WebElement jobsList;

    @FindBy(xpath = "//span[@title='All'][@id='select2-filter-by-location-container']")
    private WebElement lblFilterValue;

    public void selectLocation(String location) {
        waitForElementToBeClickable(listLocation);
        pageDown();
        verifyElementVisible(filterSection);
        waitFor(4);
        clickElement(listLocation);
        verifyElementVisible(lblFilterValue);
        String locationLocator = String.format("//li[contains(@id, '%s')]", location);
        clickElementByXpath(locationLocator);
    }

    public void selectDepartment(String department) {
        clickElement(listDepartment);
        String departmentLocator = String.format("//li[contains(@id, '%s')]", department);
        clickElementByXpath(departmentLocator);
    }

    public void verifyLocation(String location) {
        Assert.assertTrue(listLocation.getText().contains(location));
    }

    public void verifyDepartment(String department) {
        Assert.assertTrue(listDepartment.getText().contains(department));
    }

    public void clickJobViewRoleButton() {
        clickElement(btnJobViewRole);
    }

    public void verifyQaJobList() {
        waitFor(5);
        Assert.assertTrue(jobsList.isDisplayed());
        for (WebElement el : txtAllJobLocation) {
            String jobDepartmentLocation = el.getText();
            Assert.assertTrue(jobDepartmentLocation.contains("Istanbul, Turkey"));
        }

        for (int i = 0; i < txtAllJobDepartmentName.size(); i++) {
            WebElement el = txtAllJobDepartmentName.get(i);
            String jobDepartmentName = el.getText();
            System.out.println("jobDepartmentName:" + jobDepartmentName);
            Assert.assertTrue(jobDepartmentName.contains("Quality Assurance"));
        }
    }
}
