package jspServlet.DAO.impl;

import jspServlet.DAO.CustomerDAO;
import jspServlet.db.DBConnect;
import jspServlet.vo.Customer;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    /**
     * 判断用户是否登录成功
     * @param customer
     * @return 0代表失败，1代表成功
     * @throws Exception
     * @author Zeyang Sun
     */
    public int queryByAccount(Customer customer) throws Exception {

        int flag = 0;
        String sql = "select * from Customer where Account=?";
        PreparedStatement pstmt = null ;
        DBConnect dbc = null;


        try{

            dbc = new DBConnect() ;
            pstmt = dbc.getConnection().prepareStatement(sql) ;
            pstmt.setString(1,customer.getAccount()) ;
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){

                if(rs.getString("password").equals(customer.getPassword())){
                    flag = 1;
                }
            }
            rs.close() ;
            pstmt.close() ;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally{

            dbc.close() ;
        }
        return flag;
    }



    /**
     * 将用户数据插入数据库
     * @param customer
     * @return 0代表成功，1代表失败
     * @throws Exception
     * @author Zeyang Sun
     */
    @Override
    public int InsertCustomer(Customer customer) throws Exception {

        int rows=0;
        String sql = "INSERT INTO `managementsystem`.`customer` " +
                "(`Name`, `Account`, `Password`, `Gender`, `Address`)" +
        " VALUES (?, ?, ?, ?, ?);";
        PreparedStatement ps = null ;
        DBConnect dbc = null;

        try{

        dbc = new DBConnect() ;
            ps = dbc.getConnection().prepareStatement(sql) ;
            ps.setString(1,customer.getName()) ;
            ps.setString(2,customer.getAccount()) ;
            ps.setString(3,customer.getPassword()) ;
            ps.setString(4,customer.getGender()) ;
            ps.setString(5,customer.getAddress()) ;
         rows=ps.executeUpdate();

            ps.close() ;
        }catch (SQLException e){
            System.out.println("$%$%$%$%$%$%错误5445454545454");
        }finally{

        dbc.close() ;
        }
        return  rows;
    }

    @Override
    /**
     * 获取指定用户的用户信息
     * @param customer
     * @return 存入了查询到的用户信息的用户实例
     * @throws Exception
     * @author Zeyang Sun
     */
    public Customer CustomerInfo(Customer customer) throws Exception {
        String sql = "select * from Customer where Account=?";
        PreparedStatement pstmt = null ;
        DBConnect dbc = null;


        try{

            dbc = new DBConnect() ;
            pstmt = dbc.getConnection().prepareStatement(sql) ;
            pstmt.setString(1,customer.getAccount()) ;
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                customer.setName(rs.getString("Name"));
                customer.setAddress(rs.getString("Address"));
                customer.setGender(rs.getString("Gender"));
                customer.setID(rs.getInt("CustomerId"));
            }
            rs.close() ;
            pstmt.close() ;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally{

            dbc.close() ;
        }

        return customer;


    }


    /**
     * 用户改密码
     *
     * @return 是否修改成功
     * @throws Exception
     * @author Caitong Tang
     */


    public int Changepw(String ac, String ori, String change) {
        String sql1 = "select Password from ManagementSystem.Customer where Account = ?";
        String sql2 = "UPDATE ManagementSystem.Customer t SET t.Password = ? WHERE t.Account = ?";
        PreparedStatement pstmt = null ;
        DBConnect dbc = null;

        try {
            dbc = new DBConnect();
            pstmt = dbc.getConnection().prepareStatement(sql1);
            pstmt.setString(1,ac);
            ResultSet rs = pstmt.executeQuery();

            String returnoripw = null;

            while (rs.next()) {
                returnoripw = (rs.getString("Password"));
            }
            if(returnoripw.equals(ori)) {
                //验证成功；修改密码
                pstmt = dbc.getConnection().prepareStatement(sql2);
                pstmt.setString(1, change);
                pstmt.setString(2, ac);

                boolean rs2 = pstmt.execute();

                return 1;


            } else {
                return 0;
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            dbc.close();
        }

        return -1;
    }


    /**
     * 用户改信息
     *
     * @return 是否修改成功
     * @throws Exception
     * @author Caitong Tang
     *
     */

    public int Changepi(String un, String newrn, String newaddr) {
        String sql1 = "UPDATE ManagementSystem.Customer t SET t.Address = ?, t.Name = ? where t.Account = ?";

        PreparedStatement pstmt = null ;
        DBConnect dbc = null;

        try {
            dbc = new DBConnect();
            pstmt = dbc.getConnection().prepareStatement(sql1);
            pstmt.setString(1,newaddr);
            pstmt.setString(2,newrn);
            pstmt.setString(3,un);

            Boolean rs = pstmt.execute();

            String returnoripw = null;

                return 1;



        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            dbc.close();
        }

        return -1;
    }

}
