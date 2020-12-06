package plans;

public interface Applicable {
    void apply(float balance) throws NotEnoughMoneyException;
    void discard() throws NoUsersException;
    int getUsers();
}
