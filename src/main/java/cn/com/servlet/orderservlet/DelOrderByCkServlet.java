package cn.com.servlet.orderservlet;

import cn.com.service.orderservice.OrderService;
import cn.com.service.orderservice.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delOrderByCkServlet")
public class DelOrderByCkServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String[] fids = request.getParameterValues("fid");
        OrderService service = new OrderServiceImpl();
        service.delOrderCks(fids);
        //request.getRequestDispatcher(request.getContextPath()+"orderpage/orderlistlimit.jsp").forward(request,response);
        response.sendRedirect(request.getContextPath()+"/listOrderByLimitServlet");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
