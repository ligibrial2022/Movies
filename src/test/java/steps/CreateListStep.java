package steps;
import java.util.List;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import metods.Metods;

public class CreateListStep {

    public static ResponseOptions<Response> response;

    @When("the user create a list for")
    public void the_user_create_a_list(DataTable table){

        List<List<String>> data = table.asLists(String.class);
        String name = data.get(1).get(0);
        String description = data.get(1).get(1);
        String language = data.get(1).get(2);
        Metods armandoLista = new Metods();
        armandoLista.createList(
                name,description,language
        );
    }



    @Then("verify List created succesfully")
    public void verify_List_created_succesfully() {

    }


}
