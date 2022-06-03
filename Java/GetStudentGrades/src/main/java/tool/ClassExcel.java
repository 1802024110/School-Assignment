package tool;

import BasicObject.Student;

public interface ClassExcel {
    /**
     * 根据查询条件，读取学生信息
     */
    Student readStudentByName(String value);

    /**
     * 将学生信息写入excel
     */
    void writeStudentForExcel(Student students, String sheetName);
    /**
     * 将查询的学生信息写入excel
     */
}
