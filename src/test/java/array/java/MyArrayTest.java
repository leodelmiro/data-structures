package array.java;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyArrayTest {

    MyArray myArray;

    @Before
    public void init() {
        myArray = new MyArray();
    }

    @Test
    public void pushShouldIncreaseArraySize() {
        myArray.push(2);
        assertEquals(1, myArray.getLength());
    }

    @Test
    public void pushShouldKeepValue() {
        myArray.push(2);
        assertEquals(2, myArray.get(0));
    }

    @Test
    public void pushShouldKeepThreeValues() {
        myArray.push(2);
        myArray.push(3);
        myArray.push(4);
        assertEquals(2, myArray.get(0));
        assertEquals(3, myArray.get(1));
        assertEquals(4, myArray.get(2));
    }

    @Test
    public void popShouldDecreaseArraySize() {
        myArray.push(2);
        myArray.pop();
        assertEquals(0, myArray.getLength());
    }

    @Test
    public void popShouldReturnRemovedElement() {
        myArray.push(2);
        assertEquals(2, myArray.pop());
    }

    @Test
    public void insertShouldIncreaseArraySize() {
        myArray.push(2);
        myArray.insert(1, 2);
        assertEquals(2, myArray.getLength());
    }

    @Test
    public void insertShouldKeepValue() {
        myArray.push(2);
        myArray.push(2);
        myArray.insert(1, 1);
        assertEquals(1, myArray.get(1));
    }

    @Test
    public void insertShouldReturnRearrangeElements() {
        myArray.push(1);
        myArray.push(2);
        myArray.push(3);
        myArray.insert(1, 5);
        assertEquals(2, myArray.get(2));
    }

    @Test
    public void deleteShouldDecreaseArraySize() {
        myArray.push(2);
        myArray.delete(0);
        assertEquals(0, myArray.getLength());
    }

    @Test
    public void deleteShouldReturnRemovedElement() {
        myArray.push(2);
        assertEquals(2, myArray.delete(0));
    }

    @Test
    public void deleteShouldReturnRearrangeElements() {
        myArray.push(1);
        myArray.push(2);
        myArray.push(3);
        myArray.delete(1);
        assertEquals(3, myArray.get(1));
    }

    @Test
    public void shiftShouldDecreaseArraySize() {
        myArray.push(2);
        myArray.shift();
        assertEquals(0, myArray.getLength());
    }

    @Test
    public void shiftShouldReturnRemovedElement() {
        myArray.push(2);
        assertEquals(2, myArray.shift());
    }

    @Test
    public void shiftShouldReturnRearrangeElements() {
        myArray.push(1);
        myArray.push(2);
        myArray.push(3);
        myArray.shift();
        assertEquals(3, myArray.get(1));
    }

    @Test
    public void unshiftShouldIncreaseArraySize() {
        myArray.push(2);
        myArray.unshift(1);
        assertEquals(2, myArray.getLength());
    }

    @Test
    public void unshiftShouldKeepValue() {
        myArray.push(2);
        myArray.unshift(3);
        assertEquals(3, myArray.get(0));
    }

    @Test
    public void unshiftShouldReturnRearrangeElements() {
        myArray.push(1);
        myArray.push(2);
        myArray.push(3);
        myArray.unshift(0);
        assertEquals(2, myArray.get(2));
    }
}
