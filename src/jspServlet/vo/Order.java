package jspServlet.vo;

import java.util.ArrayList;


/**
 * 订单信息
 * @author Zeyang Sun
 */

public class Order {
    private Integer OrderID;
    private Integer CustomerID;
    private ArrayList<Commodity> Commodities;
    private float TotalPrice;
    private String State;
    private String OrderTime;

    public Integer getOrderID() {
        return OrderID;
    }

    public void setOrderID(Integer orderID) {
        OrderID = orderID;
    }

    public Integer getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(Integer customerID) {
        CustomerID = customerID;
    }

    public ArrayList<Commodity> getCommodities() {
        return Commodities;
    }

    public void setCommodities(ArrayList<Commodity> commodities) {
        Commodities = commodities;
    }

    public float getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        TotalPrice = totalPrice;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getOrderTime() {
        return OrderTime;
    }

    public void setOrderTime(String orderTime) {
        OrderTime = orderTime;
    }
}
