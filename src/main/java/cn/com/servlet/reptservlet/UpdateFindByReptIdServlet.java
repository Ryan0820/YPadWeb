package cn.com.servlet.reptservlet;

import cn.com.domain.Rept;
import cn.com.service.reptservice.ReptService;
import cn.com.service.reptservice.impl.ReptServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateFindByReptIdServlet")
public class UpdateFindByReptIdServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String reptid = request.getParameter("reptid");


        ReptService service = new ReptServiceImpl();
        Rept rept = service.updateFindbyid(reptid);
        request.setAttribute("rept",rept);
        request.getRequestDispatcher(request.getContextPath()+"reptpage/reptupdate.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
