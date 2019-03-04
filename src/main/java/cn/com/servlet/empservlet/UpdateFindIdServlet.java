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

@WebServlet("/updateFindIdServlet")
public class UpdateFindIdServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String empid = request.getParameter("empid");
        EmpService service = new EmpServiceImpl();
        Emp emp = service.updateFindbyid(empid);
        request.setAttribute("emp",emp);
        request.getRequestDispatcher(request.getContextPath()+"emppage/empupdate.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
