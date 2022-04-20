package ui;

public interface IClient {
    int getId();
    String getLastName();
    String getFirstName();
    IAccountState getAccountState();
}
