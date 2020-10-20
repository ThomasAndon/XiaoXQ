package jspServlet.servlet;

import jspServlet.vo.Commodity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

public class ShopServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("---ShopServlet---");
        Integer count = Integer.parseInt(req.getParameter("count"));
        HttpSession session = req.getSession();

        /*
        Enumeration<?> enumeration1 = session.getAttributeNames();
        while (enumeration1.hasMoreElements()) {
            String name = enumeration1.nextElement().toString();
            // 根据键值取session中的值
            Object value = session.getAttribute(name);
            // 打印结果
            System.out.println(name+ "=" + value);
        }

         */



        Integer cmAmount = (Integer) session.getAttribute("cmAmount");
        Float totalPrice = (Float) session.getAttribute("totalPrice");
        ArrayList<Commodity> cmArray = (ArrayList<Commodity>) session.getAttribute("cmArray");
        HashMap<Integer, Integer> shopList = (HashMap<Integer, Integer>) session.getAttribute("shopList");
        HashMap<Integer, Float> userPrice = (HashMap<Integer, Float>) session.getAttribute("userPrice");
        Commodity tempCm = (Commodity) session.getAttribute("tempCm");

        Iterator cmIt = cmArray.iterator();
        Iterator priceIt = userPrice.entrySet().iterator();
        Commodity cm = new Commodity();
        boolean cmIsRepeated = false;//判断cmArray里有无重复项
        boolean userIsRepeated = false;//判断userPrice有无重复商家
        Integer amount = count;//tempCm的数量，初始化为此次购买的数量
        float price = amount * tempCm.getPrice();//在该商家下的花费，初始化此次购买的花费

        //看该tempCm有无在cmArray里，没有的话就添加,并一起添加shopList；有的话就不理，直接进入shopList和userPrice的更新
        //而后再判断userPrice里有无tempCm对应的userID，没有的话就添加到userPrice，有的话就更新
        while (cmIt.hasNext()) {
            //System.out.println("1st loop");
            cm = (Commodity) cmIt.next();
            if (tempCm.getCommodityId() == cm.getCommodityId()) {
                cmIsRepeated = true;
                break;
            }
        }
        if(!cmIsRepeated){
            //没有时，将tempCm和数量插入shopList
            //System.out.println("false");
            cmArray.add(tempCm);
            shopList.put(tempCm.getCommodityId(),amount);
            //遍历userPrice，查看有无对应的userID
            while(priceIt.hasNext()){
                Map.Entry priceEntry = (Map.Entry)priceIt.next();
                if((Integer)priceEntry.getKey() == tempCm.getUserId()){
                    userIsRepeated = true;

                    break;
                }
            }
            if(!userIsRepeated){
                //没有时直接插入
                userPrice.put(tempCm.getUserId(), price);
            }else{
                //有时，将价格加和，更新为商家下所有商品的总价
                price += userPrice.get((Integer)tempCm.getUserId());
                userPrice.replace(tempCm.getUserId(), price);
            }

        }else{
            //System.out.println("true");
            //Integer amount = (Integer)(shopList.get((Integer)tempCm.getCommodityId()));
            //有时，将该商品数量与价格加和更新
            //System.out.println("amount = "+amount);
            amount += (Integer)(shopList.get((Integer)tempCm.getCommodityId()));
            //System.out.println("then, amount = "+amount);
            Integer num = amount;
            //???
            shopList.replace(shopList.get((Integer)tempCm.getCommodityId()), num);
            //???
            //System.out.println(shopList.get((Integer)tempCm.getCommodityId()));
            //System.out.println(userPrice.get((Integer)tempCm.getUserId()));
            price += userPrice.get((Integer)tempCm.getUserId());
            userPrice.replace(tempCm.getUserId(), price);
        }

        /*
        Enumeration<?> enumeration1 = session.getAttributeNames();
        while (enumeration1.hasMoreElements()) {
            String name = enumeration1.nextElement().toString();
            // 根据键值取session中的值
            Object value = session.getAttribute(name);
            // 打印结果
            System.out.println(name+ "=" + value);
        }

         */

        //更新cmAmount和totalPrice
        /**
        Iterator shopIt = shopList.entrySet().iterator();
        Integer tempAmount = 0;
        ;
        while(shopIt.hasNext()){
            //System.out.println("2nd loop");
            Map.Entry entry = (Map.Entry)shopIt.next();
            cmIt = cmArray.iterator();
            while(cmIt.hasNext()){
                //System.out.println("3rd loop");
                cm = (Commodity) cmIt.next();
                if((Integer)entry.getKey() == cm.getCommodityId()){
                    price = cm.getPrice();
                    break;
                }
            }
            tempAmount = (Integer)entry.getValue();
            cmAmount += tempAmount;
            //System.out.println(tempAmount);
            //System.out.println(price);
            totalPrice += (price * tempAmount);
        }
         */

        //传入session！回到checkout.jsp
        session.setAttribute("cmAmount", cmAmount);
        session.setAttribute("userPrice", userPrice);
        session.setAttribute("totalPrice", totalPrice);
        session.setAttribute("cmArray", cmArray);
        session.setAttribute("shopList", shopList);
        tempCm = new Commodity();
        session.setAttribute("tempCm", tempCm);

        Enumeration<?> enumeration1 = session.getAttributeNames();
        while (enumeration1.hasMoreElements()) {
            String name = enumeration1.nextElement().toString();
            // 根据键值取session中的值
            Object value = session.getAttribute(name);
            // 打印结果
            System.out.println(name+ "=" + value);
        }

        resp.sendRedirect("./checkout.jsp");
    }
}
