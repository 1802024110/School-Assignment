import BasicObject.Student;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import tool.imp.ClassExcelImp;
import tool.imp.RequestImp;

import java.util.*;

public class GetGrades {
    public static void main(String[] args) {
        RequestImp request = new RequestImp();
        Map<String, String> header = new HashMap<>();
        header.put("Cookie", "_bl_uid=nvlwq3CC72q8zOrsOhRm6pUttm0e; token=vmslaamuoq1md4gdhcmqw; acw_tc=2f624a6e16542441025001994e7e2c3c8c09942f9eace75e8bb56d1a3e96c8; ssxmod_itna=Wq+xuiitMDzxni8eG=w5iIyqDuR0rcQ7Qx05hqGzDAxn40iDtcB/DGqHqK59Dy=Dy7SHoPlixmqfeYT77Bb1pDCPGnDBIxQTexYYODt4DTD34DYDirKDLDmeD+CMPDdvk5s/g0D3qGrDlKDRx07l65DW1FiGCKCFoYse4D1KD5xeCKD9x0CDlcDzR2ODDyvhRh10OoIDm+ohxYGDCKDj1Ak7rYDUAKzRgaLMlGo8nGt7CuYAG0=onhxWliqKmDxBeePgYhxg7xPee+YbAqgDDcNMQhDD; ssxmod_itna2=Wq+xuiitMDzxni8eG=w5iIyqDuR0rcQ7DnFoK0=CDlh=GxjRkSl3didRBee2agl2u0XWg9ag5DC72oIU8D5ll2WGGz9uEKFeBl3kj5oQ08cN+DTow0w+jzAQF+yUZxnvT4KuVw4d+7wNsjSNQC33w0itS9qismqYa+orHYRt/mo6VCTN/+rNtVg6z+23/mw4bLraGAT0UDZ=Z+rERBOW52ZUVAay/YiE54bFqU6uy0Of1O45gngvx4+tCCqwkEI=4t8gFVLS80Eaw02Dy3NOqI3nCQGtNuEqOccG0g61mIEP1iU6bD7j9nhUBoQC5go0FWfZ70sYN3ixDjKDewq4D===; auth=010295D918293945DA08FE9541DD8A4145DA080015390069006100380061006C0074006C006B007800700063007100790075006300790075006D003400710000012F00FFC87DF3BB389E2F7348BBB77222D911EAE9252CB9; token=yc4laamu7jvhpjvlrfn8hg");
        request.setHeader(header);
        // 设置请求header
        Map<String, String> body = new HashMap<String, String>();
        body.put("courseOpenId", "h6mmaruz6nnbo0pnmbk4q");
        body.put("pageSize", "1000");
        request.setBody(body);
        // 设置请求body
        String content = request.post("https://mooc.icve.com.cn/study/ranking/getScoresRankingList");
        JSONObject student = JSON.parseObject(content);
        List<Student> students = new LinkedList<Student>();
        if (student == null){
            System.out.println("Cookies失效，请重新获取");
        }else {
            for (int i = 0; i < student.getJSONArray("list").size(); i++) {
                JSONObject jsonObject = student.getJSONArray("list").getJSONObject(i);
                Student student1 = new Student();
                student1.setName(jsonObject.getString("stuName"));
                student1.setTime(jsonObject.getString("processTimeLong"));
                student1.setResult(jsonObject.getInteger("totalscore"));
                students.add(student1);
            }
        }
        ClassExcelImp classExcelImp = new ClassExcelImp(System.getProperty("user.dir") + "\\GetStudentGrades\\src\\main\\resources\\2021学生信息.xlsx");
        while (true) {
            System.out.println("输入序号进行操作" +
                    "\n1.根据名字查询" +
                    "\n2.导出excel" +
                    "\n3.退出");
            Scanner scanner = new Scanner(System.in);
            int num = scanner.nextInt();
            switch (num) {
                case 1:
                    System.out.println("请输入要查询的学生姓名");
                    String name = scanner.next();
                    Student stu = classExcelImp.readStudentByName(name);
                    if (stu != null) {
                        if (stu.getTime() != null || students.size() == 0) {
                            System.out.println("未写入成绩");
                            System.out.println(stu);
                        } else {
                            students.forEach(student1 -> {
                                if (student1.getName().equals(name)) {
                                    System.out.println("姓名：" + student1.getName() + " 时间：" + student1.getTime() + " 成绩：" + student1.getResult());
                                    System.out.println(student1);
                                }
                            });
                        }
                    }else {
                        System.out.println("没有找到该学生");
                    }
                    break;
                case 2:
                    System.out.println("导出中，请不要关闭进程...");
                    for (Student student1 : students) {
                        classExcelImp.writeStudentForExcel(student1, "sheet1");
                    }
                    System.out.println("导出完成");
                    break;
                default:
                        System.out.println("退出");
                        System.exit(0);
            }
        }
    }
}
