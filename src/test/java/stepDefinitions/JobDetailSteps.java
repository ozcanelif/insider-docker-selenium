package stepDefinitions;

import io.cucumber.java.en.Then;
import pages.JobDetailPage;

public class JobDetailSteps {

    JobDetailPage jobDetailPage = new JobDetailPage(Hooks.getDriver());

    public JobDetailSteps() {
    }

    @Then("verify that job detail page is open")
    public void verifyThatJobDetailPageIsOpen() {
        jobDetailPage.verifyJobDetailPage();
    }
}
