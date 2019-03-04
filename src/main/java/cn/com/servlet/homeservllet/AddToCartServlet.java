package cn.com.servlet.homeservllet;

import cn.com.domain.ShopingCart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/addToCartServlet")
public class AddToCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String foodid = request.getParameter("foodid");

        HttpSession session = request.getSession();
        String cart = (String) session.getAttribute("cart");

        Map<String,ShopingCart> map = new HashMap<>();
        //创建一个购物车
        ShopingCart sci = new ShopingCart();
        sci.addFood(foodid);

        //购物车和session用户绑定
        map.put(foodid,sci);

        //将购物车存入session域
        request.setAttribute("cart",map);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
