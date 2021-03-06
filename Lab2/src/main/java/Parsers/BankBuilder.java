package Parsers;

import Bank.*;

import java.util.ArrayList;
import java.util.List;

public class BankBuilder {

    private Bank bank;
    private List<Deposit> deposits;
    private Deposit currentDeposit;

    public BankBuilder() {
        bank = null;
        deposits = new ArrayList<>();
        currentDeposit = new Deposit();
    }

    public void finish(String name, String country) {
        bank = new Bank(deposits);
        bank.setName(name);
        bank.setCountry(country);
        bank.sort();
    }

    public Bank getBank() {
        return bank;
    }

    public void finishDeposit() {
        deposits.add(currentDeposit);
        currentDeposit = new Deposit();
    }

    public void tag(String tagName, String val) {
        switch (tagName) {
            case "Type" -> tagType(val);
            case "Depositor" -> tagDepositor(val);
            case "AccountId" -> tagAccountId(val);
            case "AmountOnDeposit" -> tagAmountOnDeposit(val);
            case "Profitability" -> tagProfitability(val);
            case "TimeConstraints" -> tagTimeConstraints(val);
        }
    }

    public static final String rootName() {
        return "Deposit";
    }

    public static final String collectionName() {
        return "Bank";
    }

    public void tagType(String val) {
        currentDeposit.setType(DepositType.valueOf(val));
    }

    public void tagDepositor(String val) {
        currentDeposit.setDepositor(val);
    }

    public void tagAccountId(String val) {
        currentDeposit.setAccountId(Integer.parseInt(val));
    }

    public void tagAmountOnDeposit(String val) {
        currentDeposit.setAmountOnDeposit(Integer.parseInt(val));
    }

    public void tagProfitability(String val) {
        currentDeposit.setProfitability(Integer.parseInt(val));
    }

    public void tagTimeConstraints(String val) {
        currentDeposit.setTimeConstraints(Integer.parseInt(val));
    }

}
