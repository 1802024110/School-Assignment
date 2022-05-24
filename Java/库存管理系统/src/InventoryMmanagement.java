import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class InventoryMmanagement {
    private Collection<Goods> goods = new ArrayList<Goods>();
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
        this.goods.add(goods);
        System.out.println("添加成功,现有货物:");
        for (Goods g : this.goods) {
            System.out.println("商品名称:" + g.getName() + "\t商品颜色:" + g.getColor() + "\t商品价格:" + g.getPrice() + "\t商品数量:" + g.getAmount());
        }
    }

    public void showAllGoods() {
        System.out.println("现有货物:");
        for (Goods g : this.goods) {
            System.out.println("商品名称:" + g.getName() + "\t商品颜色:" + g.getColor() + "\t商品价格:" + g.getPrice() + "\t商品数量:" + g.getAmount());
        }
    }

    public void deleteByNmae() {
        System.out.println("输入要删除的商品名称:");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        for (Goods g : this.goods) {
            if (g.getName().equals(name)) {
                this.goods.remove(g);
                System.out.println("删除成功");
                return;
            }
        }
        for (Goods g : this.goods) {
            System.out.println("商品名称:" + g.getName() + "\t商品颜色:" + g.getColor() + "\t商品价格:" + g.getPrice() + "\t商品数量:" + g.getAmount());
        }
    }
}
