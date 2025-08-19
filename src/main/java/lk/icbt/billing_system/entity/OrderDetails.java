package lk.icbt.billing_system.entity;

public class OrderDetails implements SuperEntity{
    private String orderID;
    private String itemCode;
    private Double unitPrice;
    private int qty;

    public OrderDetails() {
    }

    public OrderDetails(String orderID, String itemCode, Double unitPrice, int qty) {
        this.orderID = orderID;
        this.itemCode = itemCode;
        this.unitPrice = unitPrice;
        this.qty = qty;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "orderID='" + orderID + '\'' +
                ", itemCode='" + itemCode + '\'' +
                ", unitPrice=" + unitPrice +
                ", qty=" + qty +
                '}';
    }
}
