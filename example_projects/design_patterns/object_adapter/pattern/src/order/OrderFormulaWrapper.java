package order;

import java.util.HashMap;
import java.util.Map;

import composites.FormulaComponent;

public class OrderFormulaWrapper extends FormulaComponent {

    private Order internalOrder;

    private final static Map<String, Integer> CATALOGUE = new HashMap<String, Integer>() {
        {
            put("Chair", 20);
            put("Table", 35);
            put("Lamp", 15);
        }
    };

    public OrderFormulaWrapper(Order order) {
        this.internalOrder = order;
    }

    @Override
    public int compute() {
        int sum  = 0;
        for (String item : internalOrder.orderListWithQuantities.keySet()) {
            sum += CATALOGUE.get(item) * internalOrder.orderListWithQuantities.get(item);
        }
        return sum;
    }

    @Override
    public FormulaComponent[] getChildren() {
        return new FormulaComponent[0];
    }

}
