import org.junit.Assert;
import org.junit.Test;
import plans.*;

public class MonthlyPlanTest {
    @Test
    public void annualCostTest() {
        Plan plan = new MonthlyPlan(150, 200);
        Assert.assertEquals(plan.getAnnualCost(), 12 * 150);
    }
}