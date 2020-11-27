package hashtable.java;

public class MyHashTable<T> {

    private int length;
    private MyNodes[] data;


    public MyHashTable(int length) {
        this.length = length;
        data = new MyNodes[length];
    }

    private int hash(String key) {
        int hashValue = 0;
        for (int i = 0; i < key.length(); i++) {
            hashValue = (hashValue + key.codePointAt(i) * i) % length;
        }

        return hashValue;
    }

    public MyNodes[] set(String key, T value) {
        int address = hash(key);
        if (data[address] == null) {
            data[address] = new MyNodes();
        }
        data[address].add(new MyNode(key, value));
        return data;
    }

    public T get(String key) {
        int address = hash(key);
        if (data[address] == null) {
            return null;
        }
        for (MyNode myNode : data[address]) {
            if (myNode.getKey().equals(key)) {
                return (T) myNode.getValue();
            }
        }

        return null;
    }

    public String[] keys() {
        String[] keys = new String[length];
        for (int i = 0; i < data.length; i++) {
            int keysCount = 0;
            if (data[i] != null) {
                for (int j = 0; j < data[i].size(); j++) {
                    keys[keysCount] = data[i].get(j).getKey();
                    keysCount++;
                }
            }
        }
        return keys;
    }
}
