package steps;

import io.cucumber.java.en.When;
import metods.Metods;

public class DeleteStep {
    @When("the user wants to delete list")
    public void the_user_wants_to_delete_list() {
    // Write code here that turns the phrase above into concrete action
        Metods deleteList = new Metods();
        deleteList.deleteList();
}

}
