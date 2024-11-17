package L6;

import ru.vsu.L6.model.Group;
import ru.vsu.L6.model.Student;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import ru.vsu.L6.сomparator.StudentComparator.NameStudentsComparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentComporatorTest {

    private static final String STUDENT_1_NAME = "Ivan";
    private static final String STUDENT_1_SURNAME = "Ivanov";
    private static final String STUDENT_2_NAME = "Lev";
    private static final String STUDENT_2_SURNAME = "Tolstoy";

    private static final String GROUP_1_NUMBER = "6";
    private static final String GROUP_1_SUBNUMBER = "2";

    private static final String GROUP_2_NUMBER = "7";
    private static final String GROUP_2_SUBNUMBER = "1";

    private static List<Student> sortingByName;
    private static List<Student> sortingByNameAndGroup;

    @BeforeAll
    static void setUp() {
        sortingByName = getSortingByName();
        sortingByNameAndGroup = getSortingByNameAndGroup();
    }

    @Test
    @DisplayName("Сортировка только по имени")
    void sortBookByTitle(){
        var student = new ArrayList<Student>();
        student.add(new Student()
                .setName(STUDENT_1_NAME)
                .setSurname(STUDENT_1_SURNAME)
                .setGroup(
                        new Group()
                                .setNumberGroup(GROUP_1_NUMBER)
                                .setNubmberSubgroup(GROUP_1_SUBNUMBER)
                ));

        student.add(new Student()
                .setName(STUDENT_2_NAME)
                .setSurname(STUDENT_2_SURNAME)
                .setGroup(
                        new Group()
                                .setNumberGroup(GROUP_2_NUMBER)
                                .setNubmberSubgroup(GROUP_2_SUBNUMBER)
                ));

        student.sort(new NameStudentsComparator());

        for (int i = 0; i < student.size(); i++) {
            assertThat(student.get(i))
                    .usingRecursiveComparison()
                    .ignoringFields( "surname")
                    .isEqualTo(sortingByName.get(i));
        }
    }

    @Test
    @DisplayName("Сортировка только по имени и группе")
    void sortBookByNameAndGroup(){
        var student = new ArrayList<Student>();
        student.add(new Student()
                .setName(STUDENT_1_NAME)
                .setSurname(STUDENT_1_SURNAME)
                .setGroup(
                        new Group()
                                .setNumberGroup(GROUP_1_NUMBER)
                                .setNubmberSubgroup(GROUP_1_SUBNUMBER)
                ));

        student.add(new Student()
                .setName(STUDENT_2_NAME)
                .setSurname(STUDENT_2_SURNAME)
                .setGroup(
                        new Group()
                                .setNumberGroup(GROUP_2_NUMBER)
                                .setNubmberSubgroup(GROUP_2_SUBNUMBER)
                ));

        student.sort(Comparator.comparing(Student::getName).thenComparing(Student::getGroup));

        for (int i = 0; i < student.size(); i++) {
            assertThat(student.get(i))
                    .usingRecursiveComparison()
                    .ignoringFields("surname", "group.nubmberSubgroup")
                    .isEqualTo(sortingByNameAndGroup.get(i));
        }
    }

    private static List<Student> getSortingByName(){
        return List.of(
                new Student()
                        .setName(STUDENT_1_NAME)
                        .setSurname(STUDENT_1_SURNAME)
                        .setGroup(
                                new Group()
                                        .setNumberGroup(GROUP_1_NUMBER)
                                        .setNubmberSubgroup(GROUP_1_SUBNUMBER)
                        ),
                new Student()
                        .setName(STUDENT_2_NAME)
                        .setSurname(STUDENT_2_SURNAME)
                        .setGroup(
                                new Group()
                                        .setNumberGroup(GROUP_2_NUMBER)
                                        .setNubmberSubgroup(GROUP_2_SUBNUMBER)
                        )
        );
    }
    private static List<Student> getSortingByNameAndGroup(){
        return List.of(
                new Student()
                        .setName(STUDENT_1_NAME)
                        .setSurname(STUDENT_1_SURNAME)
                        .setGroup(
                                new Group()
                                        .setNumberGroup(GROUP_1_NUMBER)
                                        .setNubmberSubgroup(GROUP_1_SUBNUMBER)
                        ),
                new Student()
                        .setName(STUDENT_2_NAME)
                        .setSurname(STUDENT_2_SURNAME)
                        .setGroup(
                                new Group()
                                        .setNumberGroup(GROUP_2_NUMBER)
                                        .setNubmberSubgroup(GROUP_2_SUBNUMBER)
                        )
        );
    }
}

