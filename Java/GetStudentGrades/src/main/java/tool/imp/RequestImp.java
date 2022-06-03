package tool.imp;

import tool.Request;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
public class RequestImp implements Request {
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
}
