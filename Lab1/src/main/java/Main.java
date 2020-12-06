import plans.*;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Plan> plans = Arrays.asList(new Super3G(53), new Super3GPlus(51),
                new Business4G(30), new Business4GPlus(12),
                new Unlimited4G(15), new Unlimited4GPlus(2));
        ConsoleInterface cli = new ConsoleInterface(plans);
        cli.start();
    }
}
