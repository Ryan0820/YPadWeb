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
import java.util.List;

@WebServlet("/findOneReptServlet")
public class FindOneReptServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String reptname = request.getParameter("reptname");
        ReptService service = new ReptServiceImpl();
        List<Rept> Rept = service.findbyreptname("%"+reptname+"%");
        request.setAttribute("rept",Rept);
        request.getRequestDispatcher(request.getContextPath()+"reptpage/reptlist.jsp").forward(request,response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
