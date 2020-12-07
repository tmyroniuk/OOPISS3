import Parsers.*;
import Bank.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ParserTest {

    private static String xsd = "src/test/resources/Bank.xsd";
    private static String xml = "src/test/resources/Bank.xml";
    Bank check;

    @Before
    public void init() {
        List<Deposit> deposits = new ArrayList<>();
        Deposit deposit = new Deposit();
        deposit.setType(DepositType.Urgent);
        deposit.setDepositor("Michael");
        deposit.setAccountId(11111);
        deposit.setAmountOnDeposit(2000);
        deposit.setProfitability(5);
        deposit.setTimeConstraints(12);
        deposits.add(deposit);
        deposit = new Deposit();
        deposit.setType(DepositType.Saving);
        deposit.setDepositor("Nadja");
        deposit.setAccountId(22222);
        deposit.setAmountOnDeposit(5000);
        deposit.setProfitability(8);
        deposit.setTimeConstraints(6);
        deposits.add(deposit);
        check = new Bank(deposits);
    }

    @Test
    public void domParserTest() {
        BankBuilder builder = new BankBuilder();
        Parser parser = new DomXmlParser(builder);
        parser.parseFile(xml);
        Assert.assertEquals(check.getDeposits(), builder.getBank().getDeposits());
    }

    @Test
    public void saxParserTest() {
        BankBuilder builder = new BankBuilder();
        Parser parser = new SaxXmlParser(builder);
        parser.parseFile(xml);
        Assert.assertEquals(check.getDeposits(), builder.getBank().getDeposits());
    }

    @Test
    public void staxParserTest() {
        BankBuilder builder = new BankBuilder();
        Parser parser = new StaxXmlParser(builder);
        parser.parseFile(xml);
        Assert.assertEquals(check.getDeposits(), builder.getBank().getDeposits());
    }
}
