package plans;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Finder {

    static public Optional<Plan> byPredicate(List<Plan> plans, Predicate<Plan> predicate) {
        return plans.stream()
                .filter(predicate)
                .findFirst();
    }
}

