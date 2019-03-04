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

/**
 * @author Yan
 */
@WebServlet("/listFoodServlet")
public class ListFoodServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1.调用EmpService的实现类EmpServiceImpl
        FoodService es = new FoodServiceImpl();
        //2.调用service中方法查询返回list(emp)对象
        List<Food> food = es.findAll();
        //3,.把对象存入requset域中
        req.setAttribute("food",food);
        //4.转发到emplist将员工页面展示
        req.getRequestDispatcher(req.getContextPath()+"foodpage/foodlist.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
