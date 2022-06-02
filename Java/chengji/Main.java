import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class Main {
    public static HashMap<String, chengji.Student> studentList  = new HashMap<>();

    public static String[] sliceStream(InputStream inputStream) throws IOException {
        byte[] b;
        b = new byte[inputStream.available()];
        inputStream.read(b);
        return (new String(b)).split("\n");
    }

    public static void main(String[] args) throws IOException {
        String pwd = System.getProperty("user.dir");
        FileInputStream allLists = new FileInputStream(pwd + "/chengji/all.txt");
        FileInputStream nameList = new FileInputStream(pwd + "/chengji/names.txt");
        String[] s = sliceStream(allLists);
        // 读取数据库
        for (int i = 1; i < s.length; i++) {
            chengji.Student student = new chengji.Student();
            String[] tmp = s[i].split("\t");
            student.setCg(Double.parseDouble(tmp[3]));
            student.setName(tmp[0]);
            student.setSnum(tmp[1]);
            studentList.put(student.getName(),student);
        }
        // 查找
        String[] names = sliceStream(nameList);
        System.out.println("软件21-4成绩单");
        System.out.println("|姓名\t|\t学号\t\t\t|\t成绩\t|");
        for (String name : names) {
            name = name.substring(0,name.length()-1);

            chengji.Student student = studentList.get(name);
           if(student != null){
               System.out.println("|" + student.getName() + "\t|\t" + student.getSnum() + "\t|\t" + student.getCg());
           }
        }
    }
}
