package ru.vsu.L6.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


import java.util.Objects;


@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Student{
    private String name;
    private String surname;
    private Group group;

    public boolean equals(Object o){
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return Objects.equals(name, student.name)
                && Objects.equals(surname, student.surname)
                && Objects.equals(group, student.group);
    }

    public int hashCode() {
        return Objects.hash(name, surname, group);
    }
}
