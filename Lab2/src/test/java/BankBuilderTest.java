import Parsers.*;
import Bank.*;

import org.junit.Assert;
import org.junit.Test;

public class BankBuilderTest {

    @Test
    public void sortTest() {
        BankBuilder builder = new BankBuilder();
        builder.tagTimeConstraints("5");
        builder.tagProfitability("5");
        builder.tagAmountOnDeposit("2000");;
        builder.tagAccountId("72345");
        builder.tagDepositor("Test");
        builder.tagType("Urgent");
        builder.finishDeposit();
        builder.tagTimeConstraints("5");
        builder.tagProfitability("5");
        builder.tagAmountOnDeposit("2000");;
        builder.tagAccountId("22345");
        builder.tagDepositor("Test");
        builder.tagType("Urgent");
        builder.finishDeposit();
        builder.tagTimeConstraints("5");
        builder.tagProfitability("5");
        builder.tagAmountOnDeposit("2000");;
        builder.tagAccountId("52345");
        builder.tagDepositor("Test");
        builder.tagType("Urgent");
        builder.finishDeposit();
        builder.finish("Name", "Country");

        Bank bank = builder.getBank();

        Assert.assertTrue(bank.getDeposits().get(0).compareTo(bank.getDeposits().get(1)) <= 0);
        Assert.assertTrue(bank.getDeposits().get(1).compareTo(bank.getDeposits().get(2)) <= 0);

        Assert.assertTrue(bank.getDeposits().get(0).getAccountId() <= bank.getDeposits().get(1).getAccountId());
        Assert.assertTrue(bank.getDeposits().get(1).getAccountId() <= bank.getDeposits().get(2).getAccountId());
    }
}
