package ru.vsu.L5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public enum Gender {
        MALE,
        FEMALE
    }

    public enum LanguageLevel {
        A1,
        A2,
        B1,
        B2,
        C2,
        C1
    }

    public static void main(String[] args){

        Student student = new Student("Ivan", "Ivanov", 20, LanguageLevel.B1, Gender.MALE, new Group(6, 1));
        Student spanishStudent = new spanishStudent("Anna", "Smirnova", 24, LanguageLevel.C1, Gender.FEMALE, new Group(3, 2));
        Student chineseStudent = new chineseStudent("Makar", "Samokhin", 21, LanguageLevel.A1, Gender.MALE, new Group(2, 1));

        Human human = new Human(16, "Petr", "Petrov", Gender.MALE);

        List<Interfaces.Speaking> list = new ArrayList<>();
        list.add(human);
        list.add(student);

        try (BufferedReader reader = new BufferedReader(new FileReader("C:/Users/User/OneDrive/Документы/course2/oop/sem1/src/ru/vsu/cs/course2/oop/myfile.txt"))) {
            String line = reader.readLine();
            if (line == null){
                throw new CheckedException("Файл пуст");
            }
            System.out.println(line);
        } catch (IOException | CheckedException e) {
            System.out.println(e.getMessage());
        }

        for (int i = 0; i < list.size() + 1; i++){
            if(i >= list.size()){
                throw new UncheckedRuntimeException("Выход за размер листа");
            }
            else {
                list.get(i).speak();
            }
        }

    }

    public void fileRead() {
        try (BufferedReader reader = new BufferedReader(new FileReader("myfile.txt"))) {
            String line = reader.readLine();
            System.out.println(line);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void Overflow(){
        try {
            System.out.println(f(2024));
        }catch (StackOverflowError e){
            System.out.println("Переполнение стека");
        }
    }

    public void Array(){
        int[] arr = new int[4];
        for(int i = 0; i < arr.length + 1; i++){
            if(i >= arr.length){
                throw new UncheckedRuntimeException("Выход за размер массива");
            }
            else {
                arr[i] = 36;
            }
        }
    }

    public static int f(int n){
        f(n);
        return n;
    }

    public static class CheckedException extends Exception {
        public CheckedException(String massage){
            super(massage);
        }
    }

    public static class UncheckedRuntimeException extends RuntimeException  {
        public UncheckedRuntimeException (String massage){
            super(massage);
        }
    }
}
