import org.junit.Assert;
import org.junit.Test;
import plans.*;

public class PlanTest {
    @Test
    public void costTest() {
        Plan plan = new Unlimited4G(200);
        Assert.assertEquals(plan.getCost(), 150);
    }

    @Test
    public void usersTest() {
        Plan plan = new Unlimited4G(200);
        Assert.assertEquals(plan.getUsers(), 200);
    }

    @Test
    public void applyTest() throws NotEnoughMoneyException {
        Plan plan = new Unlimited4G(1);
        Assert.assertThrows(NotEnoughMoneyException.class, () -> {
            plan.apply(100);
        });
        Assert.assertEquals(plan.getUsers(), 1);
        plan.apply(150);
        Assert.assertEquals(plan.getUsers(), 2);
    }

    @Test
    public void discardTest() throws NoUsersException {
        Plan plan = new Unlimited4G(1);
        plan.discard();
        Assert.assertEquals(plan.getUsers(), 0);
        Assert.assertThrows(NoUsersException.class, plan::discard);
        Assert.assertEquals(plan.getUsers(), 0);
    }
}