import java.util.ArrayList;

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


//ArrayList列表：1.可以像数组一样保存批量数据的一种容器  2.泛型规定了往列表中存放的数据类型
public class 抽象ArrayList使用 {
    public static void main(String[] args) {
        ArrayList<Geometry> shapeList=new ArrayList<>();
        shapeList.add(new Circle(10));
        shapeList.add(new Rect(5,20));
        shapeList.add(new Rect(4,7));
        shapeList.add(new Triangle(3,4,5));
        shapeList.add(new Triangle(6,8,10));
        shapeList.add(new Triangle(7,9,11));
        for(Geometry shape:shapeList){
            System.out.println(shape.getArea());
        }
        System.out.println("====================================");

        ArrayList<String> strList = new ArrayList<>();
        strList.add("AAAA");
        strList.add("BBBB");
        strList.add("CCCC");
        strList.add("DDDD");
        for(int i=0;i<strList.size();i++){
            System.out.println(strList.get(i));
        }
        System.out.println("使用增强型for循环来遍历列表：");
        for(String str:strList){
            System.out.println(str);
        }
    }
}
