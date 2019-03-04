package cn.com.servlet.adminservlet;

import cn.com.domain.ADM;
import cn.com.service.admservice.ADMService;
import cn.com.service.admservice.impl.ADMServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1拿到表单提交的数据
        request.setCharacterEncoding("utf-8");
        String adname = request.getParameter("adname");
        String adpass = request.getParameter("adpass");

        //1.1获取用户提交的验证码
        String verifycode = request.getParameter("verifycode");
        //1.2验证码校验
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        request.removeAttribute("CHECKCODE_SERVER");
        if (!checkcode_server.equalsIgnoreCase(verifycode)){
            //验证码不正确
            //提示信息
            request.setAttribute("login_msg","验证码错误！");
            //跳转登录页面
            request.getRequestDispatcher(request.getContextPath() + "adpage/Adlogin.jsp").forward(request,response);
            return;
        }

        //2管理员和密码与数据库做比较v
        try {
            if (adname != null || adpass != null) {
                ADMService service = new ADMServiceImpl();
                ADM adm = service.getAdmin(adname, adpass);

                String adn = adm.getAdname();
                String adp = adm.getAdpass();
                if (adname.equals(adn) && adpass.equals(adp)) {
                    request.setAttribute("admin", adm);
                    request.getRequestDispatcher(request.getContextPath() + "adpage/websiteIndex.jsp").forward(request, response);
                }
            } else {
                //不为空有错误转发
                response.sendRedirect(request.getContextPath() + "adpage/Adlogin.jsp");
            }
        } catch (Exception e) {
            //报错转发继续重新登录
            response.sendRedirect(request.getContextPath() + "adpage/Adlogin.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
