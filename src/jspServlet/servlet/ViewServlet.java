package jspServlet.servlet;

import jspServlet.DAO.CommodityDAO;
import jspServlet.DAO.CustomerDAO;
import jspServlet.DAO.impl.CommodityDAOImpl;
import jspServlet.DAO.impl.CustomerDAOImpl;
import jspServlet.vo.Commodity;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class ViewServlet extends HttpServlet {
    @Override
    /**
     *
     * @author Luo Deng
     */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    /**
     *
     * @author Luo Deng
     */
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("---ViewServlet---");
        String nameNum = req.getParameter("cmName");
        CommodityDAO dao = new CommodityDAOImpl();
        ArrayList<Commodity> tempCmArray = new ArrayList<Commodity>();
        HttpSession session = req.getSession();
        String urlString = "";

        try{
            tempCmArray = dao.NameSearch(nameNum);
            //session.setAttribute("tempCm", cm);
            //System.out.println(cm.getCommodityId());
        }catch(Exception exception){
            exception.printStackTrace();
        }

        for(Commodity cm: tempCmArray){
            System.out.println(cm.getName());
        }

        String cmName = null;
        if(tempCmArray.size() != 0){
            cmName = tempCmArray.get(0).getName();
            //System.out.println(cmName);
            session.setAttribute("tempCmArray", tempCmArray);

            switch (cmName) {
                case "Electronic_organ_1":
                    Commodity cm = tempCmArray.get(0);
                    if (cm.getTheColor().equals("white")) {
                        urlString = "imagesOfUs/M1.jpg";
                        break;
                    } else {
                        urlString = "imagesOfUs/M4.jpg";
                        break;
                    }
                case "Electronic_organ_2":
                    urlString = "imagesOfUs/Electronic_organ_2.jpg";
                    break;
                case "Electronic_organ_3":
                    urlString = "imagesOfUs/Electronic_organ_3.jpg";
                    break;
                case "Electronic_organ_4":
                    urlString = "imagesOfUs/Electronic_organ_4.jpg";
                    break;
                case "Electronic_organ_5":
                    urlString = "imagesOfUs/Electronic_organ_5.jpg";
                    break;
                case "Electronic_organ_6":
                    urlString = "imagesOfUs/Electronic_organ_6.jpg";
                    break;
                case "Electronic_organ_7":
                    urlString = "imagesOfUs/Electronic_organ_7.jpg";
                    break;
                case "Electronic_organ_8":
                    urlString = "imagesOfUs/Electronic_organ_8.jpg";
                    break;
                case "Electronic_organ_9":
                    urlString = "imagesOfUs/Electronic_organ_9.jpg";
                    break;
                case "Electronic_organ_10":
                    urlString = "imagesOfUs/Electronic_organ_10.jpg";
                    break;
                case "Electronic_organ_11":
                    urlString = "imagesOfUs/Electronic_organ_11.jpg";
                    break;
                case "Electronic_organ_12":
                    urlString = "imagesOfUs/Electronic_organ_12.jpg";
                    break;
                case "Electronic_organ_13":
                    urlString = "imagesOfUs/Electronic_organ_13.jpg";
                    break;
                case "Electronic_organ_14":
                    urlString = "imagesOfUs/Electronic_organ_14.jpg";
                    break;
                case "Electronic_organ_15":
                    urlString = "imagesOfUs/Electronic_organ_15.jpg";
                    break;
                case "Electronic_organ_16":
                    urlString = "imagesOfUs/Electronic_organ_16.jpg";
                    break;
                case "Electronic_organ_17":
                    urlString = "imagesOfUs/Electronic_organ_17.jpg";
                    break;
                case "Electronic_organ_18":
                    urlString = "imagesOfUs/Electronic_organ_18.jpg";
                    break;
                case "Electronic_organ_19":
                    urlString = "imagesOfUs/Electronic_organ_19.jpg";
                    break;
                case "Electronic_organ_20":
                    urlString = "imagesOfUs/Electronic_organ_20.jpg";
                    break;
                case "Electronic_organ_21":
                    urlString = "imagesOfUs/Electronic_organ_21.jpg";
                    break;
                case "Electronic_organ_22":
                    urlString = "imagesOfUs/Electronic_organ_22.jpg";
                    break;
                case "Electronic_organ_23":
                    urlString = "imagesOfUs/Electronic_organ_23.jpg";
                    break;
                case "Electronic_organ_25":
                    urlString = "imagesOfUs/Electronic_organ_25.jpg";
                    break;
                case "Electronic_organ_26":
                    urlString = "imagesOfUs/Electronic_organ_26.jpg";
                    break;
                case "Electronic_organ_27":
                    urlString = "imagesOfUs/Electronic_organ_27.jpg";
                    break;
                case "Electronic_organ_28":
                    urlString = "imagesOfUs/Electronic_organ_28.jpg";
                    break;
                case "Electronic_organ_29":
                    urlString = "imagesOfUs/Electronic_organ_29.jpg";
                    break;
                case "Electronic_organ_30":
                    urlString = "imagesOfUs/Electronic_organ_30.jpg";
                    break;
                case "Electronic_organ_31":
                    urlString = "imagesOfUs/Electronic_organ_31.jpg";
                    break;
                case "Electronic_organ_32":
                    urlString = "imagesOfUs/Electronic_organ_32.jpg";
                    break;
                case "Electronic_organ_33":
                    urlString = "imagesOfUs/Electronic_organ_33.jpg";
                    break;

                //随便选了一张图片
                default:
                    urlString = "imagesOfUs/Electronic_organ_1.jpg";
                    break;
            }
            session.setAttribute("urlString", urlString);
            resp.sendRedirect("./single.jsp?cmName=" + cmName);
        }else{
            System.out.println("There is no such commodity of this name!!!");
            System.exit(1);
        }
    }
}
