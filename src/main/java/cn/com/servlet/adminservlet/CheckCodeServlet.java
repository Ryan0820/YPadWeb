package cn.com.servlet.adminservlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //服务器通知浏览器不要缓存
        resp.setHeader("pragma","no-cache");
        resp.setHeader("cache-control","no-cache");
        resp.setHeader("expires","0");

        //设置大小背景
        int width = 80;
        int height = 30;
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

        //获取画笔
        Graphics pan = image.getGraphics();

        //设置背景
        pan.setColor(Color.GRAY);

        //填充图片
        pan.fillRect(0,0,width,height);

        //产生4个随机码
        String checkCode = getCheckCode();

        //将验证码放入session
        req.getSession().setAttribute("CHECKCODE_SERVER",checkCode);

        //设置画笔颜se
        pan.setColor(Color.BLACK);

        //设置字体大小
        pan.setFont(new Font("幼圆",Font.BOLD,24));

        //向图片上写入验证码
        pan.drawString(checkCode,15,25);

        //***将内存中的图片输出到浏览器
        //图片对象,格式,输出到哪
        ImageIO.write(image,"png",resp.getOutputStream());
    }

    public String getCheckCode() {
        String base = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        int size = base.length();
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 4; i++) {
            //产生0-size个随机值
            int index = random.nextInt(size);
            char c = base.charAt(index);
            sb.append(c);
        }
        return sb.toString();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

}
