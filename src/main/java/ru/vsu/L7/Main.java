package ru.vsu.L7;

public class Main {
    public static void main(String[] args) {
        ExampleLinkedList<Integer> list = new ExampleLinkedList<>();
        list.add(3);
        list.add(1);
        list.add(4);
        list.add(5);
        for (Integer temp : list) {
            System.out.println(temp);
        }
        list.delete();
        System.out.println();
        for (Integer temp : list) {
            System.out.println(temp);
        }
        list.delete(3);
        System.out.println();
        for (Integer temp : list) {
            System.out.println(temp);
        }
        System.out.println();
        System.out.println(list.findByValue(4).getValue());
    }
}
