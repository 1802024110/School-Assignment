package BasicObject;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Student {
    private String name;
    @ExcelProperty(value = "学号")
    private String id;
    @ExcelProperty(value = "性别")
    private String sex;
    @ExcelProperty(value = "专业")
    private String specialty;
    @ExcelProperty(value = "班级")
    private String className;
    @ExcelProperty(value = "辅导员")
    private String counselor;
    @ExcelProperty(value = "民族")
    private String ethnic;
    private String school;
    private String time;
    private int result;
}
