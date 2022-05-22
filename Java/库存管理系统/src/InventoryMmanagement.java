import java.util.Scanner;

public class InventoryMmanagement {
    private Goods[] goods;
    public InventoryMmanagement() {
        String tip = "欢迎使用货物管理系统！\n" +
                "1.添加货物\n" +
                "2.所有货物\n" +
                "3.删除货物";
        System.out.println(tip);
    add();
    }
    public void add() {
        System.out.println("确认添加货物?"+"\n"+"1.是"+"\n"+"2.否");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        if (choice != 1) {return;}
        System.out.println("请输入货物名称:");
        String name = sc.next();
        System.out.println("请输入货物颜色:");
        String color = sc.next();
        System.out.println("请输入货物价格:");
        double price = sc.nextDouble();
        System.out.println("请输入货物数量:");
        int num = sc.nextInt();
        Goods goods = new Goods(name, color, price, num);
        System.out.println("添加成功！");

    }

    public static void main(String[] args) {
        InventoryMmanagement im = new InventoryMmanagement();
    }
}
