package jspServlet.DAO.impl;

import jspServlet.DAO.CommodityDAO;
import jspServlet.db.DBConnect;
import jspServlet.vo.Commodity;

import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

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
     * 不重复名字地查询所有商品，并提供同名商品的最大最小价格！
     * @return ArrayList<Commodity>
     * @author Zeyang Sun
     */
    public ArrayList<Commodity> CommodityShow() {
        String sql = "SELECT Name,max(Price) as MXP,min(Price) as MIP \n" +
                " FROM managementsystem.commodity \n" +
                " group by Name;";
        PreparedStatement PS;
        DBConnect DBC=null;
        ArrayList<Commodity> Commodities = new ArrayList<Commodity>();
        try {
            DBC = new DBConnect();
            PS = DBC.getConnection().prepareStatement(sql);
            ResultSet rs = PS.executeQuery();
            while (rs.next()){
                Commodity commodity = new Commodity();
                commodity.setName(rs.getString("name"));
                commodity.setMAXPrice(rs.getFloat("MXP"));
                commodity.setMINPrice(rs.getFloat("MIP"));
                Commodities.add(commodity);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
//            for (int i=0;i<33;i++){
//                System.out.println(Commodities.get(i).getName());
//                System.out.println(Commodities.get(i).getMAXPrice());
//                System.out.println(Commodities.get(i).getMINPrice());
//            }
        return Commodities;
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
                C.setTheColor(re.getString("TheColor"));
                C.setTheClass(re.getString("TheClass"));
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
                temp.setTheColor(result.getString("TheColor"));
                temp.setTheClass(result.getString("TheClass"));
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
        String sql = "Select * from Commodity Where TheClass Like ? order by Price "+Order;
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
                temp.setTheColor(result.getString("TheColor"));
                temp.setTheClass(result.getString("TheClass"));
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
    /**  对商品进行精确名字搜索
     * @return ArrayList<Commodity>数组
     * @exception
     * @author Luo Deng
     */
    public ArrayList<Commodity> NameSearch(String nameNum) throws Exception{
        String sql = "Select * from Commodity where name = ?";
        DBConnect dbc = null;
        PreparedStatement ps;
        ArrayList<Commodity> tempCmArray = new ArrayList<>();


        try{
            dbc = new DBConnect();
            ps = dbc.getConnection().prepareStatement(sql);
            ps.setString(1, "Electronic_organ_"+nameNum);
            ResultSet re = ps.executeQuery();
            while (re.next()) {
                Commodity cm = new Commodity();
                cm.setName(re.getString("name"));
                cm.setCommodityId(re.getInt("CommodityId"));
                cm.setInstructions(re.getString("Instructions"));
                cm.setTheColor(re.getString("TheColor"));
                //System.out.println("color is "+cm.getTheColor());
                cm.setTheClass(re.getString("TheClass"));
                cm.setPrice(re.getFloat("Price"));
                cm.setUserId(re.getInt("UserId"));
                tempCmArray.add(cm);
            }
            re.close();
        } catch (SQLException throwables) {
            System.out.println("Error in search!!!");
            throwables.printStackTrace();
        }
        dbc.close();
        return tempCmArray;
    }

    @Override
    /**   将购物车内的所有商品存入订单数据库
     *  @return
     *  @exception
     *  @author Luo Deng
     */
    public void OrderCm(Integer customerID, ArrayList<Commodity> cmArray, HashMap<Integer, Integer> shopList, HashMap<Integer, Float> userPrice) throws Exception {

        String indentSql = "INSERT INTO `managementsystem`.`indent` (`TotalPrice`, `OrderTime`, `State`, `CustomerId`, `UserId`) " +
                "VALUES (?, ?, ?, ?, ?);";
        String detailSql = "INSERT INTO `managementsystem`.`itemdetail` (`OrderId`, `CommodityId`, `Number`) " +
                "VALUES (?, ?, ?);";
        String searchSql = "SELECT OrderId FROM indent ORDER BY OrderId desc limit 1";
        DBConnect dbc = null;
        PreparedStatement ps;
        String state = "ordered";
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());

        Iterator priceIt = userPrice.entrySet().iterator();
        Integer userID;
        float singlePrice = (float)0.;
        try{
            //获取数据库中所需的userID与其对应的totalPrice，和与其对应的cmID
            while(priceIt.hasNext()){
                dbc = new DBConnect();
                ps = dbc.getConnection().prepareStatement(indentSql);
                Map.Entry priceEntry = (Map.Entry)priceIt.next();
                userID = (Integer) priceEntry.getKey();
                singlePrice = (float)priceEntry.getValue();
                //生成indentsql，向indent表插入订单数据
                ps.setFloat(1, singlePrice);
                ps.setTimestamp(2, ts);
                ps.setString(3, state);
                ps.setInt(4, customerID);
                ps.setInt(5, userID);
                ps.executeUpdate();
                ps.close();
                //获取刚刚的记录的订单号
                ps = dbc.getConnection().prepareStatement(searchSql);
                ResultSet re = ps.executeQuery();
                Integer orderID = 0;
                while(re.next()){
                    orderID = re.getInt("OrderId");
                }
                ps.close();
                //获取userID下的cm和shopList里对应cm的数量
                // 并生成detailsql，向itemdetail插入订单细节数据
                Integer cmID = 0;
                Integer count = 0;
                for(Commodity cm : cmArray){
                    if(cm.getUserId() == userID){
                        cmID = cm.getCommodityId();
                        count = shopList.get(cmID);
                        ps = dbc.getConnection().prepareStatement(detailSql);
                        ps.setInt(1, orderID);
                        ps.setInt(2, cmID);
                        ps.setInt(3, count);
                        ps.executeUpdate();
                        ps.close();
                    }
                }

            }

        }catch(SQLException throwables){
            System.out.println("Error in MAKING order!!!");
            throwables.printStackTrace();
        }
        dbc.close();
    }
}
