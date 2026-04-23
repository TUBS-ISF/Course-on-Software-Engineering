package order;

import java.util.Map;

public class Order implements WarehouseRequest {
    Map<String, Integer> orderListWithQuantities;
    String recipientAddress;
    private int customerId;

    public Order(Map<String, Integer> orderList, String recipientAddress, int customerId) {
        this.orderListWithQuantities = orderList;
        this.recipientAddress = recipientAddress;
        this.customerId = customerId;
    }

    public void sendOrder() {}

    public void awardLoyaltyPoints() {}

    @Override
    public void placeRequest(Map<String, Integer> orderListWithQuantities) {
        throw new UnsupportedOperationException("Unimplemented method 'placeRequest'");
    }

    @Override
    public String getDropOffLoication() {
        throw new UnsupportedOperationException("Unimplemented method 'getDropOffLoication'");
    }
}
