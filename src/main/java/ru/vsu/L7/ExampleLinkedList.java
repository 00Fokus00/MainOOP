package ru.vsu.L7;

import lombok.Getter;

import java.util.Iterator;

@Getter
public class ExampleLinkedList<T> implements Iterable<T> {

    private ExampleNode<T> head;
    private ExampleNode<T> tail;
    private int size;

    public void add(T value){
        size++;
        ExampleNode<T> node = new ExampleNode<>();
        node.setValue(value).setNext(null).setPrevious(null);
        if (head == null){
            head = node;
            tail = node;
        }
        else {
            tail.setNext(node);
            node.setPrevious(tail);
            tail = node;
        }
        /*ExampleNodeCollection<T> temp = head;
        while (temp.getNext() != null){
            temp = temp.getNext();
        }
        temp.setNext(node);
        node.setPrevious(temp);
        tail = node;*/
    }

    public void delete(){
        if (size == 0){
            return;
        }
        if (size == 1){
            head = null;
            tail = null;
        }
        else {
            tail = tail.getPrevious();
            tail.setNext(null);
        }
        size--;
    }

    public void delete(T value){
        if (head == null){
            return;
        }
        if (size == 1){
            head = null;
            tail = null;
        }
        if (head.getValue().equals(value)){
            head = head.getNext();
            head.setPrevious(null);
            size--;
            return;
        }
        if (tail.getValue().equals(value)) {
            tail = tail.getPrevious();
            tail.setNext(null);
            size--;
            return;
        }
        ExampleNode<T> temp = new ExampleNode<>();
        while (temp.getValue() != null){
            if (temp.getValue().equals(value)){
                temp.getPrevious().setNext(temp.getNext());
                temp.getNext().setPrevious(temp.getPrevious());
                size--;
                return;
            }
            temp = temp.getNext();
        }
    }

    public ExampleNode<T> findByValue(T value){
        ExampleNode<T> temp = head;
        while (temp != null){
            if (temp.getValue().equals(value)){
                return temp;
            }
            temp = temp.getNext();
        }
        return null;
    }
    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator<>(head);
    }
}