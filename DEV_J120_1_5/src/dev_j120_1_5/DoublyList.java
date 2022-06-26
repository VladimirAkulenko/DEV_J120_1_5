/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev_j120_1_5;

/**
 *
 * @author USER
 */

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;


public class DoublyList<T> implements Iterable<T>{
    private Node first;
    private Node last;
    boolean rout = true;


    public boolean getRout(){
        return rout;
    }
    public void setRout(boolean rout){
        this.rout = rout;
    }

    //Массив
    public T[] array (T[] list){
        T[] result = (T[]) new Object[list.length];
        for (int i =0, j = result.length-1; i<list.length; i++,j--){
            result[j] = list[i];
        }
        return result;
    }

    //Добавление всех значений заданного массива в начало списка с сохранение порядка
    public void addArrayList (T [] variable){
        for (T i : array(variable)){
            addBeginningList(i);
        }
    }

    //Добавление всех значений заданного массива в конец списка с сохранение порядка
    public void addArrayListEnd (T [] variable){
        for (T i : variable){
            addEndList(i);
        }
    }

    // добавление значения в начало списка
    public void addBeginningList (T variable){
        Node newNode = new Node(variable);
        newNode.date = variable;
        if (first == null){
            first = newNode;
            last = newNode;
        }
        else {
            newNode.next = first;
            first.previous = newNode;
            first = newNode;
        }
    }
    //Извлечение значения из начала списка без его удаления из списка
    public T extractionBeginningList (){
        if (first != null)
            return (T) first.date;
        else
            throw new IllegalArgumentException("Список пуст");
    }

    // Извлечение значения из начала списка с удалением из списка
    public T extractionDeleteList () {
        if (first != null && last.previous != null) {
            T firstDate = (T) first.date;
            first = first.next;
            first.previous = null;
            return firstDate;
        } else if (first != null && first.next == null){
            T firstDate = (T) first.date;
            first = first.next;
            return firstDate;
        }
        else
            throw new IllegalArgumentException("Список пуст");
    }

    // Добавление значения в конец списка
    public void addEndList (T variable){
        Node newNode = new Node(variable);
        if(first == null){
            first=newNode;
            return;
        }
        Node temp = first;
        Node temp1 = last;
        while (temp.next != null){
            temp = temp.next;
            temp1 = temp1.previous;
        }
        temp.next =newNode;
        temp1.previous =newNode;
    }

    //Извлечение значения из конца списка без его удаления
    public T extractionEndList (){
        if (first != null){
            Node temp = first;
            while (temp.next != null){
                temp = temp.next;}
            return (T) temp.date;
        }
        else
            throw new IllegalArgumentException("Список пуст");
    }

    //Извлечение значения из конца списка с удалением
    public T extractionEndDeleteList (){
        if (first != null && last.previous != null) {
            T firstDate = (T) last.date;
            last = last.previous;
            last.next = null;
            return firstDate;
        }
        else if(first != null && first.next == null){
            T firstDate = (T) first.date;
            first = first.next;
            return firstDate;
        }
        else
            throw new IllegalArgumentException("Список пуст");
    }

    // Определение, содержит ли список заданное значение, или нет
    public boolean setValueList (T variable){
        Node temp = first;
        Boolean result = false;
        if(first == null)
            return false;
        else if (temp.next == null){
            return variable.equals(temp.date);
        }
        else
            while (temp.next != null){
                if(variable.equals(temp.date)){
                    result = true;
                    temp = temp.next;
                }
                else
                    temp = temp.next;
            }
        return  result;
    }

    // Определение, является ли список пустым, или нет
    public boolean emptyList (){
        if (first == null)
            System.out.println("Список пуст");
        else
            System.out.println("Список не пустой");
        return first == null;

    }



    // Печать всех значений списка в прямом порядке
    public void print() {
        if (first == null) return;
        Node temp = first;
        System.out.println(temp.date);
        while (temp.next != null){
            temp = temp.next;
            System.out.println(temp.date);
        }
    }
    // Печать всех значений списка в обратном порядке
    public void printBack (){
        if (first == null) return;
        Node temp = last;
        if(temp.previous == null){
            System.out.println(temp.date);
        }else {
            while (temp.previous != null){
                System.out.println(temp.date);
                temp = temp.previous;
                if(temp.previous == null){
                    System.out.println(temp.date);
                }
            }
        }
    }

    //Добавление всех значений заданной коллекции в начало списка с сохранением порядка

