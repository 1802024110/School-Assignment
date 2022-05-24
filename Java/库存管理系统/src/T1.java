import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {
        InventoryMmanagement im = new InventoryMmanagement();
        while (true) {
                String tip = "欢迎使用货物管理系统\n" +
                        "1.添加货物\n" +
                        "2.显示所有货物\n" +
                        "3.删除货物\n" ;
                System.out.println(tip);
                Scanner sc = new Scanner(System.in);
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        im.add();
                        break;
                    case 2:
                        im.showAllGoods();
                        break;
                    case 3:
                        im.deleteByNmae();
                        break;
                    default:
                        System.out.println("输入错误，请重新输入");
                        break;
                }
        }
    }
}
