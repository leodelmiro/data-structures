package array.java;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MyArray {

    private int length;
    private Object[] data;

    public MyArray() {
        this.length = 0;
        this.data = new Object[1];
    }

    public int getLength() {
        return length;
    }

    public Object get(int index) {
        if (this.length == 0 || index > length - 1 || index < 0) return null;

        return data[index];
    }

    public void push(Object element) {
        if (length == data.length) {
            data = Arrays.copyOf(data, length + 1);
        }

        data[length] = element;
        length++;
    }

    public Object pop() {
        if (length == 0) return null;

        Object removedObj = data[length - 1];
        data[length - 1] = null;

        length--;
        return removedObj;
    }

    public void insert(int index , Object element) {
        if (length == 0 || index == length-1) push(element);
        
        data = Arrays.copyOf(data, length + 1);

        insertElement(1, element);

        length++;
    }

    public Object delete(int index) {
        if (this.length == 0 || index > length - 1 || index < 0) return null;

        Object removedObj = data[index];

        removeElement(index);

        length--;
        return removedObj;
    }

    public Object shift() {
        if (length == 0) return null;

        Object removedObj = data[0];

        removeElement(0);

        length--;
        return removedObj;
    }

    public void unshift(Object element) {
        if (length == 0) push(element);

        data = Arrays.copyOf(data, length + 1);

        insertElement(0, element);

        length++;
    }

    private void removeElement(int index) {
        for (int i = index; index < length - 1; i++) {
            int successiveElement = i + 1;

            if (successiveElement == length) {
                data[i] = null;
                break;
            }

            data[i] = data[successiveElement];
        }
    }

    private void insertElement(int index, Object element) {
            int successiveElement = index + 1;

            while (successiveElement < length) {
                Object aux = data[index];
                data[index] = element;
                element = aux;

                index++;
                successiveElement++;
            }

            data[length-1] = element;
    }
}
