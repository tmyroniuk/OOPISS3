package plans;

public class Business4G extends MonthlyPlan {
    public Business4G(int users) {
        super(120, users);
    }

    @Override
    public String toString() {
        return "Business 4G, " + super.toString();
    }

    @Override
    public boolean equals(Object other) {
        if(other == this) return true;
        if(!(other instanceof Business4G)) return false;
        return super.equals(other);
    }
}