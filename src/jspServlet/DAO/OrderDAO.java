package jspServlet.DAO;


import jspServlet.vo.Order;

import java.util.ArrayList;

/**
 * 订单功能接口
 * @author Zeyang Sun
 */
public interface OrderDAO {
    public ArrayList<Order> OrderSearch(Integer CustomerID);
}
