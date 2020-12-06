import org.junit.Assert;
import org.junit.Test;
import plans.*;

public class YearlyPlanTest {
    @Test
    public void annualCostTest() {
        Plan plan = new YearlyPlan(150, 200);
        Assert.assertEquals(plan.getAnnualCost(), 150);
    }
}