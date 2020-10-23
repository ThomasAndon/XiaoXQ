package jspServlet.servlet;

import jspServlet.vo.Commodity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;

public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        System.out.println("---CartServlet---");
        Enumeration em = req.getParameterNames();
        HttpSession session = req.getSession();
        Integer cmAmount = (Integer) session.getAttribute("cmAmount");
        Float totalPrice = (Float) session.getAttribute("totalPrice");
        ArrayList<Commodity> cmArray = (ArrayList<Commodity>) session.getAttribute("cmArray");
        HashMap<Integer, Integer> shopList = (HashMap<Integer, Integer>) session.getAttribute("shopList");
        HashMap<Integer, Float> userPrice = (HashMap<Integer, Float>) session.getAttribute("userPrice");

        String paraName = "";
        String str = "";
        while (em.hasMoreElements()) {
            paraName = (String) em.nextElement();
            str = req.getParameter(paraName);
            System.out.println(paraName + " = " + str );
        }

        System.out.println(paraName);
        Integer cmID = Integer.parseInt(paraName.substring(1));
        Integer count = shopList.get(cmID);
        Boolean dec = false;
        if(paraName.substring(0,1).equals("d")){
            --count;
            dec = true;
        }else if(paraName.substring(0,1).equals("i")){
            ++count;
        }else{
            System.out.println("Error in change the amount of the cart!!!");
        }

        Commodity cm = new Commodity();
        for(Commodity cm1 : cmArray){
            if(cm1.getCommodityId() == cmID){
                cm = cm1;
                break;
            }
        }

        if(count == 0 && dec){
            shopList.remove(cmID);
            int i = 0;
            for(Commodity cm1 : cmArray){
                if(cm1.getCommodityId() == cmID){
                    cmArray.remove(i);
                    break;
                }
                ++i;
            }

            Float price1 = userPrice.get(cm.getUserId());
            if(price1 == cm.getPrice()){
                userPrice.remove(cm.getUserId());
                totalPrice = (float)0.;
            }else{
                userPrice.replace(cm.getUserId(), price1-cm.getPrice());
                totalPrice -= cm.getPrice();
            }
            System.out.println("In count == 0 and dec, totalPrice = " + totalPrice);
            --cmAmount;
        }else if(dec){
            shopList.replace(cmID, count);
            Float price2 = userPrice.get(cm.getUserId());
            userPrice.replace(cm.getUserId(), price2-cm.getPrice());
            --cmAmount;
            totalPrice = totalPrice - cm.getPrice();
            System.out.println("In count != 0 and dec totalPrice = " + totalPrice);
        }else{
            shopList.replace(cmID, count);
            Float price2 = userPrice.get(cm.getUserId());
            userPrice.replace(cm.getUserId(), price2+cm.getPrice());
            ++cmAmount;
            totalPrice = totalPrice + cm.getPrice();
            System.out.println("In count != 0 and inc, totalPrice = " + totalPrice);
        }

        session.setAttribute("cmAmount", cmAmount);
        session.setAttribute("userPrice", userPrice);
        session.setAttribute("totalPrice", totalPrice);
        session.setAttribute("cmArray", cmArray);
        session.setAttribute("shopList", shopList);

        resp.sendRedirect("./checkout.jsp");
    }
}
