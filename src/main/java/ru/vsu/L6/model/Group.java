package ru.vsu.L6.model;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Objects;


@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Group implements Comparable<Group> {

    private String nameGroup;
    private String nubmberGroup;

    @Override
    public int compareTo(Group o) {
        if (this.equals(o)) {
            return 0;
        }

        return this.nameGroup.compareTo(o.nameGroup);
    }

    @Override
    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Group group = (Group) o;
        return Objects.equals(nameGroup, group.nameGroup) && Objects.equals(nubmberGroup, group.nubmberGroup);
    }

    public int hashCode(){
        return Objects.hash(nameGroup, nubmberGroup);
    }
}
