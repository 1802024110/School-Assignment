class Circle implements Geometry{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

interface Geometry {
    double getArea();
}

class Pillar {
    private Geometry bottom;//面向抽象原则
    private double height;

    public Pillar(Geometry bottom, double height) {
        this.bottom = bottom;
        this.height = height;
    }
    public double getVolume(){
        return bottom.getArea()*height;
    }

    public Geometry getBottom() {
        return bottom;
    }

    public void setBottom(Geometry bottom) {
        this.bottom = bottom;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}

class Rect implements Geometry{
    private double w,h;

    public Rect(double h, double w) {
        this.h = h;
        this.w = w;
    }

    public double getW() {
        return w;
    }

    public void setW(double w) {
        this.w = w;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    @Override
    public double getArea() {
        return w*h;
    }
}

class Triangle implements Geometry{
    private double a,b,c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    @Override
    public double getArea() {
        double l=(a+b+c)/2;
        double s=Math.sqrt(l*(l-a)*(l-b)*(l-c));
        return s;
    }
}

public class 圆柱体抽象 {
    public static void main(String[] args) {
        Circle cirbtm = new Circle(10);
        Pillar pillar1=new Pillar(cirbtm,10);
        System.out.println("圆柱体的体积为："+pillar1.getVolume());
        Rect rectbtm=new Rect(3,5);
        Pillar pillar2=new Pillar(rectbtm,14);
        System.out.println("长方体的体积为："+pillar2.getVolume());
        //匿名对象，没有名字的对象
        Pillar pillar3=new Pillar(new Triangle(3,4,5),20);
        System.out.println("三角柱的体积为："+pillar3.getVolume());
    }
}
