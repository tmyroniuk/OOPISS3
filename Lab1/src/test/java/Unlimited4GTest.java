import org.junit.Assert;
import org.junit.Test;
import plans.*;

public class Unlimited4GTest {
    @Test
    public void toStringTest() {
        Plan plan = new Unlimited4G(1000);
        Assert.assertEquals(plan.toString(), "Unlimited 4G, monthly cost: 150, users: 1000");
    }
}