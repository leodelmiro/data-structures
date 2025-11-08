package linkedlist.singlylinkedlist;

import java.util.ArrayList;

class LinkedList {
    private LinkedNode head = null;
    private LinkedNode tail = null;
    private int size = 0;

    public LinkedList() {
    }

    public void setHead(LinkedNode head) {
        this.head = head;
    }

    public void setTail(LinkedNode tail) {
        this.tail = tail;
    }

    public int get(int index) {
        if (index >= size || index < 0 || this.size == 0 || this.head == null) {
            return -1;
        }
        if (index == 0) {
            return this.head.getValue();
        }
        if (index == size - 1) {
            return this.tail.getValue();
        }

        LinkedNode currentNode = head.getNext();
        for (int i = 1; i <= index; i++) {
            if (index == i) {
                return currentNode.getValue();
            }
            currentNode = currentNode.getNext();
        }

        return -1;
    }

    public void insertHead(int val) {
        if (this.head == null) {
            this.setHead(new LinkedNode(val, null));
            this.setTail(this.head);
            this.size++;
            return;
        }
        LinkedNode oldHead = this.head;
        this.setHead(new LinkedNode(val, oldHead));
        this.size++;
    }

    public void insertTail(int val) {
        if (this.size == 0) {
            this.setTail(new LinkedNode(val, null));
            this.setHead(this.tail);
            this.size++;
            return;
        }
        if (this.size == 1) {
            this.setTail(new LinkedNode(val, null));
            this.head.setNext(this.tail);
            this.size++;
            return;
        }
        LinkedNode newTail = new LinkedNode(val, null);
        this.tail.setNext(newTail);
        this.setTail(newTail);
        this.size++;
    }

    public boolean remove(int index) {
        if (index >= size || index < 0 || this.size == 0 || this.head == null) {
            return false;
        }
        if (index == 0) {
            if (this.head.getNext() == null) {
                this.setHead(null);
                this.setTail(null);
                this.size--;
                return true;
            }

            this.setHead(head.getNext());
            this.size--;
            return true;
        }

        LinkedNode previousNode = head;
        LinkedNode currentNode = head.getNext();
        for (int i = 1; i <= index; i++) {
            if (index == i) {
                break;
            }
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }
        previousNode.setNext(currentNode.getNext());
        this.size--;
        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> values = new ArrayList<Integer>(size);
        if (size == 0) {
            return values;
        }
        LinkedNode currentNode = head;
        for (int i = 0; i < size; i++) {
            values.add(currentNode.getValue());
            currentNode = currentNode.getNext();
        }
        return values;
    }

    class LinkedNode {
        private int value;
        private LinkedNode next = null;

        public LinkedNode(int value, LinkedNode next) {
            this.value = value;
            this.next = next;
        }

        public int getValue() {
            return this.value;
        }

        public void setNext(LinkedNode next) {
            this.next = next;
        }

        public LinkedNode getNext() {
            return this.next;
        }
    }

}

