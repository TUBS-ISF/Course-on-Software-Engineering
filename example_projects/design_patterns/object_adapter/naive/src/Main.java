import java.util.HashMap;
import java.util.Map;

import composites.FormulaComponent;
import composites.Literal;
import composites.Product;
import composites.Sum;
import order.Order;
import order.OrderFormulaWrapper;

public class Main {

    private final static Map<String, Integer> CATALOGUE = new HashMap<String, Integer>() {
        {
            put("Chair", 20);
            put("Table", 35);
            put("Lamp", 15);
        }
    };

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

    private static int getOrderCost(Order order) {
        int sum = 0;
        for (String item : order.orderListWithQuantities.keySet()) {
            sum += CATALOGUE.get(item) * order.orderListWithQuantities.get(item);
        }
        return sum;
    }

    public static void main(String[] args) {
        FormulaComponent formulaRoot = new Sum(
                new Literal(getOrderCost(new Order(ORDER_ONE, "Ba Sing Se", 3))),
                new Literal(getOrderCost(new Order(ORDER_TWO, "Omashu", 12))),
                new Product(new Literal(3), new Literal(getOrderCost(new Order(ORDER_THREE, "Zaofu", 1)))));
        System.out.println(formulaRoot.compute());
    }
}
