import org.junit.Assert;
import org.junit.Test;
import plans.*;

public class Super3GTest {
    @Test
    public void toStringTest() {
        Plan plan = new Super3G(1000);
        Assert.assertEquals(plan.toString(), "Super 3G, monthly cost: 80, users: 1000");
    }
}
