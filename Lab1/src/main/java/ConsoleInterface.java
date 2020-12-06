import plans.*;

import java.util.List;
import java.util.Scanner;

public class ConsoleInterface {

    private List<Plan> _plans;

    private void help() {
        System.out.println("print - print plans\nsort [cost/annual] - sort by given parameter\n" +
                "find [cost/annual] <value> - print one plan with given value of selected parameter\n" +
                "apply <position> <balance> - apply user with given balance to plan on given position\n" +
                "discard <position> - discard user from plan on given position\nhelp - get command list\n" +
                "exit - quit program\n");
    }

    private void printOne(Plan plan) {
        System.out.println(plan.toString());
    }
    
    private void printAll() {
        for (Plan plan: _plans) {
            printOne(plan);
        }
    }
    
    public ConsoleInterface(List<Plan> plans) {
        _plans = plans;
    }

    public void start() {
        help();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            String[] input = scanner.nextLine().split(" ");
            switch (input[0]) {
                case "exit" -> {
                    return;
                }
                case "print" -> {
                    printAll();
                }
                case "sort" -> {
                    if(input.length < 2) {
                        continue;
                    }
                    if(input[1].equals("cost")) {
                        _plans = Sorter.byCost(_plans);
                    } else if(input[1].equals("annual")) {
                        _plans = Sorter.byAnnualCost(_plans);
                    }
                }
                case "find" -> {
                    if(input.length < 3) {
                        continue;
                    }
                    int val;
                    try {
                        val = Integer.parseInt(input[2]);
                    }
                    catch (Throwable error) {
                        continue;
                    }
                    if(input[1].equals("cost")) {
                        Finder.byPredicate(_plans, plan -> plan.cost() == val).ifPresent(this::printOne);
                    } else if(input[1].equals("annual")) {
                        Finder.byPredicate(_plans, plan -> plan.annualCost() == val).ifPresent(this::printOne);
                    }
                }
                case "apply" -> {
                    int val, pos;
                    try {
                        pos = Integer.parseInt(input[1]);
                        val = Integer.parseInt(input[2]);
                    }
                    catch (Throwable error) {
                        continue;
                    }
                    if(pos < 0 || pos >= _plans.size()) {
                        continue;
                    }
                    try {
                        _plans.get(pos).apply(val);
                    }
                    catch (Exception exception) {
                        System.out.println(exception.getMessage());
                    }
                }
                case "discard" -> {
                    int pos;
                    try {
                        pos = Integer.parseInt(input[1]);
                    }
                    catch (Throwable error) {
                        continue;
                    }
                    if(pos < 0 || pos >= _plans.size()) {
                        continue;
                    }
                    try {
                        _plans.get(pos).discard();
                    }
                    catch (Exception exception) {
                        System.out.println(exception.getMessage());
                    }
                }
                case "help" -> {
                    help();
                }
            }
        }
    }
}
