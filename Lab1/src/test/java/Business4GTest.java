import org.junit.Assert;
import org.junit.Test;
import plans.*;

public class Business4GTest {
    @Test
    public void toStringTest() {
        Plan plan = new Business4G(1000);
        Assert.assertEquals(plan.toString(), "Business 4G, monthly cost: 120, users: 1000");
    }
}
