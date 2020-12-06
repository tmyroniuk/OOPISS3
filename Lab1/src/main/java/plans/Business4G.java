package plans;

public class Business4G extends MonthlyPlan {
    public Business4G(int users) {
        super(120, users);
    }

    @Override
    public String toString() {
        return "Business 4G, " + super.toString();
    }
}