package ru.vsu.L7;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Objects;


@Data
@Accessors(chain = true)
public class ExampleNode<T> {
    private ExampleNode<T> previous;
    private ExampleNode<T> next;
    private  T value;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ExampleNode<T> that = (ExampleNode<T>) o;
        return Objects.equals(value, that.value);
    }

}
