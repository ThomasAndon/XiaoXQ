package jspServlet.servlet;

import jspServlet.DAO.impl.CustomerDAOImpl;
import jspServlet.vo.Customer;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author thomasandon(Caitong Tang)
 */
public class Changepiservlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String newrn = (String) req.getParameter("rninput");
        String newaddr = (String) req.getParameter("addrinput");

        String un = (String) req.getSession().getAttribute("username");

        CustomerDAOImpl a = new CustomerDAOImpl();
        int m = a.Changepi(un, newrn, newaddr);

        if(m==-1) {
            //todo 信息修改失败，并非用户原因    Info changed failed, not users' fault.
            req.getSession().setAttribute("message", "Info changed Failed");

        } else if (m == 1) {
            //todo 修改信息成功 Info changed successfully!
            req.getSession().setAttribute("message", "Info Changed SUCCESSFULLY");
        }

        resp.sendRedirect(req.getContextPath()+"/profile.jsp");
    }
}
