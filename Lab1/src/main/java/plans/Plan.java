package plans;

public abstract class Plan implements Applicable, Payable {

    private int cost;
    private int users;

    public Plan(int cost, int users) {
        this.cost = cost;
        this.users = users;
    }

    public void apply(float balance) throws NotEnoughMoneyException {
        if(balance < getCost()) {
            throw new NotEnoughMoneyException("Not enough credit. Please,top up your account.");
        }
        ++users;
    }

    public void discard() throws NoUsersException {
        if(users == 0) {
            throw new NoUsersException("No users applied to this plan.");
        }
        --users;
    }

    public int getUsers() {
        return users;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "cost: " + getCost() + ", users: " + getUsers();
    }

    @Override
    public boolean equals(Object other) {
        if(!(other instanceof Plan))
            return false;
        Plan plan = (Plan) other;
        return plan.cost == this.cost &&
                plan.users == this.users;
    }
}
