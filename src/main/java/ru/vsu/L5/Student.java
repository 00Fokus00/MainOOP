package ru.vsu.L5;



public class Student implements Interfaces.Speaking {
    private final String name;
    private final String surname;
    private final int age;
    private final Main.LanguageLevel languageLevel;
    private final Main.Gender gender;
    private final Group group;
    public Student(String name, String surname, int age, Main.LanguageLevel level, Main.Gender gender, Group group) {
        this.age = age;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.languageLevel = level;
        this.group = group;
    }

    @Override
    public String toString() {
        return super.toString() + " " + languageLevel;
    }
    public void language(){
        System.out.println("Я учу иностранный язык");
    }

    @Override
    public void speak() {
        System.out.println("Я люблю изучать языки!");
    }
}