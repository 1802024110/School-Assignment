package tool.imp;

import BasicObject.Student;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import tool.ClassExcel;

import java.util.LinkedList;
import java.util.List;

public class ClassExcelImp implements ClassExcel {
    private final String filePath;
    /**
     * 初始化存放学生信息的list
     */
    private final List<Student> studentList = new LinkedList();

    public ClassExcelImp(String filePath) {
        this.filePath = filePath;
        // 存入文件路径
        EasyExcel.read(this.filePath, Student.class, new AnalysisEventListener<Student>() {
            @Override
            public void invoke(Student student, AnalysisContext analysisContext) {
                // 读一行就会回调此方法
                studentList.add(student);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                System.out.println("读取完成");
            }
        }).sheet().doRead();
    }

    @Override
    public Student readStudentByName(String value) {
        for (Student student : studentList) {
            if (student.getName().equals(value)) {
                return student;
            }
        }
        return null;
    }

    @Override
    public void writeStudentForExcel(Student students, String sheetName) {
        for (Student student : studentList) {
            if (student.getName().equals(students.getName()) || student.getId() == students.getId()) {
                student.setSchool(students.getSchool());
                student.setTime(students.getTime());
                student.setResult(students.getResult());
            }
        }
        EasyExcel.write(this.filePath, Student.class).sheet(sheetName).doWrite(studentList);
    }
}
