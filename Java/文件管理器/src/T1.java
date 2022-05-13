import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {
            while(true) {
                FileControl fc = new FileControl();
                Scanner scanner = new Scanner(System.in);
                String tip = "系统提示：输入一下编号进行相应操作"+
                        "\n1.按关键字搜索文件"+
                        "\n2.按文件名搜索文件"+
                        "\n3.删除指定目录及其所有文件"+
                        "\n4.退出";
                System.out.println(tip);
                System.out.println("请输入操作编号：");
                int num = scanner.nextInt();
                switch (num) {
                    case 1:
                        System.out.println("请输入查询路径：");
                        String path = scanner.next();
                        System.out.println("请输入关键字：");
                        String key = scanner.next();
                        fc.searchForkeyWord(path, key);
                        break;
                    case 2:
                        System.out.println("请输入查询路径：");
                        String path2 = scanner.next();
                        System.out.println("输入后缀名以/隔开：");
                        String suffix = scanner.next();
                        String[] suffixs = suffix.split("/");
                        fc.searchForSuffix(path2, suffixs);
                        break;
                    case 3:
                        System.out.println("请输入删除路径,以/隔开：");
                        String path3 = scanner.next();
                        String[] paths = path3.split("/");
                        fc.deleteAllFile(paths);
                        break;
                    case 4:
                        System.out.println("退出系统");
                        System.exit(0);
                }
            }
    }
}
