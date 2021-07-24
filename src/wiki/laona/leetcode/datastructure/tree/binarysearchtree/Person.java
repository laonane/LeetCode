package wiki.laona.leetcode.datastructure.tree.binarysearchtree;

/**
 * @author laona
 * @description 人类
 * @create 2021-04-16 10:22
 **/
public class Person implements Comparable<Person> {

    private int age;
    private String name;

    @Override
    public String toString() {
        return  name + ":" + age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(int age) {
        this.age = age;
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Person person) {
        return this.age - person.age;
    }
}
