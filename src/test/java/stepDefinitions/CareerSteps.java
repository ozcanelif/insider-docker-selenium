package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CareerPage;

public class CareerSteps {
    CareerPage careerPage = new CareerPage(Hooks.getDriver());

    public CareerSteps() {
    }

    @When("click see all teams button on careers page")
    public void clickSeeAllTeamsButton() {
        careerPage.clickSeeAllTeamsButton();
    }

    @And("click Quality Assurance team on careers page")
    public void clickQaTeamButton() {
        careerPage.clickQaTeamButton();
    }

    @Then("verify that careers page is open")
    public void careerPageIsOpen() {
        careerPage.verifyCareerPage();
    }

    @Then("verify that teams section on careers page")
    public void teamsSectionIsDisplayed() {
        careerPage.verifyTeamSection();
    }

    @Then("verify that locations section on careers page")
    public void locationSectionIsDisplayed() {
        careerPage.verifyLocationSection();
    }

    @Then("verify that life at insider section on careers page")
    public void lifeAtInsiderSectionIsDisplayed() {
        careerPage.verifyLifeAtInsiderSection();
    }
}