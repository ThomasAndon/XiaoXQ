package jspServlet.DAO;

import jspServlet.db.DBConnect;
import jspServlet.vo.Commodity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public interface CommodityDAO {


    public ArrayList<Commodity> NameSearch(String string,String Order);
    /**
     * 向数据库中插入商品数据
     * @param commodity 商品实例
     * @throws Exception
     * @author Zeyang Sun
     */
    public void InsertCommodity(Commodity commodity) throws Exception;

    /**
     * 不重复名字地查询所有商品，并提供同名商品的最大最小价格！
     * @return ArrayList<Commodity>
     * @author Zeyang Sun
     */

    public ArrayList<Commodity> CommodityShow();
    /**
     * 商品名称的模糊查询
     * @param string 模糊查询关键字
     * @param Order 按价格排序方式
     * @return 商品实例List
     * @throws Exception
     * @author Zeyang Sun
     */
    public ArrayList<Commodity> FQCommodity(String string,String Order) throws Exception;

    /**  对大类进行模糊查询
     *
     *
     *
     * @return 一个动态数组，原子元素为符合条件的商品
     * @exception
     * @author Caitong Tang
     */
    public ArrayList<Commodity> ColorSearch(String string,String Order) throws Exception;
    /**  对小类进行模糊查询
     *
     *
     *
     * @return 一个动态数组，原子元素为符合条件的商品
     * @exception
     * @author Caitong Tang
     */
    public ArrayList<Commodity> ClassSearch(String string,String Order) throws Exception;

    public ArrayList<Commodity> NameSearch(String nameNum) throws Exception;

    public void OrderCm(Integer customerID, ArrayList<Commodity> cmArray, HashMap<Integer, Integer> shopList, HashMap<Integer, Float> userPrice) throws Exception;
}
