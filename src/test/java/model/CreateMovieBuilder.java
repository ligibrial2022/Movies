package model;


public class CreateMovieBuilder {
    private  Movies movies;

    private CreateMovieBuilder(){
        movies = new Movies();
    }
    public  static CreateMovieBuilder aMovie(){
        return new CreateMovieBuilder();
    }
    public Movies build(){
        return movies;
    }


}
