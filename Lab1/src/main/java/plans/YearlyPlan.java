package plans;

public class YearlyPlan extends Plan {
    public YearlyPlan(int cost, int users) {
        super(cost, users);
    }

    public int getAnnualCost() {
        return getCost();
    }

    @Override
    public String toString() {
        return "yearly " + super.toString();
    }
}
