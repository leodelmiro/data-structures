class Node {
    constructor(value, next = null) {
        this.value = value;
        this.next = next;
    }
}

export default class LinkedList {
    constructor() {
        this.head = null;
        this.size = 0;
    }

    isEmpty() {
        return this.head === null;
    }

    addAtEnd(value) {
        if (this.isEmpty()) {
            this.head = new Node(value);
            this.size++;
            return;
        }

        let currentNode = this.head;
        while (currentNode.next !== null) {
            currentNode = currentNode.next;
        }

        currentNode.next = new Node(value);
        this.size++;
    }

    addAtStart(value) {
        if (this.isEmpty()) {
            this.head = new Node(value);
            this.size++;
            return;
        }

        const newNode = new Node(value, this.head);
        this.head = newNode;
        this.size++;
    }

    printLinkedList() {
        let currentNode = this.head;
        while (currentNode !== null) {
            console.log(currentNode.value);
            currentNode = currentNode.next;
        }
    }

    clear() {
        this.head = null;
        this.size = 0;
    }

    get(index) {
        const node = this.getNode(index);
        return node ? node.value : null;
    }

    getNode(index) {
        if (this.isEmpty()) return null;

        let currentNode = this.head;
        let currentIndex = 0;

        while (currentIndex < index) {
            if (!currentNode.next) return null;
            currentNode = currentNode.next;
            currentIndex++;
        }

        return currentNode;
    }

    addAt(index, value) {
        if (index === 0) {
            this.addAtStart(value);
            return;
        }

        const previousNode = this.getNode(index - 1);
        if (!previousNode) {
            this.addAtEnd(value);
            return;
        }

        const newNode = new Node(value, previousNode.next);
        previousNode.next = newNode;
        this.size++;
    }

    indexOf(value) {
        if (this.isEmpty()) return -1;

        let currentNode = this.head;
        let currentIndex = 0;

        while (currentNode !== null) {
            if (currentNode.value === value) return currentIndex;
            currentNode = currentNode.next;
            currentIndex++;
        }

        return -1;
    }

    contains(value) {
        return this.indexOf(value) !== -1;
    }

    removeAt(index) {
        if (this.isEmpty() || index >= this.size) return null;

        // remover head
        if (this.size === 1 || index === 0) {
            const oldHead = this.head;
            this.head = this.head.next;
            this.size--;
            return oldHead;
        }

        const previousNode = this.getNode(index - 1);
        if (!previousNode) return null;

        const removedNode = previousNode.next;
        if (!removedNode) return null;

        previousNode.next = removedNode.next;
        this.size--;
        return removedNode;
    }

    remove(value) {
        const elementIndex = this.indexOf(value);

        if (elementIndex === -1) return false;

        this.removeAt(elementIndex);
        return true;
    }

    toArray() {
        let currentNode = this.head;
        let vect = [];

        while (currentNode) {
            vect.push(currentNode.value)
            currentNode = currentNode.next
        }

        return vect
    }
}
