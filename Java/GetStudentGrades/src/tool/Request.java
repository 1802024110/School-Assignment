package tool;

import BasicObject.Student;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.HttpURLConnection;
import java.util.Arrays;
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
        header.put("Cookie","_bl_uid=X1lyn3Iyt6vgg9xU43jLg1RumIqe; token=xx2akiuy7ljik3mdfyrrw; ssxmod_itna=QqjxnDcDBGit0=G7+DXQcYx1rw72DiKP34D7A+DBd4h4iNDnD8x7YDvAI=Wiq=qh0m+5fetYa54fWCGpbaN4PbpEfWi4B3DEx06xhjixiiyDCeDIDWeDiDG4GmS4GtDpxG=Dj0FUZMUxi3Dbh=Di4D+7uQDmqG0DDU794G2D7t9Y7DT7M06FjUovkGqvG=DjLbD/4hWylraOcmZtCnoeWPuDB6CxBjMfwXUIeDHzLNlem+iQippE05bKAOPKihizihK3YEPCDedQGGGWAPHfDpuxD3ezigWeD===; ssxmod_itna2=QqjxnDcDBGit0=G7+DXQcYx1rw72DiKP34D7D8q1DoeGXim5GaKwIOs=2vw8CrQw0QeU+efy6xV4cAI+zqQbqSewtqSuphOMR7mHeqVKn6IxGIVpOKGFAZ=eR9r9P41TycMO8d=Sye2qkaFkaZwxPtrNqFGzyebek2phoxuizrGr79wIVPAIpgcDBaKb44nvxP+IKQe1CZP4XzW=Z6nwuA0FMnITrWmQSPLvyiyXVQLzaaW4SpaAxx7vU0bUA/HOAzTIU75rZPYwGc6BRKIIcKMGhWKCEH9SUQnEVisNA=m9qtWGqKdci+HKe1IxHKiYYAB9akKbF7Yvmwd8qpiRNSPAixDKq7oRYw8DaOQZ7qbOrsYmBqdIDDLxD2QhDD==; acw_tc=707c9fd816541531375183780e46aa6ce2d53e26bfafc932328c29ead30e1d; auth=01028303E55D6544DA08FE836BA9BF6D44DA080015390069006100380061006C0074006C006B007800700063007100790075006300790075006D003400710000012F00FFF9E29896CB82B476F4AFE83F80444E31FAD287D3; token=fun2akiucpdfxwdpuouz9a");
        request.setHeader(header);
        // 设置请求header
        Map<String, String> body = new HashMap<String, String>();
        body.put("courseOpenId","h6mmaruz6nnbo0pnmbk4q");
        body.put("pageSize","1000");
        request.setBody(body);
        // 设置请求body
        String content = request.post("https://mooc.icve.com.cn/study/ranking/getScoresRankingList");
        JSONArray list = new JSONArray();
        // 新建一个空的JSONArray对象来存所有的数据
        try {
            JSONObject json = new JSONObject(content);
            list = json.getJSONArray("list");
            // 将获得的所有数据存入list
        }
        catch (JSONException e) {
            System.out.println("JSON解析失败");
            System.exit(1);
        }
        Student[] students = new Student[list.length()];
        for(int i = 0; i < list.length(); i++){
            // 遍历list，将每一个数据存入students数组中
            Student student = new Student();
            try {
                JSONObject json = list.getJSONObject(i);
                student.setName(json.getString("stuName"));
                student.setSchool(json.getString("schoolName"));
                student.setTime(json.getString("processTimeLong"));
                student.setResult(json.getInt("totalscore"));
                students[i] = student;
                // 将每一个数据存入students数组中
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
        for (Student student : students) {
            System.out.println(student.getName() + " " + student.getSchool() + " " + student.getTime() + " " + student.getResult());
        }
    }
}
