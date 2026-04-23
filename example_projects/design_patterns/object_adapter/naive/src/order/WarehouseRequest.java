package order;

import java.util.Map;

public interface WarehouseRequest {
    public void placeRequest(Map<String, Integer> orderListWithQuantities);
    public String getDropOffLoication();
}
