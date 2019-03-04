package cn.com.servlet.foodservlet;

import cn.com.service.empservice.EmpService;
import cn.com.service.empservice.impl.EmpServiceImpl;
import cn.com.service.foodservice.FoodService;
import cn.com.service.foodservice.impl.FoodServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delFoodServlet")
public class DelFoodServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1拿到id
        String id = request.getParameter("foodid");

        //2.调用emp服务
        FoodService service = new FoodServiceImpl();

        service.delFood(id);
        response.sendRedirect(request.getContextPath()+"/listFoodByPageBeanServlet");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
