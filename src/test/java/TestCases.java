import org.junit.Test;

import model.CreateSessionLogin;

public class TestCases {

    @Test
    public void generarToken(){
        Metods metods = new Metods();
        metods.authenticationTest();
        CreateSessionLogin getToken = new CreateSessionLogin();
        System.out.println(getToken.getRequestToken());
    }

    @Test
    public void validarToken(){
        Metods metods = new Metods();
        metods.createSessionWithLogin();

    }
    @Test
    public void crearSesion(){
        Metods metods = new Metods();
        metods.createSessions();

    }

    @Test
    public void crearLista(){
        Metods metods = new Metods();
        metods.createList();

    }

    @Test
    public void obtenerDetailsList(){
        Metods metods = new Metods();
        metods.obtenerDetailsList();
    }



}
