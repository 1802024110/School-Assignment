// 抽象类 机动车
abstract class 机动车 {
    // 抽象方法 启动
    abstract void 启动();

    // 抽象方法 加速
    abstract void 加速();

    // 抽象方法 刹车
    abstract void 刹车();
}

// 具体类 汽车，继承自机动车
class 汽车 extends 机动车 {
    @Override
    void 启动() {
        System.out.println("汽车启动");
    }

    @Override
    void 加速() {
        System.out.println("汽车加速");
    }

    @Override
    void 刹车() {
        System.out.println("汽车刹车");
    }
}

// 具体类 摩托车，继承自机动车
class 摩托车 extends 机动车 {
    @Override
    void 启动() {
        System.out.println("摩托车启动");
    }

    @Override
    void 加速() {
        System.out.println("摩托车加速");
    }

    @Override
    void 刹车() {
        System.out.println("摩托车刹车");
    }
}

// 主类
public class 机动车抽象示例 {
    public static void main(String[] args) {
        机动车 myCar = new 汽车();
        myCar.启动();
        myCar.加速();
        myCar.刹车();

        机动车 myMotorcycle = new 摩托车();
        myMotorcycle.启动();
        myMotorcycle.加速();
        myMotorcycle.刹车();
    }
}