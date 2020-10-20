package jspServlet.servlet;

import jspServlet.DAO.CustomerDAO;
import jspServlet.DAO.impl.CustomerDAOImpl;
import jspServlet.vo.Customer;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpRequest;

/**
 * @author thomasandon(Caitong Tang)
 */
public class ChangepwServelet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String inporipw = (String) req.getParameter("enter-ori");
        String inpnewpw = (String) req.getParameter("enter-new");
        String un = (String) req.getSession().getAttribute("username");

        CustomerDAOImpl a = new CustomerDAOImpl();
        int m = a.Changepw(un, inporipw, inpnewpw);

        if(m==1) {
            //todo 返回信息，提示修改成功，修改session中数据 Change pw successful!

            req.getSession().setAttribute("password", inpnewpw);
            req.getSession().setAttribute("message", "Password changed SUCCESSFULLY!");



        } else if (m==0) {
            //todo 提示输入原始密码错误 Input pw is wrong!
            req.getSession().setAttribute("message", "Wrong password!");
        }else {
            //todo 修改失败，也不是用户的原因 Failed to change pw, not the users' fault!
            req.getSession().setAttribute("message", "Unknown Failure");
        }

        resp.sendRedirect(req.getContextPath()+"/profile.jsp");

    }
}

