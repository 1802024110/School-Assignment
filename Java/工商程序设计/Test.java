 interface IShape {
    double length();
    double area();
}

class Circle implements IShape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double length() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

class Rect implements IShape {
    private double width;
    private double height;

    public Rect(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double length() {
        return 2 * (width + height);
    }

    @Override
    public double area() {
        return width * height;
    }
}

class Triangle implements IShape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double length() {
    return base;
    }

    @Override
    public double area() {
        return 0.5 * base * height;
    }
}


public class Test {
    public static void main(String[] args) {
        IShape circle = new Circle(4);
        IShape rect = new Rect(4, 5);
        IShape triangle = new Triangle(2, 3);

        showIShape("圆形",circle);
        showIShape("矩形",rect);
        showIShape("三角形",triangle);
    }
    private static void showIShape(String shapeType,IShape shape){
        System.out.println(shapeType+"的周长"+shape.length());
        System.out.println(shapeType+"的面积"+shape.area());
    }
}