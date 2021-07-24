package wiki.laona.leetcode.datastructure.circle;

/**
 * @program: LeetCode
 * @description:
 * @author: HuaiAnGG
 * @create: 2021-01-16 01:07
 **/
interface List<E> {
    /**
     * 没有该元素
     */
    static final int ELEMENT_NOT_FOUND = -1;

    /**
     * 列表长度
     *
     * @return 长度
     */
    int size();

    /**
     * 是否为空
     *
     * @return empty is true
     */
    boolean isEmpty();

    /**
     * 是否包含某个元素
     *
     * @param ele 元素
     * @return contains is true
     */
    boolean contains(E ele);

    /**
     * 添加元素
     *
     * @param ele 元素
     */
    void add(E ele);

    /**
     * 根据下标获取某个元素
     *
     * @param index element index
     * @return 元素
     */
    E get(int index);

    /**
     * 替换 index 位置 ele 元素
     *
     * @param index 下标
     * @param ele   元素
     * @return 被替换的元素
     */
    E set(int index, E ele);

    /**
     * 往 index 位置添加元素
     *
     * @param index 索引下标
     * @param ele   元素
     */
    void add(int index, E ele);

    /**
     * 移除 index 位置的元素
     *
     * @param index 索引
     * @return 被移除的元素
     */
    E remove(int index);

    /**
     * 删除某个元素
     *
     * @param ele 被删除元素
     */
    void remove(E ele);

    /**
     * 查找第一次出现 ele 的索引
     *
     * @param ele 元素
     * @return 索引值
     */
    int indexOf(E ele);

    /**
     * 清空列表
     */
    void clear();
}
