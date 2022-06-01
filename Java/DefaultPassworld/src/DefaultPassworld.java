import java.util.Scanner;

public class DefaultPassworld {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String s = in.nextLine();
        String reversal = reversal(s);
        System.out.println("恭喜你,注册成功,您的账号默认密码为:" + reversal);
    }
    public static String reversal(String s){
        String passworld = "";
        for (int i = s.length()-1 ; i>=0 ; i--){
            // 反转遍历输入的用户名
            passworld += s.charAt(i);
            // 将反转后的用户名拼接成密码
        }
        return passworld;
    }

}