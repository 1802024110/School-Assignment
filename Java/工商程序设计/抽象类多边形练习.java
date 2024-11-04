abstract class IShape {
    // 抽象方法：求周长
    public abstract double length();
    
    // 抽象方法：求面积
    public abstract double area();
}

class Circle extends IShape {
    private double radius; // 圆的半径

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double length() {
        // 圆的周长公式：2 * π * r
        return 2 * Math.PI * radius;
    }

    @Override
    public double area() {
        // 圆的面积公式：π * r^2
        return Math.PI * radius * radius;
    }
}

class Rect extends IShape {
    private double width; // 矩形的宽
    private double height; // 矩形的高

    public Rect(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double length() {
        // 矩形的周长公式：2 * (宽 + 高)
        return 2 * (width + height);
    }

    @Override
    public double area() {
        // 矩形的面积公式：宽 * 高
        return width * height;
    }
}

class Triangle extends IShape {
    private double base; // 三角形的底
    private double height; // 三角形的高

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double length() {
        // 三角形的周长需要知道三边的长度，这里简化为底和高的两倍（假设等腰三角形）
        return 2 * base + 2 * height;
    }

    @Override
    public double area() {
        // 三角形的面积公式：(底 * 高) / 2
        return 0.5 * base * height;
    }
}

public class 抽象类多边形练习 {
    public static void main(String[] args) {
        IShape circle = new Circle(5); // 半径为5的圆
        IShape rect = new Rect(3, 4); // 宽为3，高为4的矩形
        IShape triangle = new Triangle(3, 4); // 底为3，高为4的三角形

        System.out.println("圆的周长: " + circle.length());
        System.out.println("圆的面积: " + circle.area());

        System.out.println("矩形的周长: " + rect.length());
        System.out.println("矩形的面积: " + rect.area());

        System.out.println("三角形的周长: " + triangle.length());
        System.out.println("三角形的面积: " + triangle.area());

    }
}