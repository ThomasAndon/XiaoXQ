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
        ArrayList<Commodity> tempCmList = new ArrayList<Commodity>();
        HttpSession session = req.getSession();

        try{
            tempCmList = dao.FQCommodity(nameNum, "desc");
            //session.setAttribute("tempCm", cm);
            //System.out.println(cm.getCommodityId());
        }catch(Exception exception){
            exception.printStackTrace();
        }

        resp.sendRedirect("./single.jsp");


    }
}
