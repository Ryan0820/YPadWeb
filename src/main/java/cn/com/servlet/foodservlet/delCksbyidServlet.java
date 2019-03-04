package cn.com.servlet.foodservlet;

import cn.com.service.foodservice.FoodService;
import cn.com.service.foodservice.impl.FoodServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delCksbyidServlet")
public class delCksbyidServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String[] fids = request.getParameterValues("fid");
        FoodService service = new FoodServiceImpl();
        service.delCksAll(fids);
        response.sendRedirect(request.getContextPath()+"/listFoodByPageBeanServlet");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
