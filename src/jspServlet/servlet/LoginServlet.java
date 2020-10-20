package jspServlet.servlet;

import jspServlet.DAO.CustomerDAO;

import jspServlet.DAO.impl.CustomerDAOImpl;
import jspServlet.vo.Commodity;
import jspServlet.vo.Customer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class LoginServlet extends HttpServlet {

    @Override
    /**
     * 跳转到注册页面
     * @author Zeyang Sun
     */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("./logup.jsp");
    }

    @Override
    /**
     * 用户登录验证
     * @author Zeyang Sun
     */
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        req.setCharacterEncoding("UTF-8");
//        resp.setCharacterEncoding("UTF-8");
//        resp.setContentType("text/html;charset=UTF-8");
        Customer customer= new Customer();
        customer.setAccount(req.getParameter("username"));
        customer.setPassword(req.getParameter("password"));

        CustomerDAO dao=new CustomerDAOImpl();
        int flag=0;

        try {
            flag=dao.queryByAccount(customer);

        } catch (Exception e) {
            e.printStackTrace();
        }

        if(flag==1){
            //Luo Deng Adds
            //购物车session构造
            Integer cmAmount = 0;//购物车商品总数量
            Float totalPrice = (float)(0.);//购物车商品总花费
            Commodity tempCm = new Commodity();//暂存的商品对象
            ArrayList<Commodity> cmArray = new ArrayList<Commodity>();//购物车内的商品信息组
            HashMap<Integer, Integer> shopList = new HashMap<Integer, Integer>();//购物车商品编号-数量
            HashMap<Integer, Float> userPrice = new HashMap<Integer, Float>();//购物车商家-总价，方便统计和生成订单
            //End Add
            Customer customer1 =new Customer();
            try {
                customer1=dao.CustomerInfo(customer);
            } catch (Exception e) {
                e.printStackTrace();
            }
            HttpSession session = req.getSession();
            session.setAttribute("try","ok");
            session.setAttribute("customerID", customer1.getID());
            session.setAttribute("username",customer.getAccount());
            //下面部分由 Thomas Andon加入
            session.setAttribute("realName", customer1.getName());
            session.setAttribute("gender", customer1.getGender());
            session.setAttribute("address", customer1.getAddress());
//            System.out.println(customer1.getAddress());
//            System.out.println(customer1.getName());
//            System.out.println(customer1.getGender());
            //end add
            //Luo Deng add
            session.setAttribute("cmAmount", cmAmount);
            session.setAttribute("userPrice", userPrice);
            session.setAttribute("totalPrice", totalPrice);
            session.setAttribute("tempCm", tempCm);
            session.setAttribute("cmArray", cmArray);
            session.setAttribute("shopList", shopList);
            //end add


            resp.sendRedirect("./index(welcome).jsp");
        }else{
            resp.sendRedirect("./errorpage.jsp");
        }

    }
}
