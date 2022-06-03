package tool;

import BasicObject.Student;

public interface ClassExcel {
    /**
     * 根据查询条件，读取学生信息
     */
    Student[] readStudent(String[] query);
    /**
     * 根据查询条件，返回需要的学生信息
     */
     Student[] readStudent(String[] query, String[] queryValue);
    /**
     * 将学生信息写入excel
     */
    void writeStudentForExcel(Student[] students);
    /**
     * 将查询的学生信息写入excel
     */
    void writeStudentForExcel(Student[] students, String[] query);
}
