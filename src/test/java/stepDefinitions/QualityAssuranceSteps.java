package stepDefinitions;

import io.cucumber.java.en.And;
import pages.QualityAssurancePage;

public class QualityAssuranceSteps {

    QualityAssurancePage qaPage = new QualityAssurancePage(Hooks.getDriver());

    public QualityAssuranceSteps() {
    }

    @And("click see all QA jobs button on quality assurance page")
    public void clickSeeAllQaJobsButton() {
        qaPage.clickSeeAllQaJobsButton();
    }
}
