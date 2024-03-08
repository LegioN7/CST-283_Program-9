/**
 * This class implements an unordered singly-linked list of objects.
 *
 * @param <ItemType> The type of elements held in this collection.
 */
class LinkedList<ItemType> {

    /**
     * The first element in the list
     */
    private Node first;

    /**
     * The last element in the list
     */
    private Node last;

    /**
     * The current position in the list
     */
    private Node currentPos;

    /**
     * Constructor creates an empty list
     */
    public LinkedList() {
        first = null;
        last = null;
    }

    /**
     * Checks if the list is empty.
     *
     * @return true if the list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Returns the number of elements in the list (size).
     *
     * @return The number of elements in the list.
     */
    public int size() {
        int count = 0;
        Node currNode = first;
        while (currNode != null) {
            count++;
            currNode = currNode.next;
        }
        return count;
    }

    /**
     * Adds an element to the front of the list.
     *
     * @param newElementData The element to add.
     */
    public void add(ItemType newElementData) {
        if (isEmpty()) {
            first = new Node(newElementData);
            last = first;
        } else {
            Node newNode = new Node(newElementData);
            newNode.next = first;
            first = newNode;
        }
    }

    /**
     * Removes an element from the list.
     *
     * @param element The element to remove.
     * @return true if the element was removed, false otherwise.
     */
    public boolean remove(ItemType element) {
        if (isEmpty())
            return false;

        boolean isRemoved = false;
        while (element.equals(first.value)) {
            first = first.next;
            if (first == null)
                last = null;
            isRemoved = true;
        }

        if (first != null) {
            Node pred = first;
            while (pred.next != null) {
                while (pred.next != null && element.equals(pred.next.value)) {
                    pred.next = pred.next.next;
                    isRemoved = true;
                }
                if (pred.next != null) {
                    pred = pred.next;
                }
            }
            last = pred;
        }

        return isRemoved;
    }

    /**
     * Checks if the list contains a certain element.
     *
     * @param target The element to check for.
     * @return true if the list contains the element, false otherwise.
     */
    public boolean contains(ItemType target) {
        boolean moreToSearch;
        Node nodePtr;

        nodePtr = first;
        boolean found = false;
        moreToSearch = (nodePtr != null);

        while (moreToSearch && !found) {
            if (target.equals(nodePtr.value)) {
                found = true;
            } else {
                nodePtr = nodePtr.next;
                moreToSearch = (nodePtr != null);
            }
        }
        return found;
    }

    /**
     * Retrieves an element from the list.
     *
     * @param target The element to retrieve.
     * @return The retrieved element, or null if the element is not found.
     */
    public ItemType retrieve(ItemType target) {
        boolean moreToSearch;
        Node nodePtr;
        ItemType returnItem;

        nodePtr = first;
        boolean found = false;
        moreToSearch = (nodePtr != null);

        while (moreToSearch && !found) {
            if (target.equals(nodePtr.value)) {
                found = true;
                return nodePtr.value;
            } else {
                nodePtr = nodePtr.next;
                moreToSearch = (nodePtr != null);
            }
        }
        return null;
    }

    /**
     * Appends an element to the end of the list.
     *
     * @param newElementData The element to append.
     */
    public void append(ItemType newElementData) {
        if (isEmpty()) {
            first = new Node(newElementData);
            last = first;
        } else {
            last.next = new Node(newElementData);
            last = last.next;
        }
    }

    /**
     * Adds an element at a certain index.
     *
     * @param index          The index at which to add the element.
     * @param newElementData The element to add.
     */
    public void addAt(int index, ItemType newElementData) {
        if (index == 0) {
            first = new Node(newElementData, first);
            if (last == null)
                last = first;
            return;
        }
        Node pred = first;
        for (int k = 1; k <= index - 1; k++) {
            pred = pred.next;
        }
        pred.next = new Node(newElementData, pred.next);
        if (pred.next.next == null)
            last = pred.next;
    }

    /**
     * Removes an element at a certain index.
     *
     * @param index The index of the element to remove.
     * @return The removed element.
     */
    public ItemType removeAt(int index) {
        ItemType element;
        if (index == 0) {
            element = first.value;
            first = first.next;
            if (first == null)
                last = null;
        } else {
            Node pred = first;
            for (int k = 1; k <= index - 1; k++)
                pred = pred.next;
            element = pred.next.value;
            pred.next = pred.next.next;
            if (pred.next == null)
                last = pred;
        }
        return element;
    }

    /**
     * Resets the current position in the list to the start of the list.
     */
    public void resetList() {
        currentPos = first;
    }

    /**
     * Gets the next item in the list.
     *
     * @return The next item in the list.
     */
    public ItemType getNextItem() {
        ItemType item;
        if (currentPos == null)
            currentPos = first;
        item = currentPos.value;
        currentPos = currentPos.next;
        return item;
    }

    /**
     * Checks if the current position is at the end of the list.
     *
     * @return true if the current position is at the end of the list, false otherwise.
     */
    public boolean atEnd() {
        return currentPos == null;
    }

    /**
     * Returns a string representation of the list.
     *
     * @return A string representation of the list.
     */
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();
        Node currPos = first;
        while (currPos != null) {
            strBuilder.append(currPos.value).append("\n");
            currPos = currPos.next;
        }
        return strBuilder.toString();
    }

    /**
     * Counts the number of occurrences of a certain item in the list.
     *
     * @param target The item to count.
     * @return The number of occurrences of the item in the list.
     */
    //
    public int countItems(ItemType target) {
        int returnCount = 0;
        ItemType currentItem;
        resetList();
        while (!atEnd()) {
            currentItem = getNextItem();
            if (currentItem.equals(target))
                returnCount++;
        }
        return returnCount;
    }

    /**
     * Private inner class definition of standard data node.
     */
    private class Node {
        ItemType value;
        Node next;

        /**
         * Construct node with data and reference to successor.
         *
         * @param val The data value.
         * @param n   The successor node.
         */
        Node(ItemType val, Node n) {
            value = val;
            next = n;
        }

        /**
         * Construct node with data and null successor.
         *
         * @param val The data value.
         */
        Node(ItemType val) {
            this(val, null);
        }
    }

}