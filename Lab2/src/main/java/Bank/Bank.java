package Banks;

import java.sql.Time;

public class Bank implements Comparable{

    private String name;
    private String country;
    private Deposit deposit;

    public Bank() {
        this.deposit = new Deposit();
    }

    public int compareTo(Object o) {
        return name.compareTo(((Bank) o).getName());
    }

    @Override
    public boolean equals(Object other) {
        if(other == this) return true;
        if(!(other instanceof Bank)) return false;
        Bank bank = (Bank) other;
        return this.name.equals(bank.getName()) &&
                this.country.equals(bank.getCountry()) &&
                this.deposit.equals(bank.getDeposit());
    }

    @Override
    public String toString() {
        return "Name: " + name +
                " Country: " + country +
                " " + deposit;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setDeposit(Deposit deposit) {
        this.deposit = deposit;
    }

    public Deposit getDeposit() {
        return deposit;
    }
}
