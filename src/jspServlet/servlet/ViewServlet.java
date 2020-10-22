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
            resp.sendRedirect("./single.jsp?cmName=" + cmName);
        }else{
            System.out.println("There is no such commodity of this name!!!");
            System.exit(1);
        }
    }
}
