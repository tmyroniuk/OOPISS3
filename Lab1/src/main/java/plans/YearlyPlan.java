package plans;

public class YearlyPlan extends Plan {
    public YearlyPlan(int cost, int users) {
        super(cost, users);
    }

    public int annualCost() {
        return cost();
    }

    @Override
    public String toString() {
        return "yearly " + super.toString();
    }
}
