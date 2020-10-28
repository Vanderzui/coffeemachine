package org.vanderzui.cofeemachine.entity;

public class SupplyEntity {
    private int count;
    //think about it
    private int price;
    private SupplyType type;

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setType(SupplyType type) {
        this.type = type;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getCount() {
        return count;
    }

    public SupplyType getType() {
        return type;
    }
}
