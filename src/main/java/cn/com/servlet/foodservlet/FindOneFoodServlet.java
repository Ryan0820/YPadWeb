package cn.com.servlet.foodservlet;

import cn.com.domain.Food;
import cn.com.service.foodservice.FoodService;
import cn.com.service.foodservice.impl.FoodServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findOneFoodServlet")
public class FindOneFoodServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("foodname");

        FoodService service = new FoodServiceImpl();
        List<Food> food = service.findbyname("%"+name+"%");
        request.setAttribute("name",name);
        request.setAttribute("food",food);
       //1 request.getRequestDispatcher(request.getContextPath()+"foodpage/foodonefindbyname.jsp").forward(request,response);
        request.getRequestDispatcher(request.getContextPath()+"foodpage/foodlist.jsp").forward(request,response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
