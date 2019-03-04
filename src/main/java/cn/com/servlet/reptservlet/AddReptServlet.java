package cn.com.servlet.reptservlet;

import cn.com.domain.Rept;
import cn.com.service.reptservice.ReptService;
import cn.com.service.reptservice.impl.ReptServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/addReptServlet")
public class AddReptServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> map = request.getParameterMap();
        Rept rept = new Rept();
        try {
            BeanUtils.populate(rept,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        ReptService service = new ReptServiceImpl();
        service.addRept(rept);

        //response.sendRedirect(request.getContextPath()+"/listReptServlet");
        response.sendRedirect(request.getContextPath()+"/listReptByPageBeanServlet");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
