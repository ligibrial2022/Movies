package model;

public class CreateBodyBuilder {
    private  CreateSessionLogin createBodyRequest;

    private CreateBodyBuilder(){
        createBodyRequest = new CreateSessionLogin();

    }
    public  static CreateBodyBuilder aBody(){
        return new CreateBodyBuilder();
    }

    public CreateBodyBuilder password(String password){
        this.createBodyRequest.setPassword(password);
        return this;
    }
    public CreateBodyBuilder username(String username){
        this.createBodyRequest.setPassword(username);
        return this;
    }
    public CreateBodyBuilder requestToken(String requestToken){
        this.createBodyRequest.setPassword(requestToken);
        return this;
    }

    public CreateSessionLogin build(){
        return createBodyRequest;
    }
}
