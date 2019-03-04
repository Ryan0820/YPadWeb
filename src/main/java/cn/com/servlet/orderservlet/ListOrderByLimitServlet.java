package cn.com.servlet.orderservlet;

import cn.com.domain.Order;
import cn.com.domain.PageBean;
import cn.com.service.orderservice.OrderService;
import cn.com.service.orderservice.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/listOrderByLimitServlet")
public class ListOrderByLimitServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");
        if (currentPage == null || "".equals(currentPage)){
            currentPage ="1";
        }
        if (rows == null || "".equals(rows)){
            rows = "6";
        }

        OrderService service = new OrderServiceImpl();
        PageBean<Order> pb = service.getListOrder(currentPage,rows);

        request.setAttribute("pb",pb);
        request.getRequestDispatcher(request.getContextPath()+"orderpage/orderlistlimit.jsp").forward(request,response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
