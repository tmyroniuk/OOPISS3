package plans;

public class Unlimited4GPlus extends YearlyPlan {
    public Unlimited4GPlus(int users) {
        super(1500, users);
    }

    @Override
    public String toString() {
        return "Unlimited 4G Plus, " + super.toString();
    }
}
