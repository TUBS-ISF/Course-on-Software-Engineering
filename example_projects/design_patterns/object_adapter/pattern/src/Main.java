import java.util.HashMap;
import java.util.Map;

import composites.FormulaComponent;
import composites.Literal;
import composites.Product;
import composites.Sum;
import order.OrderFormulaWrapper;
import order.Order;

public class Main {

    private final static Map<String, Integer> ORDER_ONE = new HashMap<String, Integer>() {
        {
            put("Chair", 4);
            put("Table", 1);
            put("Lamp", 1);
        }
    };

    private final static Map<String, Integer> ORDER_TWO = new HashMap<String, Integer>() {
        {
            put("Chair", 8);
            put("Table", 1);
            put("Lamp", 0);
        }
    };

    private final static Map<String, Integer> ORDER_THREE = new HashMap<String, Integer>() {
        {
            put("Chair", 0);
            put("Table", 0);
            put("Lamp", 10);
        }
    };

    public static void main(String[] args) {
        FormulaComponent formulaRoot = new Sum(
                new OrderFormulaWrapper(new Order(ORDER_ONE, "Ba Sing Se", 3)),
                new OrderFormulaWrapper(new Order(ORDER_TWO, "Omashu", 12)),
                new Product(new Literal(3), new OrderFormulaWrapper(new Order(ORDER_THREE, "Zaofu", 1))));
        System.out.println(formulaRoot.compute());
    }
}
