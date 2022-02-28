package model;

public class CreateSessionLogin {

    private String password;
    private String requestToken;
    private String username;

    public CreateSessionLogin() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getRequestToken() {
        return requestToken;
    }

    public void setRequestToken(final String requestToken) {
        this.requestToken = requestToken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return  "{\"username\": \"" +username + "\",\"password\": \"" + password + "\",\"request_token\":\"" + requestToken+ "\"}";
    }
}
