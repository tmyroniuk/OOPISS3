package plans;

public class Business4GPlus extends YearlyPlan {
    public Business4GPlus(int users) {
        super(1200, users);
    }

    @Override
    public String toString() {
        return "Business 4G Plus, " + super.toString();
    }

    @Override
    public boolean equals(Object other) {
        if(other == this) return true;
        if(!(other instanceof Business4GPlus)) return false;
        return super.equals(other);
    }
}