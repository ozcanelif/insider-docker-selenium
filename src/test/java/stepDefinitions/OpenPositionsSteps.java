package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.OpenPositionsPage;

public class OpenPositionsSteps {

    OpenPositionsPage openPositionsPage = new OpenPositionsPage(Hooks.getDriver());

    public OpenPositionsSteps() {
    }

    @And("select {string} as location and {string} as department on open positions page")
    public void selectAsLocationAndAsDepartment(String location, String department) {
        openPositionsPage.selectLocation(location);
        openPositionsPage.verifyLocation(location);
        openPositionsPage.selectDepartment(department);
        openPositionsPage.verifyDepartment(department);
    }

    @Then("verify QA jobs list on open positions page")
    public void verifyQAJobsList() {
        openPositionsPage.verifyQaJobList();
    }

    @When("click first job view role button on open positions page")
    public void clickFirstJobViewRoleButton() {
        openPositionsPage.clickJobViewRoleButton();
    }
}
