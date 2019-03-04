package cn.com.servlet.empservlet;

import cn.com.domain.Emp;
import cn.com.service.empservice.EmpService;
import cn.com.service.empservice.impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/empLoginServlet")
public class EmpLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String empid = request.getParameter("empid");
        String empname = request.getParameter("empname");


        if (empid == null || empname == null) {
            response.sendRedirect(request.getContextPath() + "index.jsp");

            return;
        }
        //1.1获取用户提交的验证码
        String verifycode = request.getParameter("verifycode");
        //1.2验证码校验
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        request.removeAttribute("CHECKCODE_SERVER");
        if (!checkcode_server.equalsIgnoreCase(verifycode)) {
            //验证码不正确
            //提示信息
            request.setAttribute("login_msg", "验证码错误！");
            //跳转登录页面
            request.getRequestDispatcher(request.getContextPath() + "index.jsp").forward(request, response);
            return;
        }

        //2管理员和密码与数据库做比较
        try {
            EmpService service = new EmpServiceImpl();
            Emp emp = service.empLogin(empid, empname);
            //System.out.println(emp);
            String id = String.valueOf(emp.getEmpid());
            String name = emp.getEmpname();
            HttpSession empsession = request.getSession();
            empsession.setMaxInactiveInterval(43200);
            empsession.setAttribute("emp", emp);

            //设置最大存活时间
            Cookie c = new Cookie("JSESSIONID", empsession.getId());
            c.setMaxAge(43200);
            response.addCookie(c);


            if (empid.equalsIgnoreCase(id) && empname.equalsIgnoreCase(name)) {
                //request.setAttribute("emp", emp);
                request.getRequestDispatcher(request.getContextPath() + "/listShowByPageBeanServlet").forward(request, response);
            } else {
                //不为空有错误转发
                response.sendRedirect(request.getContextPath() + "index.jsp");
            }
        } catch (Exception e) {
            //报错转发继续重新登录
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "index.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
