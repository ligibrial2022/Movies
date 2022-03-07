package model;

public class Movies {

    public String getMovie() {
        return movie;
    }

    public void setMovie(final String movie) {
        this.movie = movie;
    }

    private String movie;

    public Movies(){
    }



    @Override
    public String toString() {
        return  "{\"media_id\": \"" +movie + "\"}";
    }


}
