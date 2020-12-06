package plans;

public abstract class Plan implements Applicable, Payable {

    private int _cost;
    private int _users;

    public Plan(int cost, int users) {
        _cost = cost;
        _users = users;
    }

    public void apply(float balance) throws NotEnoughMoneyException {
        if(balance < cost()) {
            throw new NotEnoughMoneyException("Not enough credit. Please,top up your account.");
        }
        ++_users;
    }

    public void discard() throws NoUsersException {
        if(_users == 0) {
            throw new NoUsersException("No users applied to this plan.");
        }
        --_users;
    }

    public int users() {
        return _users;
    }

    public int cost() {
        return _cost;
    }

    @Override
    public String toString() {
        return "cost: " + cost() + ", users: " + users();
    }
}
