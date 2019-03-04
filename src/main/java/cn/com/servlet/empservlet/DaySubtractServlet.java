package cn.com.servlet.empservlet;

import cn.com.domain.Emp;
import cn.com.service.empservice.EmpService;
import cn.com.service.empservice.impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/daySubtractServlet")
public class DaySubtractServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String empday = request.getParameter("empday");
        String empid = request.getParameter("empid");
        EmpService service = new EmpServiceImpl();

        service.daySubtract(empday,empid);
        Emp oneemp = service.findbyid(empid);


        request.setAttribute("emp",oneemp);

        request.getRequestDispatcher(request.getContextPath()+"emppage/emponefindbyid.jsp").forward(request,response);


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
