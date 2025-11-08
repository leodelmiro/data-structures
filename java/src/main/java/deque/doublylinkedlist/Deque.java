package deque.doublylinkedlist;

class DequeNode {
    int value;
    DequeNode next;
    DequeNode prev;

    public DequeNode(int value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}

class Deque {
    private DequeNode dummyHead;
    private DequeNode dummyTail;

    public Deque() {
        this.dummyHead = new DequeNode(0);
        this.dummyTail = new DequeNode(0);

        this.dummyHead.next = this.dummyTail;
        this.dummyTail.prev = this.dummyHead;
    }

    public boolean isEmpty() {
        return this.dummyHead.next == this.dummyTail;
    }

    public void append(int value) {
        DequeNode newNode = new DequeNode(value);
        newNode.prev = this.dummyTail.prev;
        newNode.next = this.dummyTail;
        this.dummyTail.prev.next = newNode;
        this.dummyTail.prev = newNode;
    }

    public void appendleft(int value) {
        DequeNode newNode = new DequeNode(value);
        newNode.next = this.dummyHead.next;
        newNode.prev = this.dummyHead;
        this.dummyHead.next.prev = newNode;
        this.dummyHead.next = newNode;
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        DequeNode targetNode = this.dummyTail.prev;
        DequeNode prevNode = targetNode.prev;
        int value = targetNode.value;

        this.dummyTail.prev = prevNode;
        prevNode.next = this.dummyTail;

        return value;
    }

    public int popleft() {
        if (isEmpty()) {
            return -1;
        }
        DequeNode targetNode = this.dummyHead.next;
        DequeNode nextNode = targetNode.next;
        int value = targetNode.value;

        this.dummyHead.next = nextNode;
        nextNode.prev = this.dummyHead;

        return value;
    }
}
