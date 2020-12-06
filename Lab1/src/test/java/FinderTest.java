import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import plans.*;

import java.util.List;
import java.util.Optional;

public class FinderTest {
    private List<Plan> plans;

    @Before
    public void before() {
        plans = List.of(new Super3G(53), new Super3GPlus(51),
                new Business4G(30), new Business4GPlus(12),
                new Unlimited4G(15), new Unlimited4GPlus(2));
    }

    @Test
    public void byPredicateTest1() {
        Optional<Plan> plan = Finder.byPredicate(
                plans,
                p -> p.users() == 2);
        Assert.assertTrue(plan.isPresent());
        Assert.assertEquals(plan.get(), plans.get(5));
    }

    @Test
    public void byPredicateTest2() {
        Optional<Plan> plan = Finder.byPredicate(
                plans,
                p -> p.cost() <= 200);
        Assert.assertTrue(plan.isPresent());
        Assert.assertEquals(plan.get(), plans.get(0));
    }

    @Test
    public void byPredicateTest3() {
        Optional<Plan> plan = Finder.byPredicate(
                plans,
                p -> p instanceof Business4G);
        Assert.assertTrue(plan.isPresent());
        Assert.assertEquals(plan.get(), plans.get(2));
    }

    @Test
    public void byPredicateTest4() {
        Optional<Plan> plan = Finder.byPredicate(
                plans,
                p -> p.users() <= 1);
        Assert.assertFalse(plan.isPresent());
    }
}
