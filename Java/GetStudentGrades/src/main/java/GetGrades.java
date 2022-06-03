import BasicObject.Student;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tool.imp.RequestImp;

import java.util.HashMap;
import java.util.Map;

public class GetGrades {
    public static void main(String[] args) {

        RequestImp request = new RequestImp();
        Map<String,String> header = new HashMap<>();
        header.put("Cookie","_bl_uid=nvlwq3CC72q8zOrsOhRm6pUttm0e; token=qmgakmu0zzcmbo6anfy6q; ssxmod_itna=eqGx9DBDgA0=uDxl4iuitQG8ADOS=Wde88bk7Dl=74A5D8D6DQeGTb2+eb1e18einYPiDuGrrXaxojjq+WodIfOjKbt4B3DEx06+107i4GGfxBYDQxAYDGDDp8Dj4ibDY+tODjnz/Zl61KDpxGrDlKDRx074KYDWcFqPrik96P+4fYDnam1inKD9x0CDlpKmboD0aSEe0v114xDEmROK8YDvxDk=bHH34Gd0g5zmodNWmb5WY2tNhpRYWe4Gjirwam4qYbqoi0PTsGKKWGxw12tAqDWKeF7qYD==; ssxmod_itna2=eqGx9DBDgA0=uDxl4iuitQG8ADOS=Wde88bkD6hfcED0yGRD031oujXDu7QqnbAOqnB+bisq8nOIPeUnWwGiq0AWTh0KUn6W59mUQYcbFH=Scr8IvY/xPQPE/bNPKWmZDyqo6cdZcK7RciOugF1/7PGP+PsPF0Nqjn8DPgm8hWmZEcsqay11ATOq7nQ+zIF2omaLrxLjfptx/Kvsc5ao=qhGr3tprYLWrBmtrAALxgmB3S2Cbqjk=F1z=Tz233n17c2WOqTpO0UkFmaXrptnnjdhFuA62=QZa9bfEP=frpCwLXEWBbIwgPDjKG25ir=t2rK+b2YbYfqyOC/i5e3TPWaFeTRS50k+3SbVuqCji1GKFexADDwxrqAq7WNY3m=RbH4hjeuxj2KGDDjKDewD4D==; acw_tc=707c9fd516542274926013184e3f3d1b40d7671afa87633ed17505517dd456; auth=01025CDCFD7C1245DA08FE5C44C2DE1A45DA080015390069006100380061006C0074006C006B007800700063007100790075006300790075006D003400710000012F00FF359650D73B248F5E009876E3D6A6E0EB07083332; token=9cwakmuz45dycod1piywa");
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
            System.out.println(student.toString());
        }
    }
}
