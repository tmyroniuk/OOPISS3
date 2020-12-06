package plans;

public class Super3GPlus extends YearlyPlan {
    public Super3GPlus(int users) {
        super(800, users);
    }

    @Override
    public String toString() {
        return "Super 3G Plus, " + super.toString();
    }
}
