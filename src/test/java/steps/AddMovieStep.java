package steps;

import java.util.List;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import metods.Metods;

public class AddMovieStep {


    @When("the user add movie with")
    public void the_user_add_movie_with(DataTable table) {
        List<List<String>> data = table.asLists(String.class);
        String media_id = data.get(1).get(0);
        Metods addMovie = new Metods();
        addMovie.anadirPelicula(media_id);
    }

    @Then("verify the movie was added")
    public void verify_the_movie_was_added() {

    }

}
