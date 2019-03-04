package cn.com.servlet.adminservlet;

import cn.com.dao.admini.impl.ADMDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateAaPasswordServlet")
public class updateAaPasswordServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String adpass = request.getParameter("adpass");
        ADMDaoImpl dao = new ADMDaoImpl();
        dao.uppass(adpass);
        response.sendRedirect(request.getContextPath() + "adpage/Adlogin.jsp");


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
