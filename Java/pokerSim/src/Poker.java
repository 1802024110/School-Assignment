import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

public class Poker {
    public static void main(String[] args) {
        // 创建Map集合,键是编号,值是牌
        HashMap<Integer, String> hm = new HashMap<>();
        // 创建ArrayList集合,存储编号
        ArrayList<Integer> arr = new ArrayList<>();
        // 创建String数组,花色数组和点色数组
        String[] hs = {"♥", "♠", "♣", "♦"};
        String[] pai = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        // 从0开始往HashMap里面存储编号,并存储对应的牌.同时往ArrayList里面存储编号
        int index = 0;
        // 记录编号
        // 遍历数组
        for (String number : pai) {
            // 遍历点数
            for (String color : hs) {
                // 遍历花色
                hm.put(index, color + number);
                // 将编号和牌放入Map集合中
                arr.add(index);
                // 编号存入ArrayList集合里
                index++;  // 编号++
            }
        }
        hm.put(index, "大王");
        // 存入大王
        arr.add(index);
        index++;
        hm.put(index, "小王");
        // 存入小王
        arr.add(index);

        // 洗牌
        Collections.shuffle(arr);
        // 通过方法将牌打乱

        // 发牌
        TreeSet<Integer> s1 = new TreeSet<>();
        // TreeSet集合保证牌是有序的
        TreeSet<Integer> s2 = new TreeSet<>();
        TreeSet<Integer> s3 = new TreeSet<>();
        TreeSet<Integer> dp = new TreeSet<>();

        // 遍历集合
        for (int i = 0; i < arr.size(); i++) {
            // 遍历ArrayList集合
            int er = arr.get(i);
            if (er >= arr.size() - 3) {
                // 发底牌
                dp.add(i);
            } else if (i % 3 == 0) {
                // 给s1发牌
                s1.add(i);
            } else if (i % 3 == 1) {
                // 给s2发牌
                s2.add(i);
            } else {
                s3.add(i);
                // 给s3发牌
            }
        }

        // 调用看牌方法
        kp("小明", s1, hm);
        kp("小张", s2, hm);
        kp("小王", s3, hm);
        kp("底牌", dp, hm);

    }

    // 看牌方法
    public static void kp(String name, TreeSet<Integer> arr, HashMap<Integer, String> hm) {
        System.out.print(name + "的牌是:");
        // 输出谁的牌
        for (Integer key : arr) {
            // 遍历ArrayList数组
            String value = hm.get(key);
            // 通过键调用值
            System.out.print(value + " ");
            // 输出牌
        }
        System.out.println();
        // 换行
    }
}
