package plans;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class Sorter {

    static public List<Plan> byCost(List<Plan> plans) {
        return plans.stream()
                .sorted(Comparator.comparing(Plan::getCost))
                .collect(Collectors.toList());
    }

    static public List<Plan> byAnnualCost(List<Plan> plans) {
        return plans.stream()
                .sorted(Comparator.comparing(Plan::getAnnualCost))
                .collect(Collectors.toList());
    }
}
