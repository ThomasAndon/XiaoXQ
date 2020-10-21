package jspServlet.vo;

import java.sql.Date;
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
    private Date OrderTime;

    public Date getOrderTime() {
        return OrderTime;
    }

    public void setOrderTime(Date orderTime) {
        OrderTime = orderTime;
    }

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


}
