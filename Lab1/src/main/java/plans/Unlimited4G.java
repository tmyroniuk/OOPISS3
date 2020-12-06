package plans;

public class Unlimited4G extends MonthlyPlan {
    public Unlimited4G(int users) {
        super(150, users);
    }

    @Override
    public String toString() {
        return "Unlimited 4G, " + super.toString();
    }

    @Override
    public boolean equals(Object other) {
        if(other == this) return true;
        if(!(other instanceof Unlimited4G)) return false;
        return super.equals(other);
    }
}
