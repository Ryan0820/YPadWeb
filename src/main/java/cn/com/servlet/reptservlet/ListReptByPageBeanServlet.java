package cn.com.servlet.reptservlet;

import cn.com.domain.Food;
import cn.com.domain.PageBean;
import cn.com.domain.Rept;
import cn.com.service.foodservice.FoodService;
import cn.com.service.foodservice.impl.FoodServiceImpl;
import cn.com.service.reptservice.ReptService;
import cn.com.service.reptservice.impl.ReptServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/listReptByPageBeanServlet")
public class ListReptByPageBeanServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");

        if (currentPage == null || "".equals(currentPage)) {
            currentPage = "1";
        }
        if (rows == null || "".equals(rows)) {
            rows = "6";
        }


        ReptService service = new ReptServiceImpl();
        PageBean<Rept> pb = service.getPageBean(currentPage, rows);

        System.out.println(pb);
        request.setAttribute("pb", pb);

       /* //2.调用service中方法查询返回list(Rept)对象
        List<Rept> Repts = service.findAll();
        //3,.把对象存入requset域中
        request.setAttribute("rept",Repts);*/
        //request.getRequestDispatcher(request.getContextPath() + "reptpage/reptlistlimitp.jsp").forward(request, response);
        request.getRequestDispatcher(request.getContextPath()+"reptpage/reptlistp.jsp").forward(request,response);


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
