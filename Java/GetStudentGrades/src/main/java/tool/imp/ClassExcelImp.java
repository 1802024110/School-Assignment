package tool.imp;

import BasicObject.Student;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import tool.ClassExcel;

public class ClassExcelImp implements ClassExcel {
    private String filePath;
    /**
     * 初始化存放学生信息的list
     */
    private Student[] students;
    public ClassExcelImp(String filePath) {
        this.filePath = filePath;
        ExcelReaderBuilder readerBuilder = EasyExcel.read();
        // 创建一个 ExcelReader 对象
        readerBuilder.file("C:\\Users\\zy\\Desktop\\Porject\\School-Assignment\\Java\\GetStudentGrades\\src\\resources\\2021学生信息.xlsx");
        // 获取文件对象
        readerBuilder.sheet("Sheet1");
    }

    public static void main(String[] args) {
        ClassExcelImp classExcelImp = new ClassExcelImp("C:\\Users\\zy\\Desktop\\Porject\\School-Assignment\\Java\\GetStudentGrades\\src\\resources\\2021学生信息.xlsx");
    }
    @Override
    public Student[] readStudent(String[] query) {
        return null;
    }

    @Override
    public Student[] readStudent(String[] query, String[] queryValue) {
        return new Student[0];
    }

    @Override
    public void writeStudentForExcel(Student[] students) {

    }

    @Override
    public void writeStudentForExcel(Student[] students, String[] query) {

    }
}
