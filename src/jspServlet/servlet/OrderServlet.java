package jspServlet.servlet;

import jspServlet.DAO.CommodityDAO;
import jspServlet.DAO.impl.CommodityDAOImpl;
import jspServlet.vo.Commodity;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;

public class OrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("---OrderServlet---");
        HttpSession session = req.getSession();

        Float totalPrice = (Float) session.getAttribute("totalPrice");
        ArrayList<Commodity> cmArray = (ArrayList<Commodity>) session.getAttribute("cmArray");
        HashMap<Integer, Integer> shopList = (HashMap<Integer, Integer>) session.getAttribute("shopList");
        HashMap<Integer, Float> userPrice = (HashMap<Integer, Float>) session.getAttribute("userPrice");
        Integer customerID = (Integer) session.getAttribute("customerID");
        CommodityDAO dao = new CommodityDAOImpl();
        try {
            dao.OrderCm(customerID, cmArray, shopList, userPrice);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //清零
        Integer cmAmount = 0;
        totalPrice = (float)0.;
        cmArray = new ArrayList<Commodity>();
        shopList = new HashMap<Integer, Integer>();
        userPrice = new HashMap<Integer, Float>();
        session.setAttribute("cmAmount", cmAmount);
        session.setAttribute("userPrice", userPrice);
        session.setAttribute("totalPrice", totalPrice);
        session.setAttribute("cmArray", cmArray);
        session.setAttribute("shopList", shopList);

        Enumeration<?> enumeration1 = session.getAttributeNames();
        while (enumeration1.hasMoreElements()) {
            String name = enumeration1.nextElement().toString();
            // 根据键值取session中的值
            Object value = session.getAttribute(name);
            // 打印结果
            System.out.println(name+ "=" + value);
        }

        resp.sendRedirect("./index(welcome).jsp");
    }
}
