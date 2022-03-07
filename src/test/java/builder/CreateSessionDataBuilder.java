package builder;

import data.factory.CreateSessionDataFactory;
import model.CreateSessionLogin;

public class CreateSessionDataBuilder {

    private CreateSessionLogin createBodyRequest;


    private CreateSessionDataBuilder(){
        createDefaultSession();
    }
    private void createDefaultSession(){
        createBodyRequest = new CreateSessionLogin();
        this.createBodyRequest = CreateSessionDataFactory.missingAllInformation();
    }



}
