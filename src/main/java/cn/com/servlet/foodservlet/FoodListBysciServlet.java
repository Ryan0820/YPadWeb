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

@WebServlet("/foodListBysciServlet")
public class FoodListBysciServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String foodsci = request.getParameter("foodsci");

        FoodService service = new FoodServiceImpl();
        List<Food> foodList = service.findFoodsci(foodsci);
        request.setAttribute("food",foodList);
        request.getRequestDispatcher(request.getContextPath()+"foodpage/foodlist.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
