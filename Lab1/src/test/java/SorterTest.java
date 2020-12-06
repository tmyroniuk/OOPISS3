import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import plans.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SorterTest {

    private List<Plan> plans;

    @Before
    public void before() {
        plans = Arrays.asList(new Super3G(53), new Super3GPlus(51),
                new Business4G(30), new Business4GPlus(12),
                new Unlimited4G(15), new Unlimited4GPlus(2));
    }

    @Test
    public void byCostTest() {
        List<Plan> correct = new ArrayList<>();
        correct.add(new Super3G(53));
        correct.add(new Business4G(30));
        correct.add(new Unlimited4G(15));
        correct.add(new Super3GPlus(51));
        correct.add(new Business4GPlus(12));
        correct.add(new Unlimited4GPlus(2));

        Assert.assertEquals(correct, Sorter.byCost(plans));
    }

    @Test
    public void byAnnualCostTest() {
        List<Plan> correct = new ArrayList<>();
        correct.add(new Super3GPlus(51));
        correct.add(new Super3G(53));
        correct.add(new Business4GPlus(12));
        correct.add(new Business4G(30));
        correct.add(new Unlimited4GPlus(2));
        correct.add(new Unlimited4G(15));

        Assert.assertEquals(correct, Sorter.byAnnualCost(plans));
    }
}