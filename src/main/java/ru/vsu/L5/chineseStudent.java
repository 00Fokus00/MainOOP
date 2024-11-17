package ru.vsu.L5;

public class chineseStudent extends Student{

    public chineseStudent(String name, String surname, int age, Main.LanguageLevel level, Main.Gender gender, Group group) {
        super(name, surname, age, level, gender, group);
    }

    @Override
    public void language() {
        System.out.println("Я учу китайский язык");
    }
}
