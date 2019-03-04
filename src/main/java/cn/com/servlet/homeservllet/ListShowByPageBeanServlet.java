package cn.com.servlet.homeservllet;

import cn.com.domain.Food;
import cn.com.domain.PageBean;
import cn.com.service.foodservice.FoodService;
import cn.com.service.foodservice.impl.FoodServiceImpl;
import cn.com.service.homeservice.HomeService;
import cn.com.service.homeservice.impl.HomeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/listShowByPageBeanServlet")
public class ListShowByPageBeanServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");

        if (currentPage == null || "".equals(currentPage)){
            currentPage ="1";
        }
        if (rows == null || "".equals(rows)){
            rows = "16";
        }


        HomeService service = new HomeServiceImpl();
        PageBean<Food> pb = service.getPageBean(currentPage,rows);

        request.setAttribute("pb",pb);
        request.getRequestDispatcher(request.getContextPath()+"/homepage/cxshow.jsp").forward(request,response);


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
