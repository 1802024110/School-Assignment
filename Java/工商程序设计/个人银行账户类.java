import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Cust {
    private String count; // 账号
    private String name; // 开户人姓名
    private String password; // 密码
    private double money; // 账户余额
    private int selfNum; // 账户个人流水号
    private boolean isFrozen; // 账户是否被冻结
    private static String bankName = "建设银行"; // 银行名称
    private static int allNum = 0; // 开户总数
    private List<String> transactionHistory; // 交易记录

    // 构造方法
    public Cust(String count, String name, String password, double money) {
        this.count = count;
        this.name = name;
        this.password = password;
        this.money = money;
        this.isFrozen = false; // 默认账户不被冻结
        this.transactionHistory = new ArrayList<>();
        allNum++;
        this.selfNum = allNum; // 自动生成个人流水号
    }

    // 存款方法
    public void saveMoney(double inMoney) {
        if (isFrozen) {
            System.out.println("账户已被冻结，无法存款！");
            return;
        }
        if (inMoney > 0) {
            money += inMoney;
            transactionHistory.add("存款: " + inMoney);
            System.out.println("存款成功，当前余额：" + money);
        } else {
            System.out.println("存款金额必须大于0！");
        }
    }

    // 取款方法
    public void takeMoney(double outMoney) {
        if (isFrozen) {
            System.out.println("账户已被冻结，无法取款！");
            return;
        }
        if (outMoney > 0 && outMoney <= money) {
            money -= outMoney;
            transactionHistory.add("取款: " + outMoney);
            System.out.println("取款成功，当前余额：" + money);
        } else {
            System.out.println("取款金额不合法或余额不足！");
        }
    }

    // 转账方法
    public void transfer(Cust target, double amount) {
        if (isFrozen) {
            System.out.println("账户已被冻结，无法转账！");
            return;
        }
        if (amount > 0 && amount <= money) {
            this.money -= amount;
            target.saveMoney(amount);
            transactionHistory.add("转账给 " + target.getName() + ": " + amount);
            System.out.println("转账成功，您当前的余额：" + this.money);
        } else {
            System.out.println("转账金额不合法或余额不足！");
        }
    }

    // 查询方法
    public void showInfo() {
        System.out.println("所属银行：" + bankName);
        System.out.println("您是本银行" + allNum + "个顾客中的第" + selfNum + "个顾客");
        System.out.println("用户姓名：" + name);
        System.out.println("用户账号：" + count);
        System.out.println("账户余额：" + money);
        System.out.println("账户状态：" + (isFrozen ? "已冻结" : "正常"));
    }

    // 修改密码方法
    public void updatePsw(String newPwd) {
        this.password = newPwd;
        System.out.println("密码修改成功！");
    }

    // 更新姓名方法
    public void updateName(String newName) {
        this.name = newName;
        System.out.println("姓名修改成功！");
    }

    // 冻结账户方法
    public void freezeAccount() {
        this.isFrozen = true;
        System.out.println("账户已被冻结！");
    }

    // 解冻账户方法
    public void unfreezeAccount() {
        this.isFrozen = false;
        System.out.println("账户已解冻！");
    }

    // 查看所有账户余额功能
    public static void showAllBalances(Cust... c) {
        System.out.println("所有账户余额：");
        for (Cust cust : c) {
            System.out.println(cust.name + " (" + cust.count + ") : " + cust.money);
        }
    }

    // 查看交易记录功能
    public void showTransactionHistory() {
        System.out.println("交易记录：");
        for (String record : transactionHistory) {
            System.out.println(record);
        }
    }

    // 登录方法
    public boolean login(String mCount, String mPsw) {
        return mCount.equals(count) && mPsw.equals(password);
    }

    // 静态方法：计算所有银行账户的存款总额
    public static double sum(Cust... c) {
        double total = 0;
        for (Cust cust : c) {
            total += cust.money;
        }
        return total;
    }

    // 静态方法：将所有账户按余额从多到少排序并显示
    public static void sort(Cust... c) {
        // 冒泡排序
        for (int i = 0; i < c.length - 1; i++) {
            for (int j = 0; j < c.length - i - 1; j++) {
                if (c[j].money < c[j + 1].money) {
                    Cust temp = c[j];
                    c[j] = c[j + 1];
                    c[j + 1] = temp;
                }
            }
        }
        // 输出排序结果
        for (Cust cust : c) {
            System.out.println(cust.name + ", " + cust.count + ", " + cust.money + ", " + cust.selfNum);
        }
    }

    // Getters and Setters ...

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getSelfNum() {
        return selfNum;
    }

    public void setSelfNum(int selfNum) {
        this.selfNum = selfNum;
    }

    public static String getBankName() {
        return bankName;
    }

    public static void setBankName(String bankName) {
        Cust.bankName = bankName;
    }

    public static int getAllNum() {
        return allNum;
    }

    public static void setAllNum(int allNum) {
        Cust.allNum = allNum;
    }
}

