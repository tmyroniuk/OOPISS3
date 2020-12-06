import org.junit.Assert;
import org.junit.Test;
import plans.*;

public class Super3GPlusTest {
    @Test
    public void toStringTest() {
        Plan plan = new Super3GPlus(1000);
        Assert.assertEquals(plan.toString(), "Super 3G Plus, yearly cost: 800, users: 1000");
    }
}
