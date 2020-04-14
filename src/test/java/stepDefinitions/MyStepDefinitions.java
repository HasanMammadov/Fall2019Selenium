package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepDefinitions {

    @Given("User is on NetBanking landing page")
    public void userIsOnNetBankingLandingPage() {
    }

    @When("User login into application with username {string}  and password {string}")
    public void userLoginIntoApplicationWithUsernameAndPassword1(String arg0, String arg1) {
        System.out.println(arg0);
        System.out.println(arg1);
    }

    @Then("Home page is populated")
    public void homePageIsPopulated() {

    }

    @And("Cards are displayed")
    public void cardsAreDisplayed() {
    }

    @When("User login into application with username {string}  and password{string}")
    public void userLoginIntoApplicationWithUsernameAndPassword(String arg0, String arg1) {
        System.out.println(arg0);
        System.out.println(arg1);
    }

    @And("Cards are NOT displayed")
    public void cardsAreNOTDisplayed() {
        System.out.println("Cards are NOT displayed");
    }

    @When("User login into application with username <username>  and <password>")
    public void userLoginIntoApplicationWithUsernameUsernameAndPassword() {

    }
}