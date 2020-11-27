package hashtable.java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyHashTableTests {


    MyHashTable<Integer> hashTableIntegerValue;

    @BeforeEach
    void setUp() {
        hashTableIntegerValue = new MyHashTable<>(5);
        hashTableIntegerValue.set("hello", 2);
        hashTableIntegerValue.set("oi", 2);
    }

    @Test
    public void setShouldReturnData() {
        String expectedKey = "hello";
        int expectedValue = 1;

        MyNodes[] myNodes = hashTableIntegerValue.set("hello", 1);

        assertEquals(expectedKey, myNodes[0].get(2).getKey());
        assertEquals(expectedValue, myNodes[0].get(2).getValue());
    }

    @Test
    public void getShouldReturnValueWhenExist() {
        int expectedValue = 2;

        int value = hashTableIntegerValue.get("hello");

        assertEquals(expectedValue, value);
    }

    @Test
    public void getShouldReturnNullWhenDoesNotExists() {
        Object expectedValue = null;

        Object value = hashTableIntegerValue.get("set");

        assertEquals(expectedValue, value);
    }

    @Test
    public void keysShouldReturnArrayOfKeys() {
        String expectedValue = "hello";
        String expectedValue2 = "oi";

        String[] key = hashTableIntegerValue.keys();

        assertEquals(expectedValue, key[0]);
        assertEquals(expectedValue, key[0]);
        assertEquals(expectedValue2, key[1]);
        assertEquals(expectedValue2, key[1]);
    }
}
