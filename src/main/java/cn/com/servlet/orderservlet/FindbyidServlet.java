package cn.com.servlet.orderservlet;

import cn.com.domain.Order;
import cn.com.service.orderservice.OrderService;
import cn.com.service.orderservice.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findbyidServlet")
public class FindbyidServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderid = request.getParameter("orderid");

        OrderService service = new OrderServiceImpl();
        Order order = service.findbyid(orderid);
        request.setAttribute("order",order);
        request.getRequestDispatcher(request.getContextPath()+"orderpage/orderlist.jsp").forward(request,response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
