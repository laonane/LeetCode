package wiki.laona.leetcode.datastructure.single;

/**
 * @program: LeetCode
 * @description: 链表
 * @author: HuaiAnGG
 * @create: 2021-01-16 00:58
 **/
public class LinkListDemo {

    public static void main(String[] args) {
        List<Integer> linkList = new SingleLinkList<>();
        linkList.add(2);
        linkList.add(3);
        linkList.add(4);
        linkList.add(5);
        linkList.add(6);
        linkList.remove(0);
        linkList.remove(linkList.size() - 1);
        linkList.add(3, 11);
        linkList.add(0, 4444);
        System.out.println("linkList = " + linkList);
        linkList.clear();
        System.out.println("linkList = " + linkList);
    }
}

