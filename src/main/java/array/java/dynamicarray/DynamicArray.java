package array.java.dynamicarray;

import java.util.Arrays;

class DynamicArray {

    private int length = 0;
    private int capacity;
    private int[] array = new int[capacity];

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.array = new int[capacity];
    }

    public int get(int i) {
        return this.array[i];
    }

    public void set(int i, int n) {
        this.array[i] = n;
    }

    public void pushback(int n) {
        if (length == capacity) {
            resize();
        }
        this.array[length] = n;
        length++;
    }

    public int popback() {
        int value = this.array[length - 1];
        this.array[length - 1] = 0;
        length--;
        return value;
    }

    private void resize() {
        this.capacity = capacity * 2;
        this.array = Arrays.copyOf(array, capacity);
    }

    public int getSize() {
        return length;
    }

    public int getCapacity() {
        return capacity;
    }
}
