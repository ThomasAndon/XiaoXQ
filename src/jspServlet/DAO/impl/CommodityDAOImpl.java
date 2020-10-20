package jspServlet.DAO.impl;

import jspServlet.DAO.CommodityDAO;
import jspServlet.db.DBConnect;
import jspServlet.vo.Commodity;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class CommodityDAOImpl implements CommodityDAO {
    @Override
    /**
     * 向数据库中插入商品数据
     * @param commodity 商品实例
     * @throws Exception
     * @author Zeyang Sun
     */
    public void InsertCommodity(Commodity commodity) throws Exception {
        String sql="INSERT INTO `managementsystem`.`commodity` (`Name`, `Price`, `TheColor`, `TheClass`, `Instructions`, `UserId`) " +
                "VALUES (?, ?, ?, ?, ?, ?);";
        PreparedStatement PS;
        DBConnect DBC=null;
        try {
            DBC = new DBConnect();
            PS = DBC.getConnection().prepareStatement(sql);
            PS.setString(1,commodity.getName());
            PS.setString(2,""+commodity.getPrice());
            PS.setString(3,commodity.getTheColor());
            PS.setString(4,commodity.getTheClass());
            PS.setString(5,commodity.getInstructions());
            PS.setString(6,""+commodity.getUserId());
            PS.executeUpdate();
            PS.close();
        } catch (SQLException throwables) {

            throwables.printStackTrace();
        }
        DBC.close();
    }

    @Override
    /**
     * 商品名称的模糊查询
     * @param string 模糊查询关键字
     * @param Order 按价格排序方式
     * @return 商品实例List
     * @throws Exception
     * @author Zeyang Sun
     */
    public ArrayList<Commodity> FQCommodity(String string,String Order) throws Exception {
        String sql = "Select * from Commodity where name like ? order by Price "+Order;

        DBConnect DBC = null;
        PreparedStatement PS;
        ArrayList<Commodity> AL=new ArrayList<Commodity>();
        try {
            DBC = new DBConnect();
            PS = DBC.getConnection().prepareStatement(sql);
            PS.setString(1, "%" + string + "%");
            ResultSet re = PS.executeQuery();
            while (re.next()) {
                Commodity C=new Commodity();
                C.setName(re.getString("name"));
                C.setTheColor(re.getString("LargeClass"));
                C.setTheClass(re.getString("SmallClass"));
                C.setInstructions(re.getString("Instructions"));
                C.setPrice(re.getFloat("Price"));
                C.setUserId(re.getInt("UserId"));
                C.setCommodityId(re.getInt("CommodityId"));
                AL.add(C);
            }
            re.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DBC.close();
        return AL;
    }
    /**  对大类进行模糊查询
     *
     *
     *
     * @return 一个动态数组，原子元素为符合条件的商品
     * @exception
     * @author Caitong Tang
     */
    public ArrayList<Commodity> ColorSearch(String string,String Order) throws Exception {
        ArrayList<Commodity> vogue = new ArrayList<>();
        String sql = "Select * from Commodity Where TheColor Like ? order by Price "+Order;
        DBConnect dbc = null;
        PreparedStatement ps;
        try {
            dbc = new DBConnect();
            ps = dbc.getConnection().prepareStatement(sql);
            ps.setString(1, "%" + string + "%");
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                Commodity temp = new Commodity();
                temp.setName(result.getString("name"));
                temp.setCommodityId(result.getInt("CommodityId"));
                temp.setInstructions(result.getString("Instructions"));
                temp.setTheColor(result.getString("LargeClass"));
                temp.setTheClass(result.getString("SmallClass"));
                temp.setPrice(result.getFloat("Price"));
                temp.setUserId(result.getInt("UserId"));
                vogue.add(temp);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        dbc.close();
        return vogue;
    }

    @Override
    /**  对小类进行模糊查询
     *
     *
     *
     * @return 一个动态数组，原子元素为符合条件的商品
     * @exception
     * @author Caitong Tang
     */
    public ArrayList<Commodity> ClassSearch(String string,String Order) throws Exception {
        ArrayList<Commodity> vogue = new ArrayList<>();
        String sql = "Select * from Commodity Where SmallClass Like ? order by Price "+Order;
        DBConnect dbc = null;
        PreparedStatement ps;
        try {
            dbc = new DBConnect();
            ps = dbc.getConnection().prepareStatement(sql);
            ps.setString(1, "%" + string + "%");
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                Commodity temp = new Commodity();
                temp.setName(result.getString("name"));
                temp.setCommodityId(result.getInt("CommodityId"));
                temp.setInstructions(result.getString("Instructions"));
                temp.setTheColor(result.getString("LargeClass"));
                temp.setTheClass(result.getString("SmallClass"));
                temp.setPrice(result.getFloat("Price"));
                temp.setUserId(result.getInt("UserId"));
                vogue.add(temp);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        dbc.close();
        return vogue;
    }

    @Override
    /**  对单个商品进行编号搜索
     * @return Commodity 对象
     * @exception
     * @author Luo Deng
     */
    public Commodity SingleIdSearch(Integer cmId) throws Exception{
        String sql = "Select * from Commodity where CommodityId = ?";

        DBConnect dbc = null;
        PreparedStatement ps;
        Commodity cm = new Commodity();

        try{
            dbc = new DBConnect();
            ps = dbc.getConnection().prepareStatement(sql);
            ps.setInt(1, cmId);
            ResultSet re = ps.executeQuery();
            while (re.next()) {
                cm.setName(re.getString("name"));
                cm.setTheClass(re.getString("TheClass"));
                cm.setTheColor(re.getString("TheColor"));
                cm.setInstructions(re.getString("Instructions"));
                cm.setPrice(re.getFloat("Price"));
                cm.setUserId(re.getInt("UserId"));
                cm.setCommodityId(re.getInt("CommodityId"));
            }
            re.close();
        } catch (SQLException throwables) {
            System.out.println("Error in search!!!");
            throwables.printStackTrace();
        }
        dbc.close();
        return cm;
    }

    @Override
    /**   将购物车内的所有商品存入订单数据库
     *
     */
    public void OrderCm(Integer customerID, HashMap<Integer, Integer> shopList, Float totalPrice) throws Exception {
        /*
        String indentSql = "INSERT INTO `managementsystem`.`indent` (`TotalPrice`, `OrderTime`, `State`, `CustomerId`, `UserId`) " +
                "VALUES (?, ?, ?, ?, ?);";
        String detailSql = "INSERT INTO `managementsystem`.`itemdetail` (`OrderId`, `CommodityId`, `Number`) " +
                "VALUES (?, ?, ?);";
        DBConnect dbc = null;
        PreparedStatement ps;
        String state = "ordered";
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());

        try{
            dbc = new DBConnect();
            ps = dbc.getConnection().prepareStatement(indentSql);
            ps.setFloat(1, totalPrice);
            ps.setTimestamp(2, ts);
            ps.setString(3, state);
            ps.setInt(4, customerID);
            ps.setInt(5, );
        }catch(SQLException throwables){
            System.out.println("Error in MAKING order!!!");
            throwables.printStackTrace();
        }
        dbc.close();
    }

         */
    }
}
