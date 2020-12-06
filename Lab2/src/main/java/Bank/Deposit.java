package Bank;

public class Deposit implements Comparable {

    private DepositType type;
    private String depositor;
    private int accountId;
    private int amountOnDeposit;
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
                this.amountOnDeposit == deposit.getAmountOnDeposit() &&
                this.profitability == deposit.getProfitability() &&
                this.timeConstraints == deposit.getTimeConstraints();
    }

    @Override
    public String toString() {
        String res = "\t[\n\tType: ";
        switch (type) {
            case Metal -> res += "Metal";
            case Saving -> res += "Saving";
            case Urgent -> res += "Urgent";
            case Calculated -> res += "Calculated";
            case OnDemand -> res += "OnDemand";
            case Accumulating -> res += "Accumulating";
        }
        res += "\n\tDepositor: " + depositor +
                "\n\tAccount ID: " + accountId +
                "\n\tAccount on deposit: " + amountOnDeposit +
                "\n\tProfitability: " + profitability +
                "\n\tTime constraint: " + timeConstraints + "\n\t]";
        return res;
    }

    public int compareTo(Object o) {
        return Integer.compare(accountId, ((Deposit) o).accountId);
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

    public int getAmountOnDeposit() {
        return amountOnDeposit;
    }

    public void setAmountOnDeposit(int amountOnDeposit) {
        this.amountOnDeposit = amountOnDeposit;
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
