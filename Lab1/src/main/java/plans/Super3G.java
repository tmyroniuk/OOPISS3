package plans;

public class Super3G extends MonthlyPlan {
    public Super3G(int users) {
        super(80, users);
    }

    @Override
    public String toString() {
        return "Super 3G, " + super.toString();
    }

    @Override
    public boolean equals(Object other) {
        if(other == this) return true;
        if(!(other instanceof Super3G)) return false;
        return super.equals(other);
    }
}