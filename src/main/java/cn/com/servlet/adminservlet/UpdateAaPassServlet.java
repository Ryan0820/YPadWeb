package cn.com.servlet.adminservlet;

import cn.com.dao.admini.impl.ADMDaoImpl;
import cn.com.domain.ADM;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateAaPassServlet")
public class UpdateAaPassServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String daan = request.getParameter("daan");
        ADMDaoImpl dao = new ADMDaoImpl();
        ADM adm = dao.getadDaan(daan);
        String da = adm.getDaan();
        if (daan.equals(da)){
            request.getRequestDispatcher(request.getContextPath()+"adpage/uppassword.jsp").forward(request,response);
        }else {
            //报错转发继续重新登录
            response.sendRedirect(request.getContextPath() + "adpage/Adlogin.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
