package steps;

import java.util.List;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import metods.Metods;

public class ClearLstStep {
    @When("the user wants to clear list")
    public void the_user_wants_to_clear_list(DataTable table) {

        List<List<String>> data = table.asLists(String.class);
        String name = data.get(1).get(0);
        String description = data.get(1).get(1);
        String language = data.get(1).get(2);
        Metods armandoLista = new Metods();
        armandoLista.clearList(name,description,language);
    }


}