public class 个人银行账户类 {
    public static void main(String[] args) {
        // 创建客户对象
        Cust cust1 = new Cust("2024314104", "曾元", "1234", 1000000);
        Cust cust2 = new Cust("1002", "李四", "1234", 2000000);
        Cust cust3 = new Cust("1003", "王五", "1234", 500000);

        // 测试登录
        System.out.println("==============欢迎登录ATM===============");
        Scanner sc = new Scanner(System.in);

        Cust currentCust = null;
        boolean exit = false;

        // 主循环，用户选择退出时才会退出
        while (!exit) {
            System.out.println("请输入账号密码，中间用空格间隔：");
            String mCount = sc.next();
            String mPsw = sc.next();

            // 检查登录信息
            if (cust1.login(mCount, mPsw)) {
                currentCust = cust1;
            } else if (cust2.login(mCount, mPsw)) {
                currentCust = cust2;
            } else if (cust3.login(mCount, mPsw)) {
                currentCust = cust3;
            }

            // 如果登录成功，进入操作菜单
            if (currentCust != null) {
                System.out.println("欢迎" + currentCust.getName() + "登录到ATM");
                boolean loggedIn = true;

                while (loggedIn) {
                    // ATM字符界面
                    System.out.println("====================================");
                    System.out.println("|  1.查询金额        2.存款          |");
                    System.out.println("|  3.取款           4.修改密码       |");
                    System.out.println("|  5.修改姓名       6.转账          |");
                    System.out.println("|  7.冻结账户       8.解冻账户       |");
                    System.out.println("|  9.查看所有账户余额   10.查看交易记录|");
                    System.out.println("|  11.切换账户       12.退出          |");
                    System.out.println("|      请输入你需要办理业务的数字       |");
                    System.out.println("====================================");

                    switch (sc.nextInt()) {
                        case 1:
                            currentCust.showInfo();
                            break;
                        case 2:
                            System.out.println("请输入存款金额:");
                            double inMoney = sc.nextDouble();
                            currentCust.saveMoney(inMoney);
                            break;
                        case 3:
                            System.out.println("请输入取款金额:");
                            double outMoney = sc.nextDouble();
                            currentCust.takeMoney(outMoney);
                            break;
                        case 4:
                            System.out.println("请输入新密码:");
                            String newPwd = sc.next();
                            currentCust.updatePsw(newPwd);
                            break;
                        case 5:
                            System.out.println("请输入新姓名:");
                            String newName = sc.next();
                            currentCust.updateName(newName);
                            break;
                        case 6:
                            System.out.println("请输入目标账号和转账金额，中间用空格间隔：");
                            String targetCount = sc.next();
                            double transferAmount = sc.nextDouble();
                            if (targetCount.equals(cust1.getCount())) {
                                currentCust.transfer(cust1, transferAmount);
                            } else if (targetCount.equals(cust2.getCount())) {
                                currentCust.transfer(cust2, transferAmount);
                            } else if (targetCount.equals(cust3.getCount())) {
                                currentCust.transfer(cust3, transferAmount);
                            } else {
                                System.out.println("目标账号不存在！");
                            }
                            break;
                        case 7:
                            currentCust.freezeAccount();
                            break;
                        case 8:
                            currentCust.unfreezeAccount();
                            break;
                        case 9:
                            Cust.showAllBalances(cust1, cust2, cust3);
                            break;
                        case 10:
                            currentCust.showTransactionHistory();
                            break;
                        case 11:
                            System.out.println("请输入切换的账号密码，中间用空格间隔：");
                            mCount = sc.next();
                            mPsw = sc.next();
                            if (cust1.login(mCount, mPsw)) {
                                currentCust = cust1;
                            } else if (cust2.login(mCount, mPsw)) {
                                currentCust = cust2;
                            } else if (cust3.login(mCount, mPsw)) {
                                currentCust = cust3;
                            } else {
                                System.out.println("账号或密码错误，请重新选择输入！");
                                continue;
                            }
                            System.out.println("切换账户成功，欢迎" + currentCust.getName() + "登录到ATM");
                            break;
                        case 12:
                            System.out.println("退出成功");
                            loggedIn = false;
                            exit = true;
                            break;
                        default:
                            System.out.println("输入错误，请重新输入！");
                    }
                }
            } else {
                System.out.println("账号或密码错误，请重新输入！");
            }
        }

        // 输出所有客户的总存款金额
        System.out.println("所有客户的总存款金额：" + Cust.sum(cust1, cust2, cust3));
        // 按余额排序并输出
        System.out.println("按余额排序后的客户信息：");
        Cust.sort(cust1, cust2, cust3);
    }
}
