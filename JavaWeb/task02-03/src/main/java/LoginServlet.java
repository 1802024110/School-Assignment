import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String key="0123456789abcdef";
//1.接收数据
        String userName=req.getParameter("userName");
        String password=req.getParameter("password");
//将明文的password加密，然后再比较
        password=AESUtil.encrypt(password,key);
        // 注册驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
/**
 * url就是指定MySQL数据库的地址
 * 有两种
 * 1）针对5.7以下版本 jdbc:mysql://localhost:3306/dbname
 * 2）针对8.0版本 dbc:mysql://localhost:3306/dbname?
 useSSL=true&useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai
 */
            String url="jdbc:mysql://localhost:3306/wllz";
            Connection con;
            con= DriverManager.getConnection(url,"root","030501.Qs");
            String sql="Select * From user where user_name ='%s' and password='%s'";
            sql=String.format(sql,userName,password);
// 将动态的SQL语句发送给MySQL执行，并返回结果
            Statement statement=con.createStatement();
            ResultSet rs =statement.executeQuery(sql);
// next()方法，移动rs的游标，如果能移动游标，返回true，否则返回false
            if(rs.next()){
                resp.getWriter().print("1");
            }
            else{
                resp.getWriter().print("0");
            }
            con.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

//@WebServlet("/login")
//public class LoginServlet extends HttpServlet {
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        /**
//         * url就是指定MySQL数据库的地址
//         * 有两种
//         * 1）针对5.7以下版本 jdbc:mysql://localhost:3306/dbname?
//         useSSL=true&useUnicode=true&characterEncoding=utf-8
//         * 2）针对8.0版本 jdbc:mysql://localhost:3306/dbname?
//         useSSL=true&useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai
//         */
//        String url = "jdbc:mysql://localhost:3306/wllz";
//        Connection con;
//        try {
//            con = DriverManager.getConnection(url, "root", "030501.Qs");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
////1.接收数据
//        String userName = req.getParameter("userName");
//        String password = req.getParameter("password");
//
//        String sql = "select * from user where user_name='%s' and password='%s'";
//        sql = String.format(sql, userName, password);
//        // 将动态的SQL语句发送给MySQL执行，并返回结果
//        Statement statement = null;
//        try {
//            statement = con.createStatement();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        ResultSet rs;
//        try {
//            rs = statement.executeQuery(sql);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//// next()方法，移动rs的游标，如果能移动游标，返回true，否则返回false
//        try {
//            if (rs.next()) {
//                resp.getWriter().print("1");
//            } else {
//                resp.getWriter().print("0");
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        // 用完后一定要关闭连击
//        try {
//            con.close();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}