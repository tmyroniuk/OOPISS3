package Banks;

public class Deposit {

    private DepositType type;
    private String depositor;
    private int accountId;
    private int accountOnDeposit;
    private int profitability;  // profitability in percents yearly
    private int timeConstraints;  // time constraints in months

    @Override
    public boolean equals(Object other) {
        if(this == other) return true;
        if(!(other instanceof Deposit)) return false;
        Deposit deposit = (Deposit) other;
        return this.type.equals(deposit.getType()) &&
                this.depositor.equals(deposit.getDepositor()) &&
                this.accountId == deposit.getAccountId() &&
                this.accountOnDeposit == deposit.getAccountOnDeposit() &&
                this.profitability == deposit.getProfitability() &&
                this.timeConstraints == deposit.getTimeConstraints();
    }

    @Override
    public String toString() {
        String res;
        switch (type) {
            case Metal -> {
                res = "Metal";
            }
            case Saving -> {
                res = "Saving";
            }
            case Urgent -> {
                res = "Urgent";
            }
            case Calculated -> {
                res = "Calculated";
            }
            case OnDemand -> {
                res = "OnDemand";
            }
            case Accumulating -> {
                res = "Accumulating"
            }
            default -> {
                res = "";
            }
        }
        res += "Depositor: " + depositor +
                " Account ID: " + accountId +
                " Account on deposit: " + accountOnDeposit +
                " Profitability: " + profitability +
                " Time constraint: " + timeConstraints;
        return res;
    }

    public DepositType getType() {
        return type;
    }

    public void setType(DepositType type) {
        this.type = type;
    }

    public String getDepositor() {
        return depositor;
    }

    public void setDepositor(String depositor) {
        this.depositor = depositor;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getAccountOnDeposit() {
        return accountOnDeposit;
    }

    public void setAccountOnDeposit(int accountOnDeposit) {
        this.accountOnDeposit = accountOnDeposit;
    }

    public int getProfitability() {
        return profitability;
    }

    public void setProfitability(int profitability) {
        this.profitability = profitability;
    }

    public int getTimeConstraints() {
        return timeConstraints;
    }

    public void setTimeConstraints(int timeConstraints) {
        this.timeConstraints = timeConstraints;
    }
}
