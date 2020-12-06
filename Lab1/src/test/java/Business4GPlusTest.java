import org.junit.Assert;
import org.junit.Test;
import plans.*;

public class Business4GPlusTest {
    @Test
    public void toStringTest() {
        Plan plan = new Business4GPlus(1000);
        Assert.assertEquals(plan.toString(), "Business 4G Plus, yearly cost: 1200, users: 1000");
    }
}
