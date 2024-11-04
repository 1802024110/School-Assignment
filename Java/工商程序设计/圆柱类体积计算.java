// 定义圆类
class Circle {
    private double radius; // 圆的半径

    // 构造方法
    public Circle(double radius) {
        this.radius = radius;
    }

    // 获取圆的半径
    public double getRadius() {
        return radius;
    }

    // 计算圆的面积
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

// 定义圆柱类
class Cylinder {
    private Circle base;  // 底面圆
    private double height; // 圆柱的高度

    // 构造方法
    public Cylinder(Circle base, double height) {
        this.base = base;
        this.height = height;
    }

    // 计算圆柱的体积
    public double getVolume() {
        return base.getArea() * height;
    }
}

// 主类
public class 圆柱类体积计算 {
    public static void main(String[] args) {
        // 创建底面圆对象，半径为5
        Circle circle = new Circle(5);

        // 创建圆柱对象，高度为10
        Cylinder cylinder = new Cylinder(circle, 10);

        // 计算并输出圆柱的体积
        System.out.println("圆柱的体积为: " + cylinder.getVolume());
    }
}
