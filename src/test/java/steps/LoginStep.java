package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import model.CreateSessionLogin;
import metods.Metods;

public class LoginStep {


    @Given("I want to validate login for")
    public void i_want_to_validate_login_for() {
        Metods metods = new Metods();
        metods.authenticationTest();
        metods.createSessions();

    }


    @Then("verify session successfully")
    public void verify_session_successfully() {
    }



}
