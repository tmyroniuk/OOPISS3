package Bank;

import java.awt.*;
import java.util.Collections;
import java.util.List;

public class Bank{

    private String name;
    private String country;
    private List<Deposit> deposits;

    public Bank(List<Deposit> deposits) {
        this.deposits = deposits;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Deposit deposit : deposits) {
            res.append(deposit.toString()).append("\n");
        }
        return "{\nName: " + name +
                "\nCountry: " + country +
                "\n" + res + "}";
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

    public List<Deposit> getDeposits() {
        return deposits;
    }

    public void sort() {
        Collections.sort(deposits);
    }

}
