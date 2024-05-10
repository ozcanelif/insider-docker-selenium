package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.HomePage;

public class HomeSteps {

    HomePage homePage = new HomePage(Hooks.getDriver());

    public HomeSteps() {
    }

    @Then("verify that home page is open")
    public void homePageIsOpen() {
        homePage.verifyHomePage();
    }


    @And("select {string} from main manu and {string} from submenu on homepage")
    public void selectFromMainManuAndFromSubmenuOnHomepage(String mainMenu, String subMenu) {
        homePage.clickMainMenu(mainMenu);
        homePage.clickSubMenu(subMenu);
    }
}
