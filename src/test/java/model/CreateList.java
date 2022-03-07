package model;

public class CreateList {

    private String name ;
    private String description;
    private String language;
    public CreateList(){

    }
    public CreateList(String name, String description, String language) {

        this.name=name;
        this.description=description;
        this.language= language;
    }
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(final String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return  "{\"name\": \"" +name + "\",\"description\": \"" + description + "\",\"language\":\"" + language+ "\"}";
    }










}
