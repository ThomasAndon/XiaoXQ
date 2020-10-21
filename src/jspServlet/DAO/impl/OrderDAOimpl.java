package jspServlet.DAO.impl;

import jspServlet.DAO.OrderDAO;
import jspServlet.db.DBConnect;
import jspServlet.vo.Commodity;
import jspServlet.vo.Order;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDAOimpl implements OrderDAO {
    @Override
    /**
     * 查询该用户的所有订单信息
     * @param UserID
     * @return ArrayList<Order>
     * @throws
     * @author Zeyang Sun
     */
    public ArrayList<Order> OrderSearch(Integer CustomerID) {
//        System.out.println(CustomerID+"&&^%&^%^&%&^%%");
        ArrayList<Order> orders= new ArrayList<Order>();
        String sql = "select * from Indent where CustomerID=?";
        String sql2 = "select * from itemdetail where OrderID=?";
        String sql3 = "select * from commodity where CommodityId=?";
        Integer commodityid = null;
        PreparedStatement pstmt = null ;
        PreparedStatement pstmt2 = null ;
        PreparedStatement pstmt3 = null ;
        DBConnect dbc = null;


        try{

            dbc = new DBConnect() ;
            pstmt = dbc.getConnection().prepareStatement(sql) ;
            pstmt.setInt(1,CustomerID);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Order order= new Order();
                order.setCustomerID(CustomerID);
                order.setOrderID(rs.getInt("Orderid"));
                order.setTotalPrice(rs.getFloat("TotalPrice"));
                order.setState(rs.getString("State"));
                order.setOrderTime(rs.getDate("OrderTime"));
                pstmt2 = dbc.getConnection().prepareStatement(sql2) ;
                pstmt2.setInt(1,rs.getInt("Orderid"));
//                System.out.println(order.getOrderTime()+"######");
                ResultSet rs2 = pstmt2.executeQuery();
                while (rs2.next()){
                    ArrayList<Commodity> Commodities = new ArrayList<Commodity>();
                    pstmt3 = dbc.getConnection().prepareStatement(sql3) ;
                    pstmt3.setInt(1,rs2.getInt("commodityid"));
                    ResultSet rs3 = pstmt3.executeQuery();
                    while (rs3.next()){
                        Commodity commodity = new Commodity();
                        commodity.setName(rs3.getString("name"));
                        commodity.setTheClass(rs3.getString("TheClass"));
                        commodity.setTheColor(rs3.getString("TheColor"));
                        commodity.setInstructions(rs3.getString("Instructions"));
                        commodity.setPrice(rs3.getFloat("Price"));
                        commodity.setUserId(rs3.getInt("UserId"));
                        commodity.setCommodityId(rs3.getInt("CommodityId"));
//                        System.out.println(commodity.getName()+"######");
                        Commodities.add(commodity);
                    }
                    order.setCommodities(Commodities);
                    rs3.close();
                    pstmt3.close() ;
                }
                orders.add(order);
                rs2.close();
                pstmt2.close() ;
            }
            rs.close() ;
            pstmt.close() ;
        }catch (SQLException | IOException e){
            System.out.println(e.getMessage());
        }finally{
//            System.out.println(orders.get(0).getCommodities().get(0).getName()+"%%%%%######");

            dbc.close() ;
        }
        //System.out.println(orders.get(0).getOrderID()+"@@@@@@");
        //System.out.println(orders.get(0).getCommodities().get(0).getName()+"$$$$$$$");

        return orders;


    }
}
