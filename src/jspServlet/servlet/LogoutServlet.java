package jspServlet.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    /**
     * 登出
     * @author Zeyang Sun
     */
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Luo Deng modifies and adds
        System.out.println("---LogoutServlet---");
        HttpSession session = req.getSession();
        session.setAttribute("try","no");
        //移除session中其他所有元素
        Enumeration<?> enumeration1 = session.getAttributeNames();
        while (enumeration1.hasMoreElements()) {
            String name = enumeration1.nextElement().toString();
            if(name != "try"){
                session.removeAttribute(name);
            }
        }

        enumeration1 = session.getAttributeNames();
        while (enumeration1.hasMoreElements()) {
            String name = enumeration1.nextElement().toString();
            // 根据键值取session中的值
            Object value = session.getAttribute(name);
            // 打印结果
            System.out.println(name+ "=" + value);
        }
        //end add
        req.getRequestDispatcher("./index(welcome).jsp").forward(req,resp);


    }
}
