package wiki.laona.leetcode.datastructure.single;

/**
 * @program: LeetCode
 * @description: 动态数组
 * @author: HuaiAnGG
 * @create: 2021-01-12 22:04
 **/
public class DynamicArray {


    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(null);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println("list = " + list);
        list.add(0, 100);
        list.add(1, 10);
        list.add(list.size(), 999);
        System.out.println("list = " + list);
        list.remove(4);
        list.remove(1);
        System.out.println("list = " + list);
        list.set(0, 0);
        list.set(list.size() - 1, 888);
        System.out.println("list = " + list);
        list.add(null);

        System.out.println("list = " + list);
        int i = list.indexOf(null);
        System.out.println("i = " + i);
        // ArrayList<Fibonacci> fibonacciArrayList = new ArrayList<>();
        // fibonacciArrayList.add(new Fibonacci());
        // fibonacciArrayList.add(new Fibonacci());
        // fibonacciArrayList.add(new Fibonacci());
        // fibonacciArrayList.add(new Fibonacci());
        // fibonacciArrayList.clear();
        // System.gc();
    }
}