    public void addCollection (Collection<T> collection){
        T[] temp = (T[]) collection.toArray(new Object [0]);
        addArrayList(temp);
    }

    // Добавление всех значений заданной коллекции в конец списка с сохранением порядка
    public void addEndCollection (Collection<T> collection){
        T[] temp = (T[]) collection.toArray(new Object[0]);
        addArrayListEnd(temp);
    }

    //Возвращающий количество элементов списка.
    public int amount() {
        Node temp = first;
        if (first == null) {
            return 0;
        } else if (temp.next == null) {
            return 1;
        } else {
            int amo = 0;
            while (temp.next != null) {
                temp = temp.next;
                amo++;
                if (temp.next == null) {
                    amo++; }
            }
            return amo;
        }
    }
    //Удаление списка
    public void deleteList() {
        if (first != null) {
            first = null;
            last = null;  }
    }

    // Поглощение списка другим списком с добавлением значений второго в начало первого списка, после поглощения второй список должен очищаться

    public void mergerListBeginning(DoublyList <T> mergerList){
        if (mergerList.first != null){
            T[] temp =(T[]) new Object [mergerList.amount()];
            Node temp1 = mergerList.first;
            temp[0] = (T) temp1.date;
            int i =1;
            while (temp1.next != mergerList.last){
                temp[i] = (T) temp1.next.date;
                temp1 = temp1.next;
                i++;
                if (temp1.next == mergerList.last)
                    temp[temp.length - 1] = (T) mergerList.last.date;
            }
            addArrayList(temp);
            mergerList.deleteList();
        }
    }

    // Поглощение списка другим списком с добавлением значений второго в конец первого списка, после поглощения второй список должен очищаться

    public void mergerListEnd(DoublyList<T> mergerList){
        if (mergerList.first != null){
            T[] temp = (T[]) new Object[mergerList.amount()];
            Node temp1 = mergerList.first;
            temp[0] = (T) temp1.date;
            int i =1;
            while (temp1.next != mergerList.last){
                temp[i] = (T) temp1.next.date;
                temp1 = temp1.next;
                i++;
                if (temp1.next == mergerList.last)
                    temp[temp.length - 1] = (T) mergerList.last.date;
            }
            addArrayListEnd(temp);
            mergerList.deleteList();
        }
    }

    public void newForEach (T element, Consumer<? super T> operation){
        Objects.requireNonNull(operation);
        for (T t: this) {
            operation.accept(t);
            if (t.equals(element))
                break;
        }
    }

    public void newForEach (Consumer<? super T> operation, T elements){
        Objects.requireNonNull(operation);
        this.setRout(rout);
        boolean b = false;
        for (T t: this) {
            if (t.equals(elements) == b)
                continue;
            b = true;
            operation.accept(t);
        }
    }

    public void newForEach (T element, Consumer<? super T> operation, boolean rout){
        Objects.requireNonNull(operation);
        this.setRout(rout);

        for (T t: this) {
            operation.accept(t);
            if(t.equals(element))
                break;
        }
        this.setRout(true);
    }

    public void newForEach (Consumer<? super T> operation, T elements, boolean rout){
        Objects.requireNonNull(operation);
        this.setRout(rout);
        boolean b = false;
        for (T t: this) {
            if (t.equals(elements) == b)
                continue;
            b = true;
            operation.accept(t);
        }
        this.setRout(true);
    }

    @Override
    public Iterator<T> iterator() {
        return rout? new NewIterator<>(first) : new NewReversIterator<>(last);

    }



    class NewIterator <T> implements Iterator<T>{

        Node tNode;

        public NewIterator(Node tNode) {
            this.tNode = tNode;
        }

        @Override
        public boolean hasNext() {
            return tNode != null;
        }

        @Override
        public T next() {
            if (tNode == null) throw new NoSuchElementException();
            T result = (T) tNode.date;
            tNode = tNode.next;
            return result;
        }
    }

    class NewReversIterator <T> implements Iterator<T>{

        Node pNode;

        public NewReversIterator(Node pNode) {
            this.pNode = pNode;
        }

        @Override
        public boolean hasNext() {
            return pNode != null;
        }

        @Override
        public T next() {
            if (pNode == null) throw new NoSuchElementException();
            T result = (T) pNode.date;
            pNode = pNode.previous;
            return result;
        }
    }

    private class Node <T> {
        T date;
        Node next;
        Node previous;

        Node(T variable){
            date = variable;
        }

    }
}
