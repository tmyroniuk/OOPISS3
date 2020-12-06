import plans.*;

import java.util.List;
import java.util.Scanner;

public class ConsoleInterface {

    private List<Plan> plans;

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
        for (Plan plan: plans) {
            printOne(plan);
        }
    }
    
    public ConsoleInterface(List<Plan> plans) {
        this.plans = plans;
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
                        plans = Sorter.byCost(plans);
                    } else if(input[1].equals("annual")) {
                        plans = Sorter.byAnnualCost(plans);
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
                        Finder.byPredicate(plans, plan -> plan.getCost() == val).ifPresent(this::printOne);
                    } else if(input[1].equals("annual")) {
                        Finder.byPredicate(plans, plan -> plan.getAnnualCost() == val).ifPresent(this::printOne);
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
                    if(pos < 0 || pos >= plans.size()) {
                        continue;
                    }
                    try {
                        plans.get(pos).apply(val);
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
                    if(pos < 0 || pos >= plans.size()) {
                        continue;
                    }
                    try {
                        plans.get(pos).discard();
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
