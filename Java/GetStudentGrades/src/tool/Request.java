package tool;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;
public class Request {
    private Map<String,String> header;
    private String body="";
    public void setHeader(Map<String,String> header) {
        this.header = header;
    }

    public void setBody(Map<String,String> body) {
        body.forEach((k,v) -> {
            this.body += k + "=" + v + "&";
        } );
    }

    public String get(String url){
        String content = "";
        try {
            URLConnection urlConnection = new URL(url).openConnection();
            // 新建一个URL对象
            HttpURLConnection connection =  (HttpURLConnection) urlConnection;
            // 将URL对象转换为HttpURLConnection对象
            connection.setRequestMethod("GET");
            // 设置请求方式为GET
            connection.setConnectTimeout(5000);
            // 设置请求超时
            connection.setInstanceFollowRedirects(true);
            // 设置是否自动重定向
            connection.setDoOutput(true);
            // 设置是否向httpUrlConnection输出，因为这个是post请求，参数要放在http正文内，因此需要设为true, 默认情况下是false;

            this.header.forEach((k,v) -> {
                connection.setRequestProperty(k,v);
            } );
            connection.connect();
            // 连接

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream(), "UTF-8"));
            // 新建一个BufferedWriter对象，并实例化输出流
            writer.write(this.body);
            // 将body写入到输出流中
            writer.flush();

            int responseCode = connection.getResponseCode();
            // 获取响应码
            if(responseCode == 200){
                // 如果响应码为200，说明请求成功
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                // 新建一个BufferedReader对象，并实例化输入流
                String line = "";
                // 定义一个字符串，用来存储每一行的数据
                while((line = reader.readLine()) != null){
                    // 循环读取每一行的数据
                    content += line;
                    // 将每一行的数据拼接到content字符串中
                }
                reader.close();
            }
            connection.disconnect();
            // 关闭连接
            return content;
        }
        catch (Exception e) {
            System.out.println("Get请求失败"+e.getMessage());
            return content;
        }
    }

    public String post(String url){
        String content = "";
        try {
            URLConnection urlConnection = new URL(url).openConnection();
            // 新建一个URL对象
            HttpURLConnection connection =  (HttpURLConnection) urlConnection;
            // 将URL对象转换为HttpURLConnection对象
            connection.setRequestMethod("POST");
            // 设置请求方式为POST
            connection.setConnectTimeout(5000);
            // 设置请求超时
            connection.setInstanceFollowRedirects(true);
            // 设置是否自动重定向
            connection.setDoOutput(true);
            // 设置是否向httpUrlConnection输出，因为这个是post请求，参数要放在http正文内，因此需要设为true, 默认情况下是false;

            this.header.forEach((k,v) -> {
                connection.setRequestProperty(k,v);
            } );

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream(), "UTF-8"));
            // 新建一个BufferedWriter对象，并实例化输出流
            writer.write(this.body);
            // 将body写入到输出流中
            writer.flush();

            connection.connect();
            // 连接
            int responseCode = connection.getResponseCode();
            // 获取响应码
            if(responseCode == 200){
                // 如果响应码为200，说明请求成功
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                // 新建一个BufferedReader对象，并实例化输入流
                String line = "";
                // 定义一个字符串，用来存储每一行的数据
                while((line = reader.readLine()) != null){
                    // 循环读取每一行的数据
                    content += line;
                    // 将每一行的数据拼接到content字符串中
                }
                reader.close();
            }
        }catch (Exception e) {
            System.out.println("Post请求失败"+e.getMessage());
            return content;
        }
        return content;
    }
    public static void main(String[] args) {
        Request request = new Request();
        Map<String,String> header = new HashMap<>();
        header.put("Cookie","token=rimyakaucrpowsmhxjg8g; ssxmod_itna=YqRx0DBQ0Q0==4BPGKiQ230Ki=dRIAhOLfxk7DqGXf6YDZDiqAPGhDC38z42Y800G=o8A8B4Q1RA4rIojWfbnDaKfKxoGLDmKDyFm8beDx1q0rD74irDDxD3DbfdDSDWKD9D04kg9XMKDEDYP9DDoDY+=uDitD4qDB+OdDKqGg7dwPQG6qy82SICUPtj+37qDMfeGX9ic=sCcF=7Xq56Wxa2QDzTHDtMUSBLLox0pySqNxVgExeuvxm7qFFA4eY74qF0Em9DxinFjoIYqhiAPHU0vnxDf3QB+WfiD===; ssxmod_itna2=YqRx0DBQ0Q0==4BPGKiQ230Ki=dRIAhOLfxk7DA6np6=D/9exFO2zUouB1O7KAp3dIa3K4GAY9Bap3//=gYfHORGC7poXIQxAK+8y7=YxpWN/kGx+YBa/Hg30IlCujxa9Uz6iI5gXmalxu7aiWKXn0QlcFHlhA1NKT=jZ+N/WrklaTzx1Hpz8arzF2GXjI8I=ezaSW=DSy1KfxT3/P6O=THOtO85z3be=SHm+7i/Dk8qZqFdPm+IKWmGFKwXeefVKWH+8CoehE2q7yylU60IpKs74uN5OL29PtTzawFdTt+ddSb9ZqgdOOM4rwgYPOQM8o343I2aUMtMYHNWtQO=VMHUDo/740i+mk5yYY1ubXotM74X2aTODdWWq0bA2GYfoDOH62iPq7gev78oFCFdgoDpz/+FdkA/LOlDY7xrdmC6oEVSoZmzbRilOx82TA3qtqO8wf9M8/kFeB8Gp+/38t31TkW5akXc7wxT6g54bkP4WMa6id1V1Wx/Uga6M40s+FBpYegjQkr8kYq3PD7QliGuF3+BxKaIdvgO2O9WKYDGcDG7KiDD; acw_tc=2f624a7616539597256228880e4083d17c16b8d82b6e07a2a39864418ae520; auth=01022442DE0BA342DA08FE24AAA26DAB42DA080015390069006100380061006C0074006C006B007800700063007100790075006300790075006D003400710000012F00FF2D6A5C6539BA837ACFCE8CB687AC90C487793740; token=zoyakau7lvetipb8wzgyq; _bl_uid=X1lyn3Iyt6vgg9xU43jLg1RumIqe; TY_SESSION_ID=b0d41d7d-7ac7-4c21-9770-7e9d0425d0c7");
        request.setHeader(header);
        Map<String, String> body = new HashMap<String, String>();
        body.put("courseOpenId","h6mmaruz6nnbo0pnmbk4q");
        request.setBody(body);
        String content = request.post("https://mooc.icve.com.cn/study/ranking/getScoresRankingList");
    }
}
