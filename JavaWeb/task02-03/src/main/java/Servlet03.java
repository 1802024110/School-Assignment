import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/servlet03")
public class Servlet03 implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
    }
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }
    @Override
    public void service(ServletRequest servletRequest, ServletResponse
            servletResponse) throws ServletException, IOException {
// ServletRequest中包含了用户的所有请求
// 可以通过ServletResponse对象，将数据发送给浏览器
// 将字符串"Hello World"发送给浏览
        servletResponse.getWriter().println("Hello World");
    }
    @Override
    public String getServletInfo() {
        return null;
    }
    @Override
    public void destroy() {
    }
}