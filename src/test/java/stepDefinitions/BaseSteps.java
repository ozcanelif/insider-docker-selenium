package stepDefinitions;

import io.cucumber.java.en.When;
import pages.BasePage;

public class BaseSteps {

    BasePage basePage = new BasePage();

    public BaseSteps() {
    }

    @When("user on the homepage")
    public void openHomePage() {
        basePage.HomePage();
        basePage.acceptAllCookies();
    }

}

