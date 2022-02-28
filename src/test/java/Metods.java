
import org.junit.Before;

import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.response.ValidatableResponse;
import model.CreateSessionLogin;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static model.CreateBodyBuilder.aBody;

public class Metods {

    private String token;

    public String getSession() {
        return session;
    }

    public void setSession(final String session) {
        this.session = session;
    }

    private String session;

    public Metods() {
        CreateSessionLogin body = new CreateSessionLogin();
    }

    public String getToken() {
        return token;
    }

    public void setToken(final String token) {
        this.token = token;
    }

    @Before
    public void setup() {
        RestAssured.baseURI = "https://api.themoviedb.org/3/";
    }




    public void  authenticationTest() {
        ValidatableResponse response = given()
                .log().all()
                .contentType(ContentType.JSON)
                .get("https://api.themoviedb.org/3/authentication/token/new?api_key=2584fc97bde7e4c48e595b4394fc0e88")
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
                .post("https://api.themoviedb.org/3/authentication/token/validate_with_login?api_key=2584fc97bde7e4c48e595b4394fc0e88")
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
                .post("https://api.themoviedb.org/3/authentication/session/new?api_key=2584fc97bde7e4c48e595b4394fc0e88")
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract()
                .body();
       setSession(response.jsonPath().getString("session_id"));

    }

    public void createList() {
        createSessions();
         given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(
                        "{\n"
                                + "    \"name\": \"Lista1\",\n"
                                + "    \"description\": \"a\",\n"
                                + "    \"language\": \"cityslicka\"\n"
                                + "}"
                ).post("https://api.themoviedb.org/3/list?api_key=2584fc97bde7e4c48e595b4394fc0e88&session_id="+getSession()+"")
                .then()
                .log()
                .all()
                .statusCode(201);
    }

    public void obtenerDetailsList() {
        ValidatableResponse response= given()
                .log().all()
                .contentType(ContentType.JSON)
                .get("https://api.themoviedb.org/3/list/1?api_key=2584fc97bde7e4c48e595b4394fc0e88&language=en-US")
                .then()
                .log()
                .all()
                .statusCode(200);



    }




}
