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

@WebServlet("/updateFindByFoodIdServlet")
public class UpdateFindByFoodIdServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("foodid");

        FoodService service = new FoodServiceImpl();
        Food s = service.updateFindbyid(id);
        request.setAttribute("food",s);
        request.getRequestDispatcher(request.getContextPath()+"foodpage/foodupdate.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
