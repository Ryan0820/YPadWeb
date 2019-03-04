package cn.com.servlet.homeservllet;

import cn.com.domain.Food;
import cn.com.domain.PageBean;
import cn.com.service.homeservice.HomeService;
import cn.com.service.homeservice.impl.HomeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 前台菜系搜索
 */
@WebServlet("/showSearchCX")
public class ShowSearchCXServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String searchname = request.getParameter("searchcx");

        if (null == searchname){
            return;
        }
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");

        if (currentPage == null || "".equals(currentPage)){
            currentPage ="1";
        }
        if (rows == null || "".equals(rows)){
            rows = "16";
        }

        PageBean<Food> pb = null;
        try {
            HomeService service = new HomeServiceImpl();
            pb = service.getPageBeanforSearch(currentPage,rows,searchname);
        } catch (Exception e) {
            request.getRequestDispatcher(request.getContextPath()+"listShowByPageBeanServlet").forward(request,response);

        }

        request.setAttribute("pb",pb);
        request.getRequestDispatcher(request.getContextPath()+"homepage/show.jsp").forward(request,response);
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
