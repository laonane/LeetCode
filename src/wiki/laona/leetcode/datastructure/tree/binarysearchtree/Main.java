package wiki.laona.leetcode.datastructure.tree.binarysearchtree;

import wiki.laona.leetcode.datastructure.tree.binarysearchtree.file.Files;
import wiki.laona.leetcode.datastructure.tree.binarysearchtree.printer.BinaryTrees;

import java.io.File;
import java.util.Comparator;

/**
 * @author laona
 * @description 测试类
 * @create 2021-04-14 23:17
 **/
public class Main {

    private static class PersonComparator1 implements Comparator<Person> {
        public int compare(Person e1, Person e2) {
            return e1.getAge() - e2.getAge();
        }
    }

    private static class PersonComparator2 implements Comparator<Person> {
        public int compare(Person e1, Person e2) {
            return e2.getAge() - e1.getAge();
        }
    }

    public static void main(String[] args) {
        // test1();

        // test2();

        // test3();

        // test4();

        // test5();

        // test6();

        test7();
    }


    /**
     * 后序遍历
     */
    private static void test7() {
        Integer[] data = new Integer[]{
                7, 4, 9, 2, 5, 8, 11, 3, 12, 1
        };

        BinarySearchTree<Person> bst = new BinarySearchTree<>();

        for (Integer val : data) {
            bst.add(new Person(val, "laona" + val));
        }
        BinaryTrees.println(bst);

        bst.postorderTraversal();
    }

    /**
     * 中序遍历
     */
    private static void test6() {
        Integer[] data = new Integer[]{
                7, 4, 9, 2, 5, 8, 11, 3, 12, 1
        };

        BinarySearchTree<Person> bst = new BinarySearchTree<>();

        for (Integer val : data) {
            bst.add(new Person(val, "laona" + val));
        }
        BinaryTrees.println(bst);

        bst.inorderTraversal();
    }

    /**
     * 前序遍历
     */
    private static void test5() {
        Integer[] data = new Integer[]{
                7, 4, 9, 2, 5, 8, 11, 3, 12, 1
        };

        BinarySearchTree<Person> bst = new BinarySearchTree<>();

        for (Integer val : data) {
            bst.add(new Person(val, "laona" + val));
        }
        BinaryTrees.println(bst);

        bst.preorderTraversal();
    }

    /**
     * 替换重复
     */
    private static void test4() {
        Integer[] data = new Integer[]{
                7, 4, 9, 2, 5, 8, 11, 3, 12, 1
        };

        BinarySearchTree<Person> bst = new BinarySearchTree<>();

        for (Integer val : data) {
            bst.add(new Person(val, "laona" + val));
        }
        BinaryTrees.println(bst);
    }

    /**
     * 打印大批量数据
     */
    private static void test3() {
        Integer[] data = new Integer[]{
                7, 4, 9, 2, 5, 8, 11, 3, 12, 1
        };

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < 30; i++) {
            bst.add((int) (Math.random() * 100));
        }
        // 打印到控制台
        BinaryTrees.println(bst);
        //     打印到文件
        String str = BinaryTrees.printString(bst);
        str += "\n\n\n\n";
        Files.writeToFile("F:\\ProgramUpgrade\\Java\\LeetCode\\src\\wiki\\laona\\leetcode\\datastructure\\tree" +
                "\\binarysearchtree\\bst.txt", str, true);
    }

    /**
     * Person 二叉搜索树
     */
    private static void test2() {
        Integer[] data = new Integer[]{
                7, 4, 9, 2, 5, 8, 11, 3, 12, 1
        };

        BinarySearchTree<Person> bst = new BinarySearchTree<>();

        for (Integer val : data) {
            bst.add(new Person(val));
        }
        BinaryTrees.println(bst);

        System.out.println("==================================");
        BinarySearchTree<Person> bst2 = new BinarySearchTree<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o2.getAge() - o1.getAge();
            }
        });

        for (Integer val : data) {
            bst2.add(new Person(val));
        }
        BinaryTrees.println(bst2);
    }

    /**
     * 整形二叉搜索树
     */
    private static void test1() {
        Integer data[] = new Integer[]{
                7, 4, 9, 2, 5, 8, 11, 3, 12, 1
        };

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (Integer val : data) {
            bst.add(val);
        }
        BinaryTrees.println(bst);
    }
}
