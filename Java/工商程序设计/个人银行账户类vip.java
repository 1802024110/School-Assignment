// 基本银行账户类
class Cust {
    private String accountNumber;
    private String name;
    private String password;
    private double balance;

    public Cust(String accountNumber, String name, String password, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.password = password;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("存款成功！当前余额: " + balance);
        } else {
            System.out.println("存款金额必须大于0！");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("取款成功！当前余额: " + balance);
        } else {
            System.out.println("取款失败！余额不足或金额不合法。");
        }
    }

    public double checkBalance() {
        return balance;
    }

    public void changePassword(String newPassword) {
        this.password = newPassword;
        System.out.println("密码修改成功！");
    }
}

// VIP账户类
class VIPCust extends Cust {
    private static final double OVERDRAFT_LIMIT = 3000.0;

    public VIPCust(String accountNumber, String name, String password, double balance) {
        super(accountNumber, name, password, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= (checkBalance() + OVERDRAFT_LIMIT)) {
            double newBalance = checkBalance() - amount;
            System.out.println("取款成功！当前余额: " + newBalance);
        } else {
            System.out.println("取款失败！余额不足或金额不合法。");
        }
    }

    public void transfer(VIPCust target, double amount) {
        if (amount > 0 && amount <= (checkBalance() + OVERDRAFT_LIMIT)) {
            double newBalance = checkBalance() - amount;
            System.out.println("转账成功！转账金额: " + amount + "，当前余额: " + newBalance);
        } else {
            System.out.println("转账失败！余额不足或金额不合法。");
        }
    }
}

// 测试类
public class 个人银行账户类vip {
    public static void main(String[] args) {
        Cust cust1 = new Cust("123456", "张三", "password", 1000);
        cust1.deposit(500);
        cust1.withdraw(200);
        System.out.println("账户余额: " + cust1.checkBalance());
        cust1.changePassword("newPassword");

        VIPCust vipCust1 = new VIPCust("654321", "李四", "password", 2000);
        vipCust1.deposit(800);
        vipCust1.withdraw(2500); // 应该成功透支
        System.out.println("VIP账户余额: " + vipCust1.checkBalance());

        VIPCust vipCust2 = new VIPCust("111222", "王五", "password", 1500);
        vipCust1.transfer(vipCust2, 1000); // 转账
        System.out.println("转账后的VIP账户余额: " + vipCust1.checkBalance());
        System.out.println("转账后的VIP账户余额: " + vipCust2.checkBalance());
    }
}
