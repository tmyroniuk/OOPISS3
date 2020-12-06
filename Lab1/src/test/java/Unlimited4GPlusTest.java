import org.junit.Assert;
import org.junit.Test;
import plans.*;

public class Unlimited4GPlusTest {
    @Test
    public void toStringTest() {
        Plan plan = new Unlimited4GPlus(1000);
        Assert.assertEquals(plan.toString(), "Unlimited 4G Plus, yearly cost: 1500, users: 1000");
    }
}
