package metods;

import java.io.FileInputStream;
import java.util.Map;

import org.junit.Before;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.response.ResponseOptions;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import model.CreateList;
import model.CreateSessionLogin;
import model.Movies;
import utilities.APIConstant;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static model.CreateBodyBuilder.aBody;
import static model.CreateListBuilder.aBodyList;

public class Metods {

    private RequestSpecBuilder builder = new RequestSpecBuilder();
    private String method;
    private String url;
    private String token;
    private String session;
    private String id_lista;
    private  SessionContext obtenerSession;

    public String getId_lista() {
        return id_lista;
    }

    public void setId_lista(final String id_lista) {
        this.id_lista = id_lista;
    }



    public Metods(String uri, String method ){
        //Formulate the API url
        this.url = "https://api.themoviedb.org/3/" + uri;
        this.method = method;

    }


    public String getSession() {
        return session;
    }

    public void setSession(final String session) {
        this.session = session;
    }



    public Metods() {
        CreateSessionLogin body = new CreateSessionLogin();
    }

    public String getToken() {
        return token;
    }

    public void setToken(final String token) {
        this.token = token;
    }



    ReadPropertiesFile propertiesFile = new ReadPropertiesFile();
    public void  authenticationTest() {
        ValidatableResponse response = given()
                .log().all()
                .contentType(ContentType.JSON)
                .get("https://api.themoviedb.org/3/authentication/token/new?api_key="+propertiesFile.getApi_key())
                .then()
                .log()
                .all()
                .statusCode(200);

       setToken(response.extract().jsonPath().getString("request_token"));

    }

    public void createSessionWithLogin() {

        authenticationTest();
        CreateSessionLogin request = aBody()
                .username("ligibrial")
                .password("1234")
                .requestToken(getToken())
                .build();
        given()
                .contentType(JSON)
                .accept(ContentType.JSON)
                .body(request.toString())
                .post("https://api.themoviedb.org/3/authentication/token/validate_with_login?api_key="+propertiesFile.getApi_key())
                .then()
                .log()
                .all()
                .statusCode(200);
    }

    public void createSessions() {
        String session = "";
        createSessionWithLogin();
        ResponseBodyExtractionOptions response = given()
                .contentType(JSON)
                .accept(JSON)
                .body("{\"request_token\":\"" + getToken() + "\"}")
                .post("https://api.themoviedb.org/3/authentication/session/new?api_key="+propertiesFile.getApi_key())
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract()
                .body();
       setSession(response.jsonPath().getString("session_id"));

       String sesion  =response.jsonPath().getString("session_id");
        obtenerSession = new SessionContext(sesion);
        obtenerSession.setIdSession(session);
        System.out.println(obtenerSession);

    }

    public void createList(String name, String description, String language) {

        createSessions();
        System.out.println(obtenerSession.getIdSession());
        CreateList createbodyList = new CreateList();
        createbodyList.setName(name);
        createbodyList.setDescription(description);
        createbodyList.setLanguage(language);
        ValidatableResponse response= given()
                .log().all()
                .contentType(JSON)
                .body(createbodyList.toString())
                 .post("https://api.themoviedb.org/3/list?api_key="+propertiesFile.getApi_key()+"&"+"session_id="+getSession())
                .then()
                .log()
                .all()
                .statusCode(201);

        setId_lista(response.extract().jsonPath().getString("list_id"));


    }

    public void anadirPelicula(String movie) {

        createSessions();
        Movies id_media = new Movies();
        id_media.setMovie(movie);
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(
                       id_media.toString()
                ).
                post("https://api.themoviedb.org/3/list/"+propertiesFile.getList_id()+"/add_item?api_key="+propertiesFile.getApi_key()+"&"+"session_id="+getSession())
                .then()
                .log()
                .all()
                .statusCode(201);
    }

    public void clearList(String name, String description,String language) {
        createSessions();
        CreateList createbodyList = new CreateList();
        createbodyList.setName(name);
        createbodyList.setDescription(description);
        createbodyList.setLanguage(language);
        ValidatableResponse response= given()
                .log().all()
                .contentType(JSON)
                .body(createbodyList.toString())
                .post("https://api.themoviedb.org/3/list?api_key="+propertiesFile.getApi_key()+"&"+"session_id="+getSession())
                .then()
                .log()
                .all()
                .statusCode(201);
        setId_lista(response.extract().jsonPath().getString("list_id"));

    }

    public void deleteList() {

/*
        CreateList createbodyList = new CreateList();

        createbodyList.setName(name);
        createbodyList.setDescription(description);
        createbodyList.setLanguage(language);
        ValidatableResponse response= given()
                .log().all()
                .contentType(JSON)
                .body(createbodyList.toString())
                .post("https://api.themoviedb.org/3/list?api_key="+propertiesFile.getApi_key()+"&"+"session_id="+getSession())
                .then()
                .log()
                .all()
                .statusCode(201);
        setId_lista(response.extract().jsonPath().getString("list_id"));
        */


    }

    private ResponseOptions<Response> ExecuteAPI() {

        RequestSpecification requestSpec = builder.build();
        Response response;
        RequestSpecification request = RestAssured.given();
        request.contentType(ContentType.JSON);
        request.spec(requestSpec);
        if (this.method.equalsIgnoreCase(APIConstant.ApiMethods.POST)) {
            return request.post(this.url);
        } else if (this.method.equalsIgnoreCase(APIConstant.ApiMethods.DELETE)) {
            return request.delete(this.url);
        } else if (this.method.equalsIgnoreCase(APIConstant.ApiMethods.GET)) {
            return request.get(this.url);
        }
        return null;
    }

    public ResponseOptions<Response> ExecuteWithQueryParams(Map<String, String> queryPath) {
        builder.addQueryParams(queryPath);
        return  ExecuteAPI();
    }


}
