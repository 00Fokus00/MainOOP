package ru.vsu.L6.сomparator;

import ru.vsu.L6.model.Student;

import java.util.Comparator;

public class StudentComparator {

    public static class NameStudentsComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.getName().compareTo(o2.getName());
        }

    }
}
