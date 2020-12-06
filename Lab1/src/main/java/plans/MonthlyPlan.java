package plans;

public class MonthlyPlan extends Plan {

    public MonthlyPlan(int cost, int users) {
        super(cost, users);
    }

    public int getAnnualCost() {
        return getCost() * 12;
    }

    @Override
    public String toString() {
        return "monthly " + super.toString();
    }
}

